package com.rasymptote.pizzashiftintensive.presentation.pizzacard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rasymptote.pizzashiftintensive.domain.model.PizzaDough
import com.rasymptote.pizzashiftintensive.domain.model.PizzaIngredient
import com.rasymptote.pizzashiftintensive.domain.model.PizzaSize
import com.rasymptote.pizzashiftintensive.domain.usecase.CalculateBasePizzaPriceUseCase
import com.rasymptote.pizzashiftintensive.domain.usecase.GetPizzaByIdUseCase
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.mapper.toPizzaCard
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PizzaCardViewModel @Inject constructor(
    private val getPizzaByIdUseCase: GetPizzaByIdUseCase,
    private val calculateBasePizzaPriceUseCase: CalculateBasePizzaPriceUseCase,
) : ViewModel() {

    private val _state =
        MutableStateFlow<PizzaCardScreenState>(PizzaCardScreenState.Initial)

    val state = _state.asStateFlow()

    fun getPizzaCard(id: String) {
        _state.value = PizzaCardScreenState.Loading

        viewModelScope.launch(exceptionHandler) {
            val pizza = getPizzaByIdUseCase(pizzaId = id)
            val pizzaBasePrice = calculateBasePizzaPriceUseCase(pizza = pizza)
            _state.value = PizzaCardScreenState.Content(
                pizza.toPizzaCard(pizzaBasePrice)
            )
        }
    }

    private val exceptionHandler = CoroutineExceptionHandler {
            _, throwable ->
        _state.value = PizzaCardScreenState.Error(
            throwable.message ?: "Неизвестная ошибка"
        )
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

    fun onToppingSelected(topping: PizzaIngredient) {
    }
}