// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.imageview.ShapeableImageView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemReservaServiciosBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final LinearLayout LinealCantidad;

  @NonNull
  public final TextView TipoRerserva;

  @NonNull
  public final TextView TipoTienda;

  @NonNull
  public final TextView adelanto;

  @NonNull
  public final TextView apellidos;

  @NonNull
  public final Button cancelar;

  @NonNull
  public final TextView cantidadSelecionada;

  @NonNull
  public final TextView codigoReserva;

  @NonNull
  public final LinearLayout containerListenr;

  @NonNull
  public final TextView deliveryPrecio;

  @NonNull
  public final TextView descripcionus;

  @NonNull
  public final LinearLayout direccionentregaLineal;

  @NonNull
  public final TextView direcionEntrega;

  @NonNull
  public final TextView dni;

  @NonNull
  public final TextView estadous;

  @NonNull
  public final TextView fechaLlegada;

  @NonNull
  public final TextView fechaus;

  @NonNull
  public final TextView horaLlegada;

  @NonNull
  public final TextView horaus;

  @NonNull
  public final ShapeableImageView imgRerseva;

  @NonNull
  public final CircleImageView imgTienda;

  @NonNull
  public final LinearLayout linealHoraLLegada;

  @NonNull
  public final LinearLayout linealMetodoEntrega;

  @NonNull
  public final LinearLayout linealPrecioDelivery;

  @NonNull
  public final LinearLayout linealTotalDelivery;

  @NonNull
  public final LinearLayout linealdescripcion;

  @NonNull
  public final LinearLayout linealfechaLegada;

  @NonNull
  public final LinearLayout listener;

  @NonNull
  public final TextView localidadTienda;

  @NonNull
  public final TextView metodoEntrega;

  @NonNull
  public final TextView metodopago;

  @NonNull
  public final TextView nombreTienda;

  @NonNull
  public final TextView nombreuser;

  @NonNull
  public final TextView numerous;

  @NonNull
  public final TextView precioItem;

  @NonNull
  public final TextView tituloItem;

  @NonNull
  public final TextView total;

  @NonNull
  public final TextView totalDelivery;

  private ItemReservaServiciosBinding(@NonNull ConstraintLayout rootView,
      @NonNull LinearLayout LinealCantidad, @NonNull TextView TipoRerserva,
      @NonNull TextView TipoTienda, @NonNull TextView adelanto, @NonNull TextView apellidos,
      @NonNull Button cancelar, @NonNull TextView cantidadSelecionada,
      @NonNull TextView codigoReserva, @NonNull LinearLayout containerListenr,
      @NonNull TextView deliveryPrecio, @NonNull TextView descripcionus,
      @NonNull LinearLayout direccionentregaLineal, @NonNull TextView direcionEntrega,
      @NonNull TextView dni, @NonNull TextView estadous, @NonNull TextView fechaLlegada,
      @NonNull TextView fechaus, @NonNull TextView horaLlegada, @NonNull TextView horaus,
      @NonNull ShapeableImageView imgRerseva, @NonNull CircleImageView imgTienda,
      @NonNull LinearLayout linealHoraLLegada, @NonNull LinearLayout linealMetodoEntrega,
      @NonNull LinearLayout linealPrecioDelivery, @NonNull LinearLayout linealTotalDelivery,
      @NonNull LinearLayout linealdescripcion, @NonNull LinearLayout linealfechaLegada,
      @NonNull LinearLayout listener, @NonNull TextView localidadTienda,
      @NonNull TextView metodoEntrega, @NonNull TextView metodopago, @NonNull TextView nombreTienda,
      @NonNull TextView nombreuser, @NonNull TextView numerous, @NonNull TextView precioItem,
      @NonNull TextView tituloItem, @NonNull TextView total, @NonNull TextView totalDelivery) {
    this.rootView = rootView;
    this.LinealCantidad = LinealCantidad;
    this.TipoRerserva = TipoRerserva;
    this.TipoTienda = TipoTienda;
    this.adelanto = adelanto;
    this.apellidos = apellidos;
    this.cancelar = cancelar;
    this.cantidadSelecionada = cantidadSelecionada;
    this.codigoReserva = codigoReserva;
    this.containerListenr = containerListenr;
    this.deliveryPrecio = deliveryPrecio;
    this.descripcionus = descripcionus;
    this.direccionentregaLineal = direccionentregaLineal;
    this.direcionEntrega = direcionEntrega;
    this.dni = dni;
    this.estadous = estadous;
    this.fechaLlegada = fechaLlegada;
    this.fechaus = fechaus;
    this.horaLlegada = horaLlegada;
    this.horaus = horaus;
    this.imgRerseva = imgRerseva;
    this.imgTienda = imgTienda;
    this.linealHoraLLegada = linealHoraLLegada;
    this.linealMetodoEntrega = linealMetodoEntrega;
    this.linealPrecioDelivery = linealPrecioDelivery;
    this.linealTotalDelivery = linealTotalDelivery;
    this.linealdescripcion = linealdescripcion;
    this.linealfechaLegada = linealfechaLegada;
    this.listener = listener;
    this.localidadTienda = localidadTienda;
    this.metodoEntrega = metodoEntrega;
    this.metodopago = metodopago;
    this.nombreTienda = nombreTienda;
    this.nombreuser = nombreuser;
    this.numerous = numerous;
    this.precioItem = precioItem;
    this.tituloItem = tituloItem;
    this.total = total;
    this.totalDelivery = totalDelivery;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemReservaServiciosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemReservaServiciosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_reserva_servicios, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemReservaServiciosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.LinealCantidad;
      LinearLayout LinealCantidad = ViewBindings.findChildViewById(rootView, id);
      if (LinealCantidad == null) {
        break missingId;
      }

      id = R.id.TipoRerserva;
      TextView TipoRerserva = ViewBindings.findChildViewById(rootView, id);
      if (TipoRerserva == null) {
        break missingId;
      }

      id = R.id.TipoTienda;
      TextView TipoTienda = ViewBindings.findChildViewById(rootView, id);
      if (TipoTienda == null) {
        break missingId;
      }

      id = R.id.adelanto;
      TextView adelanto = ViewBindings.findChildViewById(rootView, id);
      if (adelanto == null) {
        break missingId;
      }

      id = R.id.apellidos;
      TextView apellidos = ViewBindings.findChildViewById(rootView, id);
      if (apellidos == null) {
        break missingId;
      }

      id = R.id.cancelar;
      Button cancelar = ViewBindings.findChildViewById(rootView, id);
      if (cancelar == null) {
        break missingId;
      }

      id = R.id.cantidadSelecionada;
      TextView cantidadSelecionada = ViewBindings.findChildViewById(rootView, id);
      if (cantidadSelecionada == null) {
        break missingId;
      }

      id = R.id.codigoReserva;
      TextView codigoReserva = ViewBindings.findChildViewById(rootView, id);
      if (codigoReserva == null) {
        break missingId;
      }

      id = R.id.containerListenr;
      LinearLayout containerListenr = ViewBindings.findChildViewById(rootView, id);
      if (containerListenr == null) {
        break missingId;
      }

      id = R.id.deliveryPrecio;
      TextView deliveryPrecio = ViewBindings.findChildViewById(rootView, id);
      if (deliveryPrecio == null) {
        break missingId;
      }

      id = R.id.descripcionus;
      TextView descripcionus = ViewBindings.findChildViewById(rootView, id);
      if (descripcionus == null) {
        break missingId;
      }

      id = R.id.direccionentregaLineal;
      LinearLayout direccionentregaLineal = ViewBindings.findChildViewById(rootView, id);
      if (direccionentregaLineal == null) {
        break missingId;
      }

      id = R.id.direcionEntrega;
      TextView direcionEntrega = ViewBindings.findChildViewById(rootView, id);
      if (direcionEntrega == null) {
        break missingId;
      }

      id = R.id.dni;
      TextView dni = ViewBindings.findChildViewById(rootView, id);
      if (dni == null) {
        break missingId;
      }

      id = R.id.estadous;
      TextView estadous = ViewBindings.findChildViewById(rootView, id);
      if (estadous == null) {
        break missingId;
      }

      id = R.id.fecha_llegada;
      TextView fechaLlegada = ViewBindings.findChildViewById(rootView, id);
      if (fechaLlegada == null) {
        break missingId;
      }

      id = R.id.fechaus;
      TextView fechaus = ViewBindings.findChildViewById(rootView, id);
      if (fechaus == null) {
        break missingId;
      }

      id = R.id.hora_llegada;
      TextView horaLlegada = ViewBindings.findChildViewById(rootView, id);
      if (horaLlegada == null) {
        break missingId;
      }

      id = R.id.horaus;
      TextView horaus = ViewBindings.findChildViewById(rootView, id);
      if (horaus == null) {
        break missingId;
      }

      id = R.id.imgRerseva;
      ShapeableImageView imgRerseva = ViewBindings.findChildViewById(rootView, id);
      if (imgRerseva == null) {
        break missingId;
      }

      id = R.id.imgTienda;
      CircleImageView imgTienda = ViewBindings.findChildViewById(rootView, id);
      if (imgTienda == null) {
        break missingId;
      }

      id = R.id.linealHoraLLegada;
      LinearLayout linealHoraLLegada = ViewBindings.findChildViewById(rootView, id);
      if (linealHoraLLegada == null) {
        break missingId;
      }

      id = R.id.linealMetodoEntrega;
      LinearLayout linealMetodoEntrega = ViewBindings.findChildViewById(rootView, id);
      if (linealMetodoEntrega == null) {
        break missingId;
      }

      id = R.id.linealPrecioDelivery;
      LinearLayout linealPrecioDelivery = ViewBindings.findChildViewById(rootView, id);
      if (linealPrecioDelivery == null) {
        break missingId;
      }

      id = R.id.linealTotalDelivery;
      LinearLayout linealTotalDelivery = ViewBindings.findChildViewById(rootView, id);
      if (linealTotalDelivery == null) {
        break missingId;
      }

      id = R.id.linealdescripcion;
      LinearLayout linealdescripcion = ViewBindings.findChildViewById(rootView, id);
      if (linealdescripcion == null) {
        break missingId;
      }

      id = R.id.linealfechaLegada;
      LinearLayout linealfechaLegada = ViewBindings.findChildViewById(rootView, id);
      if (linealfechaLegada == null) {
        break missingId;
      }

      id = R.id.listener;
      LinearLayout listener = ViewBindings.findChildViewById(rootView, id);
      if (listener == null) {
        break missingId;
      }

      id = R.id.localidadTienda;
      TextView localidadTienda = ViewBindings.findChildViewById(rootView, id);
      if (localidadTienda == null) {
        break missingId;
      }

      id = R.id.metodoEntrega;
      TextView metodoEntrega = ViewBindings.findChildViewById(rootView, id);
      if (metodoEntrega == null) {
        break missingId;
      }

      id = R.id.metodopago;
      TextView metodopago = ViewBindings.findChildViewById(rootView, id);
      if (metodopago == null) {
        break missingId;
      }

      id = R.id.nombreTienda;
      TextView nombreTienda = ViewBindings.findChildViewById(rootView, id);
      if (nombreTienda == null) {
        break missingId;
      }

      id = R.id.nombreuser;
      TextView nombreuser = ViewBindings.findChildViewById(rootView, id);
      if (nombreuser == null) {
        break missingId;
      }

      id = R.id.numerous;
      TextView numerous = ViewBindings.findChildViewById(rootView, id);
      if (numerous == null) {
        break missingId;
      }

      id = R.id.precioItem;
      TextView precioItem = ViewBindings.findChildViewById(rootView, id);
      if (precioItem == null) {
        break missingId;
      }

      id = R.id.tituloItem;
      TextView tituloItem = ViewBindings.findChildViewById(rootView, id);
      if (tituloItem == null) {
        break missingId;
      }

      id = R.id.total;
      TextView total = ViewBindings.findChildViewById(rootView, id);
      if (total == null) {
        break missingId;
      }

      id = R.id.totalDelivery;
      TextView totalDelivery = ViewBindings.findChildViewById(rootView, id);
      if (totalDelivery == null) {
        break missingId;
      }

      return new ItemReservaServiciosBinding((ConstraintLayout) rootView, LinealCantidad,
          TipoRerserva, TipoTienda, adelanto, apellidos, cancelar, cantidadSelecionada,
          codigoReserva, containerListenr, deliveryPrecio, descripcionus, direccionentregaLineal,
          direcionEntrega, dni, estadous, fechaLlegada, fechaus, horaLlegada, horaus, imgRerseva,
          imgTienda, linealHoraLLegada, linealMetodoEntrega, linealPrecioDelivery,
          linealTotalDelivery, linealdescripcion, linealfechaLegada, listener, localidadTienda,
          metodoEntrega, metodopago, nombreTienda, nombreuser, numerous, precioItem, tituloItem,
          total, totalDelivery);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
