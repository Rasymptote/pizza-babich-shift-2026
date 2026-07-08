package com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.component

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
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaDough
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaSize
import com.rasymptote.pizzashiftintensive.presentation.extension.titleRes

@Composable
fun PizzaOptions(
    pizzaConfiguration: PizzaConfiguration,
    onSizeSelected: (PizzaSize) -> Unit,
    onDoughSelected: (PizzaDough) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        PizzaOptionsSelector(
            items = pizzaConfiguration.pizza.sizes.map { stringResource(it.type.titleRes()) },
            selectedIndex = pizzaConfiguration.pizza.sizes.indexOf(pizzaConfiguration.selectedSize),
            onSelected = { index ->
                onSizeSelected(pizzaConfiguration.pizza.sizes[index])
            },
            modifier = Modifier.fillMaxWidth()
        )

        PizzaOptionsSelector(
            items = pizzaConfiguration.pizza.doughs.map { stringResource(it.type.titleRes()) },
            selectedIndex = pizzaConfiguration.pizza.doughs.indexOf(pizzaConfiguration.selectedDough),
            onSelected = { index ->
                onDoughSelected(pizzaConfiguration.pizza.doughs[index])
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