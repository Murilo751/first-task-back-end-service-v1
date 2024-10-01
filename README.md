# Documentação da API - Cadastro de Usuários

## Visão Geral

Esta API oferece operações CRUD (Create, Read, Update, Delete) para gerenciar o cadastro de usuários. Abaixo estão listados os endpoints disponíveis, os tipos de requisição permitidos, os parâmetros aceitos e as respostas esperadas.

- Base URL: http://localhost:8080/api/users

---

## Ferramentas de Teste

Você pode testar a API utilizando ferramentas como:

- *Postman*: Uma ferramenta gráfica para testar APIs REST.
- *cURL*: Ferramenta de linha de comando para enviar requisições HTTP.
## Documentação da API

#### Registra um usuario

```http
  POST /register
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `Corpo de requisição`      | `string` | Endpoint para registrar um novo usuário no sistema. |

##### Exemplo
```http
 json
  {
    "name": "João Silva",
    "email": "joao.silva@example.com",
    "password": "senha123"
  }
```
##### Resposta esperada
Código HTTP: 200 OK + Dados do usuario cadastrado

---

#### Busca um usuario por ID

```http
  GET /findById/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | Endpoint para buscar um usuário específico pelo seu ID |

##### Resposta esperada
Código HTTP: 200 OK + Dados do usuario buscado

---
#### Busca um usuario por email

```http
  GET /findByEmail/${email}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `email`      | `string` | Endpoint para buscar um usuário específico pelo seu ID |

##### Resposta esperada
Código HTTP: 200 OK + Dados do usuario buscado

---

#### Busca todos os usuarios

```http
  GET /getAll
```

| Tipo       | Descrição                           |
| :--------- | :---------------------------------- |
| `string` | Endpoint para listar todos os usuários cadastrados no sistema.|

##### Resposta esperada
Código HTTP: 200 OK + Dados do todos os usuarios

---

#### Atualiza um usuario

```http
  PUT /${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | Endpoint para atualizar os dados de um usuário existente.|

##### Exemplo
```http
 json
  {
    "name": "Eduardo Costa",
    "email": "dudu123@example.com",
    "password": "378farofa"
  }
```
##### Resposta esperada
Código HTTP: 200 OK + Dados do usuario atualizado

---

#### Deleta um usuario

```http
  DELETE /${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Long` | Endpoint para excluir um usuário do sistema.|

##### Resposta esperada
Código HTTP: 204 No content + 1
