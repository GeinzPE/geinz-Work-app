// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemServiciosActivosGeinzBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final MaterialButton detallesBoleta;

  @NonNull
  public final TextView estado;

  @NonNull
  public final TextView fechaActivo;

  @NonNull
  public final TextView fechaActivotxt;

  @NonNull
  public final TextView fechaVencimineto;

  @NonNull
  public final TextView fechatxtVenimiento;

  @NonNull
  public final ShapeableImageView imgServicio;

  @NonNull
  public final LinearLayout listener;

  @NonNull
  public final TextView tituloServico;

  @NonNull
  public final RelativeLayout verPreview;

  private ItemServiciosActivosGeinzBinding(@NonNull LinearLayout rootView,
      @NonNull MaterialButton detallesBoleta, @NonNull TextView estado,
      @NonNull TextView fechaActivo, @NonNull TextView fechaActivotxt,
      @NonNull TextView fechaVencimineto, @NonNull TextView fechatxtVenimiento,
      @NonNull ShapeableImageView imgServicio, @NonNull LinearLayout listener,
      @NonNull TextView tituloServico, @NonNull RelativeLayout verPreview) {
    this.rootView = rootView;
    this.detallesBoleta = detallesBoleta;
    this.estado = estado;
    this.fechaActivo = fechaActivo;
    this.fechaActivotxt = fechaActivotxt;
    this.fechaVencimineto = fechaVencimineto;
    this.fechatxtVenimiento = fechatxtVenimiento;
    this.imgServicio = imgServicio;
    this.listener = listener;
    this.tituloServico = tituloServico;
    this.verPreview = verPreview;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemServiciosActivosGeinzBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemServiciosActivosGeinzBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_servicios_activos_geinz, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemServiciosActivosGeinzBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.detallesBoleta;
      MaterialButton detallesBoleta = ViewBindings.findChildViewById(rootView, id);
      if (detallesBoleta == null) {
        break missingId;
      }

      id = R.id.estado;
      TextView estado = ViewBindings.findChildViewById(rootView, id);
      if (estado == null) {
        break missingId;
      }

      id = R.id.fechaActivo;
      TextView fechaActivo = ViewBindings.findChildViewById(rootView, id);
      if (fechaActivo == null) {
        break missingId;
      }

      id = R.id.fechaActivotxt;
      TextView fechaActivotxt = ViewBindings.findChildViewById(rootView, id);
      if (fechaActivotxt == null) {
        break missingId;
      }

      id = R.id.fechaVencimineto;
      TextView fechaVencimineto = ViewBindings.findChildViewById(rootView, id);
      if (fechaVencimineto == null) {
        break missingId;
      }

      id = R.id.fechatxtVenimiento;
      TextView fechatxtVenimiento = ViewBindings.findChildViewById(rootView, id);
      if (fechatxtVenimiento == null) {
        break missingId;
      }

      id = R.id.img_servicio;
      ShapeableImageView imgServicio = ViewBindings.findChildViewById(rootView, id);
      if (imgServicio == null) {
        break missingId;
      }

      LinearLayout listener = (LinearLayout) rootView;

      id = R.id.titulo_servico;
      TextView tituloServico = ViewBindings.findChildViewById(rootView, id);
      if (tituloServico == null) {
        break missingId;
      }

      id = R.id.ver_preview;
      RelativeLayout verPreview = ViewBindings.findChildViewById(rootView, id);
      if (verPreview == null) {
        break missingId;
      }

      return new ItemServiciosActivosGeinzBinding((LinearLayout) rootView, detallesBoleta, estado,
          fechaActivo, fechaActivotxt, fechaVencimineto, fechatxtVenimiento, imgServicio, listener,
          tituloServico, verPreview);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
