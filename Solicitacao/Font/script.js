
/* ===============================
   CONFIGURAÇÃO DA API
================================ */
const API_BASE_URL = 'localhost:8080/eventos';

/* ===============================
   ESTADO DA APLICAÇÃO
================================ */
let eventos = [];
let eventoEmEdicao = null;

/* ===============================
   INICIALIZAÇÃO
================================ */
document.addEventListener('DOMContentLoaded', () => {
    configurarDatasMinimas();
    configurarEventListeners();
    carregarEventosDaAPI();
});

/* ===============================
   CONFIGURAÇÕES INICIAIS
================================ */
function configurarDatasMinimas() {
    const hoje = new Date().toISOString().split('T')[0];

    ['dataInicio', 'dataFim', 'editDataInicio', 'editDataFim'].forEach(id => {
        document.getElementById(id).min = hoje;
    });

    document.getElementById('dataInicio').addEventListener('change', e => {
        document.getElementById('dataFim').min = e.target.value;
    });

    document.getElementById('editDataInicio').addEventListener('change', e => {
        document.getElementById('editDataFim').min = e.target.value;
    });
}

function configurarEventListeners() {
    document.getElementById('eventoForm').addEventListener('submit', criarEvento);
    document.getElementById('btnLimparForm').addEventListener('click', limparFormulario);
    document.getElementById('btnSalvarEdicao').addEventListener('click', salvarEdicaoEvento);
    document.getElementById('buscarEvento').addEventListener('input', buscarEvento);
}

/* ===============================
   CRUD – CREATE
================================ */
async function criarEvento(e) {
    e.preventDefault();

    const novoEvento = obterEventoDoFormulario();

    const response = await fetch(API_BASE_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(novoEvento)
    });

    const eventoCriado = await response.json();
    eventos.push(eventoCriado);

    atualizarListaEventos();
    atualizarEstatisticas();
    limparFormulario();
    mostrarMensagem('Evento criado com sucesso!', 'success');
}

/* ===============================
   CRUD – READ
================================ */
async function carregarEventosDaAPI() {
    const response = await fetch(API_BASE_URL);
    eventos = await response.json();
    atualizarListaEventos();
    atualizarEstatisticas();
}

async function buscarEvento(e) {
    const termo = e.target.value.trim();

    if (!termo) {
        atualizarListaEventos(eventos);
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/nome/${encodeURIComponent(termo)}`);
        if (!response.ok) throw new Error();

        const evento = await response.json();
        atualizarListaEventos([evento]);
    } catch {
        atualizarListaEventos([]);
    }
}

/* ===============================
   CRUD – UPDATE (POR ID)
================================ */
function abrirModalEdicao(evento) {
    eventoEmEdicao = evento;

    document.getElementById('editNomeEvento').value = evento.nomeEvento;
    document.getElementById('editPublicoAlvo').value = evento.publicoAlvo;
    document.getElementById('editCh').value = evento.ch;
    document.getElementById('editLocal').value = evento.local;
    document.getElementById('editDataInicio').value = evento.dataInicio;
    document.getElementById('editDataFim').value = evento.dataFim;
    document.getElementById('editDiaria').checked = evento.diaria;

    new bootstrap.Modal(document.getElementById('editarEventoModal')).show();
}

function salvarEdicaoEvento() {
    const eventoAtualizado = obterEventoDoFormularioEdicao();
    atualizarEventoPorId(eventoEmEdicao.id, eventoAtualizado);

    bootstrap.Modal.getInstance(
        document.getElementById('editarEventoModal')
    ).hide();
}

async function atualizarEventoPorId(id, eventoAtualizado) {
    const response = await fetch(`${API_BASE_URL}/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(eventoAtualizado)
    });

    const atualizado = await response.json();

    const index = eventos.findIndex(e => e.id === id);
    eventos[index] = atualizado;

    atualizarListaEventos();
    atualizarEstatisticas();
    mostrarMensagem('Evento atualizado com sucesso!', 'success');
}

/* ===============================
   CRUD – DELETE
================================ */
async function deletarEvento(id) {
    if (!confirm('Deseja realmente excluir este evento?')) return;

    await fetch(`${API_BASE_URL}/${id}`, { method: 'DELETE' });

    eventos = eventos.filter(e => e.id !== id);
    atualizarListaEventos();
    atualizarEstatisticas();
    mostrarMensagem('Evento excluído com sucesso!', 'success');
}

/* ===============================
   UI – LISTAGEM
================================ */
function atualizarListaEventos(lista = eventos) {
    const container = document.getElementById('listaEventos');
    container.innerHTML = '';

    if (lista.length === 0) {
        container.innerHTML = `
            <div class="empty-state">
                <i class="bi bi-calendar-x"></i>
                <h5>Nenhum evento encontrado</h5>
            </div>`;
        return;
    }

    lista.forEach(evento => {
        container.innerHTML += `
            <div class="card evento-card">
                <div class="card-body">
                    <h5 class="evento-header">${evento.nomeEvento}</h5>
                    <p>${evento.publicoAlvo}</p>
                    <div class="evento-actions">
                        <button class="btn btn-sm btn-outline-primary"
                            onclick='abrirModalEdicao(${JSON.stringify(evento).replace(/"/g, "&quot;")})'>
                            Editar
                        </button>
                        <button class="btn btn-sm btn-outline-danger"
                            onclick="deletarEvento(${evento.id})">
                            Excluir
                        </button>
                    </div>
                </div>
            </div>`;
    });
}

/* ===============================
   ESTATÍSTICAS
================================ */
function atualizarEstatisticas() {
    document.getElementById('totalEventos').textContent = eventos.length;
    document.getElementById('eventosDiaria').textContent =
        eventos.filter(e => e.diaria).length;

    const hoje = new Date();
    document.getElementById('eventosEsteMes').textContent =
        eventos.filter(e => new Date(e.dataInicio).getMonth() === hoje.getMonth()).length;
}

/* ===============================
   UTILITÁRIOS
================================ */
function obterEventoDoFormulario() {
    return {
        nomeEvento: nomeEvento.value.trim(),
        publicoAlvo: publicoAlvo.value.trim(),
        ch: Number(ch.value),
        local: local.value.trim(),
        dataInicio: dataInicio.value,
        dataFim: dataFim.value,
        diaria: diaria.checked
    };
}

function obterEventoDoFormularioEdicao() {
    return {
        nomeEvento: editNomeEvento.value.trim(),
        publicoAlvo: editPublicoAlvo.value.trim(),
        ch: Number(editCh.value),
        local: editLocal.value.trim(),
        dataInicio: editDataInicio.value,
        dataFim: editDataFim.value,
        diaria: editDiaria.checked
    };
}

function limparFormulario() {
    document.getElementById('eventoForm').reset();
}

function mostrarMensagem(msg, tipo) {
    const alert = document.createElement('div');
    alert.className = `alert alert-${tipo} position-fixed top-0 end-0 m-3`;
    alert.textContent = msg;
    document.body.appendChild(alert);
    setTimeout(() => alert.remove(), 4000);
}
