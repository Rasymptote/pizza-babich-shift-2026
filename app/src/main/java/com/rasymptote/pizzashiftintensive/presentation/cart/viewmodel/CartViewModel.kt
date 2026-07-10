package com.rasymptote.pizzashiftintensive.presentation.cart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration
import com.rasymptote.pizzashiftintensive.domain.usecase.cart.AddCartItemUseCase
import com.rasymptote.pizzashiftintensive.domain.usecase.cart.ObserveCartItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val observeCartItemsUseCase: ObserveCartItemsUseCase,
    private val addCartItemUseCase: AddCartItemUseCase
) : ViewModel()
{
    private val _state =
        MutableStateFlow<CartScreenState>(CartScreenState.Initial)

    val state = _state.asStateFlow()

    init {
        observeCart()
    }

    private fun observeCart() {
        viewModelScope.launch {
            observeCartItemsUseCase()
                .collect { items ->
                    _state.value = CartScreenState.Content(
                        items = items
                    )
                }
        }
    }

    fun addItem(
        pizzaConfiguration: PizzaConfiguration
    ) {
        viewModelScope.launch {
            addCartItemUseCase(pizzaConfiguration)
        }
    }
}