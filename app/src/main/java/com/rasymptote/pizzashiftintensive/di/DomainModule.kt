package com.rasymptote.pizzashiftintensive.di

import com.rasymptote.pizzashiftintensive.domain.factory.CartItemFactory
import com.rasymptote.pizzashiftintensive.domain.repository.CartRepository
import com.rasymptote.pizzashiftintensive.domain.repository.PizzaRepository
import com.rasymptote.pizzashiftintensive.domain.usecase.cart.AddCartItemUseCase
import com.rasymptote.pizzashiftintensive.domain.usecase.cart.ObserveCartItemsUseCase
import com.rasymptote.pizzashiftintensive.domain.usecase.pizza.CalculateBasePizzaPriceUseCase
import com.rasymptote.pizzashiftintensive.domain.usecase.pizza.CalculatePizzaPriceUseCase
import com.rasymptote.pizzashiftintensive.domain.usecase.pizza.GetPizzaByIdUseCase
import com.rasymptote.pizzashiftintensive.domain.usecase.pizza.GetPizzasUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    fun provideCalculateBasePizzaPriceUseCase() : CalculateBasePizzaPriceUseCase =
        CalculateBasePizzaPriceUseCase()

    @Provides
    fun providePizzasUseCase(pizzaRepository: PizzaRepository): GetPizzasUseCase =
        GetPizzasUseCase(pizzaRepository)

    @Provides
    fun providePizzaByIdUseCase(pizzaRepository: PizzaRepository): GetPizzaByIdUseCase =
        GetPizzaByIdUseCase(pizzaRepository)

    @Provides
    fun provideCalculatePizzaPriceUseCase() : CalculatePizzaPriceUseCase =
        CalculatePizzaPriceUseCase()

    @Provides
    fun provideCartItemFactory(
        calculatePizzaPriceUseCase: CalculatePizzaPriceUseCase
    ) : CartItemFactory = CartItemFactory(calculatePizzaPriceUseCase)

    @Provides
    fun provideAddCartItemUseCase(
        cartRepository: CartRepository,
        cartItemFactory: CartItemFactory
    ) : AddCartItemUseCase = AddCartItemUseCase(
        cartRepository,
        cartItemFactory
    )

    @Provides
    fun provideGetCartUseCase(cartRepository: CartRepository) : ObserveCartItemsUseCase =
        ObserveCartItemsUseCase(cartRepository)
}
