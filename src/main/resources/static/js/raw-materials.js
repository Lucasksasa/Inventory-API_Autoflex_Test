const API_URL = "http://localhost:8080/raw-materials";

function loadRawMaterials() {
    fetch(API_URL)
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById("rawMaterialList");
            list.innerHTML = "";

            data.forEach(rm => {
                const li = document.createElement("li");
                li.textContent = `${rm.name} - Stock quantity: ${rm.stockQuantity}`;

                const deleteBtn = document.createElement("button");
                deleteBtn.textContent = "Delete";
                deleteBtn.onclick = () => deleteRawMaterial(rm.id);

                li.appendChild(deleteBtn);
                list.appendChild(li);
            });
        });
}

function createRawMaterial() {
    const name = document.getElementById("name").value;
    const stockQuantity = document.getElementById("stockQuantity").value;

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: name,
            stockQuantity: parseInt(stockQuantity)
        })
    })
    .then(() => {
        document.getElementById("name").value = "";
        document.getElementById("stockQuantity").value = "";
        loadRawMaterials();
    });
}

function deleteRawMaterial(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
    .then(() => loadRawMaterials());
}
