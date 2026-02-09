package com.dorkgen.app.utils

import com.dorkgen.app.data.model.DorkCategory
import com.dorkgen.app.data.model.DorkTemplate
import com.dorkgen.app.data.model.SearchEngine

object DorkTemplates {
    
    val searchEngines = listOf(
        SearchEngine("google", "Google", "https://www.google.com/search", "q"),
        SearchEngine("bing", "Bing", "https://www.bing.com/search", "q"),
        SearchEngine("duckduckgo", "DuckDuckGo", "https://duckduckgo.com/", "q"),
        SearchEngine("yandex", "Yandex", "https://yandex.com/search/", "text"),
        SearchEngine("baidu", "Baidu", "https://www.baidu.com/s", "wd")
    )
    
    val categories = listOf(
        DorkCategory(
            id = "files",
            name = "Recherche de fichiers",
            icon = "📄",
            description = "Trouver des documents spécifiques",
            templates = listOf(
                DorkTemplate(
                    "PDF publics",
                    "filetype:pdf",
                    "Rechercher tous les fichiers PDF"
                ),
                DorkTemplate(
                    "Documents Word",
                    "filetype:doc OR filetype:docx",
                    "Trouver des documents Word"
                ),
                DorkTemplate(
                    "Feuilles de calcul",
                    "filetype:xls OR filetype:xlsx",
                    "Rechercher des fichiers Excel"
                ),
                DorkTemplate(
                    "Présentations",
                    "filetype:ppt OR filetype:pptx",
                    "Trouver des présentations PowerPoint"
                ),
                DorkTemplate(
                    "Fichiers texte",
                    "filetype:txt",
                    "Rechercher des fichiers texte"
                ),
                DorkTemplate(
                    "Archives",
                    "filetype:zip OR filetype:rar",
                    "Trouver des archives compressées"
                ),
                DorkTemplate(
                    "Documents sensibles",
                    "filetype:pdf intitle:\"confidentiel\" OR intitle:\"privé\"",
                    "Rechercher des documents potentiellement sensibles"
                )
            )
        ),
        DorkCategory(
            id = "vulnerabilities",
            name = "Vulnérabilités Web",
            icon = "🔓",
            description = "Recherche de sécurité web",
            templates = listOf(
                DorkTemplate(
                    "Répertoires exposés",
                    "intitle:\"Index of /\"",
                    "Trouver des répertoires web exposés"
                ),
                DorkTemplate(
                    "Fichiers de configuration",
                    "filetype:env OR filetype:config OR filetype:ini",
                    "Rechercher des fichiers de configuration"
                ),
                DorkTemplate(
                    "Bases de données",
                    "filetype:sql OR filetype:db",
                    "Trouver des fichiers de base de données"
                ),
                DorkTemplate(
                    "Logs serveur",
                    "filetype:log",
                    "Rechercher des fichiers de logs"
                ),
                DorkTemplate(
                    "Backups exposés",
                    "filetype:bak OR filetype:backup",
                    "Trouver des fichiers de sauvegarde"
                ),
                DorkTemplate(
                    "Erreurs PHP",
                    "intext:\"Warning: mysql_connect()\" OR intext:\"SQL syntax error\"",
                    "Rechercher des pages avec erreurs PHP/SQL"
                ),
                DorkTemplate(
                    "Panneaux admin",
                    "inurl:admin OR inurl:administrator OR inurl:panel",
                    "Trouver des interfaces d'administration"
                )
            )
        ),
        DorkCategory(
            id = "public_info",
            name = "Informations publiques",
            icon = "🌍",
            description = "Données publiquement accessibles",
            templates = listOf(
                DorkTemplate(
                    "Annuaires professionnels",
                    "intitle:\"employee directory\" OR intitle:\"staff directory\"",
                    "Trouver des annuaires d'entreprise"
                ),
                DorkTemplate(
                    "Informations de contact",
                    "intext:\"email\" AND intext:\"phone\" filetype:xls",
                    "Rechercher des listes de contacts"
                ),
                DorkTemplate(
                    "Documents gouvernementaux",
                    "site:gov filetype:pdf",
                    "Trouver des documents gouvernementaux"
                ),
                DorkTemplate(
                    "Publications académiques",
                    "site:edu filetype:pdf",
                    "Rechercher des publications universitaires"
                ),
                DorkTemplate(
                    "CV publics",
                    "intitle:\"curriculum vitae\" OR intitle:\"resume\" filetype:pdf",
                    "Trouver des CV en ligne"
                ),
                DorkTemplate(
                    "Rapports annuels",
                    "\"annual report\" filetype:pdf",
                    "Rechercher des rapports annuels d'entreprises"
                )
            )
        ),
        DorkCategory(
            id = "social",
            name = "Réseaux sociaux",
            icon = "💬",
            description = "Recherche sur les plateformes sociales",
            templates = listOf(
                DorkTemplate(
                    "Profils LinkedIn",
                    "site:linkedin.com",
                    "Rechercher sur LinkedIn"
                ),
                DorkTemplate(
                    "Tweets",
                    "site:twitter.com OR site:x.com",
                    "Rechercher des tweets"
                ),
                DorkTemplate(
                    "Posts Facebook",
                    "site:facebook.com",
                    "Rechercher sur Facebook"
                ),
                DorkTemplate(
                    "Vidéos YouTube",
                    "site:youtube.com",
                    "Rechercher des vidéos YouTube"
                ),
                DorkTemplate(
                    "Posts Instagram",
                    "site:instagram.com",
                    "Rechercher sur Instagram"
                ),
                DorkTemplate(
                    "Discussions Reddit",
                    "site:reddit.com",
                    "Rechercher sur Reddit"
                )
            )
        ),
        DorkCategory(
            id = "cameras",
            name = "Caméras & IoT",
            icon = "📹",
            description = "Appareils connectés",
            templates = listOf(
                DorkTemplate(
                    "Webcams",
                    "inurl:\"/view.shtml\" OR inurl:\"/ViewerFrame?\"",
                    "Trouver des webcams publiques"
                ),
                DorkTemplate(
                    "Caméras IP",
                    "intitle:\"Live View / - AXIS\" OR inurl:view/view.shtml",
                    "Rechercher des caméras IP"
                ),
                DorkTemplate(
                    "Imprimantes réseau",
                    "intitle:\"Printer Status\" OR inurl:\"hp/device/\"",
                    "Trouver des imprimantes réseau"
                ),
                DorkTemplate(
                    "Routeurs",
                    "intitle:\"Router Configuration\" OR inurl:\"login.htm\"",
                    "Rechercher des interfaces de routeurs"
                )
            )
        ),
        DorkCategory(
            id = "database",
            name = "Bases de données",
            icon = "🗄️",
            description = "Informations de bases de données",
            templates = listOf(
                DorkTemplate(
                    "Dumps SQL",
                    "filetype:sql intext:\"INSERT INTO\" OR intext:\"CREATE TABLE\"",
                    "Trouver des dumps de base de données"
                ),
                DorkTemplate(
                    "Fichiers CSV",
                    "filetype:csv",
                    "Rechercher des fichiers CSV"
                ),
                DorkTemplate(
                    "Exports de données",
                    "filetype:sql OR filetype:csv intext:\"password\" OR intext:\"email\"",
                    "Trouver des exports de données"
                ),
                DorkTemplate(
                    "MongoDB",
                    "intitle:\"MongoDB\" intext:\"db.\"",
                    "Rechercher des informations MongoDB"
                )
            )
        ),
        DorkCategory(
            id = "login",
            name = "Pages de connexion",
            icon = "🔑",
            description = "Interfaces d'authentification",
            templates = listOf(
                DorkTemplate(
                    "Portails de connexion",
                    "inurl:login OR inurl:signin OR inurl:auth",
                    "Trouver des pages de connexion"
                ),
                DorkTemplate(
                    "Panels FTP",
                    "intitle:\"FTP\" inurl:login",
                    "Rechercher des interfaces FTP"
                ),
                DorkTemplate(
                    "phpMyAdmin",
                    "intitle:\"phpMyAdmin\" intext:\"Welcome to phpMyAdmin\"",
                    "Trouver des installations phpMyAdmin"
                ),
                DorkTemplate(
                    "Webmail",
                    "intitle:\"Webmail\" inurl:login",
                    "Rechercher des interfaces webmail"
                )
            )
        ),
        DorkCategory(
            id = "errors",
            name = "Messages d'erreur",
            icon = "⚠️",
            description = "Erreurs et debug info",
            templates = listOf(
                DorkTemplate(
                    "Erreurs SQL",
                    "intext:\"SQL syntax\" OR intext:\"mysql_fetch_array()\"",
                    "Trouver des erreurs SQL"
                ),
                DorkTemplate(
                    "Erreurs PHP",
                    "intext:\"Warning:\" OR intext:\"Fatal error:\" intext:\"php\"",
                    "Rechercher des erreurs PHP"
                ),
                DorkTemplate(
                    "Stack traces",
                    "intext:\"stack trace\" OR intext:\"at line\"",
                    "Trouver des traces de pile d'exécution"
                ),
                DorkTemplate(
                    "Debug activé",
                    "intext:\"DEBUG\" OR intext:\"TRACE\"",
                    "Rechercher du mode debug actif"
                )
            )
        )
    )
    
    fun getCategoryById(id: String): DorkCategory? {
        return categories.find { it.id == id }
    }
    
    fun getSearchEngineById(id: String): SearchEngine? {
        return searchEngines.find { it.id == id }
    }
}
