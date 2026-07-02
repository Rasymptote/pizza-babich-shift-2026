package com.rasymptote.pizzashiftintensive.domain.exception

sealed class PizzaException(message: String) : Exception(message)

class PizzaNotFoundException(
    pizzaId: String
) : PizzaException("Pizza with id=$pizzaId not found")

class BasePriceNotFoundException(
    pizzaId: String
) : PizzaException("Pizza $pizzaId doesn't have a base price")