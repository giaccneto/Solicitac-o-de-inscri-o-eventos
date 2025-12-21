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
const API_BASE_URL = 'http://localhost:8080/eventos';
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

🎨 Interface do Usuário

Layout Principal

Sidebar: Formulário para criação de eventos

Conteúdo Principal: Lista de eventos cadastrados

Header: Barra de navegação com busca

Footer: Informações do sistema

Componentes

Formulário de Evento

Campos obrigatórios marcados com *

Validação em tempo real

Datas sincronizadas automaticamente

Cards de Evento

Informações principais visíveis

Badge indicando tipo (com/sem diária)

Botões de ação (editar/excluir)

Estatísticas

Total de eventos

Eventos com diária

Eventos do mês atual

🔧 Configuração para Produção
Backend (application.properties)
properties
# Banco de dados PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/eventospro
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=false

# CORS (ajuste para seu domínio)
cors.allowed-origins=https://seu-dominio.com

# Porta
server.port=8080
Frontend (Deploy)
Hospede os arquivos estáticos em:

Netlify (recomendado)

Vercel

GitHub Pages

AWS S3 + CloudFront

Atualize a URL da API:

javascript
const API_BASE_URL = 'https://sua-api-producao.com/eventos';
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

🤝 Contribuindo
Fork o projeto

Crie uma branch para sua feature (git checkout -b feature/AmazingFeature)

Commit suas mudanças (git commit -m 'Add some AmazingFeature')

Push para a branch (git push origin feature/AmazingFeature)

Abra um Pull Request

📄 Licença
Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE para detalhes.

👤 Autor
Giacc Neto

GitHub: @giaccneto

🙏 Agradecimentos
Spring Boot

Bootstrap

Bootstrap Icons

📞 Suporte
Encontrou um problema ou tem uma sugestão?

Verifique as Issues

Abra uma nova issue se necessário

Ou entre em contato: seu-email@exemplo.com

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
