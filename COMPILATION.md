# 🚀 GUIDE DE COMPILATION RAPIDE

## Option 1 : Script automatique (Linux/Mac)

```bash
cd DorkGeneratorApp
./compile.sh
```

Le script va :
- ✅ Vérifier l'environnement (Java, Android SDK)
- ✅ Nettoyer les builds précédents
- ✅ Compiler l'APK automatiquement
- ✅ Proposer l'installation si un appareil est connecté

---

## Option 2 : Commande manuelle

```bash
cd DorkGeneratorApp
./gradlew assembleDebug
```

L'APK sera dans : `app/build/outputs/apk/debug/app-debug.apk`

---

## Option 3 : Android Studio (Interface graphique)

1. Ouvrir le projet dans Android Studio
2. Menu : **Build → Build Bundle(s) / APK(s) → Build APK(s)**
3. Attendre la compilation (2-5 minutes)
4. Cliquer sur "locate" pour trouver l'APK

---

## Option 4 : Windows (PowerShell)

```powershell
cd DorkGeneratorApp
.\gradlew.bat assembleDebug
```

---

## 📋 Prérequis

### Installation rapide d'Android Studio :

1. **Télécharger** : https://developer.android.com/studio
2. **Installer** Android Studio
3. **Lancer** et suivre l'assistant d'installation
4. **Ouvrir** le projet DorkGeneratorApp
5. **Attendre** la synchronisation Gradle
6. **Compiler** !

**Temps total : 20-30 minutes** (incluant téléchargements)

---

## 🔥 Compilation ultra-rapide (si Android Studio déjà installé)

```bash
# 1. Extraire
unzip DorkGeneratorApp.zip

# 2. Aller dans le dossier
cd DorkGeneratorApp

# 3. Compiler
./gradlew assembleDebug

# 4. Installer (si appareil connecté)
adb install app/build/outputs/apk/debug/app-debug.apk
```

**Temps : 3-5 minutes** ⚡

---

## 🌐 Alternative : Build en ligne (sans installation locale)

### GitHub Actions (gratuit)

1. Créer un compte GitHub
2. Créer un nouveau repository
3. Uploader le contenu de DorkGeneratorApp
4. Créer `.github/workflows/android.yml` :

```yaml
name: Android Build

on:
  push:
    branches: [ main ]
  workflow_dispatch:

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v3
    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
    - name: Build APK
      run: |
        chmod +x ./gradlew
        ./gradlew assembleDebug
    - name: Upload APK
      uses: actions/upload-artifact@v3
      with:
        name: app-debug
        path: app/build/outputs/apk/debug/app-debug.apk
```

5. Push → GitHub compile automatiquement
6. Télécharger l'APK depuis "Actions" → "Artifacts"

---

## ⚡ Services de build en ligne

### Appcircle (gratuit pour 1 app)
1. https://appcircle.io/
2. Connecter votre repository Git
3. Build automatique
4. Télécharger l'APK

### Bitrise (gratuit tier)
1. https://www.bitrise.io/
2. Importer le projet
3. Build Android
4. Télécharger

---

## 🆘 Dépannage

### Erreur : "SDK not found"
```bash
export ANDROID_HOME=$HOME/Android/Sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
```

### Erreur : "JDK 17 required"
Installer JDK 17 :
- Ubuntu : `sudo apt install openjdk-17-jdk`
- Mac : `brew install openjdk@17`
- Windows : Télécharger depuis adoptium.net

### Erreur : "Gradle sync failed"
```bash
./gradlew clean
./gradlew build --refresh-dependencies
```

---

## 💡 Pourquoi je dois compiler moi-même ?

1. **Sécurité** : Vous contrôlez ce qui est dans l'APK
2. **Personnalisation** : Vous pouvez modifier avant compilation
3. **Standard** : C'est la méthode standard pour Android
4. **Apprentissage** : Vous apprenez le processus de build

---

## 📱 Après compilation

Une fois l'APK généré :

1. **Transférer** sur votre téléphone (USB, email, cloud)
2. **Activer** "Sources inconnues" dans Paramètres Android
3. **Ouvrir** le fichier APK
4. **Installer** et profiter !

---

## ⏱️ Temps estimés

| Méthode | Première fois | Compilations suivantes |
|---------|---------------|------------------------|
| Android Studio (interface) | 25-35 min | 2-5 min |
| Ligne de commande | 20-30 min | 1-3 min |
| GitHub Actions | 15-20 min | 5-8 min |
| Script compile.sh | 25-30 min | 1-2 min |

---

## 🎯 Recommandation

**Pour la première fois** : Utilisez Android Studio (interface graphique)
- Plus simple
- Gère automatiquement les dépendances
- Interface claire

**Pour les fois suivantes** : Utilisez le script `./compile.sh`
- Ultra rapide
- Une seule commande
- Installation automatique si appareil connecté

---

**Le code source est prêt, il ne reste plus qu'à compiler ! 🚀**
