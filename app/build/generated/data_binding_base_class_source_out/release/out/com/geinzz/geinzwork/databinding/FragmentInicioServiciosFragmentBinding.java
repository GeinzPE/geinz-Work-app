// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.imaginativeworld.whynotimagecarousel.ImageCarousel;

public final class FragmentInicioServiciosFragmentBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ImageCarousel carruselPublicidadBaner;

  @NonNull
  public final MaterialButton mandarSolicitud;

  private FragmentInicioServiciosFragmentBinding(@NonNull FrameLayout rootView,
      @NonNull ImageCarousel carruselPublicidadBaner, @NonNull MaterialButton mandarSolicitud) {
    this.rootView = rootView;
    this.carruselPublicidadBaner = carruselPublicidadBaner;
    this.mandarSolicitud = mandarSolicitud;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentInicioServiciosFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentInicioServiciosFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_inicio_servicios_fragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentInicioServiciosFragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.carrusel_publicidad_baner;
      ImageCarousel carruselPublicidadBaner = ViewBindings.findChildViewById(rootView, id);
      if (carruselPublicidadBaner == null) {
        break missingId;
      }

      id = R.id.mandarSolicitud;
      MaterialButton mandarSolicitud = ViewBindings.findChildViewById(rootView, id);
      if (mandarSolicitud == null) {
        break missingId;
      }

      return new FragmentInicioServiciosFragmentBinding((FrameLayout) rootView,
          carruselPublicidadBaner, mandarSolicitud);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
