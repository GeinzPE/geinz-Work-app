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
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPasswordYuserBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final EditText ContraFree;

  @NonNull
  public final TextView CreatCuenta;

  @NonNull
  public final TextView EstasPasos;

  @NonNull
  public final AppCompatButton btnLogin;

  @NonNull
  public final EditText correoElectronicoFree;

  @NonNull
  public final TextView freelancer;

  @NonNull
  public final TextView geinz;

  @NonNull
  public final TextInputLayout intContra;

  @NonNull
  public final TextInputLayout intCorreo;

  @NonNull
  public final TextInputLayout intRepetirContrafree;

  @NonNull
  public final RelativeLayout main;

  @NonNull
  public final EditText repetircontraFree;

  private ActivityPasswordYuserBinding(@NonNull RelativeLayout rootView,
      @NonNull EditText ContraFree, @NonNull TextView CreatCuenta, @NonNull TextView EstasPasos,
      @NonNull AppCompatButton btnLogin, @NonNull EditText correoElectronicoFree,
      @NonNull TextView freelancer, @NonNull TextView geinz, @NonNull TextInputLayout intContra,
      @NonNull TextInputLayout intCorreo, @NonNull TextInputLayout intRepetirContrafree,
      @NonNull RelativeLayout main, @NonNull EditText repetircontraFree) {
    this.rootView = rootView;
    this.ContraFree = ContraFree;
    this.CreatCuenta = CreatCuenta;
    this.EstasPasos = EstasPasos;
    this.btnLogin = btnLogin;
    this.correoElectronicoFree = correoElectronicoFree;
    this.freelancer = freelancer;
    this.geinz = geinz;
    this.intContra = intContra;
    this.intCorreo = intCorreo;
    this.intRepetirContrafree = intRepetirContrafree;
    this.main = main;
    this.repetircontraFree = repetircontraFree;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPasswordYuserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPasswordYuserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_password_yuser, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPasswordYuserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ContraFree;
      EditText ContraFree = ViewBindings.findChildViewById(rootView, id);
      if (ContraFree == null) {
        break missingId;
      }

      id = R.id.CreatCuenta;
      TextView CreatCuenta = ViewBindings.findChildViewById(rootView, id);
      if (CreatCuenta == null) {
        break missingId;
      }

      id = R.id.Estas_Pasos;
      TextView EstasPasos = ViewBindings.findChildViewById(rootView, id);
      if (EstasPasos == null) {
        break missingId;
      }

      id = R.id.btn_login;
      AppCompatButton btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.correo_electronicoFree;
      EditText correoElectronicoFree = ViewBindings.findChildViewById(rootView, id);
      if (correoElectronicoFree == null) {
        break missingId;
      }

      id = R.id.freelancer;
      TextView freelancer = ViewBindings.findChildViewById(rootView, id);
      if (freelancer == null) {
        break missingId;
      }

      id = R.id.geinz;
      TextView geinz = ViewBindings.findChildViewById(rootView, id);
      if (geinz == null) {
        break missingId;
      }

      id = R.id.int_contra;
      TextInputLayout intContra = ViewBindings.findChildViewById(rootView, id);
      if (intContra == null) {
        break missingId;
      }

      id = R.id.int_correo;
      TextInputLayout intCorreo = ViewBindings.findChildViewById(rootView, id);
      if (intCorreo == null) {
        break missingId;
      }

      id = R.id.int_repetirContrafree;
      TextInputLayout intRepetirContrafree = ViewBindings.findChildViewById(rootView, id);
      if (intRepetirContrafree == null) {
        break missingId;
      }

      RelativeLayout main = (RelativeLayout) rootView;

      id = R.id.repetircontraFree;
      EditText repetircontraFree = ViewBindings.findChildViewById(rootView, id);
      if (repetircontraFree == null) {
        break missingId;
      }

      return new ActivityPasswordYuserBinding((RelativeLayout) rootView, ContraFree, CreatCuenta,
          EstasPasos, btnLogin, correoElectronicoFree, freelancer, geinz, intContra, intCorreo,
          intRepetirContrafree, main, repetircontraFree);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
