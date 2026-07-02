package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rasymptote.pizzashiftintensive.domain.model.Pizza

@Composable
fun PizzaDetails(
    pizza: Pizza,
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
    }
}