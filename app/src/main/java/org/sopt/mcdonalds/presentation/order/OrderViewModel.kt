package org.sopt.mcdonalds.presentation.order

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.mcdonalds.presentation.order.navigation.Order
import org.sopt.mcdonalds.presentation.order.state.OrderContract.OrderState
import org.sopt.mcdonalds.presentation.order.type.SetType

@HiltViewModel
class OrderViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val menuId = savedStateHandle.toRoute<Order>()

    private val _uiState = MutableStateFlow(OrderState())
    val uiState = _uiState.asStateFlow()

    init {
        //  TODO: API
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

    private fun postOrder() {
//        TODO: API
    }
}
