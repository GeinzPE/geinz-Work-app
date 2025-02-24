// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BottomSheetInformacionPublicidadNoticiasServiciosGeinzBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final BottomSheetDragHandleView cerrar;

  @NonNull
  public final TextView fechaPublicada;

  @NonNull
  public final TextView finaliza;

  @NonNull
  public final TextView idServicio;

  @NonNull
  public final LinearLayout linealId;

  @NonNull
  public final TextView plan;

  @NonNull
  public final TextView tipoServicio;

  @NonNull
  public final TextView tvTitle;

  private BottomSheetInformacionPublicidadNoticiasServiciosGeinzBinding(
      @NonNull LinearLayout rootView, @NonNull BottomSheetDragHandleView cerrar,
      @NonNull TextView fechaPublicada, @NonNull TextView finaliza, @NonNull TextView idServicio,
      @NonNull LinearLayout linealId, @NonNull TextView plan, @NonNull TextView tipoServicio,
      @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.cerrar = cerrar;
    this.fechaPublicada = fechaPublicada;
    this.finaliza = finaliza;
    this.idServicio = idServicio;
    this.linealId = linealId;
    this.plan = plan;
    this.tipoServicio = tipoServicio;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static BottomSheetInformacionPublicidadNoticiasServiciosGeinzBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BottomSheetInformacionPublicidadNoticiasServiciosGeinzBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.bottom_sheet_informacion_publicidad_noticias_servicios_geinz, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BottomSheetInformacionPublicidadNoticiasServiciosGeinzBinding bind(
      @NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cerrar;
      BottomSheetDragHandleView cerrar = ViewBindings.findChildViewById(rootView, id);
      if (cerrar == null) {
        break missingId;
      }

      id = R.id.fechaPublicada;
      TextView fechaPublicada = ViewBindings.findChildViewById(rootView, id);
      if (fechaPublicada == null) {
        break missingId;
      }

      id = R.id.finaliza;
      TextView finaliza = ViewBindings.findChildViewById(rootView, id);
      if (finaliza == null) {
        break missingId;
      }

      id = R.id.id_servicio;
      TextView idServicio = ViewBindings.findChildViewById(rootView, id);
      if (idServicio == null) {
        break missingId;
      }

      id = R.id.lineal_id;
      LinearLayout linealId = ViewBindings.findChildViewById(rootView, id);
      if (linealId == null) {
        break missingId;
      }

      id = R.id.plan;
      TextView plan = ViewBindings.findChildViewById(rootView, id);
      if (plan == null) {
        break missingId;
      }

      id = R.id.tipo_servicio;
      TextView tipoServicio = ViewBindings.findChildViewById(rootView, id);
      if (tipoServicio == null) {
        break missingId;
      }

      id = R.id.tvTitle;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new BottomSheetInformacionPublicidadNoticiasServiciosGeinzBinding((LinearLayout) rootView,
          cerrar, fechaPublicada, finaliza, idServicio, linealId, plan, tipoServicio, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
