window.addEventListener('load', function (event) {
    (function(){
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
                for(paciente of data){

                    let table = document.getElementById("paciente_table");
                    let pacienteRow =table.insertRow();
                    let tr_id = 'tr_' + paciente.id;
                    pacienteRow.id = tr_id;

                    let deleteButton = '<button' +
                        ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                        ' type="button" onclick="deleteBy('+paciente.id+')" class="btn btn-danger btn_delete">' +
                        '&times' +
                        '</button>';

                    let updateButton = '<button' +
                        ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                        ' type="button" onclick="findBy('+paciente.id+')" class="btn btn-info btn_id">' +
                        paciente.id +
                        '</button>';

                    pacienteRow.innerHTML = '<td>' + updateButton + '</td>' +
                        '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                        '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                        '<td class=\"td_dni\">' + paciente.dni.toUpperCase() + '</td>' +
                        '<td class=\"td_fechaIngreso\">' + paciente.fechaIngreso.toUpperCase() + '</td>' +
                        '<td class=\"td_calle\">' + paciente.domicilio.calle.toUpperCase() + '</td>' +
                        '<td class=\"td_numero\">' + paciente.domicilio.numero + '</td>' +
                        '<td class=\"td_localidad\">' + paciente.domicilio.localidad.toUpperCase() + '</td>' +
                        '<td class=\"td_provincia\">' + paciente.domicilio.provincia.toUpperCase() + '</td>' +
                        '<td>' + deleteButton + '</td>';

                };

            })
        event.preventDefault();
    })

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/get_paciente.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })
})