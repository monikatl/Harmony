package com.example.harmony.ui.learn;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.harmony.javaHarmony.elements.HarmonicTriad;
import com.example.harmony.javaHarmony.elements.triad.MajorTriad;
import com.example.harmony.javaHarmony.elements.triad.Triads;
import com.example.harmony.javaHarmony.harmonic_triad_builder.CreateHarmonicTriad;

public class TriadsLearnViewModel extends ViewModel {
    CreateHarmonicTriad builder = new CreateHarmonicTriad();
    public MutableLiveData<HarmonicTriad> harmonicTriad;



    public TriadsLearnViewModel() {
        harmonicTriad = new MutableLiveData<>();
        harmonicTriad.setValue(
                new HarmonicTriad(new MajorTriad("C"),new MajorTriad("F"),new MajorTriad("G")));
        //userInput = new MutableLiveData<>();
    }

    public void jou(String user){
        harmonicTriad.setValue(builder.buildHarmonicTriad(user));
    }

    public LiveData<HarmonicTriad> getHarmonicTriad() {
        return harmonicTriad;
    }
}