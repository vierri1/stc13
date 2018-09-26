package lesson6.reflection.testreflection;

public class Capucin extends Monkey {
    private final int tailLength = 40;
    public int charming;
    protected int harmful;
    private int footSize;

    public Capucin(int charming, int harmful, int footSize) {
        this.charming = charming;
        this.harmful = harmful;
        this.footSize = footSize;
    }

    public Capucin(int charming) {
        this(charming, 1, 38);
    }

    protected void washFace() {
        System.out.println("Face is cleaned");
    }

    private void washEars() {
        System.out.println("Ears are washed");
    }

    public void eatBannanas(int count) {
        System.out.println("Ate " + count + " bananas");
    }
}
