// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCarritoComprasBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button cancelar;

  @NonNull
  public final RelativeLayout main;

  @NonNull
  public final ImageButton opciones;

  @NonNull
  public final RecyclerView recicleProductosItem;

  @NonNull
  public final ScrollView scrollview;

  @NonNull
  public final TextView texto;

  @NonNull
  public final TextView titulo;

  private ActivityCarritoComprasBinding(@NonNull RelativeLayout rootView, @NonNull Button cancelar,
      @NonNull RelativeLayout main, @NonNull ImageButton opciones,
      @NonNull RecyclerView recicleProductosItem, @NonNull ScrollView scrollview,
      @NonNull TextView texto, @NonNull TextView titulo) {
    this.rootView = rootView;
    this.cancelar = cancelar;
    this.main = main;
    this.opciones = opciones;
    this.recicleProductosItem = recicleProductosItem;
    this.scrollview = scrollview;
    this.texto = texto;
    this.titulo = titulo;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCarritoComprasBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCarritoComprasBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_carrito_compras, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCarritoComprasBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cancelar;
      Button cancelar = ViewBindings.findChildViewById(rootView, id);
      if (cancelar == null) {
        break missingId;
      }

      RelativeLayout main = (RelativeLayout) rootView;

      id = R.id.opciones;
      ImageButton opciones = ViewBindings.findChildViewById(rootView, id);
      if (opciones == null) {
        break missingId;
      }

      id = R.id.recicleProductosItem;
      RecyclerView recicleProductosItem = ViewBindings.findChildViewById(rootView, id);
      if (recicleProductosItem == null) {
        break missingId;
      }

      id = R.id.scrollview;
      ScrollView scrollview = ViewBindings.findChildViewById(rootView, id);
      if (scrollview == null) {
        break missingId;
      }

      id = R.id.texto;
      TextView texto = ViewBindings.findChildViewById(rootView, id);
      if (texto == null) {
        break missingId;
      }

      id = R.id.titulo;
      TextView titulo = ViewBindings.findChildViewById(rootView, id);
      if (titulo == null) {
        break missingId;
      }

      return new ActivityCarritoComprasBinding((RelativeLayout) rootView, cancelar, main, opciones,
          recicleProductosItem, scrollview, texto, titulo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
