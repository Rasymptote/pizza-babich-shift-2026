package com.rasymptote.pizzashiftintensive.domain.exception

sealed class PizzaException(message: String) : Exception(message)

class PizzaNotFoundException(
    pizzaId: String
) : PizzaException("Pizza with id=$pizzaId not found")