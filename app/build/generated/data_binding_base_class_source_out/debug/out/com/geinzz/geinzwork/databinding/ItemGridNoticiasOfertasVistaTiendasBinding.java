// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.imageview.ShapeableImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemGridNoticiasOfertasVistaTiendasBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView Tipo;

  @NonNull
  public final ShapeableImageView imgTrabajo;

  private ItemGridNoticiasOfertasVistaTiendasBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView Tipo, @NonNull ShapeableImageView imgTrabajo) {
    this.rootView = rootView;
    this.Tipo = Tipo;
    this.imgTrabajo = imgTrabajo;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemGridNoticiasOfertasVistaTiendasBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemGridNoticiasOfertasVistaTiendasBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_grid_noticias_ofertas_vista_tiendas, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemGridNoticiasOfertasVistaTiendasBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Tipo;
      TextView Tipo = ViewBindings.findChildViewById(rootView, id);
      if (Tipo == null) {
        break missingId;
      }

      id = R.id.img_trabajo;
      ShapeableImageView imgTrabajo = ViewBindings.findChildViewById(rootView, id);
      if (imgTrabajo == null) {
        break missingId;
      }

      return new ItemGridNoticiasOfertasVistaTiendasBinding((RelativeLayout) rootView, Tipo,
          imgTrabajo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
