package com.rasymptote.pizzashiftintensive.presentation.navigation

import androidx.navigation3.runtime.NavKey
import com.rasymptote.pizzashiftintensive.presentation.cart.ui.CartRoute
import com.rasymptote.pizzashiftintensive.presentation.orders.ui.OrdersRoute
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.ui.PizzaCatalogRoute
import com.rasymptote.pizzashiftintensive.presentation.profile.ui.ProfileRoute

fun NavigationOption.toRoute(): NavKey =
    when (this) {
        NavigationOption.PIZZA -> PizzaCatalogRoute
        NavigationOption.ORDERS -> OrdersRoute
        NavigationOption.CART -> CartRoute
        NavigationOption.PROFILE -> ProfileRoute
    }

fun List<NavKey>.toNavigationOption(): NavigationOption =
    when (val last = lastOrNull()) {
        is OrdersRoute -> NavigationOption.ORDERS
        is CartRoute -> NavigationOption.CART
        is ProfileRoute -> NavigationOption.PROFILE
        else -> NavigationOption.PIZZA
    }

fun MutableList<NavKey>.navigateTo(option: NavigationOption) {
    clear()
    add(option.toRoute())
}