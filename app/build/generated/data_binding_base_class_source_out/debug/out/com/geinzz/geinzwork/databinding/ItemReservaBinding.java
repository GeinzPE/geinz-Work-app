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

public final class ItemReservaBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView TipoRerserva;

  @NonNull
  public final TextView TipoTienda;

  @NonNull
  public final Button cancelar;

  @NonNull
  public final TextView cantidad;

  @NonNull
  public final TextView codigoPedido;

  @NonNull
  public final LinearLayout containerListenr;

  @NonNull
  public final TextView descripcionus;

  @NonNull
  public final LinearLayout direccionentregaLineal;

  @NonNull
  public final TextView direcionEntrega;

  @NonNull
  public final TextView entregaMetodo;

  @NonNull
  public final TextView estadous;

  @NonNull
  public final TextView fechaentrega;

  @NonNull
  public final TextView fechaus;

  @NonNull
  public final TextView horaaproximanda;

  @NonNull
  public final TextView horaus;

  @NonNull
  public final ShapeableImageView imgItem;

  @NonNull
  public final CircleImageView imgTienda;

  @NonNull
  public final LinearLayout linealdescripcion;

  @NonNull
  public final LinearLayout listener;

  @NonNull
  public final TextView localidadTienda;

  @NonNull
  public final TextView localidaduser;

  @NonNull
  public final TextView nombreTienda;

  @NonNull
  public final TextView nombreuser;

  @NonNull
  public final TextView numerous;

  @NonNull
  public final TextView precioItem;

  @NonNull
  public final TextView reserva;

  @NonNull
  public final TextView tituloItem;

  @NonNull
  public final TextView total;

  private ItemReservaBinding(@NonNull ConstraintLayout rootView, @NonNull TextView TipoRerserva,
      @NonNull TextView TipoTienda, @NonNull Button cancelar, @NonNull TextView cantidad,
      @NonNull TextView codigoPedido, @NonNull LinearLayout containerListenr,
      @NonNull TextView descripcionus, @NonNull LinearLayout direccionentregaLineal,
      @NonNull TextView direcionEntrega, @NonNull TextView entregaMetodo,
      @NonNull TextView estadous, @NonNull TextView fechaentrega, @NonNull TextView fechaus,
      @NonNull TextView horaaproximanda, @NonNull TextView horaus,
      @NonNull ShapeableImageView imgItem, @NonNull CircleImageView imgTienda,
      @NonNull LinearLayout linealdescripcion, @NonNull LinearLayout listener,
      @NonNull TextView localidadTienda, @NonNull TextView localidaduser,
      @NonNull TextView nombreTienda, @NonNull TextView nombreuser, @NonNull TextView numerous,
      @NonNull TextView precioItem, @NonNull TextView reserva, @NonNull TextView tituloItem,
      @NonNull TextView total) {
    this.rootView = rootView;
    this.TipoRerserva = TipoRerserva;
    this.TipoTienda = TipoTienda;
    this.cancelar = cancelar;
    this.cantidad = cantidad;
    this.codigoPedido = codigoPedido;
    this.containerListenr = containerListenr;
    this.descripcionus = descripcionus;
    this.direccionentregaLineal = direccionentregaLineal;
    this.direcionEntrega = direcionEntrega;
    this.entregaMetodo = entregaMetodo;
    this.estadous = estadous;
    this.fechaentrega = fechaentrega;
    this.fechaus = fechaus;
    this.horaaproximanda = horaaproximanda;
    this.horaus = horaus;
    this.imgItem = imgItem;
    this.imgTienda = imgTienda;
    this.linealdescripcion = linealdescripcion;
    this.listener = listener;
    this.localidadTienda = localidadTienda;
    this.localidaduser = localidaduser;
    this.nombreTienda = nombreTienda;
    this.nombreuser = nombreuser;
    this.numerous = numerous;
    this.precioItem = precioItem;
    this.reserva = reserva;
    this.tituloItem = tituloItem;
    this.total = total;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemReservaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemReservaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_reserva, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemReservaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
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

      id = R.id.cancelar;
      Button cancelar = ViewBindings.findChildViewById(rootView, id);
      if (cancelar == null) {
        break missingId;
      }

      id = R.id.cantidad;
      TextView cantidad = ViewBindings.findChildViewById(rootView, id);
      if (cantidad == null) {
        break missingId;
      }

      id = R.id.codigoPedido;
      TextView codigoPedido = ViewBindings.findChildViewById(rootView, id);
      if (codigoPedido == null) {
        break missingId;
      }

      id = R.id.containerListenr;
      LinearLayout containerListenr = ViewBindings.findChildViewById(rootView, id);
      if (containerListenr == null) {
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

      id = R.id.entregaMetodo;
      TextView entregaMetodo = ViewBindings.findChildViewById(rootView, id);
      if (entregaMetodo == null) {
        break missingId;
      }

      id = R.id.estadous;
      TextView estadous = ViewBindings.findChildViewById(rootView, id);
      if (estadous == null) {
        break missingId;
      }

      id = R.id.fechaentrega;
      TextView fechaentrega = ViewBindings.findChildViewById(rootView, id);
      if (fechaentrega == null) {
        break missingId;
      }

      id = R.id.fechaus;
      TextView fechaus = ViewBindings.findChildViewById(rootView, id);
      if (fechaus == null) {
        break missingId;
      }

      id = R.id.horaaproximanda;
      TextView horaaproximanda = ViewBindings.findChildViewById(rootView, id);
      if (horaaproximanda == null) {
        break missingId;
      }

      id = R.id.horaus;
      TextView horaus = ViewBindings.findChildViewById(rootView, id);
      if (horaus == null) {
        break missingId;
      }

      id = R.id.img_item;
      ShapeableImageView imgItem = ViewBindings.findChildViewById(rootView, id);
      if (imgItem == null) {
        break missingId;
      }

      id = R.id.imgTienda;
      CircleImageView imgTienda = ViewBindings.findChildViewById(rootView, id);
      if (imgTienda == null) {
        break missingId;
      }

      id = R.id.linealdescripcion;
      LinearLayout linealdescripcion = ViewBindings.findChildViewById(rootView, id);
      if (linealdescripcion == null) {
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

      id = R.id.localidaduser;
      TextView localidaduser = ViewBindings.findChildViewById(rootView, id);
      if (localidaduser == null) {
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

      id = R.id.reserva;
      TextView reserva = ViewBindings.findChildViewById(rootView, id);
      if (reserva == null) {
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

      return new ItemReservaBinding((ConstraintLayout) rootView, TipoRerserva, TipoTienda, cancelar,
          cantidad, codigoPedido, containerListenr, descripcionus, direccionentregaLineal,
          direcionEntrega, entregaMetodo, estadous, fechaentrega, fechaus, horaaproximanda, horaus,
          imgItem, imgTienda, linealdescripcion, listener, localidadTienda, localidaduser,
          nombreTienda, nombreuser, numerous, precioItem, reserva, tituloItem, total);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
