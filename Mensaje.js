
function Mensaje(titulo, id, creador, fecha, contenido) {
    let titulo = titulo;
    let id = id;
    let creador = creador;
    let fecha = fecha;
    let contenido = contenido;

    this.getTitulo = function() {
        return this.titulo;
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
    this.getContenido = function() {
        return this.contenido;
    }
}