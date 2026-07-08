package com.rasymptote.pizzashiftintensive.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.rasymptote.pizzashiftintensive.presentation.cart.ui.CartRoute
import com.rasymptote.pizzashiftintensive.presentation.cart.ui.CartScreen
import com.rasymptote.pizzashiftintensive.presentation.cart.viewmodel.CartViewModel
import com.rasymptote.pizzashiftintensive.presentation.navigation.ENTER_TRANSITION
import com.rasymptote.pizzashiftintensive.presentation.navigation.EXIT_TRANSITION
import com.rasymptote.pizzashiftintensive.presentation.navigation.NavigationOption
import com.rasymptote.pizzashiftintensive.presentation.navigation.PREDICTIVE_EXIT_TRANSITION
import com.rasymptote.pizzashiftintensive.presentation.navigation.navigateTo
import com.rasymptote.pizzashiftintensive.presentation.navigation.toNavigationOption
import com.rasymptote.pizzashiftintensive.presentation.orders.ui.OrdersRoute
import com.rasymptote.pizzashiftintensive.presentation.orders.ui.OrdersScreen
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.PizzaCardRoute
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.PizzaCardScreen
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.ui.PizzaCatalogRoute
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.ui.PizzaCatalogScreen
import com.rasymptote.pizzashiftintensive.presentation.profile.ui.ProfileRoute
import com.rasymptote.pizzashiftintensive.presentation.profile.ui.ProfileScreen
import com.rasymptote.pizzashiftintensive.presentation.ui.component.BottomBar


@Composable
fun MainScreen(
    cartViewModel: CartViewModel = hiltViewModel()
) {
    val backStack = rememberNavBackStack(PizzaCatalogRoute)

    Scaffold(
        bottomBar = {
            BottomBar(
                selected = backStack.toNavigationOption(),
                onItemClick = { backStack.navigateTo(it) }
            )
        }
    ) { padding ->

        NavDisplay(
            modifier = Modifier.padding(padding),
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            transitionSpec = ENTER_TRANSITION,
            popTransitionSpec = EXIT_TRANSITION,
            predictivePopTransitionSpec = PREDICTIVE_EXIT_TRANSITION,
            entryProvider = entryProvider {

                entry<PizzaCatalogRoute> {
                    PizzaCatalogScreen(
                        onPizzaCardClick = { backStack.add(PizzaCardRoute(it)) }
                    )
                }

                entry<PizzaCardRoute> { route ->
                    PizzaCardScreen(
                        pizzaId = route.pizzaId,
                        onBackClick = { backStack.removeLastOrNull() },
                        onAddToCartClick = { configuration ->
                            cartViewModel.addItem(configuration)
                            backStack.add(CartRoute)
                        }
                    )
                }

                entry<OrdersRoute> { OrdersScreen() }
                entry<CartRoute> {
                    CartScreen(
                        viewModel = cartViewModel,
                        onBackClick = { backStack.navigateTo(NavigationOption.PIZZA) }
                    )
                }
                entry<ProfileRoute> { ProfileScreen() }
            }
        )
    }
}