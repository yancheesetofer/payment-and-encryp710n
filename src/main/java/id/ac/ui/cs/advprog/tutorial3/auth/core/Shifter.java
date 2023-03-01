package id.ac.ui.cs.advprog.tutorial3.auth.core;

public class Shifter implements ITransformer {
    private int disposition;

    public Shifter(int disposition) {
        this.disposition = disposition;
    }

    public String transform(String str) {
        String newStr = str;
        if (this.disposition > 0) {
            for (int i = 0; i < this.disposition; i++) {
                newStr = this.shiftRightByOne(newStr);
            }
        } else {
            for (int i = 0; i > this.disposition; i--){
                newStr = this.shiftLeftByOne(newStr);

            }        }
        return newStr;
    }

    private String shiftRightByOne(String s) {
        return s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
    }

    private String shiftLeftByOne(String s) {
        return s.substring(1) + s.charAt(0);
    }
}
