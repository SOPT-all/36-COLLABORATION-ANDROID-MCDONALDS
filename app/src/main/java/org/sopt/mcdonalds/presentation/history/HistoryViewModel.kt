package org.sopt.mcdonalds.presentation.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.mcdonalds.domain.cart.model.Cart
import org.sopt.mcdonalds.domain.cart.usecase.GetCartsUseCase
import org.sopt.mcdonalds.domain.cart.usecase.UpdateCartAmountUseCase
import org.sopt.mcdonalds.presentation.history.model.RecentBurger
import org.sopt.mcdonalds.presentation.history.state.HistoryContract.HistoryState

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getCartsUseCase: GetCartsUseCase,
    private val updateCartAmountUseCase: UpdateCartAmountUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(HistoryState())
    val uiState = _uiState.asStateFlow()
    var canClick = true

    init {
        viewModelScope.launch {
            getCartsUseCase().onSuccess {
                updateCartList(it)
                updatePriceSum()
            }.onFailure {
                // TODO: API Called Failed
            }
        }
    }

    private fun updateCartList(cartList: List<Cart>) {
        _uiState.update {
            it.copy(cartList = cartList.toImmutableList())
        }
    }

    private fun updateRecentBurgerList(recentBurgerList: List<RecentBurger>) {
        _uiState.update {
            it.copy(recentBurgerList = recentBurgerList.toImmutableList())
        }
    }

    private fun updatePriceSum() {
        _uiState.update {
            it.copy(priceSum = it.cartList.sumOf { cart -> cart.price * cart.amount })
        }
    }

    fun increaseCount(index: Int) {
        if (!canClick) return
        canClick = false

        viewModelScope.launch {
            updateCartAmountUseCase(
                cartId = uiState.value.cartList[index].id,
                amount = uiState.value.cartList[index].amount + 1
            ).onSuccess {
                _uiState.update { it ->
                    val updatedList = it.cartList.toMutableList().apply {
                        this[index] = this[index].copy(amount = this[index].amount + 1)
                    }
                    it.copy(
                        cartList = updatedList.toImmutableList(),
                        priceSum = updatedList.sumOf { it.price * it.amount }
                    )
                }
            }.onFailure {
                // TODO: API Called Failed
            }
            delay(1000L)
            canClick = true
        }
    }

    fun decreaseCount(index: Int) {
        if (!canClick) return
        canClick = false

        if (uiState.value.cartList[index].amount <= 1) {
            canClick = true
            return
        }
        viewModelScope.launch {
            updateCartAmountUseCase(
                cartId = uiState.value.cartList[index].id,
                amount = uiState.value.cartList[index].amount - 1
            ).onSuccess {
                _uiState.update { it ->
                    val updatedList = it.cartList.toMutableList().apply {
                        this[index] = this[index].copy(amount = this[index].amount - 1)
                    }
                    it.copy(
                        cartList = updatedList.toImmutableList(),
                        priceSum = updatedList.sumOf { it.price * it.amount }
                    )
                }
            }.onFailure {
                // TODO: API Called Failed
            }
            delay(1000L)
            canClick = true
        }
    }
}
