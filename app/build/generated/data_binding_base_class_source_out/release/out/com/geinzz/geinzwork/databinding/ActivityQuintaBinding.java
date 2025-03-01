// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.geinzz.geinzwork.R;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityQuintaBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton SguienteCuenta;

  @NonNull
  public final TextView creaDiseA;

  @NonNull
  public final TextView generalGeinz;

  @NonNull
  public final LottieAnimationView imgnoCuenta;

  @NonNull
  public final ConstraintLayout main;

  private ActivityQuintaBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialButton SguienteCuenta, @NonNull TextView creaDiseA,
      @NonNull TextView generalGeinz, @NonNull LottieAnimationView imgnoCuenta,
      @NonNull ConstraintLayout main) {
    this.rootView = rootView;
    this.SguienteCuenta = SguienteCuenta;
    this.creaDiseA = creaDiseA;
    this.generalGeinz = generalGeinz;
    this.imgnoCuenta = imgnoCuenta;
    this.main = main;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityQuintaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityQuintaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_quinta, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityQuintaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Sguiente_cuenta;
      MaterialButton SguienteCuenta = ViewBindings.findChildViewById(rootView, id);
      if (SguienteCuenta == null) {
        break missingId;
      }

      id = R.id.crea_diseña;
      TextView creaDiseA = ViewBindings.findChildViewById(rootView, id);
      if (creaDiseA == null) {
        break missingId;
      }

      id = R.id.generalGeinz;
      TextView generalGeinz = ViewBindings.findChildViewById(rootView, id);
      if (generalGeinz == null) {
        break missingId;
      }

      id = R.id.imgnoCuenta;
      LottieAnimationView imgnoCuenta = ViewBindings.findChildViewById(rootView, id);
      if (imgnoCuenta == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      return new ActivityQuintaBinding((ConstraintLayout) rootView, SguienteCuenta, creaDiseA,
          generalGeinz, imgnoCuenta, main);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
