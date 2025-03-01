// Generated by view binder compiler. Do not edit!
package com.geinzz.geinzwork.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.geinzz.geinzwork.R;
import com.google.android.material.tabs.TabLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityServiciosGeinzBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TabLayout tabLayout;

  @NonNull
  public final TextView textAboveTabLayout;

  @NonNull
  public final ViewPager viewPager;

  private ActivityServiciosGeinzBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout main, @NonNull TabLayout tabLayout,
      @NonNull TextView textAboveTabLayout, @NonNull ViewPager viewPager) {
    this.rootView = rootView;
    this.main = main;
    this.tabLayout = tabLayout;
    this.textAboveTabLayout = textAboveTabLayout;
    this.viewPager = viewPager;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityServiciosGeinzBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityServiciosGeinzBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_servicios_geinz, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityServiciosGeinzBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.tabLayout;
      TabLayout tabLayout = ViewBindings.findChildViewById(rootView, id);
      if (tabLayout == null) {
        break missingId;
      }

      id = R.id.textAboveTabLayout;
      TextView textAboveTabLayout = ViewBindings.findChildViewById(rootView, id);
      if (textAboveTabLayout == null) {
        break missingId;
      }

      id = R.id.viewPager;
      ViewPager viewPager = ViewBindings.findChildViewById(rootView, id);
      if (viewPager == null) {
        break missingId;
      }

      return new ActivityServiciosGeinzBinding((ConstraintLayout) rootView, main, tabLayout,
          textAboveTabLayout, viewPager);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
