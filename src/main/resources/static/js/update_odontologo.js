window.addEventListener('load',
    function () {


        const formulario = document.querySelector('#update_odontologo_form');

        formulario.addEventListener('submit', function (event) {
            let odontologoId = document.querySelector('#odontologo_id').value;


            const formData = {
                id: document.querySelector('#odontologo_id').value,
                titulo: document.querySelector('#nombre').value,
                categoria: document.querySelector('#apellido').value,
                premios: document.querySelector('#matricula').value,

            };

            const url = '/odontologo';
            const settings = {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(formData)
            }
            fetch(url, settings)
                .then(response => response.json())

        })
    })


function findBy(id) {
    const url = '/odontologo'+"/"+id;
    const settings = {
        method: 'GET'
    }
    fetch(url,settings)
        .then(response => response.json())
        .then(data => {
            let odontologo = data;
            document.querySelector('#odontologo_id').value = pelicula.id;
            document.querySelector('#nombre').value = pelicula.titulo;
            document.querySelector('#apellido').value = pelicula.categoria;
            document.querySelector('#matricula').value = pelicula.premios;
            //el formulario por default esta oculto y al editar se habilita
            document.querySelector('#div_odontologo_updating').style.display = "block";
        }).catch(error => {
        alert("Error: " + error);
    })
}