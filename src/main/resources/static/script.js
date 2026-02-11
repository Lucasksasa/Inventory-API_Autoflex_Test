document.getElementById("btnLoad").addEventListener("click", loadRawMaterials);

function loadRawMaterials() {
    fetch("/raw-materials")
        .then(response => {
            if (!response.ok) {
                throw new Error("Error fetching data");
            }
            return response.json();
        })
        .then(data => renderList(data))
        .catch(error => alert(error.message));
}

function renderList(items) {
    const list = document.getElementById("list");
    list.innerHTML = "";

    items.forEach(item => {
        const li = document.createElement("li");
        li.textContent = `${item.name} - Stock quantity: ${item.stockQuantity}`;
        list.appendChild(li);
    });
}
