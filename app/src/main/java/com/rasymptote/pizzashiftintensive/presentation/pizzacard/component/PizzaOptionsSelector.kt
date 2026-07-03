package com.rasymptote.pizzashiftintensive.presentation.pizzacard.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rasymptote.pizzashiftintensive.presentation.component.SegmentedSelector

@Composable
fun <T> PizzaSelector(
    items: List<T>,
    selectedItem: T,
    onItemSelected: (T) -> Unit,
    label: @Composable (T) -> String,
    modifier: Modifier = Modifier
) {
    SegmentedSelector(
        modifier = modifier,
        items = items,
        selectedItem = selectedItem,
        onItemSelected = onItemSelected,
        label = label
    )
}