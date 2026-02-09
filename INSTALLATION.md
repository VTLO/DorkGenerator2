# GUIDE DE COMPILATION ET D'INSTALLATION

## Option 1 : Utilisation d'Android Studio (Recommandé)

### 1. Installation d'Android Studio
- Téléchargez Android Studio depuis : https://developer.android.com/studio
- Installez-le sur votre système
- Lancez Android Studio et suivez l'assistant de configuration

### 2. Ouvrir le projet
1. Ouvrez Android Studio
2. Cliquez sur "Open" ou "File → Open"
3. Naviguez jusqu'au dossier "DorkGeneratorApp"
4. Sélectionnez le dossier et cliquez sur "OK"
5. Attendez que Gradle synchronise le projet (peut prendre quelques minutes)

### 3. Compiler l'APK
**Pour une version de débogage :**
1. Menu : Build → Build Bundle(s) / APK(s) → Build APK(s)
2. Attendez la fin de la compilation
3. Cliquez sur "locate" dans la notification pour trouver l'APK
4. L'APK se trouve dans : `app/build/outputs/apk/debug/app-debug.apk`

**Pour une version de release :**
1. Menu : Build → Generate Signed Bundle / APK
2. Sélectionnez "APK" et cliquez sur "Next"
3. Si vous n'avez pas de clé de signature :
   - Cliquez sur "Create new..."
   - Remplissez les informations
   - Enregistrez le fichier .jks
4. Sélectionnez "release" comme build variant
5. Cliquez sur "Finish"

### 4. Installer sur un appareil Android

**Via USB :**
1. Activez le "Mode développeur" sur votre téléphone :
   - Paramètres → À propos du téléphone
   - Appuyez 7 fois sur "Numéro de build"
2. Activez "Débogage USB" :
   - Paramètres → Options pour développeurs
   - Activez "Débogage USB"
3. Connectez votre téléphone via USB
4. Dans Android Studio, cliquez sur le bouton "Run" (▶️)
5. Sélectionnez votre appareil

**Via fichier APK :**
1. Transférez l'APK sur votre téléphone
2. Ouvrez le fichier APK sur votre téléphone
3. Autorisez l'installation depuis des sources inconnues si demandé
4. Suivez les instructions d'installation

## Option 2 : Ligne de commande (Pour utilisateurs avancés)

### Prérequis
- JDK 17 installé
- Android SDK installé
- Variables d'environnement configurées

### Commandes

**Compiler l'APK de debug :**
```bash
cd DorkGeneratorApp
./gradlew assembleDebug
```
APK généré dans : `app/build/outputs/apk/debug/app-debug.apk`

**Compiler l'APK de release (non signé) :**
```bash
./gradlew assembleRelease
```
APK généré dans : `app/build/outputs/apk/release/app-release-unsigned.apk`

**Installer directement sur un appareil connecté :**
```bash
./gradlew installDebug
```

**Nettoyer le projet :**
```bash
./gradlew clean
```

## Option 3 : APK pré-compilé (Le plus simple)

Si un APK pré-compilé est fourni :
1. Téléchargez le fichier `dork-generator.apk`
2. Transférez-le sur votre téléphone Android
3. Ouvrez le fichier avec un gestionnaire de fichiers
4. Autorisez l'installation depuis des sources inconnues
5. Appuyez sur "Installer"

## Configuration minimale requise

### Pour le développement
- Android Studio Hedgehog (2023.1.1) ou plus récent
- JDK 17
- 8 GB RAM minimum (16 GB recommandé)
- 10 GB d'espace disque libre

### Pour l'exécution (appareil Android)
- Android 7.0 (Nougat / API 24) ou supérieur
- 50 MB d'espace libre
- Connexion Internet (pour effectuer les recherches)

## Résolution des problèmes courants

### Erreur : "SDK not found"
- Installez Android SDK via Android Studio
- Ou définissez ANDROID_HOME dans vos variables d'environnement

### Erreur : "JDK version incompatible"
- Vérifiez que JDK 17 est installé
- Configurez le JDK dans Android Studio :
  File → Project Structure → SDK Location → JDK location

### Gradle sync failed
- Vérifiez votre connexion Internet
- Essayez : File → Invalidate Caches / Restart
- Ou exécutez : `./gradlew clean build`

### L'application ne s'installe pas sur le téléphone
- Vérifiez que "Sources inconnues" est activé
- Assurez-vous d'avoir assez d'espace
- Désinstallez l'ancienne version si elle existe

## Structure du projet compilé

```
app/build/outputs/
├── apk/
│   ├── debug/
│   │   └── app-debug.apk          ← Version de débogage
│   └── release/
│       └── app-release.apk        ← Version de production
├── logs/
└── mapping/
```

## Tester l'application

Une fois installée, vous pouvez :
1. Créer un nouveau dork personnalisé
2. Tester les templates prédéfinis
3. Effectuer une recherche sur différents moteurs
4. Vérifier que l'historique fonctionne
5. Ajouter des favoris
6. Exporter vos dorks en JSON

## Support et aide

- Consultez le fichier README.md pour plus d'informations
- Vérifiez que toutes les dépendances sont correctement téléchargées
- En cas de problème persistant, nettoyez et recompilez le projet

---

**Note importante** : La première compilation peut prendre plusieurs minutes car Gradle doit télécharger toutes les dépendances nécessaires.
