// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityVistaMostrarTodosTiendasBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageButton Todos;

  @NonNull
  public final ImageButton filtrado;

  @NonNull
  public final LinearLayout filtradoslineal;

  @NonNull
  public final RelativeLayout main;

  @NonNull
  public final RecyclerView reciclTiendas;

  private ActivityVistaMostrarTodosTiendasBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageButton Todos, @NonNull ImageButton filtrado,
      @NonNull LinearLayout filtradoslineal, @NonNull RelativeLayout main,
      @NonNull RecyclerView reciclTiendas) {
    this.rootView = rootView;
    this.Todos = Todos;
    this.filtrado = filtrado;
    this.filtradoslineal = filtradoslineal;
    this.main = main;
    this.reciclTiendas = reciclTiendas;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityVistaMostrarTodosTiendasBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityVistaMostrarTodosTiendasBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_vista_mostrar_todos_tiendas, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityVistaMostrarTodosTiendasBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Todos;
      ImageButton Todos = ViewBindings.findChildViewById(rootView, id);
      if (Todos == null) {
        break missingId;
      }

      id = R.id.filtrado;
      ImageButton filtrado = ViewBindings.findChildViewById(rootView, id);
      if (filtrado == null) {
        break missingId;
      }

      id = R.id.filtradoslineal;
      LinearLayout filtradoslineal = ViewBindings.findChildViewById(rootView, id);
      if (filtradoslineal == null) {
        break missingId;
      }

      RelativeLayout main = (RelativeLayout) rootView;

      id = R.id.reciclTiendas;
      RecyclerView reciclTiendas = ViewBindings.findChildViewById(rootView, id);
      if (reciclTiendas == null) {
        break missingId;
      }

      return new ActivityVistaMostrarTodosTiendasBinding((RelativeLayout) rootView, Todos, filtrado,
          filtradoslineal, main, reciclTiendas);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
