package com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.presentation.component.ErrorMessage
import com.rasymptote.pizzashiftintensive.presentation.component.FullScreenProgressIndicator
import com.rasymptote.pizzashiftintensive.presentation.component.Title
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.component.PizzaCard
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.viewmodel.PizzaCardScreenState
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.viewmodel.PizzaCardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaCardScreen(
    viewModel: PizzaCardViewModel = hiltViewModel(),
    pizzaId: String,
    onBackClick: () -> Unit
) {
    LaunchedEffect(pizzaId) {
        viewModel.getPizzaCard(pizzaId)
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
                    onRetry = { viewModel.getPizzaCard(pizzaId) }
                )

            is PizzaCardScreenState.Content ->
                PizzaCard(
                    pizzaCard = currentState.pizzaCard,
                    onSizeSelected = viewModel::onSizeSelected,
                    onDoughSelected = viewModel::onDoughSelected,
                    onToppingSelected = viewModel::onToppingSelected
                )
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
