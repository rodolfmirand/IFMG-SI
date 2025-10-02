let editingUser = null; // se for edição, guarda o nome antigo

async function loadUsers() {
  const res = await fetch("http://127.0.0.1:5000/get");
  const users = await res.json();

  const tbody = document.getElementById("userTable");
  tbody.innerHTML = "";

  users.forEach(user => {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td>${user.name}</td>
      <td>${user.email}</td>
      <td>
        <button class="edit-btn" onclick="editUser('${user.name}', '${user.email}')">Editar</button>
        <button class="delete-btn" onclick="deleteUser('${user.name}')">Excluir</button>
      </td>
    `;
    tbody.appendChild(row);
  });
}

async function saveUser() {
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;

  if (!name || !email) {
    alert("Preencha todos os campos!");
    return;
  }

  if (editingUser) {
    await fetch("http://127.0.0.1:5000/update", {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ old_name: editingUser, new_name: name, new_email: email })
    });
    editingUser = null;
    document.getElementById("form-title").innerText = "Adicionar Usuário";
  } else {
    await fetch("http://127.0.0.1:5000/", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name, email })
    });
  }

  document.getElementById("name").value = "";
  document.getElementById("email").value = "";
  loadUsers();
}

function editUser(name, email) {
  editingUser = name;
  document.getElementById("form-title").innerText = "Editar Usuário";
  document.getElementById("name").value = name;
  document.getElementById("email").value = email;
}

async function deleteUser(name) {
  if (confirm(`Tem certeza que deseja excluir ${name}?`)) {
    await fetch("http://127.0.0.1:5000/delete", {
      method: "DELETE",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name })
    });
    loadUsers();
  }
}

loadUsers();
