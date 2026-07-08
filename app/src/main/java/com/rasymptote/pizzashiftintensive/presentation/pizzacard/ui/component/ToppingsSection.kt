package com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaIngredient

@Composable
fun ToppingsSection(
    pizzaConfiguration: PizzaConfiguration,
    onToppingSelected: (PizzaIngredient) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        ToppingsSectionTitle()

        ToppingsList(
            toppings = pizzaConfiguration.pizza.toppings,
            selectedToppings = pizzaConfiguration.selectedToppings,
            onToppingSelected = onToppingSelected,
        )
    }
}

@Composable
private fun ToppingsSectionTitle() {
    Text(
        text = stringResource(R.string.toppings_section),
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    )
}