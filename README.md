# EventosPro - Sistema de Gestão de Eventos


Um sistema completo para gestão de eventos profissionais, desenvolvido com Spring Boot no backend e HTML/CSS/JavaScript com Bootstrap no frontend.

✨ Funcionalidades
Backend (Spring Boot)

✅ CRUD completo de eventos

✅ Busca de eventos por nome

✅ Atualização de eventos existentes

✅ Exclusão de eventos

✅ API RESTful com CORS habilitado

✅ Validação de dados

Frontend (HTML/CSS/JS + Bootstrap)

✅ Interface responsiva e moderna

✅ Formulário para criação de eventos

✅ Listagem de eventos com busca em tempo real

✅ Edição e exclusão de eventos

✅ Estatísticas automáticas

✅ Validação de formulários no cliente

✅ Feedback visual com mensagens toast


🚀 Começando
Pré-requisitos
Java 17+ (para o backend)

Maven 3.8+ (para build)

Node.js (opcional, para desenvolvimento frontend)

Git (para controle de versão)

Instalação do Backend
Clone o repositório

bash
git clone https://github.com/seu-usuario/eventospro.git
cd eventospro/backend
Configure o banco de dados

O projeto usa H2 Database em memória por padrão

Para produção, configure application.properties com suas credenciais

Execute a aplicação

bash
mvn spring-boot:run
A API estará disponível em: http://localhost:8080

Instalação do Frontend
Navegue até a pasta do frontend

bash
cd eventospro/frontend
Configure a URL da API

Abra index.html

Localize a constante API_BASE_URL

Altere para a URL do seu backend:

javascript
const API_BASE_URL = 'http://localhost:8080/evento';
Execute o frontend

Abra index.html diretamente no navegador

Ou use um servidor local:

bash
npx serve .
📡 API Endpoints
Método	Endpoint	Descrição	Body JSON
POST	/eventos	Cria um novo evento	{ "nomeEvento": "string", "publicoAlvo": "string", "ch": number, "local": "string", "dataInicio": "date", "dataFim": "date", "diaria": boolean }
GET	/eventos/{nomeEvento}	Busca evento por nome	-
PUT	/eventos/{nomeEvento}	Atualiza evento existente	Mesmo formato do POST
DELETE	/eventos/{nomeEvento}	Remove evento	-
Exemplo de Request Body
json
{
  "nomeEvento": "Curso de Python Avançado",
  "publicoAlvo": "Desenvolvedores",
  "ch": 40,
  "local": "Online",
  "dataInicio": "2024-06-01",
  "dataFim": "2024-06-10",
  "diaria": true
}



Atualize a URL da API:

javascript
const API_BASE_URL = 'https://sua-api-producao.com/evento';
🧪 Testando a Aplicação
Testes Backend
bash
cd backend
mvn test
Testes Manuais
Crie um evento usando o formulário

Busque o evento pelo nome

Edite o evento criado

Exclua o evento

Verifique as estatísticas atualizadas

📱 Responsividade
O sistema é totalmente responsivo:

Desktop: Layout com sidebar fixa

Tablet: Ajuste automático de colunas

Mobile: Stack vertical dos componentes

🛠️ Tecnologias Utilizadas
Backend
Spring Boot 3.x - Framework Java

Spring Data JPA - Persistência de dados

H2 Database - Banco em memória (desenvolvimento)

PostgreSQL - Banco de produção (recomendado)

Maven - Gerenciamento de dependências

Frontend
HTML5 - Estrutura semântica

CSS3 - Estilos personalizados

JavaScript (ES6+) - Lógica do cliente

Bootstrap 5 - Componentes UI

Bootstrap Icons - Ícones vetoriais


Crie uma branch para sua feature (git checkout -b feature/AmazingFeature)

Commit suas mudanças (git commit -m 'Add some AmazingFeature')

Push para a branch (git push origin feature/AmazingFeature)

Abra um Pull Request

Melhorias:

🚧 Em breve / Roadmap
[ ] Autenticação JWT: Implementação de login seguro.

[ ] Gestão de Usuários: Fluxo de cadastro e persistência em banco de dados.

[ ] Controle de Acesso (RBAC): Autorização granular baseada na Role do usuário (Admin vs. User).



⭐ Se este projeto foi útil para você, considere dar uma estrela no repositório!


<div style="displjey inline">
  <img width='80' height='80' src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/github/github-original.svg" />
  <img width='80' height='80' src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" />
  <img width='80' height='80' src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" />       
  <img width='80' height='80'src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/spring/spring-original.svg" />
  <img width='80' height='80' src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/postman/postman-original.svg" />
  <img width='80' height='80' src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/maven/maven-original.svg" />
  <img width='80' height='80' src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/javascript/javascript-original.svg" />
  <img width='80' height='80' src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/html5/html5-original-wordmark.svg" />
  <img width='80' height='80' src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/css3/css3-original-wordmark.svg" />
  <img width='80' height='80' src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/bootstrap/bootstrap-original-wordmark.svg" />       
</div>
