package id.ac.ui.cs.advprog.tutorial3.auth.core;

public class Shifter implements ITransformer {
    private int disposition;

    public Shifter(int disposition) {
        this.disposition = disposition;
    }

    public String transform(String str) {
        // TODO: Complete this function

        return "";
    }

    private String shiftRightByOne(String s) {
        return s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
    }

    private String shiftLeftByOne(String s) {
        return s.substring(1) + s.charAt(0);
    }
}
