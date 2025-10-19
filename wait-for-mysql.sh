#!/bin/sh

echo "Esperando a que MySQL esté disponible en mysql:3306..."

# Esperar a que el puerto responda
while ! nc -z mysql 3306; do
  sleep 1
done

# Esperar hasta que se pueda ejecutar un simple SELECT con root
until mysql -h mysql -u root -e "SELECT 1;" >/dev/null 2>&1; do
  echo "Esperando a que MySQL acepte conexiones..."
  sleep 2
done

echo "MySQL está listo, arrancando Spring Boot..."
exec java -jar app.jar
