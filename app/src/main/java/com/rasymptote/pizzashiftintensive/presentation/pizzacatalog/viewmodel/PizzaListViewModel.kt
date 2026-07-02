package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rasymptote.pizzashiftintensive.domain.usecase.GetAllPizzasUseCase
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.ui.PizzaCatalogScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PizzaListViewModel @Inject constructor(
    private val getAllPizzasUseCase: GetAllPizzasUseCase
) : ViewModel() {

    private val _state =
        MutableStateFlow<PizzaCatalogScreenState>(PizzaCatalogScreenState.Loading)
    val state = _state.asStateFlow()

    init {
        getAllPizzas()
    }

    fun getAllPizzas() {
        _state.value = PizzaCatalogScreenState.Loading

        viewModelScope.launch {
            try {
                val pizzas = getAllPizzasUseCase()
                _state.value = PizzaCatalogScreenState.Content(pizzas)
            } catch (e: Exception) {
                _state.value = PizzaCatalogScreenState.Error(e.message ?: "Неизвестная ошибка")
            }
        }
    }
}