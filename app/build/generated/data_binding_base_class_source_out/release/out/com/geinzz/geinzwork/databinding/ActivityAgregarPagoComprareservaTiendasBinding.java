// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAgregarPagoComprareservaTiendasBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout LinealPagado;

  @NonNull
  public final TextInputLayout comentarioADI;

  @NonNull
  public final EditText comentarioADIED;

  @NonNull
  public final TextView comentarioAdicional;

  @NonNull
  public final ShapeableImageView comprovante;

  @NonNull
  public final ShapeableImageView imagenPlin;

  @NonNull
  public final ShapeableImageView imagenYape;

  @NonNull
  public final ShapeableImageView imgQRPago;

  @NonNull
  public final LinearLayout layoutYape;

  @NonNull
  public final LinearLayout linealSubir;

  @NonNull
  public final LinearLayout main;

  @NonNull
  public final Button notificar;

  @NonNull
  public final TextView textoAdicional;

  private ActivityAgregarPagoComprareservaTiendasBinding(@NonNull LinearLayout rootView,
      @NonNull LinearLayout LinealPagado, @NonNull TextInputLayout comentarioADI,
      @NonNull EditText comentarioADIED, @NonNull TextView comentarioAdicional,
      @NonNull ShapeableImageView comprovante, @NonNull ShapeableImageView imagenPlin,
      @NonNull ShapeableImageView imagenYape, @NonNull ShapeableImageView imgQRPago,
      @NonNull LinearLayout layoutYape, @NonNull LinearLayout linealSubir,
      @NonNull LinearLayout main, @NonNull Button notificar, @NonNull TextView textoAdicional) {
    this.rootView = rootView;
    this.LinealPagado = LinealPagado;
    this.comentarioADI = comentarioADI;
    this.comentarioADIED = comentarioADIED;
    this.comentarioAdicional = comentarioAdicional;
    this.comprovante = comprovante;
    this.imagenPlin = imagenPlin;
    this.imagenYape = imagenYape;
    this.imgQRPago = imgQRPago;
    this.layoutYape = layoutYape;
    this.linealSubir = linealSubir;
    this.main = main;
    this.notificar = notificar;
    this.textoAdicional = textoAdicional;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAgregarPagoComprareservaTiendasBinding inflate(
      @NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAgregarPagoComprareservaTiendasBinding inflate(
      @NonNull LayoutInflater inflater, @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_agregar_pago_comprareserva_tiendas, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAgregarPagoComprareservaTiendasBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.LinealPagado;
      LinearLayout LinealPagado = ViewBindings.findChildViewById(rootView, id);
      if (LinealPagado == null) {
        break missingId;
      }

      id = R.id.comentarioADI;
      TextInputLayout comentarioADI = ViewBindings.findChildViewById(rootView, id);
      if (comentarioADI == null) {
        break missingId;
      }

      id = R.id.comentarioADIED;
      EditText comentarioADIED = ViewBindings.findChildViewById(rootView, id);
      if (comentarioADIED == null) {
        break missingId;
      }

      id = R.id.comentarioAdicional;
      TextView comentarioAdicional = ViewBindings.findChildViewById(rootView, id);
      if (comentarioAdicional == null) {
        break missingId;
      }

      id = R.id.comprovante;
      ShapeableImageView comprovante = ViewBindings.findChildViewById(rootView, id);
      if (comprovante == null) {
        break missingId;
      }

      id = R.id.imagen_plin;
      ShapeableImageView imagenPlin = ViewBindings.findChildViewById(rootView, id);
      if (imagenPlin == null) {
        break missingId;
      }

      id = R.id.imagen_yape;
      ShapeableImageView imagenYape = ViewBindings.findChildViewById(rootView, id);
      if (imagenYape == null) {
        break missingId;
      }

      id = R.id.imgQR_pago;
      ShapeableImageView imgQRPago = ViewBindings.findChildViewById(rootView, id);
      if (imgQRPago == null) {
        break missingId;
      }

      id = R.id.layout_yape;
      LinearLayout layoutYape = ViewBindings.findChildViewById(rootView, id);
      if (layoutYape == null) {
        break missingId;
      }

      id = R.id.linealSubir;
      LinearLayout linealSubir = ViewBindings.findChildViewById(rootView, id);
      if (linealSubir == null) {
        break missingId;
      }

      LinearLayout main = (LinearLayout) rootView;

      id = R.id.notificar;
      Button notificar = ViewBindings.findChildViewById(rootView, id);
      if (notificar == null) {
        break missingId;
      }

      id = R.id.texto_adicional;
      TextView textoAdicional = ViewBindings.findChildViewById(rootView, id);
      if (textoAdicional == null) {
        break missingId;
      }

      return new ActivityAgregarPagoComprareservaTiendasBinding((LinearLayout) rootView,
          LinealPagado, comentarioADI, comentarioADIED, comentarioAdicional, comprovante,
          imagenPlin, imagenYape, imgQRPago, layoutYape, linealSubir, main, notificar,
          textoAdicional);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
