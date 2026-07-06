package com.rasymptote.pizzashiftintensive.presentation.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.presentation.navigation.NavigationOption

@Composable
fun BottomBar(
    selected: NavigationOption,
    onItemClick: (NavigationOption) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(40.dp),
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.outline
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            NavigationOption.entries.forEach { option ->
                BottomBarItem(
                    modifier = Modifier.weight(1f),
                    option = option,
                    selected = option == selected,
                    onClick = { onItemClick(option) }
                )
            }
        }
    }
}

@Composable
private fun BottomBarItem(
    modifier: Modifier,
    option: NavigationOption,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(50.dp))
            .background(
                if (selected)
                    MaterialTheme.colorScheme.primary
                else
                    Color.Transparent
            )
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = option.icon(),
            contentDescription = null,
            tint = if (selected) {
                MaterialTheme.colorScheme.onPrimary
            } else {
                MaterialTheme.colorScheme.outline
            },
            modifier = Modifier.size(24.dp)
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = option.label(),
            color = if (selected) {
                MaterialTheme.colorScheme.onPrimary
            } else {
                MaterialTheme.colorScheme.outline
            }
        )
    }
}

@Composable
private fun NavigationOption.icon(): Painter =
    painterResource(
        when (this) {
            NavigationOption.ORDERS -> R.drawable.ic_orders
            NavigationOption.CART -> R.drawable.ic_shopping_cart
            NavigationOption.PROFILE -> R.drawable.ic_profile
            NavigationOption.PIZZA -> R.drawable.ic_pizza
        }
    )

@Composable
private fun NavigationOption.label(): String =
    stringResource(
        when (this) {
            NavigationOption.ORDERS -> R.string.bottom_bar_orders
            NavigationOption.CART -> R.string.bottom_bar_cart
            NavigationOption.PROFILE -> R.string.bottom_bar_profile
            NavigationOption.PIZZA -> R.string.bottom_bar_pizza
        }
    )