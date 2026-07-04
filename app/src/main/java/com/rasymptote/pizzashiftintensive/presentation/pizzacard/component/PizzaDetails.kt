package com.rasymptote.pizzashiftintensive.presentation.pizzacard.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.presentation.component.Image
import com.rasymptote.pizzashiftintensive.presentation.extension.titleRes
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.model.PizzaCard

@Composable
fun PizzaDetails(
    pizzaCard: PizzaCard,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        Image(
            imageUrl = pizzaCard.pizza.imageUrl,
            contentDescription = pizzaCard.pizza.name,
            modifier = Modifier
                .padding(horizontal = 54.dp, vertical = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = pizzaCard.pizza.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = stringResource(
                R.string.pizza_details,
                pizzaCard.selectedSize.diameter,
                stringResource(pizzaCard.selectedDough.type.titleRes())
            ),
            fontSize = 16.sp
        )

        Text(
            text = pizzaCard.pizza.description,
            fontSize = 16.sp
        )
    }
}