
function MensajePrivado(titulo, id, creador, fecha, contenido, recipiente) {
    let titulo = titulo;
    let id = id;
    let creador = creador;
    let fecha = fecha;
    let contenido = contenido;
    let recipiente = recipiente;

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
    this.getRecipiente = function() {
        return this.recipiente;
    }
}