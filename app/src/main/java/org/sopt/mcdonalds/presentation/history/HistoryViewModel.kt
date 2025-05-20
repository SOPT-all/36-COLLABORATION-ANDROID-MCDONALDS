package org.sopt.mcdonalds.presentation.history

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.mcdonalds.presentation.history.model.Cart
import org.sopt.mcdonalds.presentation.history.model.RecentBurger
import org.sopt.mcdonalds.presentation.history.state.HistoryContract.HistoryState

@HiltViewModel
class HistoryViewModel @Inject constructor(
    // TODO: API connection
) : ViewModel() {
    private val _uiState = MutableStateFlow(HistoryState())
    val uiState = _uiState.asStateFlow()

    init {
        // TODO: API call
    }

    fun updateCartList(menuList: List<Cart>) {
        _uiState.update {
            it.copy(cartList = menuList.toImmutableList())
        }
    }

    fun updateRecentBurgerList(recentBurgerList: List<RecentBurger>) {
        _uiState.update {
            it.copy(recentBurgerList = recentBurgerList.toImmutableList())
        }
    }

    fun increaseCount(index: Int) {
        _uiState.update {
            val updatedList = it.cartList.toMutableList().apply {
                this[index] = this[index].copy(amount = this[index].amount + 1)
            }
            it.copy(cartList = updatedList.toImmutableList())
        }
    }

    fun decreaseCount(index: Int) {
        _uiState.update {
            val updatedList = it.cartList.toMutableList().apply {
                this[index] = this[index].copy(amount = maxOf(this[index].amount - 1, 1))
            }
            it.copy(cartList = updatedList.toImmutableList())
        }
    }

    fun updatePriceSum() {
        _uiState.update { it ->
            it.copy(priceSum = it.cartList.sumOf { it.price * it.amount })
        }
    }
}
