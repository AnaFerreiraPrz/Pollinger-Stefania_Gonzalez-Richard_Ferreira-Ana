function deleteBy(id)
{
    const url = '/odontologos/eliminar/'+ id;
    const settings = {
        method: 'DELETE'
    }
    fetch(url,settings);

    let row_id = "#tr_" + id;
    document.querySelector(row_id).remove();

}