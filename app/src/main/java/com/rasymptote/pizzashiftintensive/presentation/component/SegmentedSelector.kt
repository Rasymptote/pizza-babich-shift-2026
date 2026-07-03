package com.rasymptote.pizzashiftintensive.presentation.component

import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun <T> SegmentedSelector(
    items: List<T>,
    selectedItem: T,
    onItemSelected: (T) -> Unit,
    label: @Composable (T) -> String,
    modifier: Modifier = Modifier
) {
    SingleChoiceSegmentedButtonRow(
        modifier = modifier
    ) {
        items.forEachIndexed { index, item ->
            SegmentedButton(
                selected = item == selectedItem,
                onClick = { onItemSelected(item) },
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = items.size
                ),
                label = {
                    Text(label(item))
                }
            )
        }
    }
}