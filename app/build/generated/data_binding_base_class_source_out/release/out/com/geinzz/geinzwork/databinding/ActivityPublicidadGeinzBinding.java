// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPublicidadGeinzBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView encontrados;

  @NonNull
  public final ImageView filtrado;

  @NonNull
  public final TextView filtradoCateogoriaPromo;

  @NonNull
  public final TextView filtradoUsuairo;

  @NonNull
  public final TextView filtradotext;

  @NonNull
  public final NestedScrollView linealappLayout;

  @NonNull
  public final LinearLayoutCompat loading;

  @NonNull
  public final RelativeLayout main;

  @NonNull
  public final ImageView noResultados;

  @NonNull
  public final RecyclerView recielAnuncios;

  @NonNull
  public final RelativeLayout relativeNoEncontrado;

  @NonNull
  public final TextView textoPincipal;

  @NonNull
  public final TextView txtNoResultados;

  private ActivityPublicidadGeinzBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView encontrados, @NonNull ImageView filtrado,
      @NonNull TextView filtradoCateogoriaPromo, @NonNull TextView filtradoUsuairo,
      @NonNull TextView filtradotext, @NonNull NestedScrollView linealappLayout,
      @NonNull LinearLayoutCompat loading, @NonNull RelativeLayout main,
      @NonNull ImageView noResultados, @NonNull RecyclerView recielAnuncios,
      @NonNull RelativeLayout relativeNoEncontrado, @NonNull TextView textoPincipal,
      @NonNull TextView txtNoResultados) {
    this.rootView = rootView;
    this.encontrados = encontrados;
    this.filtrado = filtrado;
    this.filtradoCateogoriaPromo = filtradoCateogoriaPromo;
    this.filtradoUsuairo = filtradoUsuairo;
    this.filtradotext = filtradotext;
    this.linealappLayout = linealappLayout;
    this.loading = loading;
    this.main = main;
    this.noResultados = noResultados;
    this.recielAnuncios = recielAnuncios;
    this.relativeNoEncontrado = relativeNoEncontrado;
    this.textoPincipal = textoPincipal;
    this.txtNoResultados = txtNoResultados;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPublicidadGeinzBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPublicidadGeinzBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_publicidad_geinz, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPublicidadGeinzBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.encontrados;
      TextView encontrados = ViewBindings.findChildViewById(rootView, id);
      if (encontrados == null) {
        break missingId;
      }

      id = R.id.filtrado;
      ImageView filtrado = ViewBindings.findChildViewById(rootView, id);
      if (filtrado == null) {
        break missingId;
      }

      id = R.id.filtradoCateogoriaPromo;
      TextView filtradoCateogoriaPromo = ViewBindings.findChildViewById(rootView, id);
      if (filtradoCateogoriaPromo == null) {
        break missingId;
      }

      id = R.id.filtradoUsuairo;
      TextView filtradoUsuairo = ViewBindings.findChildViewById(rootView, id);
      if (filtradoUsuairo == null) {
        break missingId;
      }

      id = R.id.filtradotext;
      TextView filtradotext = ViewBindings.findChildViewById(rootView, id);
      if (filtradotext == null) {
        break missingId;
      }

      id = R.id.linealappLayout;
      NestedScrollView linealappLayout = ViewBindings.findChildViewById(rootView, id);
      if (linealappLayout == null) {
        break missingId;
      }

      id = R.id.loading;
      LinearLayoutCompat loading = ViewBindings.findChildViewById(rootView, id);
      if (loading == null) {
        break missingId;
      }

      RelativeLayout main = (RelativeLayout) rootView;

      id = R.id.no_resultados;
      ImageView noResultados = ViewBindings.findChildViewById(rootView, id);
      if (noResultados == null) {
        break missingId;
      }

      id = R.id.recielAnuncios;
      RecyclerView recielAnuncios = ViewBindings.findChildViewById(rootView, id);
      if (recielAnuncios == null) {
        break missingId;
      }

      id = R.id.relative_no_encontrado;
      RelativeLayout relativeNoEncontrado = ViewBindings.findChildViewById(rootView, id);
      if (relativeNoEncontrado == null) {
        break missingId;
      }

      id = R.id.texto_pincipal;
      TextView textoPincipal = ViewBindings.findChildViewById(rootView, id);
      if (textoPincipal == null) {
        break missingId;
      }

      id = R.id.txt_no_resultados;
      TextView txtNoResultados = ViewBindings.findChildViewById(rootView, id);
      if (txtNoResultados == null) {
        break missingId;
      }

      return new ActivityPublicidadGeinzBinding((RelativeLayout) rootView, encontrados, filtrado,
          filtradoCateogoriaPromo, filtradoUsuairo, filtradotext, linealappLayout, loading, main,
          noResultados, recielAnuncios, relativeNoEncontrado, textoPincipal, txtNoResultados);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
