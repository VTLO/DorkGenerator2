package com.dorkgen.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dorks")
data class Dork(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val query: String,
    val category: String,
    val timestamp: Long = System.currentTimeMillis(),
    val isFavorite: Boolean = false,
    val searchEngine: String = "Google"
)

data class DorkCategory(
    val id: String,
    val name: String,
    val icon: String,
    val description: String,
    val templates: List<DorkTemplate>
)

data class DorkTemplate(
    val name: String,
    val query: String,
    val description: String
)

data class SearchEngine(
    val id: String,
    val name: String,
    val baseUrl: String,
    val queryParam: String
)

enum class DorkOperator(val operator: String, val description: String) {
    SITE("site:", "Recherche dans un domaine spécifique"),
    FILETYPE("filetype:", "Recherche par type de fichier"),
    INURL("inurl:", "Terme dans l'URL"),
    INTITLE("intitle:", "Terme dans le titre"),
    INTEXT("intext:", "Terme dans le texte"),
    CACHE("cache:", "Version en cache"),
    LINK("link:", "Pages avec lien vers"),
    RELATED("related:", "Sites similaires"),
    INFO("info:", "Informations sur un site"),
    DEFINE("define:", "Définition d'un terme"),
    ALLINTITLE("allintitle:", "Tous les termes dans le titre"),
    ALLINURL("allinurl:", "Tous les termes dans l'URL"),
    ALLINTEXT("allintext:", "Tous les termes dans le texte"),
    BEFORE("before:", "Avant une date (YYYY-MM-DD)"),
    AFTER("after:", "Après une date (YYYY-MM-DD)")
}
