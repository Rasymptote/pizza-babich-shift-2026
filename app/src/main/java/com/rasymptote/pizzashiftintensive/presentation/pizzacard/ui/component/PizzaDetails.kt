package com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.component

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
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration
import com.rasymptote.pizzashiftintensive.presentation.extension.titleRes
import com.rasymptote.pizzashiftintensive.presentation.ui.component.Image

@Composable
fun PizzaDetails(
    pizzaConfiguration: PizzaConfiguration,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        Image(
            imageUrl = pizzaConfiguration.pizza.imageUrl,
            contentDescription = pizzaConfiguration.pizza.name,
            modifier = Modifier
                .padding(horizontal = 54.dp, vertical = 32.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = pizzaConfiguration.pizza.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = stringResource(
                R.string.pizza_details,
                pizzaConfiguration.selectedSize.diameter,
                stringResource(pizzaConfiguration.selectedDough.type.titleRes())
            ),
            fontSize = 16.sp
        )

        Text(
            text = pizzaConfiguration.pizza.description,
            fontSize = 16.sp
        )
    }
}