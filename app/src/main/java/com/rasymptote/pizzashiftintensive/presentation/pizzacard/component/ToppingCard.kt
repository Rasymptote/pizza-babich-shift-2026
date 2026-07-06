package com.rasymptote.pizzashiftintensive.presentation.pizzacard.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.domain.model.Ingredient
import com.rasymptote.pizzashiftintensive.domain.model.PizzaIngredient
import com.rasymptote.pizzashiftintensive.presentation.component.Image
import com.rasymptote.pizzashiftintensive.presentation.extension.titleRes

@Composable
fun ToppingCard(
    topping: PizzaIngredient,
    isSelected: Boolean,
    onToppingSelected: (PizzaIngredient) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        onClick = { onToppingSelected(topping) },
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Image(
                imageUrl = topping.imageUrl,
                contentDescription = stringResource(topping.type.titleRes()),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(top = 8.dp)
            )

            ToppingTitle(
                toppingType = topping.type,
                modifier = Modifier.weight(1f)
            )

            ToppingPriceBadge(
                price = topping.price,
                isSelected = isSelected
            )
        }
    }
}

@Composable
private fun ToppingTitle(
    toppingType: Ingredient,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(toppingType.titleRes()),
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        lineHeight = 16.sp,
        modifier = modifier,
    )
}

@Composable
private fun ToppingPriceBadge(
    price: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val currency = stringResource(R.string.currency_rub)

    val background = if (isSelected) {
        MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
    } else {
        MaterialTheme.colorScheme.surfaceVariant
    }

    val textColor = if (isSelected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurface
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50))
            .background(background)
            .padding(vertical = 4.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.price_format, price, currency),
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = textColor
        )
    }
}