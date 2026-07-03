package com.rasymptote.pizzashiftintensive.presentation.pizzacard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rasymptote.pizzashiftintensive.domain.model.PizzaDough
import com.rasymptote.pizzashiftintensive.domain.model.PizzaIngredient
import com.rasymptote.pizzashiftintensive.domain.model.PizzaSize
import com.rasymptote.pizzashiftintensive.domain.usecase.GetBasePricedPizzaByIdUseCase
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.mapper.toScreenModel
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.PizzaCardScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PizzaCardViewModel @Inject constructor(
    private val getBasePricedPizzaByIdUseCase: GetBasePricedPizzaByIdUseCase
) : ViewModel() {

    private val _state =
        MutableStateFlow<PizzaCardScreenState>(PizzaCardScreenState.Loading)

    val state = _state.asStateFlow()

    init {
        getPizzaCard("1")
    }

    fun getPizzaCard(id: String) = viewModelScope.launch {
        _state.value = PizzaCardScreenState.Loading

        runCatching {
            getBasePricedPizzaByIdUseCase(id)
        }.onSuccess {
            _state.value = PizzaCardScreenState.Content(it.toScreenModel())
        }.onFailure {
            _state.value = PizzaCardScreenState.Error(it.message ?: "Неизвестная ошибка")
        }
    }

    private inline fun updateContent(
        transform: (PizzaCardScreenState.Content) -> PizzaCardScreenState.Content
    ) {
        _state.update { state ->
            if (state is PizzaCardScreenState.Content) transform(state)
            else state
        }
    }

    fun onSizeSelected(size: PizzaSize) = updateContent {
        it.copy(pizzaCard = it.pizzaCard.copy(selectedSize = size))
    }

    fun onDoughSelected(dough: PizzaDough) = updateContent {
        it.copy(pizzaCard = it.pizzaCard.copy(selectedDough = dough))
    }

    fun onToppingClicked(topping: PizzaIngredient) {
    }
}