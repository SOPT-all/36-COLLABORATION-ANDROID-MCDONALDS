package org.sopt.mcdonalds.presentation.menu

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.mcdonalds.presentation.menu.model.Menu
import org.sopt.mcdonalds.presentation.menu.state.MenuListContract.MenuListState

@HiltViewModel
class MenuListViewModel @Inject constructor(
    // TODO: API Connection
) : ViewModel() {
    private val _uiState = MutableStateFlow(MenuListState())
    val uiState = _uiState.asStateFlow()

    init {
        // TODO: API call
    }

    private fun updateMenuList(menuList: List<Menu>) {
        _uiState.update {
            it.copy(menuList = menuList.toImmutableList())
        }
    }
}
