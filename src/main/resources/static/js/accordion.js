const accordions = document.querySelectorAll('.accordion')
accordions.forEach(ac => {
    ac.addEventListener('click', () =>{
        const body = ac.querySelector('.accordion-body')
        body.classList.toggle('active');
    })
})