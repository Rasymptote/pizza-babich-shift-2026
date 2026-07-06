package com.rasymptote.pizzashiftintensive.presentation.pizzacard.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
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
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PizzaOptionsSelector(
            items = pizzaCard.pizza.sizes.map { stringResource(it.type.titleRes()) },
            selectedIndex = pizzaCard.pizza.sizes.indexOf(pizzaCard.selectedSize),
            onSelected = { index ->
                onSizeSelected(pizzaCard.pizza.sizes[index])
            },
            modifier = Modifier.fillMaxWidth()
        )

        PizzaOptionsSelector(
            items = pizzaCard.pizza.doughs.map { stringResource(it.type.titleRes()) },
            selectedIndex = pizzaCard.pizza.doughs.indexOf(pizzaCard.selectedDough),
            onSelected = { index ->
                onDoughSelected(pizzaCard.pizza.doughs[index])
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun PizzaOptionsSelector(
    items: List<String>,
    selectedIndex: Int,
    onSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    SingleChoiceSegmentedButtonRow(
        modifier = modifier
    ) {
        items.forEachIndexed { index, title ->
            SegmentedButton(
                selected = index == selectedIndex,
                onClick = { onSelected(index) },
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = items.size
                ),
                colors = SegmentedButtonDefaults.colors(
                    activeContainerColor = MaterialTheme.colorScheme.primary,
                    activeContentColor = MaterialTheme.colorScheme.onPrimary,

                    inactiveContainerColor = MaterialTheme.colorScheme.surface,
                    inactiveContentColor = MaterialTheme.colorScheme.onSurface,

                    activeBorderColor = MaterialTheme.colorScheme.primary,
                    inactiveBorderColor = MaterialTheme.colorScheme.outline
                ),
                label = {
                    Text(title)
                }
            )
        }
    }
}