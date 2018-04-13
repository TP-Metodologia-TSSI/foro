


function Usuario(nombre, id, urlImagen, admin, status, amigos) {
    let nombre = nombre;
    let id = id;
    let urlImagen = urlImagen;
    let administrador = admin;
    let status = status;
    let amigos = amigos;

    this.getNombre = function() {
        return this.nombre;
    }
    this.getImagenPerfil = function() {
        return this.urlImagen;
    }
    this.getId = function() {
        return this.id;
    }
    this.getAdmin = function() {
        return this.administrador;
    }
    this.getStatus = function() {
        return this.status;
    }
}