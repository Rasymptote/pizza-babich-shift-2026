package com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaDough
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaSize

@Composable
fun PizzaSection(
    pizzaConfiguration: PizzaConfiguration,
    onSizeSelected: (PizzaSize) -> Unit,
    onDoughSelected: (PizzaDough) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        PizzaDetails(pizzaConfiguration = pizzaConfiguration, Modifier.fillMaxWidth())

        PizzaOptions(
            pizzaConfiguration = pizzaConfiguration,
            onSizeSelected = onSizeSelected,
            onDoughSelected = onDoughSelected
        )
    }
}
