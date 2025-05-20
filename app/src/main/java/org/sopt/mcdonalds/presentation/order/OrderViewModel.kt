package org.sopt.mcdonalds.presentation.order

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.mcdonalds.presentation.order.navigation.Order
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val menuId = savedStateHandle.toRoute<Order>()

    init {
        // TODO: API
    }
}