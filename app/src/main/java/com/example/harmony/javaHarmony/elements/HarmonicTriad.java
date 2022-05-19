package com.example.harmony.javaHarmony.elements;

import com.example.harmony.javaHarmony.elements.triad.Triads;
import com.example.harmony.javaHarmony.tools.Text;


public class HarmonicTriad {
    private Triads tonicTriad;
    private Triads subdominantTriad;
    private Triads dominantTriad;

    public HarmonicTriad(Triads tonicTriad, Triads subdominantTriad, Triads dominantTriad) {
        this.tonicTriad = tonicTriad;
        this.subdominantTriad = subdominantTriad;
        this.dominantTriad = dominantTriad;
    }

    @Override
    public String toString() {
         StringBuilder harmonicTriadBuilder = new StringBuilder();
          return  harmonicTriadBuilder.append(Text.TONIC)
                                    .append(tonicTriad.toString())
                                    .append(System.getProperty("line.separator"))
                                    .append(Text.SUBDOMINANT)
                                    .append(subdominantTriad)
                                    .append(System.getProperty("line.separator"))
                                    .append(Text.DOMINANT)
                                    .append(dominantTriad)
                                    .toString();
    }

    public Triads getTonicTriad() {
        return tonicTriad;
    }

    public void setTonicTriad(Triads tonicTriad) {
        this.tonicTriad = tonicTriad;
    }

    public Triads getSubdominantTriad() {
        return subdominantTriad;
    }

    public void setSubdominantTriad(Triads subdominantTriad) {
        this.subdominantTriad = subdominantTriad;
    }

    public Triads getDominantTriad() {
        return dominantTriad;
    }

    public void setDominantTriad(Triads dominantTriad) {
        this.dominantTriad = dominantTriad;
    }
}
