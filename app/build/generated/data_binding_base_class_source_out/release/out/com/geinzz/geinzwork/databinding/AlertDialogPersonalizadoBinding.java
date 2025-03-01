// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.geinzz.geinzwork.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AlertDialogPersonalizadoBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView dialogMessage;

  @NonNull
  public final TextView dialogTitle;

  private AlertDialogPersonalizadoBinding(@NonNull LinearLayout rootView,
      @NonNull TextView dialogMessage, @NonNull TextView dialogTitle) {
    this.rootView = rootView;
    this.dialogMessage = dialogMessage;
    this.dialogTitle = dialogTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AlertDialogPersonalizadoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AlertDialogPersonalizadoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.alert_dialog_personalizado, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AlertDialogPersonalizadoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.dialog_message;
      TextView dialogMessage = ViewBindings.findChildViewById(rootView, id);
      if (dialogMessage == null) {
        break missingId;
      }

      id = R.id.dialog_title;
      TextView dialogTitle = ViewBindings.findChildViewById(rootView, id);
      if (dialogTitle == null) {
        break missingId;
      }

      return new AlertDialogPersonalizadoBinding((LinearLayout) rootView, dialogMessage,
          dialogTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
