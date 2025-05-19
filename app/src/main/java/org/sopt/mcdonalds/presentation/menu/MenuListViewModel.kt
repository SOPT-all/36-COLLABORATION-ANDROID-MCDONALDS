package org.sopt.mcdonalds.presentation.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.mcdonalds.domain.menu.model.Menu
import org.sopt.mcdonalds.domain.menu.usecase.GetMenusUseCase
import org.sopt.mcdonalds.presentation.menu.state.MenuListContract.MenuListState
import javax.inject.Inject

@HiltViewModel
class MenuListViewModel @Inject constructor(
    private val getMenusUseCase: GetMenusUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(MenuListState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getMenusUseCase().onSuccess {
                updateMenuList(it)
            }.onFailure {
                // TODO: API Called Failed
            }
        }
    }

    private fun updateMenuList(menuList: List<Menu>) {
        _uiState.update {
            it.copy(menuList = menuList.toPersistentList())
        }
    }
}
