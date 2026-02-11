const fetchBtn = document.getElementById('fetchProductionBtn');
const tableBody = document.getElementById('productionTableBody');

fetchBtn.addEventListener('click', () => {
    fetch('/production/available')
        .then(response => response.json())
        .then(data => {
            tableBody.innerHTML = ''; // limpa a tabela antes de preencher
            data.forEach(product => {
                const row = document.createElement('tr');

                const nameCell = document.createElement('td');
                nameCell.textContent = product.productName;

                const unitPriceCell = document.createElement('td');
                unitPriceCell.textContent = `$${product.unitPrice.toFixed(2)}`;

                const quantityCell = document.createElement('td');
                quantityCell.textContent = product.quantityToProduce;

                const totalValueCell = document.createElement('td');
                totalValueCell.textContent = `$${product.totalValue.toFixed(2)}`;

                row.appendChild(nameCell);
                row.appendChild(unitPriceCell);
                row.appendChild(quantityCell);
                row.appendChild(totalValueCell);

                tableBody.appendChild(row);
            });
        })
        .catch(err => console.error('Error fetching production data:', err));
});
