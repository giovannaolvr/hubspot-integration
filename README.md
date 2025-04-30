# HubSpot Integration

Este projeto foi desenvolvido com o objetivo de implementar uma integração entre uma aplicação Java e a API do HubSpot utilizando OAuth 2.0 (Authorization Code Flow). A aplicação expõe endpoints REST para autenticação, criação de contatos e recebimento de webhooks.

## Como executar

### Pré-requisitos

- Java 17+
- Maven 3.8+
- Conta no HubSpot com app configurado (com client ID, client secret e redirect URI)
- (Opcional) Insomnia ou outra ferramenta para testar os endpoints

### Passos para rodar localmente

1. Clone este repositório:
   ```bash
   git clone https://github.com/giovannaolvr/hubspot-integration.git
   cd hubspot-integration
   ```

2. Configure as variáveis de ambiente no arquivo `application.properties` (em `src/main/resources`) com suas credenciais do HubSpot:
   ```properties
   hubspot.clientId=SUA_CLIENT_ID
   hubspot.clientSecret=SEU_CLIENT_SECRET
   hubspot.redirectUri=SUA_REDIRECT_URI
   ```

3. Compile e execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse os endpoints:

   - **GET /oauth/authorize**  
     Retorna a URL de autorização do HubSpot para iniciar o fluxo OAuth.

   - **GET /oauth/callback?code=XXX**  
     Endpoint de callback que troca o código de autorização por um access token.

   - **POST /contacts**  
     Cria um novo contato no HubSpot CRM. Envie os dados do contato em JSON, no seguinte formato:
     ```bash
     {
      "email": "joao.silva@example.com",
      "firstName": "João",
      "lastName": "Silva"
      }
     ![image](https://github.com/user-attachments/assets/ac35eebd-2c73-4d99-b533-fd0f7e91c5b9)

---

## Documentação Técnica

### Principais decisões e bibliotecas utilizadas

- **Spring Boot**: framework moderno e produtivo para criação de APIs REST em Java.
- **spring-boot-starter-web**: para criação dos endpoints REST.
- **spring-boot-starter-validation**: para validar as entradas da API.
- **spring-boot-starter-security**: segurança básica e configuração inicial.
- **Lombok**: para reduzir boilerplate no código (getters, setters, constructors).
- **OAuth2 Authorization Code Flow**: fluxo mais seguro para troca de credenciais e tokens.

### Decisões técnicas

- Separação clara entre camadas de controller, service e configuração.
- Validações aplicadas no endpoint de criação de contato.
- Estrutura pronta para receber autenticação segura e tratamento robusto de erros.
- Uso de boas práticas do Spring e da API HubSpot, conforme documentação oficial.

---

## Melhorias futuras

Infelizmente, não consegui finalizar todas as funcionalidades planejadas. Entretanto, as seguintes melhorias estão mapeadas:

- 🔗 Finalizar a integração completa com o webhook do HubSpot.
- 🤖 Automatizar a troca de tokens e criação dinâmica dos headers.
- 💻 Criar um frontend simples para facilitar testes e visualização dos fluxos.
- 🛡️ Melhorar autenticação e segurança com tokens e filtros adicionais.
- 🧪 Criar testes automatizados para garantir cobertura dos fluxos.

---

## Organização do código

- `controller/` – Endpoints da aplicação.
- `service/` – Lógica de integração com o HubSpot.
- `config/` – Configurações do cliente OAuth.
- `model/` – Modelos e DTOs utilizados nos endpoints.
