// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class IncludeCamposPrincipalesBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextInputLayout apellidoint;

  @NonNull
  public final EditText apellidouser;

  @NonNull
  public final EditText dniUser;

  @NonNull
  public final TextInputLayout dniint;

  @NonNull
  public final TextInputLayout horaint;

  @NonNull
  public final EditText horareserva;

  @NonNull
  public final AutoCompleteTextView localidadUser;

  @NonNull
  public final EditText nombreUser;

  @NonNull
  public final TextInputLayout nombreint;

  @NonNull
  public final EditText numeroContacto;

  @NonNull
  public final TextInputLayout numeroint;

  private IncludeCamposPrincipalesBinding(@NonNull RelativeLayout rootView,
      @NonNull TextInputLayout apellidoint, @NonNull EditText apellidouser,
      @NonNull EditText dniUser, @NonNull TextInputLayout dniint, @NonNull TextInputLayout horaint,
      @NonNull EditText horareserva, @NonNull AutoCompleteTextView localidadUser,
      @NonNull EditText nombreUser, @NonNull TextInputLayout nombreint,
      @NonNull EditText numeroContacto, @NonNull TextInputLayout numeroint) {
    this.rootView = rootView;
    this.apellidoint = apellidoint;
    this.apellidouser = apellidouser;
    this.dniUser = dniUser;
    this.dniint = dniint;
    this.horaint = horaint;
    this.horareserva = horareserva;
    this.localidadUser = localidadUser;
    this.nombreUser = nombreUser;
    this.nombreint = nombreint;
    this.numeroContacto = numeroContacto;
    this.numeroint = numeroint;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static IncludeCamposPrincipalesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static IncludeCamposPrincipalesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.include_campos_principales, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static IncludeCamposPrincipalesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.apellidoint;
      TextInputLayout apellidoint = ViewBindings.findChildViewById(rootView, id);
      if (apellidoint == null) {
        break missingId;
      }

      id = R.id.apellidouser;
      EditText apellidouser = ViewBindings.findChildViewById(rootView, id);
      if (apellidouser == null) {
        break missingId;
      }

      id = R.id.dniUser;
      EditText dniUser = ViewBindings.findChildViewById(rootView, id);
      if (dniUser == null) {
        break missingId;
      }

      id = R.id.dniint;
      TextInputLayout dniint = ViewBindings.findChildViewById(rootView, id);
      if (dniint == null) {
        break missingId;
      }

      id = R.id.horaint;
      TextInputLayout horaint = ViewBindings.findChildViewById(rootView, id);
      if (horaint == null) {
        break missingId;
      }

      id = R.id.horareserva;
      EditText horareserva = ViewBindings.findChildViewById(rootView, id);
      if (horareserva == null) {
        break missingId;
      }

      id = R.id.localidadUser;
      AutoCompleteTextView localidadUser = ViewBindings.findChildViewById(rootView, id);
      if (localidadUser == null) {
        break missingId;
      }

      id = R.id.nombreUser;
      EditText nombreUser = ViewBindings.findChildViewById(rootView, id);
      if (nombreUser == null) {
        break missingId;
      }

      id = R.id.nombreint;
      TextInputLayout nombreint = ViewBindings.findChildViewById(rootView, id);
      if (nombreint == null) {
        break missingId;
      }

      id = R.id.numeroContacto;
      EditText numeroContacto = ViewBindings.findChildViewById(rootView, id);
      if (numeroContacto == null) {
        break missingId;
      }

      id = R.id.numeroint;
      TextInputLayout numeroint = ViewBindings.findChildViewById(rootView, id);
      if (numeroint == null) {
        break missingId;
      }

      return new IncludeCamposPrincipalesBinding((RelativeLayout) rootView, apellidoint,
          apellidouser, dniUser, dniint, horaint, horareserva, localidadUser, nombreUser, nombreint,
          numeroContacto, numeroint);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
