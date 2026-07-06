package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.model.BasePricedPizza

@Composable
fun PizzaCatalog(
    pizzas: List<BasePricedPizza>,
    modifier: Modifier = Modifier,
    onPizzaCardClick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 32.dp
        ),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        items(
            items = pizzas,
            key = {it.pizza.id }
        ) { pizza ->

            PizzaCatalogItem(
                pizza = pizza,
                onClick = onPizzaCardClick
            )
        }
    }
}
