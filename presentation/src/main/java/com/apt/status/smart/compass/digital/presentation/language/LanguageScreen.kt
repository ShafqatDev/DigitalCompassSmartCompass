package com.apt.status.smart.compass.digital.presentation.language

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.apt.status.smart.compass.digital.presentation.language.components.LanguageView
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageScreen(
//    fromSplash: Boolean = false,
    viewModel: LanguageViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    BackHandler {
//        if (!fromSplash) {
//            viewModel.incrementSessionCount()
//        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
//                        if (!fromSplash) {
//                            viewModel.incrementSessionCount()
//                        }
                    }) {
                        Icon(Icons.Default.ArrowBackIosNew, contentDescription = null)
                    }
                },
                title = {
                    Text(text = "Select Language")
                },
                actions = {
                    IconButton(onClick = {
                        viewModel.languageSelected()
                        viewModel.incrementSessionCount()
                    }) {
                        Icon(Icons.Default.Done, contentDescription = null)
                    }
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            content = {
                items(state.languagesList, key = { it.hashCode() }) { model ->
                    LanguageView(
                        isSelected = state.selectedLangCode == model.shortCode,
                        language = model,
                        onLanguageSelected = {
                            viewModel.changeLang(model)
                        }
                    )
                }
            }
        )
    }
}
