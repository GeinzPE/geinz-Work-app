// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.imageview.ShapeableImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemCustomPublicidadPrincipalBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView descripcion;

  @NonNull
  public final Guideline guidelineEnd;

  @NonNull
  public final ShapeableImageView imgPublicidad;

  @NonNull
  public final RelativeLayout realtiveClikc;

  @NonNull
  public final TextView titulos;

  private ItemCustomPublicidadPrincipalBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView descripcion, @NonNull Guideline guidelineEnd,
      @NonNull ShapeableImageView imgPublicidad, @NonNull RelativeLayout realtiveClikc,
      @NonNull TextView titulos) {
    this.rootView = rootView;
    this.descripcion = descripcion;
    this.guidelineEnd = guidelineEnd;
    this.imgPublicidad = imgPublicidad;
    this.realtiveClikc = realtiveClikc;
    this.titulos = titulos;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemCustomPublicidadPrincipalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemCustomPublicidadPrincipalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_custom_publicidad_principal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemCustomPublicidadPrincipalBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.descripcion;
      TextView descripcion = ViewBindings.findChildViewById(rootView, id);
      if (descripcion == null) {
        break missingId;
      }

      id = R.id.guideline_end;
      Guideline guidelineEnd = ViewBindings.findChildViewById(rootView, id);
      if (guidelineEnd == null) {
        break missingId;
      }

      id = R.id.img_publicidad;
      ShapeableImageView imgPublicidad = ViewBindings.findChildViewById(rootView, id);
      if (imgPublicidad == null) {
        break missingId;
      }

      id = R.id.realtive_clikc;
      RelativeLayout realtiveClikc = ViewBindings.findChildViewById(rootView, id);
      if (realtiveClikc == null) {
        break missingId;
      }

      id = R.id.titulos;
      TextView titulos = ViewBindings.findChildViewById(rootView, id);
      if (titulos == null) {
        break missingId;
      }

      return new ItemCustomPublicidadPrincipalBinding((ConstraintLayout) rootView, descripcion,
          guidelineEnd, imgPublicidad, realtiveClikc, titulos);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
