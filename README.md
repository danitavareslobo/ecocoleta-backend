# EcoColeta API - Backend

## API RESTful para Gestão de Coletas de Recicláveis

Plataforma desenvolvida para gestão de coleta seletiva. O sistema permite o usuario **RESIDENCIAL** registre e acompanhe solicitação de coletas de materiais especificos, e que usuarios **COLETORES** validem e executem os materias coletados.

### Tecnologias

| Tecnologia | Aplicação Prática |
| :--- | :--- |
| Java (JDK 21) | Linguagem utilizada para o projeto com aplicação de POO. |
| Spring Boot | Desenvolvimento da API, uso de Injeção de Dependências. |
| **MVC** (Model-View-Controller) | Separação de responsabilidades (Controlador, Serviço e Repositório). |
| PostgreSQL & Spring Data JPA | Banco de dados e modelagem relacional. |
| Spring Security & JWT | Autenticação e **Controle de Acesso por Perfil (RBAC)**. |
| APIs RESTful & DTOs | Criação de rotas padronizadas (CRUD) e separação para proteção de dados. |

### Estrutura do Código

A arquitetura do projeto está organizada em camadas, utilziando padrão **MVC** com o objetivo de manter o código limpo e escalável

*  `controlador`: Recebe requisições HTTP e direciona para camade de serviço.
*  `servico`: Contém a *REGRA DE NEGÓCIO* e a logica da aplicação.
*  `repositorio`: Inteface de comunicação com banco de dados (**PostgreSQL**).
*  `entidades`: Classes que representam o *MODELO DE DADOS*.
*  `DTO'S`: Objeto de trasnferencia de dados entre camadas.
*  `ENUMs`: Objeto para controle de dados mais especificos como *Peril, Status...*

## Segurança

A segurança foi implementada para garantir acessos de endpoints especificos do fluxo de coleta para cada tipo de usuario.

### Autenticação e Perfis

* **Autenticação JWT:** Acessos são validados por Token JWT.
* **Controle de Perfil:** Sistema retringe acessos especificos para cada tipo de Perfil(`COLETOR`/`RESIDENCIAL`).
* **Usuarios iniciais:** Três (3) contas de **COLETOR** são criadas automaticamente para testes de gerenciamento das coletas:
    USUARIOS  /  SENHA
  *  `coletor1` / `coletor1`
  *  `coletor2` / `coletor2`
  *  `coletor3` / `coletor3`

## Configuração e Execução

### 1 - Pré-requisito
* Java (JDK 21)
* PostegreSQL
* Maven

### 2 - Configuração do Banco de Dados

```sql
-- Criar banco e usuário
CREATE DATABASE ecocoleta;
CREATE USER ecocoleta_user WITH PASSWORD 'ecocoleta123';
GRANT ALL PRIVILEGES ON DATABASE ecocoleta TO ecocoleta_user;
```

### 3 - Configuração da Aplicação (application.properties)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecocoleta
spring.datasource.username=ecocoleta_user
spring.datasource.password=ecocoleta123
spring.jpa.hibernate.ddl-auto=update
```


## Deploy

**API em produção:** https://ecocoleta-api.onrender.com


## 👥 Autores

- **Carlos Henrique Motta** - [@CHMotta](https://github.com/CHMotta)
- **Daniele Tavares Lobo** - [@danitavareslobo](https://github.com/danitavareslobo)
- **Osiel Fernandes** - [@osi-83](https://github.com/osi-83)


⭐ Se este projeto te ajudou, considere dar uma estrela!
###  🌱 EcoColeta - Em busca de um sistema mais sustentavel.
  


