package com.geinzz.geinzwork.dataclass

data class dataclassCarritoCompra(
    // Información del pedido y driver
    val idDriver: String?,
    val idPedido: String?,
    val estado: String?,
    val metodoPago: String?,
    val productos: String?,
    val estadoPedido: String?,
    val metodoEntrega: String?,
    val tipoRealizado:String?,

    // Totales para cancelar
    val precioDelivery: Double?,
    val totalCancelar: Double?,
    val totalDriver: Double?,
    val totalProductos: Double?,

    // Fecha y hora
    val fecha: String?,
    val hora: String?,

    // Información de la tienda
    val idTienda: String?,
    val nombreTienda: String?,
    val localidadTienda: String?,
    val tipoTienda: String?,

    // Información del usuario
    val idUser: String?,
    val nombre: String?,
    val numero: String?,
    val localidad: String?,
    val direccion: String?,
    val referencia: String?
)