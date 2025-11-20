#!/usr/bin/env bash

# ================================
#  Génération du fichier .env.prod
# ================================

# Fonction pour générer un mot de passe fort
generate_password() {
  LC_ALL=C tr -dc 'A-Za-z0-9!@#$%^&*()-_=+{}[]' </dev/urandom | head -c 32
}

echo "🔧 Génération des secrets pour .env.prod ..."

DB_URL="jdbc:postgresql://vv_db:5432/voyagezvert"
DB_USER="postgres"
DB_PASSWORD=$(generate_password)

JWT_SECRET=$(generate_password)
API_KEY_INTERNAL=$(generate_password)

# Écrire dans .env.prod
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

echo "✅ Fichier .env.prod généré."
echo "📁 Contenu sécurisé et prêt pour Docker / Spring Boot."
echo ""
echo "⚠️ Le fichier contient des secrets — garde-le privé."
echo ""
echo "➡️  Pour charger cet environnement :"
echo "source .env.prod"