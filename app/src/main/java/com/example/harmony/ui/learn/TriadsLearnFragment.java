package com.example.harmony.ui.learn;



import androidx.activity.OnBackPressedCallback;
import androidx.annotation.ColorInt;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import com.example.harmony.MainActivity;
import com.example.harmony.R;
import com.example.harmony.databinding.TriadsLearnFragmentBinding;
import com.example.harmony.javaHarmony.elements.HarmonicTriad;
import com.example.harmony.javaHarmony.harmonic_triad_builder.CreateHarmonicTriad;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;


public class TriadsLearnFragment extends Fragment {

    private TriadsLearnViewModel mViewModel;
    private @NonNull TriadsLearnFragmentBinding binding;

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(TriadsLearnViewModel.class);

       //binding = TriadsLearnFragmentBinding.inflate(inflater, container, false);
       //View root = binding.getRoot();

        TriadsLearnFragmentBinding dataBinding =
                DataBindingUtil.inflate(inflater,R.layout.triads_learn_fragment,container,false);

        View view = dataBinding.getRoot();

        dataBinding.setLifecycleOwner(this);
        dataBinding.setViewModel(mViewModel);

        return view;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TriadsLearnViewModel.class);
        // TODO: Use the ViewModel
    }

}