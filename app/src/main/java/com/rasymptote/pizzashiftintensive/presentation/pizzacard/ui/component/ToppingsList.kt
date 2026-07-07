package com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rasymptote.pizzashiftintensive.domain.model.PizzaIngredient

@Composable
fun ToppingsList(
    toppings: List<PizzaIngredient>,
    selectedToppings: Set<PizzaIngredient>,
    onToppingSelected: (PizzaIngredient) -> Unit,
    columns: Int,
    modifier: Modifier = Modifier
) {
    val rows = toppings.chunked(columns)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        rows.forEach { row ->
            ToppingsRow(
                toppings = row,
                selectedToppings = selectedToppings,
                columns = columns,
                onToppingSelected = onToppingSelected
            )
        }
    }
}

@Composable
private fun ToppingsRow(
    toppings: List<PizzaIngredient>,
    selectedToppings: Set<PizzaIngredient>,
    columns: Int,
    onToppingSelected: (PizzaIngredient) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        toppings.forEach { topping ->
            ToppingCard(
                topping = topping,
                isSelected = topping in selectedToppings,
                onToppingSelected = onToppingSelected,
                modifier = Modifier.weight(1f)
            )
        }

        EmptyCells(count = columns - toppings.size)
    }
}

@Composable
private fun RowScope.EmptyCells(
    count: Int,
    modifier: Modifier = Modifier
) {
    repeat(count) {
        Spacer(
            modifier = modifier.weight(1f)
        )
    }
}