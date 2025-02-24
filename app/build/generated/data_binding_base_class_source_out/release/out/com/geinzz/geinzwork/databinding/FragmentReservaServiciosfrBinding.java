// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentReservaServiciosfrBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final RecyclerView recicleReservaServicios;

  @NonNull
  public final MaterialButton reservaArticulo;

  @NonNull
  public final MaterialButton reservaPromo;

  @NonNull
  public final MaterialButton reservaServicios;

  @NonNull
  public final MaterialButton todos;

  private FragmentReservaServiciosfrBinding(@NonNull FrameLayout rootView,
      @NonNull RecyclerView recicleReservaServicios, @NonNull MaterialButton reservaArticulo,
      @NonNull MaterialButton reservaPromo, @NonNull MaterialButton reservaServicios,
      @NonNull MaterialButton todos) {
    this.rootView = rootView;
    this.recicleReservaServicios = recicleReservaServicios;
    this.reservaArticulo = reservaArticulo;
    this.reservaPromo = reservaPromo;
    this.reservaServicios = reservaServicios;
    this.todos = todos;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentReservaServiciosfrBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentReservaServiciosfrBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_reserva_serviciosfr, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentReservaServiciosfrBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.recicleReservaServicios;
      RecyclerView recicleReservaServicios = ViewBindings.findChildViewById(rootView, id);
      if (recicleReservaServicios == null) {
        break missingId;
      }

      id = R.id.reservaArticulo;
      MaterialButton reservaArticulo = ViewBindings.findChildViewById(rootView, id);
      if (reservaArticulo == null) {
        break missingId;
      }

      id = R.id.reservaPromo;
      MaterialButton reservaPromo = ViewBindings.findChildViewById(rootView, id);
      if (reservaPromo == null) {
        break missingId;
      }

      id = R.id.reservaServicios;
      MaterialButton reservaServicios = ViewBindings.findChildViewById(rootView, id);
      if (reservaServicios == null) {
        break missingId;
      }

      id = R.id.todos;
      MaterialButton todos = ViewBindings.findChildViewById(rootView, id);
      if (todos == null) {
        break missingId;
      }

      return new FragmentReservaServiciosfrBinding((FrameLayout) rootView, recicleReservaServicios,
          reservaArticulo, reservaPromo, reservaServicios, todos);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
