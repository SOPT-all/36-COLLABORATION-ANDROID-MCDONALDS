package org.sopt.mcdonalds.presentation.order

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.mcdonalds.presentation.order.navigation.Order
import org.sopt.mcdonalds.presentation.order.type.SetType
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val menuId = savedStateHandle.toRoute<Order>()

    private val _burgerCount = mutableStateOf(1)
    val burgerCount: MutableState<Int> get() = _burgerCount

    private val _setType = mutableStateOf(SetType.SET)
    val setType: MutableState<SetType> get() = _setType

    init {
    //  TODO: API
    }

    fun increaseBurgerCount() {
        _burgerCount.value++
    }

    fun decreaseBurgerCount() {
        _burgerCount.value--
    }

    fun updateSetType(setType: SetType) {
        _setType.value = setType
    }

    private fun postOrder(){
//        TODO: API
    }
}