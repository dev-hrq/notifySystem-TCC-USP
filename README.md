![alt](logo.webp)

# NotifyX

Sistema de notificações desenvolvido como projeto de TCC.

## Requisitos

- Java 17
- Maven 3.6+
- MongoDB 6.0+

## Configuração do Ambiente

1. **MongoDB**
   - Instale o MongoDB
   - O banco de dados será criado automaticamente como `notifyxdb`
   - A aplicação espera que o MongoDB esteja rodando em:
     - Host: localhost
     - Porta: 27017

2. **Java e Maven**
   - Certifique-se de ter o Java 17 instalado
   - Maven deve estar configurado no seu PATH

## Construindo o Projeto

Para construir o projeto, execute:

```bash
mvn clean install
```

## Executando a Aplicação

Para iniciar a aplicação, use:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em: http://localhost:8080

## Documentação da API

A documentação da API está disponível através do Swagger UI:
- Swagger UI: http://localhost:8080/swagger-ui.html
- Especificação OpenAPI: http://localhost:8080/api-docs

## Testando a API

### Usando Swagger UI
1. Acesse http://localhost:8080/swagger-ui.html
2. Navegue até a seção "Message"
3. Teste os endpoints disponíveis:
   - POST /api/messages - Criar nova mensagem
   - GET /api/messages - Listar todas as mensagens
   - GET /api/messages/remetente/{remetente} - Buscar mensagens por remetente
   - GET /api/messages/destinatario/{destinatario} - Buscar mensagens por destinatário

### Usando cURL

**Criar nova mensagem:**
```bash
curl -X POST http://localhost:8080/api/messages \
-H "Content-Type: application/json" \
-d '{
    "mensagem": "Teste de mensagem",
    "destinatario": "usuario2",
    "lembrarRemetente": true,
    "dataLembrete": "2024-03-10T10:00:00",
    "dataEvento": "2024-03-15T15:00:00"
}'
```

**Resposta esperada:**
```json
{
    "id": "65ed1234abcd5678ef901234",
    "mensagem": "Teste de mensagem",
    "remetente": "sistema",
    "destinatario": "usuario2",
    "lembrarRemetente": true,
    "dataLembrete": "2024-03-10T10:00:00",
    "dataEvento": "2024-03-15T15:00:00"
}
```

**Observações**: 
- O ID é gerado automaticamente pelo MongoDB
- O remetente é definido automaticamente pelo sistema com base no usuário autenticado
- O formato de data deve ser: "yyyy-MM-dd'T'HH:mm:ss" (Exemplo: "2024-03-10T10:00:00")

**Listar todas as mensagens:**
```bash
curl http://localhost:8080/api/messages
```

**Buscar mensagens por remetente:**
```bash
curl http://localhost:8080/api/messages/remetente/usuario1
```

**Buscar mensagens por destinatário:**
```bash
curl http://localhost:8080/api/messages/destinatario/usuario2
```

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── phrq/
│   │           └── notifyback/
│   │               ├── config/
│   │               │   └── OpenApiConfig.java
│   │               ├── controller/
│   │               │   └── MessageController.java
│   │               ├── service/
│   │               │   └── MessageService.java
│   │               ├── repository/
│   │               │   └── MessageRepository.java
│   │               ├── model/
│   │               │   └── Message.java
│   │               ├── dto/
│   │               │   └── MessageDTO.java
│   │               ├── mapper/
│   │               │   └── MessageMapper.java
│   │               └── NotifybackApplication.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── phrq/
                └── notifyback/
                    └── NotifybackApplicationTests.java
```

## Estrutura de Pacotes

- `controller`: Controladores REST para manipulação de requisições HTTP
- `service`: Implementação da lógica de negócios
- `repository`: Interfaces de acesso ao MongoDB
- `model`: Classes de entidade do MongoDB
- `dto`: Objetos de Transferência de Dados para API
- `mapper`: Conversores entre DTOs e entidades
- `config`: Classes de configuração da aplicação

## Tecnologias Utilizadas

- Spring Boot 3.4.3
- Java 17
- MongoDB para persistência de dados
- Spring Data MongoDB
- OpenAPI 3.0 (Swagger) para documentação
- MapStruct para mapeamento de objetos
- Lombok para redução de código boilerplate
- Spring DevTools para desenvolvimento
- Maven para gerenciamento de dependências

## Funcionalidades

- [x] CRUD de mensagens
- [x] Busca de mensagens por remetente
- [x] Busca de mensagens por destinatário
- [x] Documentação interativa com Swagger
- [x] Persistência em MongoDB
- [ ] Autenticação e autorização (Em desenvolvimento)
- [ ] Notificações em tempo real
- [ ] Agendamento de mensagens 