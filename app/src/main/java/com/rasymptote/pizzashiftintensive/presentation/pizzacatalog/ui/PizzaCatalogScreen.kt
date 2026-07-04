package com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rasymptote.pizzashiftintensive.presentation.component.ErrorMessage
import com.rasymptote.pizzashiftintensive.presentation.component.FullScreenProgressIndicator
import com.rasymptote.pizzashiftintensive.presentation.component.Title
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.component.PizzaCatalog
import com.rasymptote.pizzashiftintensive.presentation.pizzacatalog.viewmodel.PizzaCatalogViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaCatalogScreen(
    viewModel: PizzaCatalogViewModel = viewModel()
) {

    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar (
                { Title() }
            )
        }
    ) { padding ->

        when (val currentState = state) {
            PizzaCatalogScreenState.Initial -> {
                viewModel.getBasePricedPizzas()
            }

            PizzaCatalogScreenState.Loading -> {
                FullScreenProgressIndicator()
            }

            is PizzaCatalogScreenState.Error -> {
                ErrorMessage(
                    message = currentState.message,
                    onRetry = {
                        viewModel.getBasePricedPizzas()
                    }
                )
            }

            is PizzaCatalogScreenState.Content ->
                PizzaCatalog(
                    pizzas = currentState.pizzas,
                    modifier = Modifier.padding(padding),
                    {}
                )
        }
    }
}
