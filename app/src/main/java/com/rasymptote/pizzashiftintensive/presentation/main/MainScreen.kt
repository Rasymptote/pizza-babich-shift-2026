package com.rasymptote.pizzashiftintensive.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.rasymptote.pizzashiftintensive.presentation.animation.ENTER_TRANSITION
import com.rasymptote.pizzashiftintensive.presentation.animation.EXIT_TRANSITION
import com.rasymptote.pizzashiftintensive.presentation.animation.PREDICTIVE_EXIT_TRANSITION
import com.rasymptote.pizzashiftintensive.presentation.cart.ui.CartRoute
import com.rasymptote.pizzashiftintensive.presentation.cart.ui.CartScreen
import com.rasymptote.pizzashiftintensive.presentation.component.BottomBar
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


@Composable
fun MainScreen() {
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
                        onBackClick = { backStack.removeLastOrNull() }
                    )
                }

                entry<OrdersRoute> { OrdersScreen() }
                entry<CartRoute> { CartScreen() }
                entry<ProfileRoute> { ProfileScreen() }
            }
        )
    }
}