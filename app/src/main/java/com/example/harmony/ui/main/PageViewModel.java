package com.example.harmony.ui.main;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.harmony.javaHarmony.elements.HarmonicTriad;
import com.example.harmony.javaHarmony.harmonic_triad_builder.CreateHarmonicTriad;
import com.example.harmony.practise.Practice;
import com.example.harmony.practise.Practise;


public class PageViewModel extends ViewModel {

    public MutableLiveData<HarmonicTriad> harmonicTriad = new MutableLiveData<>();
    public MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    public MutableLiveData<String> randomButton= new MutableLiveData<>();
    public MutableLiveData<String> texta= new MutableLiveData<>();
    public MutableLiveData<String> resultView= new MutableLiveData<>();
    public MutableLiveData<String> userResultText = new MutableLiveData<>();
    public MutableLiveData<String> key = new MutableLiveData<>();
    public MutableLiveData<Boolean> isComplete = new MutableLiveData<>();
    public int index;
    public int position;
    public Practice practice;


    CreateHarmonicTriad builder = new CreateHarmonicTriad();

    public PageViewModel(){
        randomButton.setValue("LOSUJ");
        resultView.setValue("?");
    }


    public void randomKey(int scope){
        harmonicTriad.setValue(builder.buildHarmonicTriad(builder.randomKey(scope)));
    }

    public void checkPractice(){
        switch (position){
            case 0:
                if(index==1){
                    practice = Practice.FS;
                }else if(index==2){
                    practice = Practice.FD;
                }else{
                    practice = Practice.FSD;
                }
                break;
            case 1:
                if(index==1){
                    practice = Practice.SS;
                }else if(index==2){
                    practice = Practice.SD;
                }else{
                    practice = Practice.SSD;
                }
                break;
            case 2:
                if(index==1){
                    practice = Practice.ASD;
                }else if(index==2){
                    practice = Practice.ASD;
                }else{
                    practice = Practice.ASD;
                }
                break;
        }
    }

    public void getKey(String name){
        checkPractice();
        key.setValue(name);
        if(checkUserInput()) {
            practice.increment();
            resultView.setValue(key.getValue());
            texta.setValue(String.valueOf(practice.getCorrectAnswers()));
            if(practice.isComplete()){
                texta.setValue("Cwiczenie zaliczone!");
            }
        }else{
            resultView.setValue("X");
        }
    }

    public boolean checkUserInput(){
        boolean isCorrect = false;
        String searchedKey = "";
        switch (mIndex.getValue()){
            case 1:
                searchedKey = harmonicTriad.getValue().getSubdominantTriad().getNameTriad();
                break;
            case 2:
                searchedKey = harmonicTriad.getValue().getDominantTriad().getNameTriad();
                break;
            case 3:
                searchedKey = harmonicTriad.getValue().getTonicTriad().getNameTriad();
                break;
            default:
                break;
        }
        if(key.getValue().equals(searchedKey)){
            isCorrect = true;

        }
        return isCorrect;
    }

    public void setIndex(int index) {
        mIndex.setValue(index);
    }
}