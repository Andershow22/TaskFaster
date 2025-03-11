function validacaoCadastro() {
    console.log("enhbjcfei")
    //passa por todos os inputs e vê se algum está vazio
    let inputs = Array.from(document.getElementsByClassName("input-cadastro"));
    inputs.forEach(input => {
        if (input.value == "") {
            let label = document.querySelector(`label[for="${input.name}"]`)
            label.style.visibility = "visible"
            label.style.opacity = "1"
            label.style.transition = "opacity 0.2s ease-in-out"
        }
    }); //acaba o  for each

    //valida se as senhas correspondem
    if (inputs[3].value != inputs[4].value) {
        let label = document.querySelector(`label[for="${inputs[4].name}"]`)
        label.style.visibility = "visible"
        label.style.opacity = "1"
        label.style.transition = "opacity 0.2s ease-in-out"
        label.innerHTML = "As senhas não são compatíveis"

    }
}
function validacaoLogin(){
    let inputs = Array.from(document.getElementsByClassName("form-control"));
    inputs.forEach(input => {
        if (input.value == "") {
            let label = document.querySelector(`label[for="${input.name}"]`)
            label.style.visibility = "visible"
            label.style.opacity = "1"
            label.style.transition = "opacity 0.2s ease-in-out"
        }
    })
}

function validacaoCriarTarefa(){
    let inputs = Array.from(document.getElementsByClassName("form-control"));
    inputs.forEach(input => {
        if (input.value == "") {
            let label = document.querySelector(`label[for="titulo"]`)
            label.style.visibility = "visible"
            label.style.opacity = "1"
            label.style.transition = "opacity 0.2s ease-in-out"
        }
    })
}