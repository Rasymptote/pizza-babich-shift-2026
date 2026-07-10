package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rasymptote.pizzashiftintensive.domain.usecase.pizza.CalculateBasePizzaPriceUseCase
import com.rasymptote.pizzashiftintensive.domain.usecase.pizza.GetPizzasUseCase
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.model.BasePricedPizza
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PizzaCatalogViewModel @Inject constructor(
    private val getPizzasUseCase: GetPizzasUseCase,
    private val calculateBasePizzaPriceUseCase: CalculateBasePizzaPriceUseCase
) : ViewModel() {

    private val _state =
        MutableStateFlow<PizzaCatalogScreenState>(PizzaCatalogScreenState.Initial)
    val state = _state.asStateFlow()

    fun getBasePricedPizzas() {
        _state.value = PizzaCatalogScreenState.Loading

        viewModelScope.launch(exceptionHandler) {
            val basePricedPizzas = getPizzasUseCase().map {
                BasePricedPizza(it, calculateBasePizzaPriceUseCase(it))
            }
            _state.value = PizzaCatalogScreenState.Content(basePricedPizzas)
        }
    }

    private val exceptionHandler = CoroutineExceptionHandler {
        _, throwable ->
        _state.value = PizzaCatalogScreenState.Error(
            throwable.message ?: "Неизвестная ошибка"
        )
    }
}