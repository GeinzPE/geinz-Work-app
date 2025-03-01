// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
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

public final class ActivityPoliticasCreacionCuentaBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView privacyPolicyChanges;

  @NonNull
  public final TextView privacyPolicyContact;

  @NonNull
  public final TextView privacyPolicyDataProtection;

  @NonNull
  public final TextView privacyPolicyInformationCollected;

  @NonNull
  public final TextView privacyPolicyIntro;

  @NonNull
  public final TextView privacyPolicyTitle;

  @NonNull
  public final TextView privacyPolicyUseOfInformation;

  @NonNull
  public final TextView privacyPolicyUserRights;

  @NonNull
  public final TextView privacyPolicyWorkerGuidelines;

  @NonNull
  public final ScrollView scrollView;

  private ActivityPoliticasCreacionCuentaBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout main, @NonNull TextView privacyPolicyChanges,
      @NonNull TextView privacyPolicyContact, @NonNull TextView privacyPolicyDataProtection,
      @NonNull TextView privacyPolicyInformationCollected, @NonNull TextView privacyPolicyIntro,
      @NonNull TextView privacyPolicyTitle, @NonNull TextView privacyPolicyUseOfInformation,
      @NonNull TextView privacyPolicyUserRights, @NonNull TextView privacyPolicyWorkerGuidelines,
      @NonNull ScrollView scrollView) {
    this.rootView = rootView;
    this.main = main;
    this.privacyPolicyChanges = privacyPolicyChanges;
    this.privacyPolicyContact = privacyPolicyContact;
    this.privacyPolicyDataProtection = privacyPolicyDataProtection;
    this.privacyPolicyInformationCollected = privacyPolicyInformationCollected;
    this.privacyPolicyIntro = privacyPolicyIntro;
    this.privacyPolicyTitle = privacyPolicyTitle;
    this.privacyPolicyUseOfInformation = privacyPolicyUseOfInformation;
    this.privacyPolicyUserRights = privacyPolicyUserRights;
    this.privacyPolicyWorkerGuidelines = privacyPolicyWorkerGuidelines;
    this.scrollView = scrollView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPoliticasCreacionCuentaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPoliticasCreacionCuentaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_politicas_creacion_cuenta, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPoliticasCreacionCuentaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.privacy_policy_changes;
      TextView privacyPolicyChanges = ViewBindings.findChildViewById(rootView, id);
      if (privacyPolicyChanges == null) {
        break missingId;
      }

      id = R.id.privacy_policy_contact;
      TextView privacyPolicyContact = ViewBindings.findChildViewById(rootView, id);
      if (privacyPolicyContact == null) {
        break missingId;
      }

      id = R.id.privacy_policy_data_protection;
      TextView privacyPolicyDataProtection = ViewBindings.findChildViewById(rootView, id);
      if (privacyPolicyDataProtection == null) {
        break missingId;
      }

      id = R.id.privacy_policy_information_collected;
      TextView privacyPolicyInformationCollected = ViewBindings.findChildViewById(rootView, id);
      if (privacyPolicyInformationCollected == null) {
        break missingId;
      }

      id = R.id.privacy_policy_intro;
      TextView privacyPolicyIntro = ViewBindings.findChildViewById(rootView, id);
      if (privacyPolicyIntro == null) {
        break missingId;
      }

      id = R.id.privacy_policy_title;
      TextView privacyPolicyTitle = ViewBindings.findChildViewById(rootView, id);
      if (privacyPolicyTitle == null) {
        break missingId;
      }

      id = R.id.privacy_policy_use_of_information;
      TextView privacyPolicyUseOfInformation = ViewBindings.findChildViewById(rootView, id);
      if (privacyPolicyUseOfInformation == null) {
        break missingId;
      }

      id = R.id.privacy_policy_user_rights;
      TextView privacyPolicyUserRights = ViewBindings.findChildViewById(rootView, id);
      if (privacyPolicyUserRights == null) {
        break missingId;
      }

      id = R.id.privacy_policy_worker_guidelines;
      TextView privacyPolicyWorkerGuidelines = ViewBindings.findChildViewById(rootView, id);
      if (privacyPolicyWorkerGuidelines == null) {
        break missingId;
      }

      id = R.id.scrollView;
      ScrollView scrollView = ViewBindings.findChildViewById(rootView, id);
      if (scrollView == null) {
        break missingId;
      }

      return new ActivityPoliticasCreacionCuentaBinding((ConstraintLayout) rootView, main,
          privacyPolicyChanges, privacyPolicyContact, privacyPolicyDataProtection,
          privacyPolicyInformationCollected, privacyPolicyIntro, privacyPolicyTitle,
          privacyPolicyUseOfInformation, privacyPolicyUserRights, privacyPolicyWorkerGuidelines,
          scrollView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
