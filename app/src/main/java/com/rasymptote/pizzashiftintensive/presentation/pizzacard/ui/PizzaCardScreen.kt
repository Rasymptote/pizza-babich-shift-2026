package com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.domain.model.pizza.PizzaConfiguration
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui.component.PizzaCard
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.viewmodel.PizzaCardScreenState
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.viewmodel.PizzaCardViewModel
import com.rasymptote.pizzashiftintensive.presentation.ui.component.ErrorMessage
import com.rasymptote.pizzashiftintensive.presentation.ui.component.FullScreenProgressIndicator
import com.rasymptote.pizzashiftintensive.presentation.ui.component.PrimaryButton
import com.rasymptote.pizzashiftintensive.presentation.ui.component.Title

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaCardScreen(
    viewModel: PizzaCardViewModel = hiltViewModel(),
    pizzaId: String,
    onBackClick: () -> Unit,
    onAddToCartClick: (PizzaConfiguration) -> Unit,
) {
    LaunchedEffect(pizzaId) {
        viewModel.getPizzaCard(pizzaId = pizzaId)
    }

    val state by viewModel.state.collectAsState()

    Column(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        PizzaCardTitle(onBackClick = onBackClick)
        when (val currentState = state) {
            PizzaCardScreenState.Initial,
            PizzaCardScreenState.Loading ->
                FullScreenProgressIndicator()

            is PizzaCardScreenState.Error ->
                ErrorMessage(
                    message = currentState.message,
                    positiveButtonText = stringResource(R.string.error_retry_button),
                    onRetry = { viewModel.getPizzaCard(pizzaId = pizzaId) }
                )

            is PizzaCardScreenState.Content -> {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    PizzaCard(
                        pizzaConfiguration = currentState.pizzaConfiguration,
                        onSizeSelected = viewModel::onSizeSelected,
                        onDoughSelected = viewModel::onDoughSelected,
                        onToppingSelected = viewModel::onToppingSelected
                    )

                    PrimaryButton(
                        text = stringResource(
                            R.string.cart_button_price,
                            currentState.price
                        ),
                        onClick = { onAddToCartClick(currentState.pizzaConfiguration) },
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                            .align(Alignment.BottomCenter)
                    )
                }
            }
        }
    }
}

@Composable
private fun PizzaCardTitle(
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
        Title(text = stringResource(R.string.pizza_card_title))
    }
}
