package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rasymptote.pizzashiftintensive.presentation.component.Image
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.model.BasePricedPizza

@Composable
fun PizzaCatalogItem(
    pizza: BasePricedPizza,
    onClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(pizza.pizza.id) },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            imageUrl = pizza.pizza.imageUrl,
            contentDescription = pizza.pizza.name,
            modifier = Modifier.size(120.dp)
        )

        Spacer(Modifier.width(24.dp))

        PizzaDetails(
            pizza = pizza,
            modifier = Modifier.weight(1f)
        )
    }
}
