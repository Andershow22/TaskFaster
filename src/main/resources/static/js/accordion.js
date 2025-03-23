const accordions = document.querySelectorAll('.accordion');

accordions.forEach(ac => {
    const header = ac.querySelector('.accordion-header'); // Ouvinte apenas no header
    if (header) {
        header.addEventListener('click', () => {
            ac.classList.toggle('active'); // Aplica a classe "active" no accordion inteiro
        });
    }
});