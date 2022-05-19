package com.example.harmony.ui.practise;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.harmony.PractiseActivity;
import com.example.harmony.R;
import com.example.harmony.databinding.FragmentPractiseBinding;
import com.example.harmony.practise.Practise;
import com.example.harmony.ui.main.PlaceholderFragment;

import java.util.List;

public class PractiseFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PractiseViewModel notificationsViewModel =
                new ViewModelProvider(this).get(PractiseViewModel.class);

       View view = inflater.inflate(R.layout.fragment_practise, container, false);


       String names[] ={"TONACJE BEMOLOWE", "TONACJE KRZYŻYKOWE", "WSZYSTKIE TONACJE"};
       String descriptions[] = {"Odgaduj elementy triady harmonicznej w tonacjach bemolowych do siedmiu znaków!",
               "Odgaduj elementy triady harmonicznej w tonacjach krzyżykowych do siedmiu znaków!",
               "Odgaduj elementy triady harmonicznej we wszystkich tonacjach do siedmiu znaków!"};
       String numbers[] = {"Cwiczenie 1","Cwiczenie 2","Cwiczenie 3"};
       int images[] = {R.drawable.bemol_com, R.drawable.pngwing_com, R.drawable.kisspng_golden_spiral_golden_ratio_clip_art_number_fibonacci_drawing_black_and_white_transparent_amp_5d023ac52f2332_4604504315604272051931};

        MyAdapter myAdapter = new MyAdapter(getContext(), names, descriptions, numbers, images);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        myAdapter.setListener(new MyAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), PractiseActivity.class);
                intent.putExtra("position", position);
                getActivity().startActivity(intent);
            }
        });

        ProgressBar progresBar = (ProgressBar) view.findViewById(R.id.progressBar);
        progresBar.setProgress(10);

        return view;
    }

}