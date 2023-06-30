const loadTurnos = function () {

    const url = '/turnos';
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
            for (turno of data) {

                let table = document.getElementById("turnosTable");
                let turnoRow = table.insertRow();
                let tr_id = 'tr_' + turno.id;
                turnoRow.id = tr_id;

                let deleteButton = '<button' +
                    ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                    ' type="button" ' +
                    'onclick="deleteTurno(' + turno.id + ')" ' +
                    'class="btn btn-danger btn_delete">' +
                    '&times' +
                    '</button>';



                turnoRow.innerHTML =
                    '<td class=\"td_id\">' + turno.id + '</td>' +
                    '<td class=\"td_paciente\">' + turno.paciente.toUpperCase() + '</td>' +
                    '<td class=\"td_odontologo\">' + turno.odontologo.toUpperCase() + '</td>' +
                    '<td class=\"td_fecha_y_hora\">' + turno.fechaYHora.toUpperCase() + '</td>' +
                    '<td>' + deleteButton + '</td>';
            };

        })
}


const deleteTurno = function(id) {
    const url = '/turnos/eliminar/'+ id;
    const settings = {
        method: 'DELETE'
    }

    fetch(url,settings);

    let row_id = "#tr_" + id;
    document.querySelector(row_id).remove();

}


window.addEventListener('load', function () {
    loadTurnos();
})