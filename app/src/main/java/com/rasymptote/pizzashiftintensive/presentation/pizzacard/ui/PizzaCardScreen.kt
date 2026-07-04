package com.rasymptote.pizzashiftintensive.presentation.pizzacard.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.presentation.component.ErrorMessage
import com.rasymptote.pizzashiftintensive.presentation.component.FullScreenProgressIndicator
import com.rasymptote.pizzashiftintensive.presentation.component.Title
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.component.PizzaSection
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.component.ToppingsSection
import com.rasymptote.pizzashiftintensive.presentation.pizzacard.viewmodel.PizzaCardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaCardScreen(
    viewModel: PizzaCardViewModel = viewModel()
) {

    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Title(text = "Пицца") }
            )
        }
    ) { padding ->

        when (val currentState = state) {
            PizzaCardScreenState.Initial -> {
                viewModel.getPizzaCard("1")
            }

            PizzaCardScreenState.Loading -> {
                FullScreenProgressIndicator()
            }

            is PizzaCardScreenState.Error -> {
                ErrorMessage(
                    message = currentState.message,
                    positiveButtonText = stringResource(R.string.error_retry_button),
                    onRetry = {}
                )
            }

            is PizzaCardScreenState.Content -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(padding)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    contentPadding = PaddingValues(bottom = 24.dp)
                ) {
                    item {
                        PizzaSection(
                            pizzaCard = currentState.pizzaCard,
                            onSizeSelected = viewModel::onSizeSelected,
                            onDoughSelected = viewModel::onDoughSelected,
                        )
                    }

                    item {
                        ToppingsSection(
                            pizzaCard = currentState.pizzaCard,
                            onToppingClicked = viewModel::onToppingClicked
                        )
                    }
                }
            }
        }
    }
}


