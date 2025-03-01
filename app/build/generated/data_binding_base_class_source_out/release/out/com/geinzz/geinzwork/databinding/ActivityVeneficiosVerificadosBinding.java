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
import com.geinzz.geinzwork.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityVeneficiosVerificadosBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView benefit1;

  @NonNull
  public final TextView benefit2;

  @NonNull
  public final TextView benefit3;

  @NonNull
  public final TextView benefit7;

  @NonNull
  public final TextView benefit8;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView verificationTitle;

  private ActivityVeneficiosVerificadosBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView benefit1, @NonNull TextView benefit2, @NonNull TextView benefit3,
      @NonNull TextView benefit7, @NonNull TextView benefit8, @NonNull ConstraintLayout main,
      @NonNull TextView verificationTitle) {
    this.rootView = rootView;
    this.benefit1 = benefit1;
    this.benefit2 = benefit2;
    this.benefit3 = benefit3;
    this.benefit7 = benefit7;
    this.benefit8 = benefit8;
    this.main = main;
    this.verificationTitle = verificationTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityVeneficiosVerificadosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityVeneficiosVerificadosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_veneficios_verificados, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityVeneficiosVerificadosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.benefit1;
      TextView benefit1 = ViewBindings.findChildViewById(rootView, id);
      if (benefit1 == null) {
        break missingId;
      }

      id = R.id.benefit2;
      TextView benefit2 = ViewBindings.findChildViewById(rootView, id);
      if (benefit2 == null) {
        break missingId;
      }

      id = R.id.benefit3;
      TextView benefit3 = ViewBindings.findChildViewById(rootView, id);
      if (benefit3 == null) {
        break missingId;
      }

      id = R.id.benefit7;
      TextView benefit7 = ViewBindings.findChildViewById(rootView, id);
      if (benefit7 == null) {
        break missingId;
      }

      id = R.id.benefit8;
      TextView benefit8 = ViewBindings.findChildViewById(rootView, id);
      if (benefit8 == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.verificationTitle;
      TextView verificationTitle = ViewBindings.findChildViewById(rootView, id);
      if (verificationTitle == null) {
        break missingId;
      }

      return new ActivityVeneficiosVerificadosBinding((ConstraintLayout) rootView, benefit1,
          benefit2, benefit3, benefit7, benefit8, main, verificationTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
