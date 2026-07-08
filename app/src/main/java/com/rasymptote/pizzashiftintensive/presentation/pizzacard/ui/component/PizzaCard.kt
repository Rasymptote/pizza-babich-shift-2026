package com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaDough
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaIngredient
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaSize

@Composable
fun PizzaCard(
    pizzaConfiguration: PizzaConfiguration,
    onSizeSelected: (PizzaSize) -> Unit,
    onDoughSelected: (PizzaDough) -> Unit,
    onToppingSelected: (PizzaIngredient) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(bottom = 24.dp)
    ) {
        item {
            PizzaSection(
                pizzaConfiguration = pizzaConfiguration,
                onSizeSelected = onSizeSelected,
                onDoughSelected = onDoughSelected,
            )
        }

        item {
            ToppingsSection(
                pizzaConfiguration = pizzaConfiguration,
                onToppingSelected = onToppingSelected,
            )
        }
    }
}