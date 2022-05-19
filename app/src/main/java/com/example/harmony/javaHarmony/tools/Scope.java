package com.example.harmony.javaHarmony.tools;

public enum Scope {
    FLAT(8), SHARP(16), ALL(0);

    int number;
    Scope(int _number){
        number = _number;
    }

    public int getNumber(){
        return number;
    }
}
