# ---------- Etapa 1: Build con Maven ----------
FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /build

# Copiamos primero el pom para cachear dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiamos el resto del código y compilamos
COPY . .
RUN mvn clean package -DskipTests

# ---------- Etapa 2: Runtime ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiamos el jar generado sin depender del nombre exacto
COPY --from=builder /build/target/*.jar /app/rosevigon.jar

# Opcional: usar un usuario no root
USER 1001

EXPOSE 8080
ENTRYPOINT ["java","-jar","rosevigon.jar"]
