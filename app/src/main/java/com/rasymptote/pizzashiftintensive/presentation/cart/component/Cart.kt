package com.rasymptote.pizzashiftintensive.presentation.cart.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rasymptote.pizzashiftintensive.domain.model.cart.CartItem

@Composable
fun Cart(
    items: List<CartItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        ) {
        itemsIndexed(
            items = items,
            key = { _, item -> item.id!! }
        ) { index, item ->

            CartItemCard(
                item = item,
                modifier = Modifier.padding(vertical = 24.dp)
            )

            if (index != items.lastIndex) {
                HorizontalDivider()
            }
        }
    }
}