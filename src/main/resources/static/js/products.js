const API_URL = "http://localhost:8080/products";

function loadProducts() {
    fetch(API_URL)
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById("productList");
            list.innerHTML = "";

            data.forEach(product => {
                const li = document.createElement("li");
                li.textContent = `${product.name} - $${product.price}`;

                const deleteBtn = document.createElement("button");
                deleteBtn.textContent = "Delete";
                deleteBtn.onclick = () => deleteProduct(product.id);

                li.appendChild(deleteBtn);
                list.appendChild(li);
            });
        });
}

function createProduct() {
    const name = document.getElementById("name").value;
    const price = document.getElementById("price").value;

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: name,
            price: price
        })
    })
    .then(() => {
        document.getElementById("name").value = "";
        document.getElementById("price").value = "";
        loadProducts();
    });
}

function deleteProduct(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
    .then(() => loadProducts());
}
