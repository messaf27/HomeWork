package Classes;
import java.util.Random;

public class UniqID {
    private static int createCount;
    private int maxId;

    public UniqID() {
        createCount++;
        this.maxId = 1024;
    }

    public UniqID(int maxId) {
        createCount++;
        this.maxId = maxId;
    }

    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    int creteId() {
        return randInt(createCount, this.maxId);
    }
}
