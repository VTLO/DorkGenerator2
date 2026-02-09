package com.dorkgen.app.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dorkgen.app.viewmodel.DorkViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: DorkViewModel
) {
    val context = LocalContext.current
    var showExportDialog by remember { mutableStateOf(false) }
    var showClearAllDialog by remember { mutableStateOf(false) }
    var showAboutDialog by remember { mutableStateOf(false) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Paramètres") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            // Data section
            Text(
                "Données",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(16.dp)
            )
            
            SettingItem(
                icon = Icons.Default.FileUpload,
                title = "Exporter les dorks",
                description = "Sauvegarder vos dorks en JSON",
                onClick = { showExportDialog = true }
            )
            
            Divider(modifier = Modifier.padding(horizontal = 16.dp))
            
            SettingItem(
                icon = Icons.Default.DeleteForever,
                title = "Effacer toutes les données",
                description = "Supprimer l'historique et les favoris",
                onClick = { showClearAllDialog = true },
                isDestructive = true
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // About section
            Text(
                "À propos",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(16.dp)
            )
            
            SettingItem(
                icon = Icons.Default.Info,
                title = "À propos de l'application",
                description = "Version 1.0",
                onClick = { showAboutDialog = true }
            )
            
            Divider(modifier = Modifier.padding(horizontal = 16.dp))
            
            SettingItem(
                icon = Icons.Default.Security,
                title = "Utilisation éthique",
                description = "Guide des bonnes pratiques",
                onClick = {
                    Toast.makeText(
                        context,
                        "Utilisez les dorks de manière responsable et légale",
                        Toast.LENGTH_LONG
                    ).show()
                }
            )
        }
    }
    
    // Export dialog
    if (showExportDialog) {
        val exportData = viewModel.exportDorks()
        AlertDialog(
            onDismissRequest = { showExportDialog = false },
            icon = { Icon(Icons.Default.FileUpload, contentDescription = null) },
            title = { Text("Exporter les dorks") },
            text = {
                Column {
                    Text("Les dorks ont été exportés au format JSON.")
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = exportData,
                        onValueChange = {},
                        readOnly = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        textStyle = androidx.compose.ui.text.TextStyle(
                            fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace,
                            fontSize = androidx.compose.ui.unit.TextUnit(10f, androidx.compose.ui.unit.TextUnitType.Sp)
                        )
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText("Dorks Export", exportData)
                        clipboard.setPrimaryClip(clip)
                        Toast.makeText(context, "Copié dans le presse-papier", Toast.LENGTH_SHORT).show()
                        showExportDialog = false
                    }
                ) {
                    Text("Copier")
                }
            },
            dismissButton = {
                TextButton(onClick = { showExportDialog = false }) {
                    Text("Fermer")
                }
            }
        )
    }
    
    // Clear all dialog
    if (showClearAllDialog) {
        AlertDialog(
            onDismissRequest = { showClearAllDialog = false },
            icon = { Icon(Icons.Default.Warning, contentDescription = null, tint = MaterialTheme.colorScheme.error) },
            title = { Text("Effacer toutes les données") },
            text = { Text("Cette action est irréversible. Tous vos dorks, historiques et favoris seront supprimés définitivement.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.clearAllData()
                        showClearAllDialog = false
                        Toast.makeText(context, "Toutes les données ont été supprimées", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Text("Effacer tout")
                }
            },
            dismissButton = {
                TextButton(onClick = { showClearAllDialog = false }) {
                    Text("Annuler")
                }
            }
        )
    }
    
    // About dialog
    if (showAboutDialog) {
        AlertDialog(
            onDismissRequest = { showAboutDialog = false },
            icon = { Icon(Icons.Default.Info, contentDescription = null) },
            title = { Text("Dork Generator") },
            text = {
                Column {
                    Text("Version 1.0", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Application de génération de dorks avancés pour la recherche.")
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "⚠️ Avertissement",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.error
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "Cette application est destinée à un usage éducatif et de recherche légitime uniquement. " +
                        "L'utilisateur est seul responsable de l'utilisation qu'il en fait. " +
                        "Respectez les lois en vigueur et la vie privée d'autrui.",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("© 2024 Dork Generator", style = MaterialTheme.typography.bodySmall)
                }
            },
            confirmButton = {
                TextButton(onClick = { showAboutDialog = false }) {
                    Text("Fermer")
                }
            }
        )
    }
}

@Composable
fun SettingItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    description: String,
    onClick: () -> Unit,
    isDestructive: Boolean = false
) {
    ListItem(
        headlineContent = { 
            Text(
                title,
                color = if (isDestructive) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
            )
        },
        supportingContent = { Text(description) },
        leadingContent = { 
            Icon(
                icon, 
                contentDescription = null,
                tint = if (isDestructive) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
            ) 
        },
        modifier = androidx.compose.ui.Modifier.clickable(onClick = onClick)
    )
}
