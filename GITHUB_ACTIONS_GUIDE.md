# 🚀 GUIDE GITHUB ACTIONS - BUILD AUTOMATIQUE

## 📋 Vue d'ensemble

GitHub Actions va **compiler automatiquement votre APK** dans le cloud, gratuitement !

**Avantages** :
- ✅ Pas besoin d'installer Android Studio
- ✅ Build dans le cloud (gratuit)
- ✅ APK téléchargeable directement
- ✅ Automatique à chaque push
- ✅ Historique des builds

---

## 🎯 ÉTAPE PAR ÉTAPE

### 📝 Étape 1 : Créer un compte GitHub (si vous n'en avez pas)

1. Allez sur https://github.com
2. Cliquez sur "Sign up"
3. Suivez les instructions
4. Vérifiez votre email

⏱️ **Temps : 2-3 minutes**

---

### 📁 Étape 2 : Créer un nouveau repository

1. Connectez-vous à GitHub
2. Cliquez sur le bouton **"+"** en haut à droite
3. Sélectionnez **"New repository"**
4. Remplissez les informations :
   - **Repository name** : `DorkGenerator` (ou autre nom)
   - **Description** : `Application Android pour générer des dorks de recherche`
   - **Visibilité** : Public (pour utiliser Actions gratuitement)
   - ✅ Cochez **"Add a README file"**
5. Cliquez sur **"Create repository"**

⏱️ **Temps : 1 minute**

---

### 📤 Étape 3 : Uploader le code

**Option A : Via l'interface web (plus simple)**

1. Sur la page de votre repository, cliquez sur **"Add file"** → **"Upload files"**
2. **Extrayez** DorkGeneratorApp.zip sur votre ordinateur
3. **Sélectionnez TOUS les fichiers** du dossier DorkGeneratorApp (Ctrl+A / Cmd+A)
4. **Glissez-déposez** dans la fenêtre GitHub
5. En bas, dans "Commit changes" :
   - Message : `Initial commit - Dork Generator v1.0`
6. Cliquez sur **"Commit changes"**

⚠️ **Important** : Uploadez le CONTENU du dossier, pas le dossier lui-même !

**Structure correcte après upload** :
```
votre-repo/
├── .github/
│   └── workflows/
│       ├── android-build.yml
│       └── android-release.yml
├── app/
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── README.md
├── INSTALLATION.md
├── compile.sh
└── COMPILATION.md
```

**Option B : Via Git (si vous connaissez Git)**

```bash
# 1. Extraire le projet
unzip DorkGeneratorApp.zip
cd DorkGeneratorApp

# 2. Initialiser Git
git init
git add .
git commit -m "Initial commit - Dork Generator v1.0"

# 3. Lier au repository GitHub
git remote add origin https://github.com/VOTRE-USERNAME/DorkGenerator.git
git branch -M main
git push -u origin main
```

⏱️ **Temps : 3-5 minutes** (upload des fichiers)

---

### 🤖 Étape 4 : Vérifier que GitHub Actions est activé

1. Dans votre repository, cliquez sur l'onglet **"Actions"**
2. Vous devriez voir : **"Get started with GitHub Actions"**
3. Si un message vous demande d'activer Actions, cliquez sur **"I understand..."**
4. GitHub détecte automatiquement les workflows dans `.github/workflows/`

✅ **Actions est maintenant actif !**

---

### 🏗️ Étape 5 : Lancer le premier build

**Le build se lance automatiquement** dès que vous uploadez le code !

Pour vérifier :

1. Allez dans l'onglet **"Actions"**
2. Vous verriez voir un workflow en cours : **"🤖 Build Android APK"**
3. Cliquez dessus pour voir la progression en direct

⏱️ **Durée du build : 5-8 minutes**

Vous pouvez voir :
- ✅ Setup Java
- ✅ Cache Gradle
- ✅ Build APK
- ✅ Upload artifact

---

### 📥 Étape 6 : Télécharger l'APK

Une fois le build terminé (icône verte ✅) :

1. Restez sur la page du workflow
2. Descendez en bas de la page
3. Dans la section **"Artifacts"**, vous verrez :
   - 📦 **dork-generator-apk**
4. Cliquez dessus pour **télécharger** (fichier ZIP)
5. **Extrayez le ZIP**, vous obtenez votre **APK** !

🎉 **Votre APK est prêt !**

---

### 📱 Étape 7 : Installer l'APK sur Android

1. **Transférez** l'APK sur votre téléphone (USB, email, cloud...)
2. Sur votre téléphone :
   - **Paramètres** → **Sécurité** → **Sources inconnues** → Activez
3. **Ouvrez** le fichier APK avec un gestionnaire de fichiers
4. **Appuyez** sur **"Installer"**
5. **Lancez** l'application !

---

## 🔄 BUILDS AUTOMATIQUES

### Quand GitHub Actions compile automatiquement ?

✅ **À chaque push** sur la branche `main` ou `master`  
✅ **À chaque pull request**  
✅ **Manuellement** via "Run workflow"

### Lancer un build manuellement

1. Allez dans **"Actions"**
2. Sélectionnez **"🤖 Build Android APK"** dans la liste de gauche
3. Cliquez sur **"Run workflow"** (bouton gris en haut à droite)
4. Sélectionnez la branche `main`
5. Cliquez sur **"Run workflow"** (vert)

⏱️ Le build démarre immédiatement !

---

## 🚀 BUILD DE RELEASE (Optionnel)

Pour créer une **release officielle** avec version :

1. Allez dans **"Actions"**
2. Sélectionnez **"🚀 Build Release APK"**
3. Cliquez sur **"Run workflow"**
4. Entrez un **numéro de version** (ex: `1.0.0`)
5. Cliquez sur **"Run workflow"**

✅ Cela créera :
- Un APK de release
- Un tag Git `v1.0.0`
- Une **release GitHub** avec l'APK téléchargeable publiquement

### Télécharger depuis les Releases

1. Allez dans l'onglet **"Releases"** (à droite, sous "About")
2. Cliquez sur la dernière release
3. Dans **"Assets"**, téléchargez l'APK directement
4. Partagez le lien de la release avec d'autres !

---

## 📊 WORKFLOWS DISPONIBLES

### 1. **🤖 Build Android APK** (`android-build.yml`)
- **Quand** : À chaque push / PR
- **Durée** : 5-8 minutes
- **Output** : APK de debug dans Artifacts
- **Usage** : Tests et développement

### 2. **🚀 Build Release APK** (`android-release.yml`)
- **Quand** : Manuel ou sur tag
- **Durée** : 6-10 minutes
- **Output** : APK de release + GitHub Release
- **Usage** : Versions officielles

---

## 💡 ASTUCES

### Voir les logs en cas d'erreur

1. Cliquez sur le workflow qui a échoué (icône rouge ❌)
2. Cliquez sur l'étape qui a échoué
3. Lisez les logs d'erreur

**Erreurs courantes** :
- ❌ Fichiers manquants → Vérifiez que tous les fichiers sont uploadés
- ❌ Gradle sync failed → Attendez, réessayez

### Accélérer les builds

✅ **Le cache Gradle** est déjà configuré !  
- Premier build : 5-8 minutes
- Builds suivants : 3-5 minutes

### Limites GitHub Actions (plan gratuit)

- ✅ **2000 minutes/mois** (largement suffisant)
- ✅ **500 MB** de stockage d'artifacts
- ✅ **Illimité** pour repos publics

---

## 📋 CHECKLIST RAPIDE

- [ ] Créer un compte GitHub
- [ ] Créer un repository public
- [ ] Extraire DorkGeneratorApp.zip
- [ ] Uploader TOUT le contenu du dossier
- [ ] Aller dans "Actions"
- [ ] Attendre la fin du build (5-8 min)
- [ ] Télécharger l'APK depuis "Artifacts"
- [ ] Installer sur Android

⏱️ **Temps total : 15-20 minutes**

---

## 🆘 DÉPANNAGE

### ❌ "Actions is disabled"
**Solution** : Allez dans Settings → Actions → General → Allow all actions

### ❌ "Workflow file is invalid"
**Solution** : Vérifiez que `.github/workflows/` contient les fichiers YAML

### ❌ "Build failed"
**Solution** : 
1. Vérifiez que TOUS les fichiers sont uploadés
2. Vérifiez la structure (app/, gradle/, build.gradle.kts, etc.)
3. Relancez le workflow

### ❌ "Can't find artifact"
**Solution** : Le build a peut-être échoué. Vérifiez qu'il y a une icône verte ✅

---

## 🎉 FÉLICITATIONS !

Vous avez maintenant un **système de build automatique** pour votre application Android !

**Avantages** :
- ✅ APK disponible en 5-8 minutes
- ✅ Pas besoin d'Android Studio
- ✅ Build dans le cloud
- ✅ Historique des versions
- ✅ Partage facile via releases

---

## 📚 RESSOURCES

- Documentation GitHub Actions : https://docs.github.com/actions
- Android Gradle Plugin : https://developer.android.com/studio/build
- Exemples de workflows : https://github.com/actions/starter-workflows

---

## 🚀 PROCHAINES ÉTAPES

Une fois votre APK téléchargé :
1. ✅ Installez sur votre Android
2. ✅ Testez toutes les fonctionnalités
3. ✅ Créez des dorks personnalisés
4. ✅ Explorez les 42 templates
5. ✅ Partagez l'app (via Releases) !

---

**Besoin d'aide ?** Consultez les logs du workflow ou créez une issue sur GitHub !

**Bon build ! 🎉**
