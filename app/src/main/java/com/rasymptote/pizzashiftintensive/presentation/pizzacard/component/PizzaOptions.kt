package com.rasymptote.pizzashiftintensive.presentation.pizzacard.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rasymptote.pizzashiftintensive.domain.model.PizzaDough
import com.rasymptote.pizzashiftintensive.domain.model.PizzaSize
import com.rasymptote.pizzashiftintensive.presentation.extension.titleRes
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.model.PizzaCard

@Composable
fun PizzaOptions(
    pizzaCard: PizzaCard,
    onSizeSelected: (PizzaSize) -> Unit,
    onDoughSelected: (PizzaDough) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        PizzaSelector(
            items = pizzaCard.pizza.sizes,
            selectedItem = pizzaCard.selectedSize,
            onItemSelected = onSizeSelected,
            label = { stringResource(it.type.titleRes()) },
            modifier = Modifier.fillMaxWidth()
        )

        PizzaSelector(
            items = pizzaCard.pizza.doughs,
            selectedItem = pizzaCard.selectedDough,
            onItemSelected = onDoughSelected,
            label = { stringResource(it.type.titleRes()) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}