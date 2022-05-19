package com.example.harmony.ui.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.harmony.PractiseActivity;
import com.example.harmony.R;
import com.example.harmony.databinding.FragmentPlaceHolderBinding;
import com.example.harmony.javaHarmony.tools.Scope;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private FragmentPlaceHolderBinding binding;
    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.index = index;
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

       // binding = FragmentPractiseActivityBinding.inflate(inflater, container, false);
       // View root = binding.getRoot();

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_place_holder,container,false);
        View root = binding.getRoot();

        binding.setLifecycleOwner(this);
        binding.setViewModel(pageViewModel);


        Intent intent = getActivity().getIntent();
        int position = intent.getIntExtra("position",0);
        pageViewModel.position = position;

        switch (position){
            case 0:
                position= Scope.FLAT.getNumber();
                break;
            case 1:
                position=Scope.SHARP.getNumber();
                break;
            case 2:
                position=Scope.ALL.getNumber();
                break;
        }

        final int scope = position;

        binding.randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pageViewModel.randomKey(scope);
                String text = pageViewModel.harmonicTriad.getValue().getTonicTriad().getNameTriad();
                pageViewModel.randomButton.setValue(text);
                pageViewModel.resultView.setValue("?");
            }
        });



        //if (pageViewModel.practice.isComplete())
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}