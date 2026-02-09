package com.dorkgen.app.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.dorkgen.app.data.model.DorkOperator
import com.dorkgen.app.data.model.DorkTemplate
import com.dorkgen.app.utils.DorkTemplates
import com.dorkgen.app.viewmodel.DorkViewModel
import java.net.URLEncoder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneratorScreen(
    viewModel: DorkViewModel,
    categoryId: String?,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val currentQuery by viewModel.currentQuery.collectAsState()
    val selectedEngine by viewModel.selectedEngine.collectAsState()
    
    var showEngineSelector by remember { mutableStateOf(false) }
    var showOperatorHelper by remember { mutableStateOf(false) }
    var showTemplates by remember { mutableStateOf(categoryId != null) }
    
    val category = categoryId?.let { DorkTemplates.getCategoryById(it) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(category?.name ?: "Générateur de Dorks") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Retour")
                    }
                },
                actions = {
                    IconButton(onClick = { showOperatorHelper = true }) {
                        Icon(Icons.Default.Help, contentDescription = "Aide")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Query input
            OutlinedTextField(
                value = currentQuery,
                onValueChange = { viewModel.updateQuery(it) },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Requête Dork") },
                placeholder = { Text("Entrez votre dork ici...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                trailingIcon = {
                    if (currentQuery.isNotEmpty()) {
                        IconButton(onClick = { viewModel.updateQuery("") }) {
                            Icon(Icons.Default.Clear, contentDescription = "Effacer")
                        }
                    }
                },
                minLines = 3,
                maxLines = 5,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                shape = RoundedCornerShape(12.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Search engine selector
            Card(
                modifier = Modifier.fillMaxWidth(),
                onClick = { showEngineSelector = true }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            "Moteur de recherche",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            DorkTemplates.getSearchEngineById(selectedEngine)?.name ?: "Google",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Action buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        if (currentQuery.isNotEmpty()) {
                            val engine = DorkTemplates.getSearchEngineById(selectedEngine)
                            if (engine != null) {
                                val encodedQuery = URLEncoder.encode(currentQuery, "UTF-8")
                                val searchUrl = "${engine.baseUrl}?${engine.queryParam}=$encodedQuery"
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(searchUrl))
                                context.startActivity(intent)
                                
                                // Save to history
                                viewModel.saveDork(
                                    currentQuery,
                                    category?.name ?: "Personnalisé"
                                )
                            }
                        }
                    },
                    modifier = Modifier.weight(1f),
                    enabled = currentQuery.isNotEmpty(),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(Icons.Default.Search, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Rechercher")
                }
                
                OutlinedButton(
                    onClick = { showTemplates = !showTemplates },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Icon(
                        if (showTemplates) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Templates")
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Templates list
            if (showTemplates && category != null) {
                Text(
                    "Templates disponibles",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(8.dp))
                
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(category.templates) { template ->
                        TemplateCard(
                            template = template,
                            onClick = { viewModel.updateQuery(template.query) }
                        )
                    }
                }
            } else if (showTemplates) {
                Text(
                    "Aucun template pour cette catégorie",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
    
    // Engine selector dialog
    if (showEngineSelector) {
        AlertDialog(
            onDismissRequest = { showEngineSelector = false },
            title = { Text("Choisir un moteur") },
            text = {
                Column {
                    DorkTemplates.searchEngines.forEach { engine ->
                        ListItem(
                            headlineContent = { Text(engine.name) },
                            modifier = Modifier.clickable {
                                viewModel.setSearchEngine(engine.id)
                                showEngineSelector = false
                            },
                            leadingContent = {
                                RadioButton(
                                    selected = engine.id == selectedEngine,
                                    onClick = {
                                        viewModel.setSearchEngine(engine.id)
                                        showEngineSelector = false
                                    }
                                )
                            }
                        )
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showEngineSelector = false }) {
                    Text("Fermer")
                }
            }
        )
    }
    
    // Operator helper dialog
    if (showOperatorHelper) {
        AlertDialog(
            onDismissRequest = { showOperatorHelper = false },
            title = { Text("Opérateurs Dork") },
            text = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    DorkOperator.values().forEach { operator ->
                        ListItem(
                            headlineContent = { 
                                Text(
                                    operator.operator,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            supportingContent = { Text(operator.description) },
                            modifier = Modifier.clickable {
                                viewModel.updateQuery(currentQuery + " ${operator.operator}")
                                showOperatorHelper = false
                            }
                        )
                        if (operator != DorkOperator.values().last()) {
                            Divider()
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showOperatorHelper = false }) {
                    Text("Fermer")
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemplateCard(
    template: DorkTemplate,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                template.name,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                template.query,
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                template.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
