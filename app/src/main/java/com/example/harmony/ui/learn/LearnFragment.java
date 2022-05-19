package com.example.harmony.ui.learn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.harmony.R;
import com.example.harmony.databinding.FragmentLearnBinding;


public class LearnFragment extends Fragment {

    private FragmentLearnBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LearnViewModel dashboardViewModel =
                new ViewModelProvider(this).get(LearnViewModel.class);

        binding = FragmentLearnBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textLearn;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final ImageButton flat = binding.imageButton3;
        flat.setOnClickListener(view ->
                Navigation.findNavController(view).navigate(R.id.action_navigation_learn_to_triadsLearn));

        final ImageButton sharp = binding.imageButton4;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}