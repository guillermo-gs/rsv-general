#!/usr/bin/env bash
set -euo pipefail

# Uso: ./merge-and-build.sh [env1=.env.common] [env2=.env.docker] [salida=.env]
ENV1="${1:-.env.common}"
ENV2="${2:-.env.docker}"
OUT="${3:-.env}"

if [[ ! -f "$ENV1" ]]; then
  echo "❌ No existe $ENV1" >&2; exit 1
fi
if [[ ! -f "$ENV2" ]]; then
  echo "❌ No existe $ENV2" >&2; exit 1
fi

ts="$(date +%Y%m%d-%H%M%S)"
TMP1="$(mktemp)"; TMP2="$(mktemp)"; TMP_OUT="$(mktemp)"

sanitize() {
  # Quita BOM y CRLF
  awk 'NR==1{sub(/^\xef\xbb\xbf/,"")} {gsub(/\r$/,""); print}' "$1"
}

sanitize "$ENV1" > "$TMP1"
sanitize "$ENV2" > "$TMP2"

## Backup si ya hay .env
#if [[ -f "$OUT" ]]; then
#  cp -f "$OUT" "${OUT}.bak-${ts}"
#  echo "🗂  Backup creado: ${OUT}.bak-${ts}"
#fi

# Fusiona: primero common, luego docker (lo último gana)
cat "$TMP1" > "$TMP_OUT"
echo "" >> "$TMP_OUT"
cat "$TMP2" >> "$TMP_OUT"

# Opcional: limpiar líneas vacías repetidas al final
# sed -i -e :a -e '/^\n*$/{$d;N;ba' -e '}' "$TMP_OUT" 2>/dev/null || true

mv -f "$TMP_OUT" "$OUT"
echo "✅ Generado $OUT con $(wc -l < "$OUT") líneas"

# Validación rápida: formato CLAVE=valor (avisa si ve líneas raras)
BAD_LINES=$(grep -nE '^[^#][^=]*$' "$OUT" || true)
if [[ -n "$BAD_LINES" ]]; then
  echo "⚠️  Hay líneas sin '=' en $OUT (revisa comentarios/espacios):"
  echo "$BAD_LINES"
fi

# Pre-chequeo de compose (interpolación de variables)
if ! docker-compose config >/dev/null; then
  echo "⚠️  'docker-compose config' reporta problemas de variables. Revisa $OUT." >&2
fi

# Build
echo "🚧 Ejecutando: docker-compose build"
docker-compose build
echo "🏁 Build completado."
