package com.rasymptote.pizzashiftintensive.presentation.cart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.domain.model.cart.CartItem
import com.rasymptote.pizzashiftintensive.domain.model.pizza.Dough
import com.rasymptote.pizzashiftintensive.domain.model.pizza.Ingredient
import com.rasymptote.pizzashiftintensive.domain.model.pizza.Size
import com.rasymptote.pizzashiftintensive.presentation.extension.titleRes
import com.rasymptote.pizzashiftintensive.presentation.ui.component.Image

@Composable
fun CartItemCard(
    item: CartItem,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            imageUrl = item.imageUrl,
            contentDescription = item.pizzaName,
            modifier = Modifier.size(88.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = item.pizzaName,
            )

            SizeAndDough(
                size = item.selectedSize,
                dough = item.selectedDough
            )

            Toppings(item.selectedToppings)

            Price(item.price)
        }
    }
}

@Composable
private fun SizeAndDough(
    size: Size,
    dough: Dough
) {
    Text(
        text = stringResource(
            R.string.pizza_details,
            size.diameter,
            stringResource(dough.titleRes()).lowercase()
        )
    )
}

@Composable
private fun Toppings(
    selectedToppings: Set<Ingredient>
) {
    if (selectedToppings.isEmpty()) {
        return
    }

    val toppings = selectedToppings
        .map { stringResource(it.titleRes()).lowercase() }
        .joinToString(", ")

    Text(
        text = "+ $toppings",
    )
}

@Composable
private fun Price(
    price: Int
) {
    Text(
        text = stringResource(
            R.string.price_format,
            price,
            stringResource(R.string.currency_rub)
        ),
    )
}