package com.rasymptote.pizzashiftintensive.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.PizzaCardRoute
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.PizzaCardScreen
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.ui.PizzaCatalogRoute
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.ui.PizzaCatalogScreen

@Composable
fun MainScreen() {
    val backStack = rememberNavBackStack(PizzaCatalogRoute)
    Scaffold { innerPadding ->
        NavDisplay(
            modifier = Modifier.padding(innerPadding),
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<PizzaCatalogRoute> {
                    PizzaCatalogScreen(
                        onPizzaCardClick = { pizzaId -> backStack.add(PizzaCardRoute(pizzaId))},
                    )
                }
                entry<PizzaCardRoute> { route ->
                    PizzaCardScreen(
                        pizzaId = route.pizzaId,
                        onBackClick = { backStack.removeLastOrNull() }
                    )
                }
            }
        )
    }
}