const loadOdontologos = function () {
    console.log("Cargando odontologos")
    const url = '/odontologos';
    const settings = {
        method: 'GET'
    }

    fetch(url, settings)
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Something went wrong');
        })
        .then(data => {
            for (odontologo of data) {

                let table = document.getElementById("odontologoTable");
                let odontologoRow = table.insertRow();
                let tr_id = 'tr_' + odontologo.id;
                odontologoRow.id = tr_id;

                let updateButton = '<button' +
                    ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                    ' type="button" onclick="getOdontologoById(' + odontologo.id + ')" class="btn btn-info btn_id">' +
                    odontologo.id +
                    '</button>';

                odontologoRow.innerHTML = '<td>' + updateButton + '</td>' +
                    '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_apellido\">' + odontologo.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_matricula\">' + odontologo.matricula.toUpperCase() + '</td>';

            }
            ;

        })
}

const loadPacientes = function () {
    console.log("Cargando pacientes")
    const url = '/pacientes';
    const settings = {
        method: 'GET'
    }

    fetch(url, settings)
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('Something went wrong');
        })
        .then(data => {
            for (paciente of data) {

                let table = document.getElementById("paciente_table");
                let pacienteRow = table.insertRow();
                let tr_id = 'tr_' + paciente.id;
                pacienteRow.id = tr_id;

                let updateButton = '<button' +
                    ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                    ' type="button" onclick="getPacienteById(' + paciente.id + ')" class="btn btn-info btn_id">' +
                    paciente.id +
                    '</button>';

                pacienteRow.innerHTML = '<td>' + updateButton + '</td>' +
                    '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_dni\">' + paciente.dni.toUpperCase() + '</td>' +
                    '<td class=\"td_fechaIngreso\">' + paciente.fechaIngreso.toUpperCase() + '</td>' +
                    '<td class=\"td_domicilio\">' + paciente.domicilio.calle.toUpperCase() + '</td>';
            }
            ;

        })
}

const getOdontologoById = function (id) {
    const url = '/odontologos' + "/" + id;
    const settings = {
        method: 'GET'
    }
    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            let odontologo = data;
            document.querySelector('#odontologo_id').value = odontologo.id;
            document.querySelector('#matricula').value = odontologo.matricula;
            document.querySelector('#div_turno_updating').style.display = "block";
        }).catch(error => {
        alert("Error: " + error);
    })
}

const getPacienteById = function (id) {
    const url = '/pacientes' + "/" + id;
    const settings = {
        method: 'GET'
    }
    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            let odontologo = data;
            document.querySelector('#paciente_id').value = paciente.id;
            document.querySelector('#dni').value = paciente.dni;
            document.querySelector('#div_turno_updating').style.display = "block";
        }).catch(error => {
        alert("Error: " + error);
    })
}

const inicializarFormulario = function () {
    function resetUploadForm() {
        document.querySelector('#odontologo_id').value = "";
        document.querySelector('#matricula').value = "";
        document.querySelector('#paciente_id').value = "";
        document.querySelector('#dni').value = "";
        document.querySelector('#fechaReserva').value = "";
    }

    const formulario = document.querySelector('#ingresar_turno');

    formulario.addEventListener('submit', function (event) {

        const formData = {
            odontologo: {id: document.querySelector('#odontologo_id').value},
            paciente: {id: document.querySelector('#paciente_id').value},
            fechaYHora: document.querySelector('#fechaReserva').value.replace("T", " "),
        };

        const url = '/turnos/registrar';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }


        fetch(url, settings)
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error('Something went wrong');
            })
            .then(data => {
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong></strong> Turno ingresado con exito</div>'

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetUploadForm();
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error intente nuevamente</strong> </div>'

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";

            });

        event.preventDefault();
    });
}


window.addEventListener('load', function () {
    loadOdontologos();
    loadPacientes();
    inicializarFormulario();
})