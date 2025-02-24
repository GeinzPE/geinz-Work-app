package com.geinzz.geinzwork.dataclass

data class dataclasscompra_reserva_promociones(
    //camposUSer
    val nombre: String?,
    val apellido: String?,
    val dni: String?,
    val numero: String?,
    val localidadus: String?,
    //tienda
    val tipoReserva: String?,
    val localidadTienda: String?,
    val estado: String = "pendiente",
    val nombreTienda: String?,
    val idTienda: String?,
    val tipoTienda: String?,
    //fecha y hora
    val fechaActual: String?,
    val horaActual: String?,
    val horaReserva: String?,
    //producto
    val codigoPedido: String?,
    val metodoEntrega: String?,
    val tituloProducto: String?,
    val idproducto: String?,
    val referenciaEntrega: String? = "",
    val direcionEntrega: String? = "",
    val tipoRealizado:String?="",
    val metodoPAgo:String?="",

    //totales
    val Precio_producto: String?,
    val Total_item_selecionado: String?,
    val Total_driver: String?,
    val totalApagar: String?,
)
