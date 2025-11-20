# VoyagezVert - Backend

Ce dépôt contient le backend Springboot pour le projet **VoyagezVert**.

---

## 🚀 Prérequis

- Docker + Docker Compose (en WSL si possible)
- Git Flow : feature → staging → prod
- Git Conventional Commits : [https://www.conventionalcommits.org/en/v1.0.0/]

---

## 🛠️ Démarrage rapide

### 1. Cloner le projet
- Nous vous conseillons de créer un dossier "VoyagezVert" si vous clonez aussi le `vv_frontend`
- Puis cloner le `vv_backend` dans le dossier crée
```bash
git clone https://github.com/VoyagezVert/vv_backend.git
cd vv_backend
```

### 2. Ouvrir le projet avec devcontainer

Le devcontainer.json est configuré pour JDK25 & SpringBoot4
- Créez le fichier `.devcontainer/.env.local` ou executez la commande (si nécessaire)
```bash
echo "GIT_USER=" >> .devcontainer/.env.local
echo "GIT_EMAIL=" >> .devcontainer/.env.local
```
- Buildez le `.devcontainer/devcontainer.json`
- Ouvrez le container dans votre IDE

### 3. Développement

- Les fichiers sont montés dans le conteneur pour le dev live.
- Ne pas oublier de faire des tests unitaires !
- Le backend s'ouvre automatiquement en hotreload sur le port 8080 (sur votre machine hôte, sinon pensez à configurer le docker network)

### 4. Connexion avec le frontend

A venir...
