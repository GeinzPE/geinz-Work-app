// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BottomSheetEditarPublicacionBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final BottomSheetDragHandleView cerrar;

  @NonNull
  public final TextInputLayout descripcionServicios;

  @NonNull
  public final EditText descripcionServiciosED;

  @NonNull
  public final AppCompatButton editar;

  @NonNull
  public final ShapeableImageView imagenTrabajo;

  @NonNull
  public final CircularProgressIndicator progressCargaImagen;

  @NonNull
  public final EditText tituloPublicacionED;

  @NonNull
  public final TextInputLayout tituloPublicaciontext;

  private BottomSheetEditarPublicacionBinding(@NonNull LinearLayout rootView,
      @NonNull BottomSheetDragHandleView cerrar, @NonNull TextInputLayout descripcionServicios,
      @NonNull EditText descripcionServiciosED, @NonNull AppCompatButton editar,
      @NonNull ShapeableImageView imagenTrabajo,
      @NonNull CircularProgressIndicator progressCargaImagen, @NonNull EditText tituloPublicacionED,
      @NonNull TextInputLayout tituloPublicaciontext) {
    this.rootView = rootView;
    this.cerrar = cerrar;
    this.descripcionServicios = descripcionServicios;
    this.descripcionServiciosED = descripcionServiciosED;
    this.editar = editar;
    this.imagenTrabajo = imagenTrabajo;
    this.progressCargaImagen = progressCargaImagen;
    this.tituloPublicacionED = tituloPublicacionED;
    this.tituloPublicaciontext = tituloPublicaciontext;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static BottomSheetEditarPublicacionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BottomSheetEditarPublicacionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.bottom_sheet_editar_publicacion, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BottomSheetEditarPublicacionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cerrar;
      BottomSheetDragHandleView cerrar = ViewBindings.findChildViewById(rootView, id);
      if (cerrar == null) {
        break missingId;
      }

      id = R.id.descripcionServicios;
      TextInputLayout descripcionServicios = ViewBindings.findChildViewById(rootView, id);
      if (descripcionServicios == null) {
        break missingId;
      }

      id = R.id.descripcionServiciosED;
      EditText descripcionServiciosED = ViewBindings.findChildViewById(rootView, id);
      if (descripcionServiciosED == null) {
        break missingId;
      }

      id = R.id.editar;
      AppCompatButton editar = ViewBindings.findChildViewById(rootView, id);
      if (editar == null) {
        break missingId;
      }

      id = R.id.imagen_trabajo;
      ShapeableImageView imagenTrabajo = ViewBindings.findChildViewById(rootView, id);
      if (imagenTrabajo == null) {
        break missingId;
      }

      id = R.id.progress_carga_imagen;
      CircularProgressIndicator progressCargaImagen = ViewBindings.findChildViewById(rootView, id);
      if (progressCargaImagen == null) {
        break missingId;
      }

      id = R.id.titulo_publicacionED;
      EditText tituloPublicacionED = ViewBindings.findChildViewById(rootView, id);
      if (tituloPublicacionED == null) {
        break missingId;
      }

      id = R.id.titulo_publicaciontext;
      TextInputLayout tituloPublicaciontext = ViewBindings.findChildViewById(rootView, id);
      if (tituloPublicaciontext == null) {
        break missingId;
      }

      return new BottomSheetEditarPublicacionBinding((LinearLayout) rootView, cerrar,
          descripcionServicios, descripcionServiciosED, editar, imagenTrabajo, progressCargaImagen,
          tituloPublicacionED, tituloPublicaciontext);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
