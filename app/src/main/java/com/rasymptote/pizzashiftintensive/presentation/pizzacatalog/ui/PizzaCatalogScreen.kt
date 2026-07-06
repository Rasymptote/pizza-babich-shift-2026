package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.rasymptote.pizzashiftintensive.R
import com.rasymptote.pizzashiftintensive.presentation.component.ErrorMessage
import com.rasymptote.pizzashiftintensive.presentation.component.FullScreenProgressIndicator
import com.rasymptote.pizzashiftintensive.presentation.component.Title
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.component.PizzaCatalog
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.viewmodel.PizzaCatalogScreenState
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.viewmodel.PizzaCatalogViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaCatalogScreen(
    modifier: Modifier = Modifier,
    viewModel: PizzaCatalogViewModel = hiltViewModel(),
    onPizzaCardClick: (String) -> Unit,
) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getBasePricedPizzas()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Title(text = stringResource(R.string.pizza_catalog_title))

        when (val currentState = state) {
            PizzaCatalogScreenState.Initial,
            PizzaCatalogScreenState.Loading ->
                FullScreenProgressIndicator()

            is PizzaCatalogScreenState.Error ->
                ErrorMessage(
                    message = currentState.message,
                    positiveButtonText = stringResource(R.string.error_retry_button),
                    onRetry = {
                        viewModel.getBasePricedPizzas()
                    }
                )

            is PizzaCatalogScreenState.Content ->
                PizzaCatalog(
                    pizzas = currentState.pizzas,
                    onPizzaCardClick = onPizzaCardClick
                )
        }
    }
}
