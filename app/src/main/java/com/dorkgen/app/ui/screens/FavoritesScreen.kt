package com.dorkgen.app.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.dorkgen.app.viewmodel.DorkViewModel
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(
    viewModel: DorkViewModel
) {
    val context = LocalContext.current
    val favoriteDorks by viewModel.favoriteDorks.collectAsState()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favoris") }
            )
        }
    ) { padding ->
        if (favoriteDorks.isEmpty()) {
            EmptyState(message = "Aucun favori")
        } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(padding)
            ) {
                items(favoriteDorks) { dork ->
                    DorkHistoryItem(
                        dork = dork,
                        onExecute = {
                            val encodedQuery = URLEncoder.encode(dork.query, "UTF-8")
                            val searchUrl = when (dork.searchEngine.lowercase()) {
                                "google" -> "https://www.google.com/search?q=$encodedQuery"
                                "bing" -> "https://www.bing.com/search?q=$encodedQuery"
                                "duckduckgo" -> "https://duckduckgo.com/?q=$encodedQuery"
                                "yandex" -> "https://yandex.com/search/?text=$encodedQuery"
                                "baidu" -> "https://www.baidu.com/s?wd=$encodedQuery"
                                else -> "https://www.google.com/search?q=$encodedQuery"
                            }
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl))
                            context.startActivity(intent)
                        },
                        onToggleFavorite = { viewModel.toggleFavorite(dork) },
                        onDelete = { viewModel.deleteDork(dork) }
                    )
                }
            }
        }
    }
}
