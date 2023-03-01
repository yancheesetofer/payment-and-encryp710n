package id.ac.ui.cs.advprog.tutorial3.auth.core;

import java.util.ArrayList;
import java.util.List;

public class Encryptor {
    private final List<ITransformer> steps;
    public Encryptor() {
        // TODO: Complete this function
        this.steps = new ArrayList<>();
        steps.add(new Shuffler(11));
        steps.add(new Substituter(2));
        steps.add(new Shifter(3));
        steps.add(new Reverser());
        steps.add(new Substituter(15));
        steps.add(new Shifter(-5));
        steps.add(new Shuffler(37));
    }

    public String encrypt(String password) {
        String encrypted = password;
        for (ITransformer step : steps) {
            encrypted = step.transform(encrypted);
        }
        return encrypted;
    }

}

