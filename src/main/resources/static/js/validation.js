
//validações
////////////////////////////////////////////////
function validacaoCadastro(event) {
    //passa por todos os inputs e vê se algum está vazio
    let inputs = Array.from(document.getElementsByClassName("input-cadastro"));
    let valido = true;

    inputs.forEach(input => {
        if (input.value == "") {
            let label = document.querySelector(`label[for="${input.name}"]`)
            label.style.visibility = "visible"
            label.style.opacity = "1"
            label.style.transition = "opacity 0.2s ease-in-out"
            valido = false;
        }
    }); //acaba o  for each

    //valida se as senhas correspondem
    if (inputs[3].value != inputs[4].value) {
        let label = document.querySelector(`label[for="${inputs[4].name}"]`)
        label.style.visibility = "visible"
        label.style.opacity = "1"
        label.style.transition = "opacity 0.2s ease-in-out"
        label.innerHTML = "As senhas não são compatíveis"
        valido = false;
    }
    if (!valido) {
        event.preventDefault();
    }
}
function validacaoLogin() {
    let inputs = Array.from(document.getElementsByClassName("form-control"));
    let resultado = true;
    inputs.forEach(input => {
        if (input.value == "") {
            let label = document.querySelector(`label[for="${input.name}"]`)
            label.style.visibility = "visible"
            label.style.opacity = "1"
            label.style.transition = "opacity 0.2s ease-in-out"
            resultado = false;
        }

    })
    return resultado;
}

function validacaoCriarTarefa() {
    let inputs = Array.from(document.getElementsByClassName("form-control"));
    inputs.forEach(input => {
        if (input.value == "") {
            let label = document.querySelector(`label[for="titulo"]`)
            label.style.visibility = "visible"
            label.style.opacity = "1"
            label.style.transition = "opacity 0.2s ease-in-out"
        }
    })

    /*
    if (resultado) {
        let url = "/tarefa/criar";
        fetch(url, {
            method: "POST",
            headers: { "Content-Type": "application/json" }, // Define o tipo de conteúdo
            body: JSON.stringify({
                titulo: inputs[0].value,
                descricao: inputs[1].value,
                prioridade: inputs[2].value,
                data_finalizacao: inputs[3].value,
            })
        })
        .then(response => {
            if (response.ok) {
                return response.text();
            }
            throw new Error("Erro ao criar tarefa");
        })
        .then(message => {
            console.log(message);
            window.location.reload();
        })
        .catch(error => console.error("Erro:", error));
    }
        */
}

//AJAX
///////////////////////////////////////////////
