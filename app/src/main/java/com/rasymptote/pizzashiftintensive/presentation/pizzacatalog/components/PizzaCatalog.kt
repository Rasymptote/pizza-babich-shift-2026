package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rasymptote.pizzashiftintensive.domain.model.Pizza

@Composable
fun PizzaCatalog(
    pizzas: List<Pizza>,
    modifier: Modifier = Modifier,
    onPizzaCardClick: (Pizza) -> Unit
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
            key = Pizza::id
        ) { pizza ->

            PizzaCatalogItem(
                pizza = pizza,
                onClick = onPizzaCardClick
            )
        }
    }
}
