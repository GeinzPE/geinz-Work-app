// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.geinzz.geinzwork.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAddReviewBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextInputLayout cantidadEstrellas;

  @NonNull
  public final EditText cantidadStarts;

  @NonNull
  public final RelativeLayout container;

  @NonNull
  public final EditText contenidoReseview;

  @NonNull
  public final TextView fecha;

  @NonNull
  public final TextView hora;

  @NonNull
  public final TextInputLayout intCorreo;

  @NonNull
  public final LottieAnimationView lottieAnimationView;

  @NonNull
  public final TextView opinion;

  @NonNull
  public final MaterialButton piblicarReview;

  @NonNull
  public final TextView reseA;

  @NonNull
  public final TextInputLayout tipoTrabajo;

  @NonNull
  public final EditText tipoTrabajoED;

  @NonNull
  public final TextView tvErrorMessage;

  private FragmentAddReviewBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextInputLayout cantidadEstrellas, @NonNull EditText cantidadStarts,
      @NonNull RelativeLayout container, @NonNull EditText contenidoReseview,
      @NonNull TextView fecha, @NonNull TextView hora, @NonNull TextInputLayout intCorreo,
      @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView opinion,
      @NonNull MaterialButton piblicarReview, @NonNull TextView reseA,
      @NonNull TextInputLayout tipoTrabajo, @NonNull EditText tipoTrabajoED,
      @NonNull TextView tvErrorMessage) {
    this.rootView = rootView;
    this.cantidadEstrellas = cantidadEstrellas;
    this.cantidadStarts = cantidadStarts;
    this.container = container;
    this.contenidoReseview = contenidoReseview;
    this.fecha = fecha;
    this.hora = hora;
    this.intCorreo = intCorreo;
    this.lottieAnimationView = lottieAnimationView;
    this.opinion = opinion;
    this.piblicarReview = piblicarReview;
    this.reseA = reseA;
    this.tipoTrabajo = tipoTrabajo;
    this.tipoTrabajoED = tipoTrabajoED;
    this.tvErrorMessage = tvErrorMessage;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAddReviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAddReviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_add_review, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAddReviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cantidadEstrellas;
      TextInputLayout cantidadEstrellas = ViewBindings.findChildViewById(rootView, id);
      if (cantidadEstrellas == null) {
        break missingId;
      }

      id = R.id.cantidadStarts;
      EditText cantidadStarts = ViewBindings.findChildViewById(rootView, id);
      if (cantidadStarts == null) {
        break missingId;
      }

      id = R.id.container;
      RelativeLayout container = ViewBindings.findChildViewById(rootView, id);
      if (container == null) {
        break missingId;
      }

      id = R.id.contenidoReseview;
      EditText contenidoReseview = ViewBindings.findChildViewById(rootView, id);
      if (contenidoReseview == null) {
        break missingId;
      }

      id = R.id.fecha;
      TextView fecha = ViewBindings.findChildViewById(rootView, id);
      if (fecha == null) {
        break missingId;
      }

      id = R.id.hora;
      TextView hora = ViewBindings.findChildViewById(rootView, id);
      if (hora == null) {
        break missingId;
      }

      id = R.id.int_correo;
      TextInputLayout intCorreo = ViewBindings.findChildViewById(rootView, id);
      if (intCorreo == null) {
        break missingId;
      }

      id = R.id.lottieAnimationView;
      LottieAnimationView lottieAnimationView = ViewBindings.findChildViewById(rootView, id);
      if (lottieAnimationView == null) {
        break missingId;
      }

      id = R.id.opinion;
      TextView opinion = ViewBindings.findChildViewById(rootView, id);
      if (opinion == null) {
        break missingId;
      }

      id = R.id.piblicarReview;
      MaterialButton piblicarReview = ViewBindings.findChildViewById(rootView, id);
      if (piblicarReview == null) {
        break missingId;
      }

      id = R.id.reseña;
      TextView reseA = ViewBindings.findChildViewById(rootView, id);
      if (reseA == null) {
        break missingId;
      }

      id = R.id.tipo_trabajo;
      TextInputLayout tipoTrabajo = ViewBindings.findChildViewById(rootView, id);
      if (tipoTrabajo == null) {
        break missingId;
      }

      id = R.id.tipo_trabajoED;
      EditText tipoTrabajoED = ViewBindings.findChildViewById(rootView, id);
      if (tipoTrabajoED == null) {
        break missingId;
      }

      id = R.id.tvErrorMessage;
      TextView tvErrorMessage = ViewBindings.findChildViewById(rootView, id);
      if (tvErrorMessage == null) {
        break missingId;
      }

      return new FragmentAddReviewBinding((ConstraintLayout) rootView, cantidadEstrellas,
          cantidadStarts, container, contenidoReseview, fecha, hora, intCorreo, lottieAnimationView,
          opinion, piblicarReview, reseA, tipoTrabajo, tipoTrabajoED, tvErrorMessage);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
