package com.example.harmony.practise;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public enum Practice {

    FS(0, false),
    FD(0, false),
    FSD(0, false),
    SS(0, false),
    SD(0, false),
    SSD(0, false),
    AS(0, false),
    AD(0, false),
    ASD(0, false);

    Practice(int cA, boolean isComp) {
        correctAnswers = cA;
        isComplete = isComp;
        if(correctAnswers!=10){
            this.isComplete = false;
        }else{
            this.isComplete = true;
        }
    }

    int correctAnswers;
    boolean isComplete;

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }



    public void increment(){
        if(this.correctAnswers<10){
            correctAnswers++;
        }
        if(this.correctAnswers==10){
            isComplete = true;
        }
    }

    public boolean completeExercise(){
        if (correctAnswers==10){
            return true;
        }
        else {
            return false;
        }
    }
}
