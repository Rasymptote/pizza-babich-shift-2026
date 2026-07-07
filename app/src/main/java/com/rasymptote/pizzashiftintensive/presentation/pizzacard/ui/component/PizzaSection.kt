package com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rasymptote.pizzashiftintensive.domain.model.PizzaDough
import com.rasymptote.pizzashiftintensive.domain.model.PizzaSize
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.model.PizzaCard

@Composable
fun PizzaSection(
    pizzaCard: PizzaCard,
    onSizeSelected: (PizzaSize) -> Unit,
    onDoughSelected: (PizzaDough) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        PizzaDetails(pizzaCard = pizzaCard, Modifier.fillMaxWidth())

        PizzaOptions(
            pizzaCard = pizzaCard,
            onSizeSelected = onSizeSelected,
            onDoughSelected = onDoughSelected
        )
    }
}
