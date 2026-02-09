#!/bin/bash

# Script de compilation automatique pour Dork Generator
# Usage: ./compile.sh

echo "╔═══════════════════════════════════════════════════════════════╗"
echo "║     DORK GENERATOR - Script de compilation automatique       ║"
echo "╚═══════════════════════════════════════════════════════════════╝"
echo ""

# Vérification de l'environnement
echo "🔍 Vérification de l'environnement..."

# Vérifier Java
if ! command -v java &> /dev/null; then
    echo "❌ Java n'est pas installé. Installez JDK 17."
    exit 1
fi

JAVA_VERSION=$(java -version 2>&1 | awk -F '"' '/version/ {print $2}' | cut -d'.' -f1)
if [ "$JAVA_VERSION" -lt 17 ]; then
    echo "❌ Java 17+ requis. Version actuelle: $JAVA_VERSION"
    exit 1
fi
echo "✅ Java version OK"

# Vérifier ANDROID_HOME
if [ -z "$ANDROID_HOME" ]; then
    echo "⚠️  ANDROID_HOME n'est pas défini."
    echo "   Définissez-le dans ~/.bashrc ou ~/.zshrc:"
    echo "   export ANDROID_HOME=/path/to/android/sdk"
    echo ""
    read -p "Continuer quand même ? (y/n) " -n 1 -r
    echo
    if [[ ! $REPLY =~ ^[Yy]$ ]]; then
        exit 1
    fi
else
    echo "✅ ANDROID_HOME: $ANDROID_HOME"
fi

echo ""
echo "🏗️  Compilation de l'APK..."
echo ""

# Nettoyer les builds précédents
echo "🧹 Nettoyage..."
./gradlew clean

# Compiler l'APK de debug
echo "🔨 Compilation en cours..."
./gradlew assembleDebug

# Vérifier le résultat
if [ $? -eq 0 ]; then
    APK_PATH="app/build/outputs/apk/debug/app-debug.apk"
    if [ -f "$APK_PATH" ]; then
        APK_SIZE=$(du -h "$APK_PATH" | cut -f1)
        echo ""
        echo "╔═══════════════════════════════════════════════════════════════╗"
        echo "║                   ✅ COMPILATION RÉUSSIE !                    ║"
        echo "╚═══════════════════════════════════════════════════════════════╝"
        echo ""
        echo "📱 APK généré avec succès !"
        echo "📦 Taille: $APK_SIZE"
        echo "📍 Emplacement: $APK_PATH"
        echo ""
        echo "📲 Pour installer sur votre appareil Android:"
        echo "   1. Transférez $APK_PATH sur votre téléphone"
        echo "   2. Activez 'Sources inconnues' dans les paramètres"
        echo "   3. Ouvrez le fichier APK et installez"
        echo ""
        echo "Ou via ADB:"
        echo "   adb install $APK_PATH"
        echo ""
        
        # Proposer d'installer directement si un appareil est connecté
        if command -v adb &> /dev/null; then
            DEVICES=$(adb devices | grep -w "device" | wc -l)
            if [ "$DEVICES" -gt 0 ]; then
                echo "🔌 Appareil Android détecté !"
                read -p "Installer l'APK maintenant ? (y/n) " -n 1 -r
                echo
                if [[ $REPLY =~ ^[Yy]$ ]]; then
                    adb install -r "$APK_PATH"
                    echo "✅ Installation terminée !"
                fi
            fi
        fi
    else
        echo "❌ L'APK n'a pas été trouvé à l'emplacement attendu."
        exit 1
    fi
else
    echo ""
    echo "❌ La compilation a échoué."
    echo "Vérifiez les messages d'erreur ci-dessus."
    exit 1
fi
