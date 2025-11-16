# 🚗 Sistema Automotivo – Gestão de Estoque de Veículos  
![Java](https://img.shields.io/badge/Java-17-red)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.4-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Status](https://img.shields.io/badge/Status-Ativo-success)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

Sistema CRUD completo para gerenciar o estoque de veículos de uma concessionária, utilizando Java + Spring Boot, API REST e banco de dados MySQL.  
Projeto desenvolvido com foco em aplicar conceitos de Programação Orientada a Objetos (POO), persistência com JPA e arquitetura baseada em camadas.

---

## 📘 Funcionalidades
✔ Cadastro de marcas  
✔ Cadastro de modelos  
✔ Cadastro de veículos  
✔ Busca e filtros avançados  
✔ Atualização de dados  
✔ Exclusão de veículos  
✔ API REST completa  
✔ Banco MySQL com relacionamentos  

---

## 🏛 Arquitetura

```
Controller → Repository → Entity (JPA)
```

---

## 📦 Tecnologias Utilizadas
- Java 17  
- Spring Boot 3.1.4  
- Spring Web  
- Spring Data JPA  
- MySQL  
- Maven  
- HTML/JS (frontend simples)

---

## 🗃 Modelo de Banco de Dados

Entidades principais:  
- Brand  
- VehicleModel  
- Vehicle

Relacionamentos:  
- VehicleModel → Brand (N:1)  
- Vehicle → VehicleModel (N:1)

O script para criação está em:

```
schema.sql
```

---

## ▶️ Como Executar o Backend

### 1. Clonar o repositório

```
git clone https://github.com/SEU_USUARIO/autosystem.git
```

### 2. Criar o banco no MySQL

```
CREATE DATABASE autosystem;
```

Atualizar o arquivo:

```
src/main/resources/application.properties
```

### 3. Instalar dependências

```
mvn clean install
```

### 4. Rodar o projeto

```
mvn spring-boot:run
```

---

## 🌐 Endpoints da API

### 📌 Brands

```
GET    /api/brands
POST   /api/brands
PUT    /api/brands/{id}
DELETE /api/brands/{id}
```

### 📌 Models

```
GET  /api/models
POST /api/models
```

### 📌 Vehicles

```
GET    /api/vehicles
GET    /api/vehicles/{id}
POST   /api/vehicles
PUT    /api/vehicles/{id}
DELETE /api/vehicles/{id}
```

---

## 💻 Frontend Simples

Arquivo localizado em:

```
index.html
```

Abra no navegador com o backend rodando.

---

## 🤝 Como Contribuir

1. Fazer um fork  
2. Criar branch:

```
git checkout -b feature/minha-feature
```

3. Commit:

```
git commit -m "Minha nova feature"
```
4. Push:

```
git push origin feature/minha-feature
```
5. Abrir Pull Request

---

## 📝 Licença
Distribuído sob licença MIT.
