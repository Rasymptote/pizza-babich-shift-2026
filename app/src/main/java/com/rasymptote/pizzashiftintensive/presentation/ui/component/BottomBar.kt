package com.rasymptote.pizzashiftintensive.presentation.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            .background(bottomBarItemBackground(selected))
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = option.icon(),
            contentDescription = null,
            tint = bottomBarItemContentColor(selected),
            modifier = Modifier.size(24.dp)
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = option.label(),
            color = bottomBarItemContentColor(selected)
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


@Composable
private fun bottomBarItemBackground(selected: Boolean): Color =
    if (selected) {
        MaterialTheme.colorScheme.primary
    } else {
        Color.Transparent
    }

@Composable
private fun bottomBarItemContentColor(selected: Boolean): Color =
    if (selected) {
        MaterialTheme.colorScheme.onPrimary
    } else {
        MaterialTheme.colorScheme.outline
    }