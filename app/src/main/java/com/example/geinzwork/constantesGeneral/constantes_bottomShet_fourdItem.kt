package com.example.geinzwork.constantesGeneral


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.geinzwork.NotificacionRS
import com.geinzz.geinzwork.R
import com.geinzz.geinzwork.adapterViewholder.adapter_radioButton_envios
import com.geinzz.geinzwork.constantesGeneral.constantes
import com.geinzz.geinzwork.constantesGeneral.constantesCarrito
import com.geinzz.geinzwork.constantesGeneral.constantesDatosUsuarioTienda
import com.geinzz.geinzwork.constantesGeneral.constantesImagenes
import com.geinzz.geinzwork.constantesGeneral.mostrarFechaDialog_horaDialog
import com.geinzz.geinzwork.databinding.BottomSheetReservaProductosBinding
import com.geinzz.geinzwork.dataclass.dataclasscompra_reserva_promociones
import com.geinzz.geinzwork.dataclass.dataclassradiobtn
import com.geinzz.geinzwork.vistaTiendas.direccion_entrega_lat_log
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.imageview.ShapeableImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

object constantes_bottomShet_fourdItem {
    private lateinit var firebaseAuth: FirebaseAuth

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    fun bottomSheetReservaProducto(
        titulo_dialog: String,
        tipo: String,
        dialog: BottomSheetDialog,
        idTienda: String,
        idProductoClikado: String,
        context: Context,
        nombreTienda: TextView,
        idUSer: String,
        lista: MutableList<dataclassradiobtn>,
    ) {
        val bindingBottomShjet = BottomSheetReservaProductosBinding.inflate(LayoutInflater.from(context))
        val titulo = bindingBottomShjet.tvTitle
        val view = bindingBottomShjet.root
        val horaActual = bindingBottomShjet.horaActual
        val fechaActual = bindingBottomShjet.FechaActual
        val tipoTienda = bindingBottomShjet.TipoTienda
        val localidaTienda = bindingBottomShjet.localidadTienda
        val nombreUser = bindingBottomShjet.camposPrincipales.nombreUser
        val apellidouser = bindingBottomShjet.camposPrincipales.apellidouser
        val dniUser = bindingBottomShjet.camposPrincipales.dniUser
        val numeroContacto = bindingBottomShjet.camposPrincipales.numeroContacto
        val horareserva = bindingBottomShjet.camposPrincipales.horareserva
        val horaint = bindingBottomShjet.camposPrincipales.horaint
        val localidadUser = bindingBottomShjet.camposPrincipales.localidadUser
        val RadioMetodoPago = bindingBottomShjet.metodoPagos.RadioMetodoPago
        val tituloItem = bindingBottomShjet.itemPreviewProductos.tituloItem
        val stokART = bindingBottomShjet.itemPreviewProductos.Stok
        val precioItem = bindingBottomShjet.itemPreviewProductos.precioItem
        val cantidad = bindingBottomShjet.itemPreviewProductos.cantidad
        val mas = bindingBottomShjet.itemPreviewProductos.mas
        val menos = bindingBottomShjet.itemPreviewProductos.menos
        val imgItem = bindingBottomShjet.itemPreviewProductos.imgItem
        val aumentarCantidadLineal = bindingBottomShjet.itemPreviewProductos.aumentarCantidadLineal
        val textoDriverPago = bindingBottomShjet.totalPagar
        val pagodeldriver = bindingBottomShjet.totalPagar.drivetxt
        val productosTotal = bindingBottomShjet.totalPagar.pagoProductos
        val totalPagar = bindingBottomShjet.totalPagar.totalPagar
        val totalLinealPagar = bindingBottomShjet.totalPagar.linealTotalPagar
        val linealDriver = bindingBottomShjet.totalPagar.linealDriver
        val layoutContainer = bindingBottomShjet.direccionEnvios.layoutContainer
        val delivery_precio = bindingBottomShjet.direccionEnvios.precioDelivery
        val longitudUser = bindingBottomShjet.direccionEnvios.longituduser
        val latitudUser = bindingBottomShjet.direccionEnvios.latitudUSer
        val direccionEntrega = bindingBottomShjet.direccionEnvios.direccionED
        val referenciaEntrega = bindingBottomShjet.direccionEnvios.referenciaED
        val reccileRadioBtn = bindingBottomShjet.direccionEnvios.reccileRadioBtn
        val creaDireccion = bindingBottomShjet.direccionEnvios.creaDireccion
        val metodoDelivery = bindingBottomShjet.metodoEntrega.delivery
        val radioGrupMetodoEntrega = bindingBottomShjet.metodoEntrega.RadiomodoEntrega
        val btnApply = bindingBottomShjet.btnApply
        var METODPAGO: String = ""
        var metodoEntrega = ""
        var precioITemSTR: String = ""
        var StokART_PROMO: String = ""

        obtnerDireciones(
            idUSer,
            lista,
            reccileRadioBtn,
            creaDireccion,
            context,
            direccionEntrega,
            referenciaEntrega,
            latitudUser,
            longitudUser, delivery_precio, pagodeldriver, totalPagar
        )
        obtenerHorarioDeHoy(idTienda) { apertura, cierre, boolena ->
            bindingBottomShjet.horarioAtencion.text = "$apertura AM a $cierre PM"
        }
        mas.setOnClickListener {
            incrementarCantidad(
                cantidad,
                1,
                stokART,
                context,
                mas,
                productosTotal,
                precioItem,
                pagodeldriver,
                totalPagar
            )
        }
        menos.setOnClickListener {
            incrementarCantidad(
                cantidad,
                -1,
                stokART,
                context,
                menos,
                productosTotal,
                precioItem,
                pagodeldriver,
                totalPagar
            )
        }
        titulo.text = titulo_dialog
        creaDireccion.setOnClickListener {
            context.startActivity(Intent(context, direccion_entrega_lat_log::class.java))
            dialog.dismiss()
        }
        constantesCarrito.obtnerfechaHora(horaActual, fechaActual)
        constantesDatosUsuarioTienda.obtnerLocalidades(localidadUser)
        constantesCarrito.setearDatosUsuario { nombre, numero, localidad, apellido ->
            if (nombre == null || numero == null || localidad == null || apellido == null) {
                Log.e("user", "Error: Algunos datos son null")
            } else {
                nombreUser.setText(nombre)
                numeroContacto.setText(numero)
                localidadUser.setText(localidad)
                apellidouser.setText(apellido)
                constantesDatosUsuarioTienda.obtnerLocalidades(localidadUser)
            }
        }
        delivery_precio.setOnClickListener {
            if (direccionEntrega.text.isNullOrEmpty()) {
                Toast.makeText(context, "Primero devemos obtener su direccion", Toast.LENGTH_SHORT)
                    .show()
                delivery_precio.dismissDropDown()
            } else {
                delivery_precio.showDropDown()
            }
        }
        constantes_cotizacion_driver.setearDelivery(delivery_precio, context)
        delivery_precio.setOnItemClickListener { parent, view, position, id ->
            val selectedService = parent.getItemAtPosition(position).toString()
            constantes_cotizacion_driver.obtenerCostoDelivery(
                longitudUser,
                latitudUser,
                idTienda,
                { estandar ->
                    if (selectedService == "Delivery estandar(GEINZ)") {
                        textoDriverPago.drivetxt.text = "(estandar) "
                        setearTotal(totalPagar, pagodeldriver, productosTotal, estandar)
                    }
                },
                { express ->
                    if (selectedService == "Delivery express(GEINZ)") {
                        textoDriverPago.drivetxt.text = "(express) "
                        setearTotal(totalPagar, pagodeldriver, productosTotal, express)
                    }
                })
        }
        horareserva.setOnClickListener {
            mostrarFechaDialog_horaDialog.showTimePiker(context as AppCompatActivity, horareserva)
        }
        constantesDatosUsuarioTienda.obtenerDetallesTienda(idTienda) { localidad, tipo ->
            localidaTienda.text = localidad
            tipoTienda.text = tipo
            if (tipo == "virtual") {
                metodoDelivery.isVisible = true
                direccionEntrega.isVisible = true
                referenciaEntrega.isVisible = true
                layoutContainer.isVisible = true
                linealDriver.isVisible = true
                totalLinealPagar.isVisible = false
                metodoEntrega = "Delivery"

            } else {
                radioGrupMetodoEntrega.isVisible = true
                linealDriver.isVisible = false
                direccionEntrega.isVisible = false
                referenciaEntrega.isVisible = false
                layoutContainer.isVisible = false
                totalLinealPagar.isVisible = false
            }
        }
        RadioMetodoPago.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.Efectivo -> {
                    METODPAGO = "EFECTIVO"
                    bindingBottomShjet.metodoPagos.layoutYape.isVisible = false
                    bindingBottomShjet.metodoPagos.pagoEfectivo.isVisible = true
                    bindingBottomShjet.metodoPagos.imagenYape.isVisible = false
                }

                R.id.Yape -> {
                    METODPAGO = "YAPE"
                    bindingBottomShjet.metodoPagos.imagenYape.isVisible = true
                    bindingBottomShjet.metodoPagos.layoutYape.isVisible = true
                    bindingBottomShjet.metodoPagos.pagoEfectivo.isVisible = false
                    bindingBottomShjet.metodoPagos.imagenPlin.isVisible = false
                }

                R.id.Plin -> {
                    METODPAGO = "PLIN"
                    bindingBottomShjet.metodoPagos.imagenYape.isVisible = false
                    bindingBottomShjet.metodoPagos.layoutYape.isVisible = true
                    bindingBottomShjet.metodoPagos.imagenPlin.isVisible = true
                    bindingBottomShjet.metodoPagos.pagoEfectivo.isVisible = false
                }

                else -> {
                    METODPAGO = ""
                }
            }

        }
        radioGrupMetodoEntrega.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.recojoEnTienda -> {
                    totalLinealPagar.isVisible = true
                    direccionEntrega.isVisible = false
                    referenciaEntrega.isVisible = false
                    layoutContainer.isVisible = false
                    linealDriver.isVisible = false
                    metodoEntrega = "Recojo en tienda"
                    direccionEntrega.setText("")
                    referenciaEntrega.setText("")
                    delivery_precio.setText("")
                    pagodeldriver.text = "0.0"
                    totalPagar.text = productosTotal.text
                }

                R.id.Delivery -> {
                    totalLinealPagar.isVisible = true
                    linealDriver.isVisible = true
                    layoutContainer.isVisible = true
                    direccionEntrega.isVisible = true
                    referenciaEntrega.isVisible = true
                    metodoEntrega = "Delivery"
                    pagodeldriver.text = "***"
                    totalPagar.text = "***"
                }

                else -> {
                    direccionEntrega.isVisible = false
                    referenciaEntrega.isVisible = false
                    metodoEntrega = ""
                    totalLinealPagar.isVisible = false
                }
            }
        }

        when (tipo) {
            "reservaPromociones" -> {
                horaint.isVisible = true
                get_obtenerPromoSugeridas(
                    tituloItem,
                    precioItem,
                    productosTotal,
                    imgItem,
                    context,
                    idProductoClikado,
                    idTienda,
                    bindingBottomShjet,
                ) { precio, stok ->
                    precioITemSTR = precio
                    StokART_PROMO = stok
                    stokART.text = StokART_PROMO
                }
                btnApply.setOnClickListener {
                    val horaentrega = horareserva.text.toString().trim()
                    val nombre = nombreUser.text.toString().trim()
                    val apellido = apellidouser.text.toString().trim()
                    val numero = numeroContacto.text.toString().trim()
                    val dni = dniUser.text.toString().trim()
                    val localidadUserTxt = localidadUser.text.toString().trim()
                    val nombreTienda = nombreTienda.text.toString().trim()
                    val tituloItemPromo = tituloItem.text.toString().trim()
                    val precioItemPromo = precioItem.text.toString().trim()
                    val cantidad = cantidad.text.toString().trim()
                    val tipoTienda = tipoTienda.text.toString().trim()
                    val horaActual = horaActual.text.toString().trim()
                    val fechaActual = fechaActual.text.toString().trim()
                    val pagodeldriver = pagodeldriver.text.toString().trim()
                    val totalPagar = totalPagar.text.toString().trim()
                    val direccionEntrega = direccionEntrega.text.toString().trim()
                    val referenciaEntrega = referenciaEntrega.text.toString().trim()
                    val dataclas = dataclasscompra_reserva_promociones(
                        //campos user
                        nombre = nombre,
                        apellido = apellido,
                        dni = dni,
                        numero = numero,
                        localidadus = localidadUserTxt,
                        //tienda
                        tipoReserva = "reserva promo",
                        localidadTienda = localidaTienda.text.toString(),
                        estado = "pendiente",
                        nombreTienda = nombreTienda,
                        idTienda = idTienda,
                        tipoTienda = tipoTienda,
                        //fecha y hora
                        fechaActual = fechaActual,
                        horaActual = horaActual,
                        horaReserva = horaentrega,
                        //producto
                        codigoPedido = constantesCarrito.generarCodigoPedido(),
                        metodoEntrega = metodoEntrega,
                        tituloProducto = tituloItemPromo,
                        idproducto = idProductoClikado,
                        referenciaEntrega = referenciaEntrega,
                        direcionEntrega = direccionEntrega,
                        tipoRealizado="reserva de promociones",
                        metodoPAgo=METODPAGO,
                        //totales
                        Precio_producto = precioItemPromo,
                        Total_item_selecionado = cantidad,
                        Total_driver = pagodeldriver,
                        totalApagar = totalPagar,
                    )
                    manejarClick(
                        "reserva_promo",
                        bindingBottomShjet,
                        context,
                        metodoEntrega,
                        idTienda,
                        localidaTienda,
                        localidadUser,
                        metodoDelivery,
                        METODPAGO
                    ) {
                        notificarCompraOReserva(
                            "idReservaPedido",
                            "reserva_promociones",
                            idTienda,
                            context,
                            constantesCarrito.generarCodigoPedido(),
                            dataclas,"reserva",
                            "Reserva de promocione",
                        ) { enviado ->
                            if (enviado) {
                                dialog.dismiss()
                            }
                        }
                    }
                }
            }

            "compraPromociones" -> {
                horaint.isVisible = false
                get_obtenerPromoSugeridas(
                    tituloItem,
                    precioItem,
                    productosTotal,
                    imgItem,
                    context,
                    idProductoClikado,
                    idTienda,
                    bindingBottomShjet,

                ) { precio, stok ->
                    precioITemSTR = precio
                    StokART_PROMO = stok
                    stokART.text = StokART_PROMO
                }
                btnApply.setOnClickListener {
                    val nombre = nombreUser.text.toString().trim()
                    val apellido = apellidouser.text.toString().trim()
                    val numero = numeroContacto.text.toString().trim()
                    val dni = dniUser.text.toString().trim()
                    val localidadUserTxt = localidadUser.text.toString().trim()
                    val nombreTienda = nombreTienda.text.toString().trim()
                    val tituloItemPromo = tituloItem.text.toString().trim()
                    val precioItemPromo = precioItem.text.toString().trim()
                    val cantidad = cantidad.text.toString().trim().trim()
                    val tipoTienda = tipoTienda.text.toString().trim()
                    val horaActual = horaActual.text.toString().trim()
                    val fechaActual = fechaActual.text.toString().trim()
                    val pagodeldriver = pagodeldriver.text.toString().trim()
                    val totalPagar = totalPagar.text.toString().trim()
                    val direccionEntrega = direccionEntrega.text.toString().trim()
                    val referenciaEntrega = referenciaEntrega.text.toString().trim()
                    val dataclas = dataclasscompra_reserva_promociones(
                        nombre = nombre,
                        apellido = apellido,
                        dni = dni,
                        numero = numero,
                        localidadus = localidadUserTxt,
                        tipoReserva = "compra promocion",
                        localidadTienda = localidaTienda.text.toString(),
                        estado = "pendiente",
                        nombreTienda = nombreTienda,
                        idTienda = idTienda,
                        tipoTienda = tipoTienda,
                        fechaActual = fechaActual,
                        horaActual = horaActual,
                        horaReserva = "",
                        codigoPedido = constantesCarrito.generarCodigoPedido(),
                        metodoEntrega = metodoEntrega,
                        tituloProducto = tituloItemPromo,
                        idproducto = idProductoClikado,
                        referenciaEntrega = referenciaEntrega,
                        direcionEntrega = direccionEntrega,
                        tipoRealizado="compra de promociones",
                        metodoPAgo=METODPAGO,
                        Precio_producto = precioItemPromo,
                        Total_item_selecionado = cantidad,
                        Total_driver = pagodeldriver,
                        totalApagar = totalPagar,
                    )
                    manejarClick(
                        "compra_promo",
                        bindingBottomShjet,
                        context,
                        metodoEntrega,
                        idTienda,
                        localidaTienda,
                        localidadUser,
                        metodoDelivery,
                        METODPAGO
                    ) {
                        notificarCompraOReserva(
                            "productos",
                            "compra_promociones",
                            idTienda,
                            context,
                            constantesCarrito.generarCodigoPedido(),
                            dataclas,"compra",
                            "Compra de promocion"
                        ) { enviado ->
                            if (enviado) {
                                dialog.dismiss()
                            }
                        }
                    }
                }
            }

            "reservaarticulos" -> {
                aumentarCantidadLineal.isVisible = true
                get_obtenerProductos(
                    tituloItem,
                    precioItem,
                    productosTotal,
                    imgItem,
                    context,
                    idProductoClikado,
                    idTienda,
                    bindingBottomShjet,
                ) { precio, stok ->
                    precioITemSTR = precio
                    StokART_PROMO = stok
                    stokART.text = StokART_PROMO
                }
                btnApply.setOnClickListener {
                    val nombre = nombreUser.text.toString().trim()
                    val apellido = apellidouser.text.toString().trim()
                    val numero = numeroContacto.text.toString().trim()
                    val dni = dniUser.text.toString().trim()
                    val localidadUserTxt = localidadUser.text.toString().trim()
                    val nombreTienda = nombreTienda.text.toString().trim()
                    val tituloItemPromo = tituloItem.text.toString().trim()
                    val precioItemPromo = precioItem.text.toString().trim()
                    val cantidad = cantidad.text.toString().trim()
                    val tipoTienda = tipoTienda.text.toString().trim()
                    val horaentrega = horareserva.text.toString().trim()
                    val horaActual = horaActual.text.toString().trim()
                    val fechaActual = fechaActual.text.toString().trim()
                    val pagodeldriver = pagodeldriver.text.toString().trim()
                    val totalPagar = totalPagar.text.toString().trim()
                    val direccionEntrega = direccionEntrega.text.toString().trim()
                    val referenciaEntrega = referenciaEntrega.text.toString().trim()
                    val dataclas = dataclasscompra_reserva_promociones(
                        //campos user
                        nombre = nombre,
                        apellido = apellido,
                        dni = dni,
                        numero = numero,
                        localidadus = localidadUserTxt,
                        //tienda
                        tipoReserva = "reserva articulos",
                        localidadTienda = localidaTienda.text.toString(),
                        estado = "pendiente",
                        nombreTienda = nombreTienda,
                        idTienda = idTienda,
                        tipoTienda = tipoTienda,
                        //fecha y hora
                        fechaActual = fechaActual,
                        horaActual = horaActual,
                        horaReserva = horaentrega,
                        //producto
                        codigoPedido = constantesCarrito.generarCodigoPedido(),
                        metodoEntrega = metodoEntrega,
                        tituloProducto = tituloItemPromo,
                        idproducto = idProductoClikado,
                        referenciaEntrega = referenciaEntrega,
                        direcionEntrega = direccionEntrega,
                        tipoRealizado="Reserva de articulos",
                        metodoPAgo=METODPAGO,
                        //totales
                        Precio_producto = precioItemPromo,
                        Total_item_selecionado = cantidad,
                        Total_driver = pagodeldriver,
                        totalApagar = totalPagar,
                    )
                    manejarClick(
                        "reserva_promo",
                        bindingBottomShjet,
                        context,
                        metodoEntrega,
                        idTienda,
                        localidaTienda,
                        localidadUser,
                        metodoDelivery,
                        METODPAGO
                    ) {
                        notificarCompraOReserva(
                            "idReservaPedido",
                            "reserva_articulos",
                            idTienda,
                            context,
                            constantesCarrito.generarCodigoPedido(),
                            dataclas,"reserva",
                            "Reserva de articulos",

                        ) { enviado ->
                            if (enviado) {
                                dialog.dismiss()
                            }
                        }
                    }
                }
            }
        }

        dialog.setContentView(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun validarCamposYHora(
        idTienda: String,
        metodoEntrega: String,
        binding: BottomSheetReservaProductosBinding,
        context: Context,
        callback: (Boolean) -> Unit,
    ) {
        compararHoraEntregaLLegada(
            binding.camposPrincipales.horareserva.text.toString(),
            binding.camposPrincipales.horareserva,
            idTienda
        ) { isWithinHours ->
            if (!isWithinHours) {
                Toast.makeText(
                    context,
                    "Ingrese una hora dentro del horario de atención",
                    Toast.LENGTH_SHORT
                ).show()
                callback(false)
                return@compararHoraEntregaLLegada
            }

            val verificacionCampos = verificarDeliveryCmapos(
                binding.direccionEnvios.direccionED,
                binding.direccionEnvios.referenciaED,
                binding.direccionEnvios.precioDelivery
            )
            if (metodoEntrega.equals("")) {
                Toast.makeText(context, "Seleccione su metodo de entrega", Toast.LENGTH_SHORT)
                    .show()
                callback(false)
                return@compararHoraEntregaLLegada
            }

            if (metodoEntrega == "Delivery" && !verificacionCampos) {
                Toast.makeText(context, "Formulario incompleto", Toast.LENGTH_SHORT).show()
                callback(false)
                return@compararHoraEntregaLLegada
            }

            if (!verificarCamposReservaCompra(context,binding, true)) {
                Toast.makeText(context, "Formulario incompleto", Toast.LENGTH_SHORT).show()
                callback(false)
                return@compararHoraEntregaLLegada
            }

            callback(true) // Si todas las validaciones pasan, llamar al callback con true
        }
    }


    private fun get_obtenerPromoSugeridas(
        tituloItem: TextView,
        precioItem: TextView,
        productosTotal: TextView,
        imgItem: ShapeableImageView,
        context: Context,
        idProductoClikado: String,
        idTienda: String,
        bindingBottomShjet: BottomSheetReservaProductosBinding,
        precioPROMO: (String, String) -> Unit,
    ) {
        val db = FirebaseFirestore.getInstance().collection("Tiendas").document(idTienda)
            .collection("promociones").document(idProductoClikado)
        db.get().addOnSuccessListener { res ->
            if (res.exists()) {
                val datos = res.data
                val imgArticulo = datos?.get("imagenUrl") as? String ?: ""
                val stok = datos?.get("stok") as? String ?: ""
                val nombreArticulo = datos?.get("titulo") as? String ?: ""
                val precio = datos?.get("precio") as? String ?: ""
                val plin = datos?.get("plin") as? Boolean ?: false
                val yape = datos?.get("yape") as? Boolean ?: false
                val efectivo = datos?.get("efectivo") as? Boolean ?: false
                val yapeRuta = "Tiendas/$idTienda/QR_pagos/Yape.jpg"
                val plinrRuta = "Tiendas/$idTienda/QR_pagos/Plin.jpg"
                precioPROMO(precio, stok)
                Log.d("precio_stok", "obtenemos precio y stok $precio $stok")
                constantesSetadas(
                    yapeRuta,
                    plinrRuta,
                    context,
                    bindingBottomShjet,
                    yape,
                    efectivo,
                    plin
                )
                verificarViivilidad_Pagos(
                    yape,
                    efectivo,
                    plin,
                    bindingBottomShjet.metodoPagos.Yape,
                    bindingBottomShjet.metodoPagos.Efectivo,
                    bindingBottomShjet.metodoPagos.Plin
                )
                setearIMGART(
                    tituloItem,
                    nombreArticulo,
                    precioItem,
                    precio,
                    productosTotal,
                    context,
                    imgArticulo,
                    imgItem
                )

            } else {
                Log.e("getErrorArt", "error")
                precioPROMO("", "")
            }
        }
            .addOnSuccessListener { res ->
                Log.e("getErrorArt", "error al obtener el articulo de la db")
            }
    }

    private fun get_obtenerProductos(
        tituloItem: TextView,
        precioItem: TextView,
        productosTotal: TextView,
        imgItem: ShapeableImageView,
        context: Context,
        idProductoClikado: String,
        idTienda: String,
        bindingBottomShjet: BottomSheetReservaProductosBinding,
        precioITEM: (String, String) -> Unit,
    ) {
        val db = FirebaseFirestore.getInstance().collection("Tiendas").document(idTienda)
            .collection("articulos").document(idProductoClikado)
        db.get().addOnSuccessListener { res ->
            if (res.exists()) {
                val datos = res.data
                val imgArticulo = datos?.get("imgArticulo") as? String ?: ""
                val nombreArticulo = datos?.get("nombreArticulo") as? String ?: ""
                val precio = datos?.get("precio") as? String ?: ""
                val plin = datos?.get("plin") as? Boolean ?: false
                val yape = datos?.get("yape") as? Boolean ?: false
                val cantidad = datos?.get("cantidad") as? String ?: ""
                val efectivo = datos?.get("efectivo") as? Boolean ?: false
                val yapeRuta = "Tiendas/$idTienda/QR_pagos/Yape.jpg"
                val plinrRuta = "Tiendas/$idTienda/QR_pagos/Plin.jpg"
                precioITEM(precio, cantidad)
                constantesSetadas(
                    yapeRuta,
                    plinrRuta,
                    context,
                    bindingBottomShjet,
                    yape,
                    efectivo,
                    plin
                )
                verificarViivilidad_Pagos(
                    yape,
                    efectivo,
                    plin,
                    bindingBottomShjet.metodoPagos.Yape,
                    bindingBottomShjet.metodoPagos.Efectivo,
                    bindingBottomShjet.metodoPagos.Plin
                )
                setearIMGART(
                    tituloItem,
                    nombreArticulo,
                    precioItem,
                    precio,
                    productosTotal,
                    context,
                    imgArticulo,
                    imgItem
                )

            } else {
                Log.e("getErrorArt", "error")
                precioITEM("", "")
            }
        }
            .addOnSuccessListener { res ->
                Log.e("getErrorArt", "error al obtener el articulo de la db")
            }
    }


    fun dialogo_solo_envios_localidadTienda(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("ATENCIÓN")
            .setMessage("Los envíos por delivery solo están disponibles para localidades iguales a las tiendas negocios o locales.")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .create().show()
    }

    private fun validacionCamposUsuario(
        bindingBottomShjet: BottomSheetReservaProductosBinding,
        context: Context,
        METODPAGO: String,
    ): Boolean {
        val nombre = bindingBottomShjet.camposPrincipales.nombreUser.text.toString().trim()
        val apellido = bindingBottomShjet.camposPrincipales.apellidouser.text.toString().trim()
        val numero = bindingBottomShjet.camposPrincipales.numeroContacto.text.toString().trim()
        val dni = bindingBottomShjet.camposPrincipales.dniUser.text.toString().trim()
        return when {
            nombre.isEmpty() -> {
                bindingBottomShjet.camposPrincipales.nombreUser.error = "El campo es requerido"
                Toast.makeText(context, "Campo nombre vacio", Toast.LENGTH_SHORT).show()
                false
            }

            apellido.isEmpty() -> {
                bindingBottomShjet.camposPrincipales.apellidouser.error = "El campo es requerido"
                Toast.makeText(context, "Campo apellido vacio", Toast.LENGTH_SHORT).show()
                false
            }

            numero.isEmpty() -> {
                bindingBottomShjet.camposPrincipales.numeroContacto.error = "El campo es requerido"
                Toast.makeText(context, "Campo numero vacio", Toast.LENGTH_SHORT).show()
                false
            }

            dni.isEmpty() -> {
                bindingBottomShjet.camposPrincipales.dniUser.error = "El campo es requerido"
                Toast.makeText(context, "Campo DNI vacio", Toast.LENGTH_SHORT).show()
                false
            }

            METODPAGO.isEmpty() -> {
                Toast.makeText(context, "Seleccione un método de pago", Toast.LENGTH_SHORT).show()
                false
            }

            else -> true
        }
    }


    fun constantesSetadas(
        yapeRuta: String,
        plinrRuta: String,
        context: Context,
        bindingBottomShjet: BottomSheetReservaProductosBinding,
        yape: Boolean,
        efectivo: Boolean,
        plin: Boolean,
    ) {
        constantesImagenes.obtenerURLDescarga(
            context,
            bindingBottomShjet.metodoPagos.imagenYape,
            yapeRuta
        )
        constantesImagenes.obtenerURLDescarga(
            context,
            bindingBottomShjet.metodoPagos.imagenPlin,
            plinrRuta
        )

        verificarViivilidad_Pagos(
            yape,
            efectivo,
            plin,
            bindingBottomShjet.metodoPagos.Yape,
            bindingBottomShjet.metodoPagos.Efectivo,
            bindingBottomShjet.metodoPagos.Plin
        )

    }

    private fun setearIMGART(
        tituloItem: TextView,
        nombreArticulo: String,
        precioItem: TextView,
        precio: String,
        productosTotal: TextView,
        context: Context,
        imgArticulo: String,
        imgItem: ShapeableImageView,
    ) {
        tituloItem.text = nombreArticulo
        precioItem.text = precio
        productosTotal.text = precio
        Glide.with(context)
            .load(imgArticulo)
            .into(imgItem)
    }

    private fun incrementarCantidad(
        cantidad: TextView,
        incremento: Int,
        stock: TextView,
        context: Context,
        btnApply: ImageButton,
        precioAumentado: TextView,
        precioUnitario: TextView,
        precioDElivery: TextView,
        totalAPAGARGENERAL: TextView,
    ) {
        val cantidadSTR = cantidad.text.toString()

        val precioUnitarioDouble = precioUnitario.text.toString().toDoubleOrNull() ?: 0.0
        val precioDriver = precioDElivery.text.toString().toDoubleOrNull() ?: 0.0
        val stockINT = stock.text.toString().toDoubleOrNull() ?: 0.0
        val cantidadINT = if (cantidadSTR.isNotBlank()) cantidadSTR.toInt() else 0
        val nuevaCantidad = cantidadINT + incremento


        if (nuevaCantidad > stockINT) {
            Toast.makeText(
                context,
                "La cantidad no puede superar al stock disponible",
                Toast.LENGTH_SHORT
            ).show()
            btnApply.isEnabled = true
        } else if (nuevaCantidad < 1) {
            Toast.makeText(context, "La cantidad no puede ser menor que 1", Toast.LENGTH_SHORT)
                .show()
            btnApply.isEnabled = true
        } else {
            cantidad.text = nuevaCantidad.toString()
            btnApply.isEnabled = true

            val precioTotal = nuevaCantidad * precioUnitarioDouble
            precioAumentado.text = String.format("%.2f", precioTotal)
            totalAPAGARGENERAL.text = (precioTotal + precioDriver).toString()
        }
    }


    fun obtnerDireciones(
        idUSer: String,
        lista: MutableList<dataclassradiobtn>,
        RecyclerView: RecyclerView,
        btnCrearDirecion: Button,
        context: Context,
        direccion: EditText,
        refererencia: EditText,
        latUSser: TextView,
        logUSer: TextView,
        precioDElivery: AutoCompleteTextView,
        pagoDriver: TextView, total_Pagar: TextView,
    ) {
        val dbTrabajadores =
            FirebaseFirestore.getInstance().collection("Trabajadores_Usuarios_Drivers")
                .document("trabajadores").collection("trabajadores").document(idUSer)
                .collection("ubicacion")

        val dbUsuarios = FirebaseFirestore.getInstance().collection("Trabajadores_Usuarios_Drivers")
            .document("usuarios").collection("usuarios").document(idUSer)
            .collection("ubicacion")
        lista.clear()
        dbTrabajadores.get().addOnSuccessListener { res ->
            for (datos in res) {
                val data = datos.data
                val lat = data?.get("lat") as? String ?: ""
                val log = data?.get("log") as? String ?: ""
                val direccion = data?.get("direccion") as? String ?: ""
                val id = data?.get("id") as? String ?: ""
                val referencia = data?.get("referencia") as? String ?: ""
                val dataclass = dataclassradiobtn(id, lat, log, referencia, direccion)
                lista.add(dataclass)
            }
            if (lista.isEmpty()) {
                dbUsuarios.get().addOnSuccessListener { resUsuarios ->
                    for (datos in resUsuarios) {
                        val data = datos.data
                        val lat = data?.get("lat") as? String ?: ""
                        val log = data?.get("log") as? String ?: ""
                        val direccion = data?.get("direccion") as? String ?: ""
                        val id = data?.get("id") as? String ?: ""
                        val referencia = data?.get("referencia") as? String ?: ""
                        val dataclass = dataclassradiobtn(id, lat, log, referencia, direccion)
                        lista.add(dataclass)
                    }
                    if (lista.isEmpty()) {
                        RecyclerView.isVisible = false
                        btnCrearDirecion.isVisible = true
                    } else {
                        RecyclerView.isVisible = true
                        btnCrearDirecion.isVisible = false
                        inicializarRecicle(
                            RecyclerView,
                            context,
                            lista,
                            direccion,
                            refererencia,
                            latUSser,
                            logUSer, precioDElivery, pagoDriver, total_Pagar
                        )
                    }
                }.addOnFailureListener { e ->
                    Toast.makeText(
                        context,
                        "Error al buscar en usuarios: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                RecyclerView.isVisible = true
                btnCrearDirecion.isVisible = false
                inicializarRecicle(
                    RecyclerView,
                    context,
                    lista,
                    direccion,
                    refererencia,
                    latUSser,
                    logUSer, precioDElivery, pagoDriver, total_Pagar
                )
            }
        }.addOnFailureListener { e ->
            Toast.makeText(
                context,
                "Error al buscar en trabajadores: ${e.message}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun setearTotal(
        total_Pagar: TextView,
        totalDelivery: TextView,
        precioTotalProductos: TextView,
        delivery: Int,
    ) {
        val estandar_precio = (delivery.toString()).toDouble()
        val total_ART = (precioTotalProductos.text.toString()).toDouble()
        val totalPagar = estandar_precio + total_ART
        totalDelivery.text =
            constantes_cotizacion_driver.formatearNumeros(estandar_precio.toString())
        total_Pagar.text = constantes_cotizacion_driver.formatearNumeros(totalPagar.toString())
    }

    private fun inicializarRecicle(
        recycle: RecyclerView,
        context: Context,
        items: MutableList<dataclassradiobtn>,
        direccion: EditText,
        refererencia: EditText,
        latUSser: TextView,
        logUSer: TextView,
        precioDElivery: AutoCompleteTextView,
        pagoDriver: TextView,
        totalPAgar: TextView,
    ) {

        val adapter = adapter_radioButton_envios(items) { ubicacionSeleccionada ->
            direccion.setText(ubicacionSeleccionada.direccion)
            refererencia.setText(ubicacionSeleccionada.referencia)
            latUSser.text = ubicacionSeleccionada.lat
            logUSer.text = ubicacionSeleccionada.log
            precioDElivery.setText("")
            constantes_cotizacion_driver.setearDelivery(precioDElivery, context)
            pagoDriver.text = "***"
            totalPAgar.text = "***"

        }

        recycle.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recycle.adapter = adapter
    }

    fun verificarViivilidad_Pagos(
        yape: Boolean,
        efectivo: Boolean,
        plin: Boolean,
        Yape: RadioButton,
        Efectivo: RadioButton,
        Plin: RadioButton,
    ) {
        if (yape == true && efectivo == true && plin) {
            Yape.isVisible = true
            Efectivo.isVisible = true
            Yape.isVisible = true
            Plin.isVisible = true
        } else if (yape == true && efectivo == true) {
            Yape.isVisible = true
            Efectivo.isVisible = true
            Yape.isVisible = true
            Plin.isVisible = false
        } else if (yape == true && plin) {
            Yape.isVisible = true
            Efectivo.isVisible = false
            Yape.isVisible = true
            Plin.isVisible = true
        } else if (yape == true) {
            Yape.isVisible = true
            Efectivo.isVisible = false
            Yape.isVisible = true
            Plin.isVisible = false
        } else if (efectivo == true) {
            Yape.isVisible = false
            Efectivo.isVisible = true
            Yape.isVisible = false
            Plin.isVisible = false
        } else if (plin) {
            Plin.isVisible = true
            Yape.isVisible = false
            Efectivo.isVisible = false
            Yape.isVisible = false
        } else {
            Yape.isVisible = false
            Efectivo.isVisible = false
            Yape.isVisible = false
            Plin.isVisible = false
        }
    }

    private fun verificarDeliveryCmapos(
        direcion: EditText,
        refererencia: EditText,
        precio_driver: EditText,
    ): Boolean {
        var isValid = true

        if (direcion.text.isEmpty()) {
            direcion.error = "Seleccione una de sus direcciones de entrega"
            isValid = false
        }

        if (refererencia.text.isEmpty()) {
            refererencia.error = "Seleccione una de sus direcciones de entrega"
            isValid = false
        }

        if (precio_driver.text.isEmpty()) {
            precio_driver.error = "Seleccione su precio de driver"

            isValid = false
        }

        return isValid
    }

    private fun verificarCamposReservaCompra(
        context: Context,
        bindingBottomShjet: BottomSheetReservaProductosBinding,
        verificarHora: Boolean,
    ): Boolean {
        var todosLosCamposValidos = true

        if (bindingBottomShjet.camposPrincipales.nombreUser.text.isEmpty()) {
            bindingBottomShjet.camposPrincipales.nombreUser.error = "El campo de nombre está vacío"
            Toast.makeText(context,"el campo de nombre esta vacio",Toast.LENGTH_SHORT).show()
            todosLosCamposValidos = false
        }
        if (bindingBottomShjet.camposPrincipales.apellidouser.text.isEmpty()) {
            bindingBottomShjet.camposPrincipales.apellidouser.error = "El campo de apellido está vacío"
            Toast.makeText(context,"el campo de apellido esta vacio",Toast.LENGTH_SHORT).show()
            todosLosCamposValidos = false
        }
        if (bindingBottomShjet.camposPrincipales.dniUser.text.isEmpty()) {
            bindingBottomShjet.camposPrincipales.dniUser.error = "El campo de DNI está vacío"
            Toast.makeText(context,"el campo de DNI esta vacio",Toast.LENGTH_SHORT).show()
            todosLosCamposValidos = false
        }
        if (bindingBottomShjet.camposPrincipales.numeroContacto.text.isEmpty()) {
            bindingBottomShjet.camposPrincipales.numeroContacto.error = "El campo de número está vacío"
            Toast.makeText(context,"el campo de número esta vacio",Toast.LENGTH_SHORT).show()
            todosLosCamposValidos = false
        }
        if (bindingBottomShjet.camposPrincipales.localidadUser.text.isEmpty()) {
            bindingBottomShjet.camposPrincipales.localidadUser.error = "El campo de localidad está vacío"
            Toast.makeText(context,"el campo de localidad esta vacio",Toast.LENGTH_SHORT).show()
            todosLosCamposValidos = false
        }

        if (verificarHora && bindingBottomShjet.camposPrincipales.horareserva.text.isEmpty()) {
            bindingBottomShjet.camposPrincipales.horareserva.error = "El campo de hora está vacío"
            Toast.makeText(context,"el campo de hora esta vacio",Toast.LENGTH_SHORT).show()
            todosLosCamposValidos = false
        }

        return todosLosCamposValidos
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun compararHoraEntregaLLegada(
        horaSeleccionada: String,
        editextHora: EditText,
        idTienda: String,
        callback: (Boolean) -> Unit,
    ) {
        val formatoHora = SimpleDateFormat("HH:mm", Locale.getDefault())

        if (editextHora.text.isEmpty()) {
            editextHora.error = "Ingrese una hora"
            callback(false)
            return
        }
        obtenerHorarioDeHoy(idTienda) { abierto, cerrado, boolean ->
            Log.d(
                "hora_comparada",
                "Las horas a comparar son $abierto AM tienda, $cerrado PM tienda, $horaSeleccionada hora seleccionada por el usuario"
            )
            val horaSeleccionadaDate: Date? = formatoHora.parse(horaSeleccionada)
            val aperturaDate: Date? = formatoHora.parse(abierto.toString())
            val cierreDate: Date? = formatoHora.parse(cerrado.toString())
            if (horaSeleccionadaDate == null || aperturaDate == null || cierreDate == null) {
                Log.e("hora_comparada", "Error al analizar las horas.")
                callback(false)
                return@obtenerHorarioDeHoy
            }
            val isWithinHours = if (cierreDate.before(aperturaDate)) {
                !(horaSeleccionadaDate.before(aperturaDate) && horaSeleccionadaDate.after(cierreDate))
            } else {
                !(horaSeleccionadaDate.before(aperturaDate) || horaSeleccionadaDate.after(cierreDate))
            }

            callback(isWithinHours) // Llamar al callback con el resultado de la comparación
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun obtenerHorarioDeHoy(
        storeId: String,
        callback: (LocalTime, LocalTime, cerrado: Boolean) -> Unit,
    ) {
        val db = FirebaseFirestore.getInstance()
        val hoy = DayOfWeek.from(
            Calendar.getInstance().time.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        ).name.toLowerCase(
            Locale.ROOT
        )

        val diasEnInglesAEs = when (hoy) {
            "monday" -> "lunes"
            "tuesday" -> "martes"
            "wednesday" -> "miercoles"
            "thursday" -> "jueves"
            "friday" -> "viernes"
            "saturday" -> "sabado"
            "sunday" -> "domingo"
            else -> {
                "lunes"
            }
        }
        Log.d("hoy", "el dia de hoy es $diasEnInglesAEs")


        val horarioRef =
            db.collection("Tiendas").document(storeId).collection("horario")
                .document(diasEnInglesAEs.toString())

        horarioRef.get().addOnSuccessListener { document ->
            if (document != null && document.exists()) {
                val aperturaStr = document.getString("h_apertura") ?: "00:00"
                val cierreStr = document.getString("h_cierre") ?: "00:00"
                val cerrado = document.getBoolean("cerrado") ?: false
                val formatter = DateTimeFormatter.ofPattern("HH:mm")
                val apertura = LocalTime.parse(aperturaStr, formatter)
                val cierre = LocalTime.parse(cierreStr, formatter)

                callback(apertura, cierre, cerrado)
                Log.d("hoy", "la apertura es $apertura y el cierre es $cierre")
            } else {
                println("No se encontró el documento para hoy")
            }
        }.addOnFailureListener { exception ->
            exception.printStackTrace()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun manejarClick(
        tipo: String,
        bindingBottomShjet: BottomSheetReservaProductosBinding,
        context: Context,
        metodoEntrega: String,
        idTienda: String,
        localidaTienda: TextView,
        localidadUser: EditText,
        metodoDelivery: TextView,
        METODPAGO: String,
        funcionEspecifica: () -> Unit,
    ) {
        val localidadUserTxt = localidadUser.text.toString()
        val deliveryText = metodoDelivery.text.toString()

        when (tipo) {
            "compra_promo" -> {
                if (!validacionCamposUsuario(bindingBottomShjet, context, METODPAGO)) {
                    return
                }

                if (metodoEntrega.isEmpty()) {
                    Toast.makeText(context, "Seleccione su método de entrega", Toast.LENGTH_SHORT).show()
                    return
                }

                if (metodoEntrega.equals("Recojo en tienda")) {
                    funcionEspecifica()
                    return
                }

                if (metodoEntrega == "Delivery" || deliveryText == "delivery") {
                    val verificacionCampos = verificarDeliveryCmapos(
                        bindingBottomShjet.direccionEnvios.direccionED,
                        bindingBottomShjet.direccionEnvios.referenciaED,
                        bindingBottomShjet.direccionEnvios.precioDelivery
                    )
                    if (!verificacionCampos) {
                        return
                    }

                    if (localidadUserTxt != localidaTienda.text.toString()) {
                        dialogo_solo_envios_localidadTienda(context)
                        return
                    }
                }

                funcionEspecifica()
            }


            "reserva_promo" -> {
                validarCamposYHora(
                    idTienda,
                    metodoEntrega,
                    bindingBottomShjet,
                    context,
                ) { isValid ->
                    if (isValid) {
                        if (!validacionCamposUsuario(bindingBottomShjet, context, METODPAGO)) {
                            return@validarCamposYHora
                        } else {
                            if ((metodoEntrega == "Delivery" || deliveryText == "delivery") && localidadUserTxt != localidaTienda.text.toString()) {
                                dialogo_solo_envios_localidadTienda(context)
                            } else {
                                funcionEspecifica()
                            }
                        }
                    } else {
                        Toast.makeText(
                            context,
                            "error al realizar el envio",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

            "reserva_articulo" -> {}
        }

    }

    private fun notificarCompraOReserva(
        tipoProdutoOreser:String,
        child:String,
        idTienda: String,
        context: Context,
        idART: String,
        dataclasscompraReservaPromociones: dataclasscompra_reserva_promociones,
        tipoChil1:String,
        tipoOperacion: String,
        enviado: (Boolean) -> Unit,

    ) {
        firebaseAuth = FirebaseAuth.getInstance()
        val realtimeInstance = FirebaseDatabase.getInstance()
        val CompraTienda = realtimeInstance.getReference("CompraTienda").child(idTienda)
            .child(firebaseAuth.uid.toString()).child(tipoChil1).child(idART)
        val PedidosUsuario =
            realtimeInstance.getReference("PedidosUsuario").child(firebaseAuth.uid.toString())
                .child("tiendas").child(idTienda).child(tipoChil1).child(idART)

        val hashMap = hashMapOf<String, Any>(
            "idDriver" to "",
            "idPedido" to idART,
            "estado" to "pendiente",
            "estadoPedido" to "pendiente",
            "metodoPago" to dataclasscompraReservaPromociones.metodoPAgo.toString(),
            tipoProdutoOreser to dataclasscompraReservaPromociones.idproducto!!,
            "metodoEntrega" to (dataclasscompraReservaPromociones.metodoEntrega.takeIf { it?.isNotBlank() ?: false } ?: "Delivery"),
            "tipoRealizado" to dataclasscompraReservaPromociones.tipoRealizado!!,

            "fecha" to dataclasscompraReservaPromociones.fechaActual!!,
            "hora" to dataclasscompraReservaPromociones.horaActual!!,
            "hora_llegada" to dataclasscompraReservaPromociones.horaReserva!!,

            "idTienda" to idTienda,
            "nombreTienda" to dataclasscompraReservaPromociones.nombreTienda!!,
            "localidadTienda" to dataclasscompraReservaPromociones.localidadTienda!!,
            "tipoTienda" to dataclasscompraReservaPromociones.tipoTienda!!,

            "idUSer" to firebaseAuth.uid.toString(),
            "nombre" to dataclasscompraReservaPromociones.nombre!!,
            "apellido" to dataclasscompraReservaPromociones.apellido!!,
            "numero" to dataclasscompraReservaPromociones.numero!!,
            "localidad" to dataclasscompraReservaPromociones.localidadus!!,
            "referencia" to (dataclasscompraReservaPromociones.referenciaEntrega.takeIf { it?.isNotBlank() ?: false } ?: ""),
            "direccion" to (dataclasscompraReservaPromociones.direcionEntrega.takeIf { it?.isNotBlank() ?: false } ?: ""),
            "dni" to dataclasscompraReservaPromociones.dni!!,

            "totalDriver" to dataclasscompraReservaPromociones.Total_driver!!,
            "tituloProducto" to dataclasscompraReservaPromociones.tituloProducto!!,
            "totalProductos" to dataclasscompraReservaPromociones.Precio_producto!!,
            "Total_item_selecionado" to dataclasscompraReservaPromociones.Total_item_selecionado!!,
            "tipoReserva" to dataclasscompraReservaPromociones.tipoReserva!!,
            "precioDelivery" to dataclasscompraReservaPromociones.Total_driver!!,
            "totalCancelar" to dataclasscompraReservaPromociones.totalApagar!!,



        )

        PedidosUsuario.setValue(hashMap)
            .addOnSuccessListener {
                Toast.makeText(context, "Operación realizada correctamente", Toast.LENGTH_SHORT)
                    .show()
                constantes.obtnerTokenTienda(idTienda) { token ->
                    GlobalScope.launch {
                        val enviar_notificaciones = NotificacionRS()
                        enviar_notificaciones.sendNotification_con_parametros(
                            "IDTienda",
                            idTienda,
                            "INICIO",
                            context,
                            token,
                            "Operación de $tipoOperacion: ${dataclasscompraReservaPromociones.tituloProducto}",
                            "Tienes una nueva operación de $tipoOperacion. Haz clic para aceptar o rechazar la operación"
                        )
                    }
                    enviado(true)
                }
            }.addOnFailureListener {
                enviado(false)
                Toast.makeText(context, "Error al realizar la operación", Toast.LENGTH_SHORT).show()
            }

        CompraTienda.setValue(hashMap)
            .addOnSuccessListener {
                enviado(true)
                Log.d("operacion_$tipoOperacion", "Operación realizada correctamente")
            }
            .addOnFailureListener {
                enviado(false)
                Log.d("operacion_$tipoOperacion", "Error al realizar la operación")
            }
    }


}