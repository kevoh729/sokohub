   const products = [
            { name: 'Wireless Earbuds', price: 'Ksh 2,500', emoji: '🎧' },
            { name: 'Smart Watch', price: 'Ksh 5,999', emoji: '⌚' },
            { name: 'Phone Case', price: 'Ksh 800', emoji: '📱' },
            { name: 'Sneakers', price: 'Ksh 4,200', emoji: '👟' },
            { name: 'Perfume Set', price: 'Ksh 3,500', emoji: '💐' },
            { name: 'Handbag', price: 'Ksh 6,500', emoji: '👜' },
            { name: 'Sunglasses', price: 'Ksh 2,800', emoji: '😎' },
            { name: 'Beanie', price: 'Ksh 1,200', emoji: '🧢' }
        ];

        // Render products
        function renderProducts() {
            const grid = document.getElementById('productsGrid');
            grid.innerHTML = products.map((prod) => `
                <div class="product-card">
                    <div class="product-image">${prod.emoji}</div>
                    <div class="product-info">
                        <div class="product-name">${prod.name}</div>
                        <div class="product-price">${prod.price}</div>
                        <button class="add-to-cart-btn" onclick="addToCart('${prod.name}')">Add to Cart</button>
                    </div>
                </div>
            `).join('');
        }

        // Filter categories
        function filterCategory(element) {
            document.querySelectorAll('.category-chip').forEach(chip => {
                chip.classList.remove('active');
            });
            element.classList.add('active');
        }

        // Bottom nav
        function switchNav(element, page) {
            document.querySelectorAll('.nav-item').forEach(item => {
                item.classList.remove('active');
            });
            element.classList.add('active');
            console.log('Navigating to: ' + page);
        }

        // Actions
        function addToCart(productName) {
            alert('✅ ' + productName + ' added to cart!');
        }

        function goToCart() {
            alert('🛒 Cart page');
        }

        function toggleNotifications() {
            alert('🔔 You have 3 new notifications');
        }

        function shopNow() {
            document.getElementById('productsGrid').scrollIntoView({ behavior: 'smooth' });
        }

        // Initialize
        document.addEventListener('DOMContentLoaded', () => {
            renderProducts();
        });