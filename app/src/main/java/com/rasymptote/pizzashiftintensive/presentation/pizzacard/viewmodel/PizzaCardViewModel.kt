package com.rasymptote.pizzashiftintensive.presentation.pizzacard.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rasymptote.pizzashiftintensive.domain.mapper.toPizzaConfiguration
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaDough
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaIngredient
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaSize
import com.rasymptote.pizzashiftintensive.domain.usecase.pizza.CalculatePizzaPriceUseCase
import com.rasymptote.pizzashiftintensive.domain.usecase.pizza.GetPizzaByIdUseCase
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
    private val calculatePizzaPriceUseCase: CalculatePizzaPriceUseCase,
) : ViewModel() {

    private val _state =
        MutableStateFlow<PizzaCardScreenState>(PizzaCardScreenState.Initial)

    val state = _state.asStateFlow()

    fun getPizzaCard(pizzaId: String) {
        _state.value = PizzaCardScreenState.Loading

        viewModelScope.launch(exceptionHandler) {
            val pizza = getPizzaByIdUseCase(pizzaId = pizzaId)
            val configuration = pizza.toPizzaConfiguration()

            _state.value = PizzaCardScreenState.Content(
                pizzaConfiguration = configuration,
                price = calculatePizzaPriceUseCase(configuration)
            )
        }
    }

    private val exceptionHandler = CoroutineExceptionHandler {
            _, throwable ->
        _state.value = PizzaCardScreenState.Error(
            throwable.message ?: "Неизвестная ошибка"
        )
    }

    private inline fun updateConfiguration(
        transform: (PizzaConfiguration) -> PizzaConfiguration
    ) {
        _state.update { state ->
            if (state is PizzaCardScreenState.Content) {
                val updatedConfiguration =
                    transform(state.pizzaConfiguration)

                state.copy(
                    pizzaConfiguration = updatedConfiguration,
                    price = calculatePizzaPriceUseCase(updatedConfiguration)
                )
            } else {
                state
            }
        }
    }


    fun onSizeSelected(size: PizzaSize) {
        updateConfiguration {
            it.copy(selectedSize = size)
        }
    }

    fun onDoughSelected(dough: PizzaDough) {
        updateConfiguration {
            it.copy(selectedDough = dough)
        }
    }

    fun onToppingSelected(topping: PizzaIngredient) {
        updateConfiguration {
            val toppings = if (topping in it.selectedToppings) {
                it.selectedToppings - topping
            } else {
                it.selectedToppings + topping
            }

            it.copy(
                selectedToppings = toppings
            )
        }
    }
}