package com.rasymptote.pizzashiftintensive.presentation.cart.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.presentation.cart.component.Cart
import com.rasymptote.pizzashiftintensive.presentation.cart.viewmodel.CartScreenState
import com.rasymptote.pizzashiftintensive.presentation.cart.viewmodel.CartViewModel
import com.rasymptote.pizzashiftintensive.presentation.ui.component.Title

@Composable
fun CartScreen(
    viewModel: CartViewModel,
    onBackClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CartTitle(onBackClick = onBackClick)

        when (val current = state) {
            CartScreenState.Initial -> {}

            is CartScreenState.Content -> {
                Cart(
                    items = current.items,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun CartTitle(
    onBackClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(R.string.back_button)
            )
        }
        Title(text = stringResource(R.string.cart_title))
    }
}