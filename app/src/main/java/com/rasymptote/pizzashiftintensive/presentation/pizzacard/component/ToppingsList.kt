package com.rasymptote.pizzashiftintensive.presentation.pizzacard.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rasymptote.pizzashiftintensive.domain.model.PizzaIngredient
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.model.PizzaCard

@Composable
fun ToppingsList(
    pizzaCard: PizzaCard,
    onToppingClicked: (PizzaIngredient) -> Unit,
    rowSize: Int,
    modifier: Modifier = Modifier
) {
    val rows = pizzaCard.pizza.toppings.chunked(rowSize)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        rows.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { topping ->
                    ToppingCard(
                        topping = topping,
                        onToppingClicked = onToppingClicked,
                        modifier = Modifier.weight(1f),
                    )
                }

                repeat(rowSize - row.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}