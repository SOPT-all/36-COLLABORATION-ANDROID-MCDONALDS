package org.sopt.mcdonalds.presentation.order

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.mcdonalds.domain.cart.model.CartDetail
import org.sopt.mcdonalds.domain.cart.usecase.PostCartUseCase
import org.sopt.mcdonalds.domain.menu.model.MenuDetail
import org.sopt.mcdonalds.domain.menu.usecase.GetMenuDetailUseCase
import org.sopt.mcdonalds.presentation.order.navigation.Order
import org.sopt.mcdonalds.presentation.order.state.OrderContract.OrderSideEffect
import org.sopt.mcdonalds.presentation.order.state.OrderContract.OrderState
import org.sopt.mcdonalds.presentation.order.type.OrderType
import org.sopt.mcdonalds.presentation.order.type.SetType

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val getMenuDetailUseCase: GetMenuDetailUseCase,
    private val postCartUseCase: PostCartUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val menuId = savedStateHandle.toRoute<Order>().menuId

    private val _uiState = MutableStateFlow(OrderState())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<OrderSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    init {
        viewModelScope.launch {
            getMenuDetailUseCase(menuId = menuId).onSuccess {
                updateMenuDetail(menuDetail = it)
            }.onFailure {
                // TODO: API Called Failed
            }
        }
    }

    private fun updateMenuDetail(menuDetail: MenuDetail) {
        _uiState.update {
            it.copy(menuDetail = menuDetail)
        }
    }

    fun increaseBurgerCount() {
        _uiState.update {
            it.copy(burgerCount = it.burgerCount + 1)
        }
    }

    fun decreaseBurgerCount() {
        _uiState.update {
            it.copy(burgerCount = it.burgerCount - 1)
        }
    }

    fun updateSetType(setType: SetType) {
        _uiState.update {
            it.copy(setType = setType)
        }
    }

    fun onClickOrderButton(orderType: OrderType) {
        viewModelScope.launch {
            postCartUseCase(
                cartDetail = CartDetail(
                    isSet = _uiState.value.setType == SetType.SET,
                    amount = _uiState.value.burgerCount,
                    menuId = _uiState.value.menuDetail.id
                )
            ).onSuccess {
                when (orderType) {
                    OrderType.ORDER_NOW -> _sideEffect.emit(OrderSideEffect.NavigateToHistory)
                    OrderType.ADD_TO_CART -> _sideEffect.emit(OrderSideEffect.NavigateToMenuList)
                }
            }.onFailure {
                // TODO
            }
        }
    }
}
