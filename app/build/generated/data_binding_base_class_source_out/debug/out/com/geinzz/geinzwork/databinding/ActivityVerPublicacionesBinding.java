// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityVerPublicacionesBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final Button CreaPublicacion;

  @NonNull
  public final LinearLayout linealNoCuenta;

  @NonNull
  public final AppBarLayout linealappLayout;

  @NonNull
  public final LinearLayoutCompat loading;

  @NonNull
  public final CoordinatorLayout main;

  @NonNull
  public final RecyclerView recicleViewTrabajos;

  private ActivityVerPublicacionesBinding(@NonNull CoordinatorLayout rootView,
      @NonNull Button CreaPublicacion, @NonNull LinearLayout linealNoCuenta,
      @NonNull AppBarLayout linealappLayout, @NonNull LinearLayoutCompat loading,
      @NonNull CoordinatorLayout main, @NonNull RecyclerView recicleViewTrabajos) {
    this.rootView = rootView;
    this.CreaPublicacion = CreaPublicacion;
    this.linealNoCuenta = linealNoCuenta;
    this.linealappLayout = linealappLayout;
    this.loading = loading;
    this.main = main;
    this.recicleViewTrabajos = recicleViewTrabajos;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityVerPublicacionesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityVerPublicacionesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_ver_publicaciones, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityVerPublicacionesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Crea_publicacion;
      Button CreaPublicacion = ViewBindings.findChildViewById(rootView, id);
      if (CreaPublicacion == null) {
        break missingId;
      }

      id = R.id.lineal_no_cuenta;
      LinearLayout linealNoCuenta = ViewBindings.findChildViewById(rootView, id);
      if (linealNoCuenta == null) {
        break missingId;
      }

      id = R.id.linealappLayout;
      AppBarLayout linealappLayout = ViewBindings.findChildViewById(rootView, id);
      if (linealappLayout == null) {
        break missingId;
      }

      id = R.id.loading;
      LinearLayoutCompat loading = ViewBindings.findChildViewById(rootView, id);
      if (loading == null) {
        break missingId;
      }

      CoordinatorLayout main = (CoordinatorLayout) rootView;

      id = R.id.recicleViewTrabajos;
      RecyclerView recicleViewTrabajos = ViewBindings.findChildViewById(rootView, id);
      if (recicleViewTrabajos == null) {
        break missingId;
      }

      return new ActivityVerPublicacionesBinding((CoordinatorLayout) rootView, CreaPublicacion,
          linealNoCuenta, linealappLayout, loading, main, recicleViewTrabajos);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
