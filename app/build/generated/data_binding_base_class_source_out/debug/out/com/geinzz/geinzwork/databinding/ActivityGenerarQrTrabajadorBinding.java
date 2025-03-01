// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityGenerarQrTrabajadorBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton compartir;

  @NonNull
  public final RelativeLayout contenedorSinQr;

  @NonNull
  public final ImageButton descargarQR;

  @NonNull
  public final MaterialButton generarQR;

  @NonNull
  public final ImageView imageQr;

  @NonNull
  public final ShapeableImageView imageView;

  @NonNull
  public final RelativeLayout linealCompartirDescargar;

  @NonNull
  public final RelativeLayout linealImgQr;

  @NonNull
  public final LinearLayoutCompat loading;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView nombreTrabajador;

  @NonNull
  public final LinearLayout textoGeinz;

  @NonNull
  public final LinearLayout textoOculto;

  private ActivityGenerarQrTrabajadorBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageButton compartir, @NonNull RelativeLayout contenedorSinQr,
      @NonNull ImageButton descargarQR, @NonNull MaterialButton generarQR,
      @NonNull ImageView imageQr, @NonNull ShapeableImageView imageView,
      @NonNull RelativeLayout linealCompartirDescargar, @NonNull RelativeLayout linealImgQr,
      @NonNull LinearLayoutCompat loading, @NonNull ConstraintLayout main,
      @NonNull TextView nombreTrabajador, @NonNull LinearLayout textoGeinz,
      @NonNull LinearLayout textoOculto) {
    this.rootView = rootView;
    this.compartir = compartir;
    this.contenedorSinQr = contenedorSinQr;
    this.descargarQR = descargarQR;
    this.generarQR = generarQR;
    this.imageQr = imageQr;
    this.imageView = imageView;
    this.linealCompartirDescargar = linealCompartirDescargar;
    this.linealImgQr = linealImgQr;
    this.loading = loading;
    this.main = main;
    this.nombreTrabajador = nombreTrabajador;
    this.textoGeinz = textoGeinz;
    this.textoOculto = textoOculto;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGenerarQrTrabajadorBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGenerarQrTrabajadorBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_generar_qr_trabajador, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGenerarQrTrabajadorBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.compartir;
      ImageButton compartir = ViewBindings.findChildViewById(rootView, id);
      if (compartir == null) {
        break missingId;
      }

      id = R.id.contenedor_sin_qr;
      RelativeLayout contenedorSinQr = ViewBindings.findChildViewById(rootView, id);
      if (contenedorSinQr == null) {
        break missingId;
      }

      id = R.id.descargarQR;
      ImageButton descargarQR = ViewBindings.findChildViewById(rootView, id);
      if (descargarQR == null) {
        break missingId;
      }

      id = R.id.generarQR;
      MaterialButton generarQR = ViewBindings.findChildViewById(rootView, id);
      if (generarQR == null) {
        break missingId;
      }

      id = R.id.image_qr;
      ImageView imageQr = ViewBindings.findChildViewById(rootView, id);
      if (imageQr == null) {
        break missingId;
      }

      id = R.id.imageView;
      ShapeableImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.linealCompartir_descargar;
      RelativeLayout linealCompartirDescargar = ViewBindings.findChildViewById(rootView, id);
      if (linealCompartirDescargar == null) {
        break missingId;
      }

      id = R.id.lineal_img_qr;
      RelativeLayout linealImgQr = ViewBindings.findChildViewById(rootView, id);
      if (linealImgQr == null) {
        break missingId;
      }

      id = R.id.loading;
      LinearLayoutCompat loading = ViewBindings.findChildViewById(rootView, id);
      if (loading == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.nombreTrabajador;
      TextView nombreTrabajador = ViewBindings.findChildViewById(rootView, id);
      if (nombreTrabajador == null) {
        break missingId;
      }

      id = R.id.textoGeinz;
      LinearLayout textoGeinz = ViewBindings.findChildViewById(rootView, id);
      if (textoGeinz == null) {
        break missingId;
      }

      id = R.id.textoOculto;
      LinearLayout textoOculto = ViewBindings.findChildViewById(rootView, id);
      if (textoOculto == null) {
        break missingId;
      }

      return new ActivityGenerarQrTrabajadorBinding((ConstraintLayout) rootView, compartir,
          contenedorSinQr, descargarQR, generarQR, imageQr, imageView, linealCompartirDescargar,
          linealImgQr, loading, main, nombreTrabajador, textoGeinz, textoOculto);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
