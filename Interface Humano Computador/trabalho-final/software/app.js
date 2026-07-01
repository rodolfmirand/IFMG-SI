// ListaFácil — app de tarefas simples, com localStorage.
// Contém falhas de usabilidade PROPOSITAIS — ver docs/00-escopo-software.md

const STORAGE_TASKS = "listafacil_tarefas";
const STORAGE_CATS = "listafacil_categorias";

let tarefas = JSON.parse(localStorage.getItem(STORAGE_TASKS) || "[]");
let categorias = JSON.parse(localStorage.getItem(STORAGE_CATS) || "null") || ["Trabalho", "Pessoal", "Estudos"];
let editandoId = null;

function salvarTarefas() { localStorage.setItem(STORAGE_TASKS, JSON.stringify(tarefas)); }
function salvarCategorias() { localStorage.setItem(STORAGE_CATS, JSON.stringify(categorias)); }

// ============================================================
// LOGGER DE SESSÃO (para testes de usabilidade)
// Invisível ao participante — nada muda na tela. Captura eventos com
// timestamp, contagem de ações e tempo por tarefa. Uso no console (F12):
//   startTask('nome')  -> marca início da tarefa
//   endTask()          -> marca fim e imprime tempo + nº de ações
//   exportSessionLog() -> baixa/imprime o log completo
//   resetSessionLog()  -> zera log e dados (rodar antes de cada participante)
// Ver docs/04-roteiro-teste-usabilidade.md, seção 9.
// ============================================================
const sessao = {
  inicio: Date.now(),
  eventos: [],
  tarefaAtual: null,
  tarefaInicio: null,
  tarefaAcoes: 0,
};

function logEvent(tipo, detalhe) {
  const t = Date.now();
  if (sessao.tarefaAtual) sessao.tarefaAcoes++;
  sessao.eventos.push({
    tipo,
    detalhe: detalhe || "",
    msDesdeInicio: t - sessao.inicio,
    tarefa: sessao.tarefaAtual,
    hora: new Date(t).toLocaleTimeString("pt-BR"),
  });
}

// Registra automaticamente cada clique relevante (contagem de ações e caminho).
document.addEventListener("click", e => {
  const el = e.target.closest("button, a, .nav-btn");
  if (!el) return;
  const rotulo = (el.getAttribute("title") || el.textContent || el.dataset.view || "")
    .trim().replace(/\s+/g, " ").slice(0, 40);
  logEvent("clique", `${el.tagName.toLowerCase()}:${rotulo}`);
}, true);

window.startTask = function (nome) {
  sessao.tarefaAtual = nome || "tarefa";
  sessao.tarefaInicio = Date.now();
  sessao.tarefaAcoes = 0;
  logEvent("tarefa:inicio", sessao.tarefaAtual);
  console.log(`[sessão] Tarefa iniciada: "${sessao.tarefaAtual}"`);
};

window.endTask = function () {
  if (!sessao.tarefaAtual) { console.warn("[sessão] Nenhuma tarefa em andamento."); return; }
  const dur = ((Date.now() - sessao.tarefaInicio) / 1000).toFixed(1);
  const acoes = sessao.tarefaAcoes;
  logEvent("tarefa:fim", `${sessao.tarefaAtual} — ${dur}s, ${acoes} ações`);
  console.log(`[sessão] Tarefa "${sessao.tarefaAtual}" concluída em ${dur}s com ${acoes} ações (caminho ótimo = 6).`);
  const resumo = { tarefa: sessao.tarefaAtual, tempo_s: Number(dur), acoes };
  sessao.tarefaAtual = null;
  return resumo;
};

window.exportSessionLog = function () {
  const dados = {
    duracaoTotal_s: ((Date.now() - sessao.inicio) / 1000).toFixed(1),
    totalEventos: sessao.eventos.length,
    eventos: sessao.eventos,
  };
  console.table(sessao.eventos);
  try {
    const blob = new Blob([JSON.stringify(dados, null, 2)], { type: "application/json" });
    const a = document.createElement("a");
    a.href = URL.createObjectURL(blob);
    a.download = `sessao-${new Date().toISOString().slice(0, 19).replace(/[:T]/g, "-")}.json`;
    a.click();
    URL.revokeObjectURL(a.href);
  } catch (_) { /* download opcional */ }
  return dados;
};

window.resetSessionLog = function () {
  localStorage.removeItem(STORAGE_TASKS);
  localStorage.removeItem(STORAGE_CATS);
  sessao.inicio = Date.now();
  sessao.eventos = [];
  sessao.tarefaAtual = null;
  sessao.tarefaAcoes = 0;
  console.log("[sessão] Log e dados zerados. Recarregue a página (F5) para começar limpo.");
};

// Ícones SVG inline (estilo Lucide). Nota: os ícones de "editar" e "concluir"
// usam o mesmo tamanho/cor e não têm rótulo — falha proposital #2.
const ICONS = {
  editar: '<svg viewBox="0 0 24 24" class="ico"><path d="M12 20h9"/><path d="M16.5 3.5a2.12 2.12 0 0 1 3 3L7 19l-4 1 1-4 12.5-12.5z"/></svg>',
  concluir: '<svg viewBox="0 0 24 24" class="ico"><polyline points="20 6 9 17 4 12"/></svg>',
  excluir: '<svg viewBox="0 0 24 24" class="ico"><polyline points="3 6 5 6 21 6"/><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"/></svg>',
};

// ---------- Navegação entre views ----------
function mostrarView(id) {
  document.querySelectorAll(".view").forEach(v => v.hidden = true);
  document.getElementById(id).hidden = false;
}

document.querySelectorAll(".nav-btn").forEach(btn => {
  btn.addEventListener("click", () => {
    document.querySelectorAll(".nav-btn").forEach(b => b.classList.remove("active"));
    btn.classList.add("active");
    const view = btn.dataset.view;
    mostrarView("view-" + view);
    if (view === "lista") renderLista();
    if (view === "categorias") renderCategorias();
  });
});

// ---------- Lista de tarefas ----------
function preencherFiltroCategorias() {
  const sel = document.getElementById("filtro-categoria");
  sel.innerHTML = '<option value="">Todas as categorias</option>' +
    categorias.map(c => `<option value="${c}">${c}</option>`).join("");
}

function formatarPrazo(iso) {
  // Falha proposital: formato ambíguo DD/MM, sem indicar por extenso.
  if (!iso) return "sem prazo";
  const [ano, mes, dia] = iso.split("-");
  return `${dia}/${mes}`;
}

function renderLista() {
  preencherFiltroCategorias();
  const catFiltro = document.getElementById("filtro-categoria").value;
  const statusFiltro = document.getElementById("filtro-status").value;

  let filtradas = tarefas.filter(t => {
    if (catFiltro && t.categoria !== catFiltro) return false;
    if (statusFiltro === "pendente" && t.concluida) return false;
    if (statusFiltro === "concluida" && !t.concluida) return false;
    return true;
  });

  const ul = document.getElementById("lista-tarefas");
  const vazio = document.getElementById("lista-vazia");
  ul.innerHTML = "";

  if (filtradas.length === 0) {
    vazio.hidden = false;
    return;
  }
  vazio.hidden = true;

  filtradas.forEach(t => {
    const li = document.createElement("li");
    li.innerHTML = `
      <div class="tarefa-info">
        <span class="tarefa-titulo ${t.concluida ? "concluida" : ""}">${t.titulo}</span>
        <span class="tarefa-meta">
          <span class="badge badge-cat">${t.categoria || "sem categoria"}</span>
          <span class="badge badge-prazo">prazo ${formatarPrazo(t.prazo)}</span>
          <span class="badge badge-prio ${t.prioridade}">${t.prioridade}</span>
        </span>
      </div>
      <div class="tarefa-acoes">
        <button title="editar" data-acao="editar" data-id="${t.id}">${ICONS.editar}</button>
        <button title="concluir" data-acao="concluir" data-id="${t.id}">${ICONS.concluir}</button>
        <button title="excluir" data-acao="excluir" data-id="${t.id}">${ICONS.excluir}</button>
      </div>`;
    ul.appendChild(li);
  });
}

document.getElementById("lista-tarefas").addEventListener("click", e => {
  const btn = e.target.closest("button");
  if (!btn) return;
  const id = btn.dataset.id;
  const acao = btn.dataset.acao;
  const tarefa = tarefas.find(t => t.id === id);
  if (!tarefa) return;

  if (acao === "editar") {
    abrirFormulario(tarefa);
  } else if (acao === "concluir") {
    tarefa.concluida = !tarefa.concluida;
    salvarTarefas();
    logEvent("tarefa:concluir", `${tarefa.titulo} -> ${tarefa.concluida ? "concluída" : "reaberta"}`);
    renderLista();
  } else if (acao === "excluir") {
    // Falha proposital: sem confirmação e sem "desfazer".
    tarefas = tarefas.filter(t => t.id !== id);
    salvarTarefas();
    logEvent("tarefa:excluir", tarefa.titulo);
    renderLista();
  }
});

document.getElementById("filtro-categoria").addEventListener("change", () => { logEvent("filtro:categoria", document.getElementById("filtro-categoria").value || "todas"); renderLista(); });
document.getElementById("filtro-status").addEventListener("change", () => { logEvent("filtro:status", document.getElementById("filtro-status").value || "todos"); renderLista(); });

// ---------- Formulário de tarefa ----------
function preencherSelectCategoria() {
  const sel = document.getElementById("campo-categoria");
  sel.innerHTML = categorias.map(c => `<option value="${c}">${c}</option>`).join("");
}

function abrirFormulario(tarefa) {
  preencherSelectCategoria();
  const erro = document.getElementById("form-erro");
  erro.hidden = true;

  if (tarefa) {
    editandoId = tarefa.id;
    document.getElementById("form-titulo").textContent = "Editar tarefa";
    document.getElementById("campo-titulo").value = tarefa.titulo;
    document.getElementById("campo-categoria").value = tarefa.categoria;
    document.getElementById("campo-prazo").value = tarefa.prazo;
    document.getElementById("campo-prioridade").value = tarefa.prioridade;
  } else {
    editandoId = null;
    document.getElementById("form-titulo").textContent = "Nova tarefa";
    document.getElementById("form-tarefa").reset();
  }
  mostrarView("view-form");
}

document.getElementById("btn-nova-tarefa").addEventListener("click", () => abrirFormulario(null));
document.getElementById("btn-cancelar").addEventListener("click", () => {
  mostrarView("view-lista");
  renderLista();
});

document.getElementById("form-tarefa").addEventListener("submit", e => {
  e.preventDefault();
  const titulo = document.getElementById("campo-titulo").value.trim();
  const erro = document.getElementById("form-erro");

  if (!titulo) {
    // Falha proposital: mensagem de erro genérica, não diz o que está errado.
    erro.hidden = false;
    logEvent("erro:salvar", "título vazio (mensagem genérica exibida)");
    return;
  }
  erro.hidden = true;

  const dados = {
    titulo,
    categoria: document.getElementById("campo-categoria").value,
    prazo: document.getElementById("campo-prazo").value,
    prioridade: document.getElementById("campo-prioridade").value,
  };

  if (editandoId) {
    const t = tarefas.find(t => t.id === editandoId);
    Object.assign(t, dados);
    logEvent("tarefa:editar", dados.titulo);
  } else {
    tarefas.push({ id: crypto.randomUUID(), concluida: false, ...dados });
    logEvent("tarefa:criar", `${dados.titulo} [${dados.categoria}/${dados.prioridade}/${dados.prazo || "sem prazo"}]`);
  }
  salvarTarefas();

  // Falha proposital: nenhum feedback visual de sucesso (sem toast/spinner) —
  // volta direto para a lista como se nada tivesse acontecido.
  mostrarView("view-lista");
  renderLista();
});

// ---------- Categorias ----------
function renderCategorias() {
  const ul = document.getElementById("lista-categorias");
  ul.innerHTML = categorias.map(c => `
    <li>
      <span>${c}</span>
      <div class="tarefa-acoes">
        <button title="excluir categoria" data-cat="${c}">${ICONS.excluir}</button>
      </div>
    </li>`).join("");
}

document.getElementById("btn-add-categoria").addEventListener("click", () => {
  const input = document.getElementById("nova-categoria-nome");
  const nome = input.value.trim();
  if (!nome || categorias.includes(nome)) return;
  categorias.push(nome);
  salvarCategorias();
  input.value = "";
  renderCategorias();
});

document.getElementById("lista-categorias").addEventListener("click", e => {
  const btn = e.target.closest("button[data-cat]");
  if (!btn) return;
  const cat = btn.dataset.cat;
  // Falha proposital: exclui a categoria sem avisar que tarefas associadas
  // ficarão "sem categoria" — nenhuma confirmação é pedida.
  categorias = categorias.filter(c => c !== cat);
  tarefas.forEach(t => { if (t.categoria === cat) t.categoria = ""; });
  salvarCategorias();
  salvarTarefas();
  renderCategorias();
});

document.getElementById("link-ajuda").addEventListener("click", e => {
  e.preventDefault();
  mostrarView("view-ajuda");
});
document.getElementById("btn-voltar-ajuda").addEventListener("click", () => {
  document.querySelector('.nav-btn[data-view="categorias"]').click();
});

// ---------- Inicialização ----------
renderLista();
