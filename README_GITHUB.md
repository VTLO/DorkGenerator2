# 🔍 Dork Generator - Application Android

[![Build Status](https://github.com/VOTRE-USERNAME/DorkGenerator/workflows/🤖%20Build%20Android%20APK/badge.svg)](https://github.com/VOTRE-USERNAME/DorkGenerator/actions)
[![License](https://img.shields.io/badge/License-Educational-blue.svg)](LICENSE)
[![Android](https://img.shields.io/badge/Android-7.0%2B-green.svg)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.20-purple.svg)](https://kotlinlang.org)

> Application Android moderne pour générer et utiliser des **dorks de recherche avancés** avec Material Design 3

![Dork Generator Banner](https://via.placeholder.com/1200x300/6750A4/FFFFFF?text=Dork+Generator+-+Android+App)

---

## 📱 Description

**Dork Generator** est une application Android complète permettant de créer, gérer et utiliser des dorks de recherche avancés (Google Dorking) de manière simple et intuitive.

### ✨ Fonctionnalités principales

- 🎯 **Générateur intelligent** avec suggestions automatiques
- 📚 **8 catégories** de dorks prédéfinies
- 🎨 **42 templates** prêts à l'emploi
- 🌐 **5 moteurs** de recherche (Google, Bing, DuckDuckGo, Yandex, Baidu)
- 📜 **Historique** complet avec recherche
- ⭐ **Favoris** pour sauvegarder vos dorks
- 💾 **Export JSON** de vos données
- 🎨 **Material Design 3** avec thème clair/sombre
- 🗄️ **Base de données Room** locale et persistante

---

## 📥 Téléchargement

### Dernière version

[![Download APK](https://img.shields.io/badge/Download-APK-brightgreen?style=for-the-badge&logo=android)](https://github.com/VOTRE-USERNAME/DorkGenerator/releases/latest)

Ou allez dans [**Releases**](https://github.com/VOTRE-USERNAME/DorkGenerator/releases) pour télécharger l'APK.

### Build automatique

Chaque commit déclenche un build automatique. Vous pouvez télécharger le dernier APK depuis :
1. Onglet [**Actions**](https://github.com/VOTRE-USERNAME/DorkGenerator/actions)
2. Sélectionnez le dernier workflow réussi (✅)
3. Téléchargez l'artifact **"dork-generator-apk"**

---

## 🚀 Installation

### Prérequis

- Android 7.0 (Nougat / API 24) ou supérieur
- 50 MB d'espace libre

### Étapes

1. **Téléchargez** l'APK depuis [Releases](https://github.com/VOTRE-USERNAME/DorkGenerator/releases)
2. **Activez** "Sources inconnues" dans Paramètres → Sécurité
3. **Ouvrez** le fichier APK
4. **Installez** l'application
5. **Profitez** ! 🎉

---

## 📚 Catégories de Dorks

| Catégorie | Templates | Description |
|-----------|-----------|-------------|
| 📄 **Fichiers** | 7 | PDF, DOC, XLS, PPT, archives |
| 🔓 **Vulnérabilités** | 7 | Configs, logs, backups, erreurs |
| 🌍 **Infos publiques** | 6 | Annuaires, contacts, documents |
| 💬 **Réseaux sociaux** | 6 | LinkedIn, Twitter, Facebook, etc. |
| 📹 **Caméras & IoT** | 4 | Webcams, caméras IP, imprimantes |
| 🗄️ **Bases de données** | 4 | SQL dumps, CSV, MongoDB |
| 🔑 **Authentification** | 4 | Pages login, FTP, admin panels |
| ⚠️ **Erreurs** | 4 | Erreurs SQL, PHP, traces |

**Total : 42 templates** répartis en 8 catégories

---

## 🛠️ Technologies

- **Langage** : Kotlin 1.9.20
- **UI Framework** : Jetpack Compose
- **Architecture** : MVVM
- **Database** : Room 2.6.1
- **Navigation** : Navigation Compose 2.7.6
- **Async** : Kotlin Coroutines & Flow
- **Material** : Material Design 3

---

## 🏗️ Compilation

### Option 1 : GitHub Actions (Automatique)

Chaque push compile automatiquement l'APK. Voir [GITHUB_ACTIONS_GUIDE.md](GITHUB_ACTIONS_GUIDE.md)

### Option 2 : Compilation locale

```bash
# Cloner le repository
git clone https://github.com/VOTRE-USERNAME/DorkGenerator.git
cd DorkGenerator

# Compiler l'APK
./gradlew assembleDebug

# APK généré dans :
# app/build/outputs/apk/debug/app-debug.apk
```

### Option 3 : Android Studio

1. Ouvrir le projet dans Android Studio
2. Build → Build Bundle(s) / APK(s) → Build APK(s)
3. Attendre la compilation
4. Récupérer l'APK

📖 **Guide détaillé** : [COMPILATION.md](COMPILATION.md)

---

## 📖 Documentation

- 📘 [**README.md**](README.md) - Documentation technique complète
- 🚀 [**GITHUB_ACTIONS_GUIDE.md**](GITHUB_ACTIONS_GUIDE.md) - Build automatique
- 🔧 [**COMPILATION.md**](COMPILATION.md) - Guide de compilation
- 📦 [**INSTALLATION.md**](INSTALLATION.md) - Installation détaillée
- 📋 [**LISTE_TEMPLATES.md**](LISTE_TEMPLATES.md) - Catalogue des templates
- ⚡ [**GUIDE_RAPIDE.md**](GUIDE_RAPIDE.md) - Démarrage rapide

---

## 📱 Captures d'écran

### Écran d'accueil
*Interface Material Design 3 avec 8 catégories*

### Générateur de Dorks
*Champ de saisie intelligent avec templates*

### Historique
*Liste complète avec recherche et favoris*

---

## 🎯 Cas d'usage

### ✅ Utilisations légitimes

- Recherche de documents publics
- Audit de sécurité autorisé
- Recherche académique et éducative
- Veille technologique
- Tests sur vos propres systèmes

### ❌ Utilisations interdites

- Accès non autorisé à des systèmes
- Vol ou exfiltration de données
- Violation de la vie privée
- Exploitation de vulnérabilités sans permission
- Toute activité illégale

---

## ⚠️ Avertissement

Cette application est destinée à un **usage éducatif et de recherche légitime uniquement**.

⚖️ **Responsabilité** : Vous êtes seul responsable de l'utilisation que vous faites de cette application. Le développeur décline toute responsabilité en cas d'usage inapproprié ou illégal.

🛡️ **Recommandations** :
- Respectez les lois en vigueur
- Obtenez les autorisations nécessaires
- Respectez la vie privée d'autrui
- Utilisez de manière éthique

---

## 🤝 Contribution

Les contributions sont les bienvenues !

1. Fork le projet
2. Créez une branche (`git checkout -b feature/AmazingFeature`)
3. Committez vos changements (`git commit -m 'Add some AmazingFeature'`)
4. Pushez vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrez une Pull Request

---

## 📊 Structure du projet

```
DorkGenerator/
├── .github/
│   └── workflows/          # GitHub Actions
│       ├── android-build.yml
│       └── android-release.yml
├── app/
│   ├── src/main/
│   │   ├── java/com/dorkgen/app/
│   │   │   ├── data/       # Models, Database, Repository
│   │   │   ├── ui/         # Screens & Theme
│   │   │   ├── viewmodel/  # ViewModels
│   │   │   └── utils/      # Templates & Utils
│   │   └── res/            # Resources
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

## 🔄 Roadmap

- [ ] Import de dorks depuis JSON
- [ ] Partage de dorks entre utilisateurs
- [ ] Catégories personnalisées
- [ ] Templates personnalisés
- [ ] Statistiques d'utilisation
- [ ] Widget Android
- [ ] Mode hors ligne avec cache
- [ ] Support multilingue complet

---

## 📜 Licence

Ce projet est fourni à des **fins éducatives**. Voir [LICENSE](LICENSE) pour plus de détails.

---

## 👨‍💻 Auteur

Développé avec ❤️ en Kotlin & Jetpack Compose

---

## 🌟 Support

Si vous aimez ce projet, n'hésitez pas à :
- ⭐ Mettre une étoile au repository
- 🐛 Signaler des bugs via Issues
- 💡 Proposer des améliorations
- 🔀 Contribuer au code

---

## 📧 Contact

Pour toute question ou suggestion, créez une [Issue](https://github.com/VOTRE-USERNAME/DorkGenerator/issues).

---

<div align="center">

**Dork Generator v1.0** | Made with ❤️ and ☕

[Releases](https://github.com/VOTRE-USERNAME/DorkGenerator/releases) • [Documentation](GITHUB_ACTIONS_GUIDE.md) • [Issues](https://github.com/VOTRE-USERNAME/DorkGenerator/issues)

</div>
