# Dork Generator - Application Android

## 📱 Description

**Dork Generator** est une application Android moderne et complète pour créer, gérer et utiliser des dorks de recherche avancés. L'application utilise Material Design 3 et offre une interface intuitive pour générer des requêtes de recherche puissantes sur différents moteurs.

## ✨ Fonctionnalités

### 🎯 Fonctionnalités principales

- **Générateur de Dorks intelligent** avec suggestions automatiques
- **8 catégories prédéfinies** avec templates :
  - 📄 Recherche de fichiers (PDF, DOC, XLS, etc.)
  - 🔓 Vulnérabilités web
  - 🌍 Informations publiques
  - 💬 Réseaux sociaux
  - 📹 Caméras & IoT
  - 🗄️ Bases de données
  - 🔑 Pages de connexion
  - ⚠️ Messages d'erreur

- **Support multi-moteurs** :
  - Google
  - Bing
  - DuckDuckGo
  - Yandex
  - Baidu

- **Gestion des données** :
  - Historique complet des recherches
  - Système de favoris
  - Recherche dans l'historique
  - Export/Import JSON
  - Suppression sélective

### 🎨 Interface utilisateur

- **Material Design 3** moderne
- Thème clair/sombre automatique
- Navigation fluide avec bottom bar
- Animations et transitions élégantes
- Interface responsive

### 🔧 Fonctionnalités techniques

- Architecture MVVM propre
- Base de données Room locale
- Jetpack Compose pour l'UI
- Kotlin coroutines pour l'asynchrone
- Navigation Compose

## 🏗️ Architecture du projet

```
DorkGeneratorApp/
├── app/
│   ├── src/main/
│   │   ├── java/com/dorkgen/app/
│   │   │   ├── MainActivity.kt
│   │   │   ├── data/
│   │   │   │   ├── model/
│   │   │   │   │   └── Models.kt
│   │   │   │   ├── database/
│   │   │   │   │   └── DorkDatabase.kt
│   │   │   │   └── repository/
│   │   │   │       └── DorkRepository.kt
│   │   │   ├── viewmodel/
│   │   │   │   └── DorkViewModel.kt
│   │   │   ├── ui/
│   │   │   │   ├── screens/
│   │   │   │   │   ├── HomeScreen.kt
│   │   │   │   │   ├── GeneratorScreen.kt
│   │   │   │   │   ├── HistoryScreen.kt
│   │   │   │   │   ├── FavoritesScreen.kt
│   │   │   │   │   └── SettingsScreen.kt
│   │   │   │   └── theme/
│   │   │   │       ├── Color.kt
│   │   │   │       ├── Theme.kt
│   │   │   │       └── Type.kt
│   │   │   └── utils/
│   │   │       └── DorkTemplates.kt
│   │   ├── res/
│   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## 🚀 Installation et compilation

### Prérequis

- Android Studio Hedgehog (2023.1.1) ou plus récent
- JDK 17
- Android SDK 34
- Gradle 8.2+

### Étapes d'installation

1. **Cloner ou télécharger le projet**
   ```bash
   cd DorkGeneratorApp
   ```

2. **Ouvrir dans Android Studio**
   - File → Open → Sélectionner le dossier DorkGeneratorApp

3. **Synchroniser Gradle**
   - Android Studio synchronisera automatiquement les dépendances
   - Ou cliquez sur "Sync Project with Gradle Files"

4. **Compiler l'application**
   ```bash
   ./gradlew assembleDebug
   ```
   L'APK sera généré dans : `app/build/outputs/apk/debug/`

5. **Installer sur un appareil**
   ```bash
   ./gradlew installDebug
   ```

### Compilation de l'APK de release

```bash
./gradlew assembleRelease
```

## 📦 Dépendances principales

```kotlin
// Compose & Material 3
androidx.compose.material3:material3
androidx.compose.ui:ui

// Room Database
androidx.room:room-runtime:2.6.1
androidx.room:room-ktx:2.6.1

// Navigation
androidx.navigation:navigation-compose:2.7.6

// ViewModel
androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0

// DataStore
androidx.datastore:datastore-preferences:1.0.0

// Gson
com.google.code.gson:gson:2.10.1
```

## 🎮 Utilisation

### Créer un dork personnalisé

1. Ouvrez l'application
2. Appuyez sur "Créer un nouveau Dork"
3. Saisissez votre requête
4. Sélectionnez un moteur de recherche
5. Appuyez sur "Rechercher"

### Utiliser un template

1. Sur l'écran d'accueil, sélectionnez une catégorie
2. Parcourez les templates disponibles
3. Appuyez sur un template pour l'utiliser
4. Modifiez si nécessaire
5. Lancez la recherche

### Gérer l'historique

- Consultez vos recherches précédentes dans l'onglet "Historique"
- Ajoutez des dorks aux favoris avec l'icône ❤️
- Recherchez dans l'historique avec la barre de recherche
- Supprimez des entrées individuelles ou tout l'historique

### Exporter vos dorks

1. Allez dans "Paramètres"
2. Appuyez sur "Exporter les dorks"
3. Copiez le JSON généré

## 🔍 Opérateurs Dork disponibles

L'application supporte tous les opérateurs de recherche avancés :

- `site:` - Recherche dans un domaine spécifique
- `filetype:` - Recherche par type de fichier
- `inurl:` - Terme dans l'URL
- `intitle:` - Terme dans le titre
- `intext:` - Terme dans le texte
- `cache:` - Version en cache
- `link:` - Pages avec lien vers
- `related:` - Sites similaires
- `before:` / `after:` - Filtres de date
- Et plus encore...

## ⚠️ Avertissement légal et éthique

**IMPORTANT** : Cette application est destinée à un **usage éducatif et de recherche légitime uniquement**.

### Utilisations légitimes :
- ✅ Recherche de documents publics
- ✅ Audit de sécurité autorisé
- ✅ Recherche académique
- ✅ Veille technologique
- ✅ Tests sur vos propres systèmes

### Utilisations illégales/non éthiques :
- ❌ Accès non autorisé à des systèmes
- ❌ Vol de données
- ❌ Violation de la vie privée
- ❌ Exploitation de vulnérabilités sans permission
- ❌ Toute activité illégale

**Vous êtes seul responsable de l'utilisation que vous faites de cette application. Respectez les lois en vigueur et l'éthique.**

## 🐛 Dépannage

### Erreurs de compilation

- Vérifiez que vous utilisez la bonne version de JDK (17)
- Nettoyez le projet : `./gradlew clean`
- Invalidez les caches : File → Invalidate Caches / Restart

### Problèmes de Room Database

- Les migrations sont automatiques pour cette version
- En cas de problème, désinstallez et réinstallez l'app

## 📝 License

Ce projet est fourni à des fins éducatives. Utilisez-le de manière responsable.

## 🤝 Contribution

Les contributions sont les bienvenues ! N'hésitez pas à :
- Signaler des bugs
- Proposer de nouvelles fonctionnalités
- Améliorer la documentation
- Ajouter de nouveaux templates de dorks

## 📧 Support

Pour toute question ou problème, veuillez créer une issue sur le repository.

---

**Version actuelle** : 1.0  
**SDK minimum** : Android 7.0 (API 24)  
**SDK cible** : Android 14 (API 34)  
**Langage** : Kotlin  
**Framework UI** : Jetpack Compose

Développé avec ❤️ en utilisant les dernières technologies Android
