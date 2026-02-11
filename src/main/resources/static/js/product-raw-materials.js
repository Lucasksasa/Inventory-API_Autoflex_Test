const productSelect = document.getElementById('productSelect');
const rawMaterialSelect = document.getElementById('rawMaterialSelect');
const requiredQuantityInput = document.getElementById('requiredQuantity');
const linkBtn = document.getElementById('linkBtn');
const linkedList = document.getElementById('linkedList');

let selectedProductId = null;

// Fetch products and raw materials
async function loadData() {
    const products = await fetch('/products').then(res => res.json());
    products.forEach(p => {
        const option = document.createElement('option');
        option.value = p.id;
        option.textContent = p.name;
        productSelect.appendChild(option);
    });

    const rawMaterials = await fetch('/raw-materials').then(res => res.json());
    rawMaterials.forEach(rm => {
        const option = document.createElement('option');
        option.value = rm.id;
        option.textContent = `${rm.name} - Stock: ${rm.stockQuantity}`;
        rawMaterialSelect.appendChild(option);
    });

    // Load linked raw materials for the first product
    if (products.length > 0) {
        selectedProductId = products[0].id;
        loadLinkedRawMaterials(selectedProductId);
    }
}

async function loadLinkedRawMaterials(productId) {
    linkedList.innerHTML = '';
    const linked = await fetch(`/product-raw-materials/product/${productId}`)
        .then(res => res.json());

    linked.forEach(item => {
        const li = document.createElement('li');
        li.textContent = `Raw Material ID: ${item.rawMaterialId} - Required Quantity: ${item.requiredQuantity}`;
        linkedList.appendChild(li);
    });
}

// Event listeners
productSelect.addEventListener('change', (e) => {
    selectedProductId = e.target.value;
    loadLinkedRawMaterials(selectedProductId);
});

linkBtn.addEventListener('click', async () => {
    const rawMaterialId = rawMaterialSelect.value;
    const requiredQuantity = requiredQuantityInput.value;

    if (!selectedProductId || !rawMaterialId || requiredQuantity <= 0) {
        alert('Please select product, raw material and quantity!');
        return;
    }

    await fetch(`/product-raw-materials?productId=${selectedProductId}&rawMaterialId=${rawMaterialId}&requiredQuantity=${requiredQuantity}`, {
        method: 'POST'
    });

    loadLinkedRawMaterials(selectedProductId);
});

// Initial load
loadData();
