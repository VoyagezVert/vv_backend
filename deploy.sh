#!/usr/bin/env bash

# ================================
#  Génération des fichiers .env.prod
# ================================

# Fonction pour générer un mot de passe fort
generate_password() {
  LC_ALL=C tr -dc 'A-Za-z0-9!@#$%^&*()-_=+{}[]' </dev/urandom | head -c 32
}

echo "🔧 Génération des secrets pour .env.prod ..."

# -----------------------
#  Variables pour DB et secrets
# -----------------------
DB_URL="jdbc:postgresql://vv_db:5432/voyagezvert"
DB_USER="postgres"
DB_PASSWORD=$(generate_password)

JWT_SECRET=$(generate_password)
API_KEY_INTERNAL=$(generate_password)

# -----------------------
#  1️⃣ Fichier .env.prod pour Docker / Spring Boot
# -----------------------
cat > .env.prod <<EOF
# =====================================
#   Fichier d'environnement de production
# =====================================

DB_URL="${DB_URL}"
DB_USER="${DB_USER}"
DB_PASSWORD="${DB_PASSWORD}"

JWT_SECRET="${JWT_SECRET}"
API_KEY_INTERNAL="${API_KEY_INTERNAL}"
EOF

echo "✅ Fichier .env.prod (Docker/Spring) généré."

# -----------------------
#  2️⃣ Fichier .env.prod à la racine pour la base de données seulement
# -----------------------
cat > ../.env.prod <<EOF
# =============================
#   Fichier d'environnement DB
# =============================

POSTGRES_DB="voyagezvert"
POSTGRES_USER="${DB_USER}"
POSTGRES_PASSWORD="${DB_PASSWORD}"
EOF

echo "✅ Fichier .env.prod (racine) généré avec identifiants DB."

echo ""
echo "⚠️ Les fichiers contiennent des secrets — garde-les privés."
echo ""
echo "➡️  Pour charger l'environnement :"
echo "source .env.prod"