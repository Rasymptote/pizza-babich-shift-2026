package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.model.PizzaScreenModel

@Composable
fun PizzaDetails(
    pizza: PizzaScreenModel,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Text(
            text = pizza.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = pizza.description,
            fontSize = 16.sp,
        )
        Text(
            text = stringResource(R.string.pizza_price, pizza.initialPrice),
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}