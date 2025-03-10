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
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemPlanesGeinzNoticiasPublicidadBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout linealCaracteristica;

  @NonNull
  public final LinearLayout linealCaracteristicasLayout;

  @NonNull
  public final LinearLayout linealPrecio;

  @NonNull
  public final TextView planNombre;

  @NonNull
  public final TextView precio;

  @NonNull
  public final TextView textoCaracteristica;

  @NonNull
  public final LinearLayout tituloLineal;

  @NonNull
  public final MaterialButton verMas;

  private ItemPlanesGeinzNoticiasPublicidadBinding(@NonNull RelativeLayout rootView,
      @NonNull LinearLayout linealCaracteristica, @NonNull LinearLayout linealCaracteristicasLayout,
      @NonNull LinearLayout linealPrecio, @NonNull TextView planNombre, @NonNull TextView precio,
      @NonNull TextView textoCaracteristica, @NonNull LinearLayout tituloLineal,
      @NonNull MaterialButton verMas) {
    this.rootView = rootView;
    this.linealCaracteristica = linealCaracteristica;
    this.linealCaracteristicasLayout = linealCaracteristicasLayout;
    this.linealPrecio = linealPrecio;
    this.planNombre = planNombre;
    this.precio = precio;
    this.textoCaracteristica = textoCaracteristica;
    this.tituloLineal = tituloLineal;
    this.verMas = verMas;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemPlanesGeinzNoticiasPublicidadBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemPlanesGeinzNoticiasPublicidadBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_planes_geinz_noticias_publicidad, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemPlanesGeinzNoticiasPublicidadBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.linealCaracteristica;
      LinearLayout linealCaracteristica = ViewBindings.findChildViewById(rootView, id);
      if (linealCaracteristica == null) {
        break missingId;
      }

      id = R.id.linealCaracteristicasLayout;
      LinearLayout linealCaracteristicasLayout = ViewBindings.findChildViewById(rootView, id);
      if (linealCaracteristicasLayout == null) {
        break missingId;
      }

      id = R.id.linealPrecio;
      LinearLayout linealPrecio = ViewBindings.findChildViewById(rootView, id);
      if (linealPrecio == null) {
        break missingId;
      }

      id = R.id.planNombre;
      TextView planNombre = ViewBindings.findChildViewById(rootView, id);
      if (planNombre == null) {
        break missingId;
      }

      id = R.id.precio;
      TextView precio = ViewBindings.findChildViewById(rootView, id);
      if (precio == null) {
        break missingId;
      }

      id = R.id.textoCaracteristica;
      TextView textoCaracteristica = ViewBindings.findChildViewById(rootView, id);
      if (textoCaracteristica == null) {
        break missingId;
      }

      id = R.id.titulo_lineal;
      LinearLayout tituloLineal = ViewBindings.findChildViewById(rootView, id);
      if (tituloLineal == null) {
        break missingId;
      }

      id = R.id.ver_mas;
      MaterialButton verMas = ViewBindings.findChildViewById(rootView, id);
      if (verMas == null) {
        break missingId;
      }

      return new ItemPlanesGeinzNoticiasPublicidadBinding((RelativeLayout) rootView,
          linealCaracteristica, linealCaracteristicasLayout, linealPrecio, planNombre, precio,
          textoCaracteristica, tituloLineal, verMas);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
