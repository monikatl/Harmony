package com.example.harmony.ui.learn;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LearnViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LearnViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Wybierz # lub b aby tworzyć Triadę harmoniczną.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}