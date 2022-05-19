package com.example.harmony.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<String>description;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        description = new MutableLiveData<>();
        mText.setValue("KOLO KWINTOWE");
        description.setValue("Koło kwintowe, okrąg kwintowy[1] – graficzny schemat[2] przedstawiający gamy / tonacje w systemie dur-moll uszeregowane według zmieniającej się liczby znaków przykluczowych. Nazwa wywodzi się od kwintowego pokrewieństwa między sąsiadującymi tonacjami, rozmieszczonymi na okręgu według zmieniającej się liczby znaków przykluczowych. W kierunku zgodnym z ruchem wskazówek zegara w każdej następnej gamie przybywa dodatkowo jeden krzyżyk, przy czym tonika gamy (nadająca jednocześnie jej nazwę) jest dominantą gamy wyjściowej (poprzedzającej). W kierunku przeciwnym zwiększa się liczbę bemoli, a tonika jest subdominantą gamy wyjściowej.\n" +
                "\n" +
                "Każda tonacja durowa posiada pokrewną tonację molową (zbudowaną na tonice znajdującej się o tercję małą poniżej toniki pokrewnej tonacji durowej). Obie mają takie same znaki przykluczowe. W kole kwintowym daje to układ tonacji molowych rozpoczynający się od a-moll (pokrewnej do C-dur).");
    }

    public LiveData<String> getText() {
        return mText;
    }
}