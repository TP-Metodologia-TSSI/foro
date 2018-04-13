
function Subforo(nombre, id, descripcion, creador, fecha,
                moderadores, temas) {
    let nombre = nombre;
    let id = id;
    let descripcion = descripcion;
    let creador = creador;
    let fecha = fecha;
    let moderadores = moderadores;
    let temas = temas;

    this.getNombre = function() {
        return this.nombre;
    }
    this.getDescripcion = function() {
        return this.descripcion;
    }
    this.getId = function() {
        return this.id;
    }
    this.getCreador = function() {
        return this.creador;
    }
    this.getFecha = function() {
        return this.fecha;
    }
}