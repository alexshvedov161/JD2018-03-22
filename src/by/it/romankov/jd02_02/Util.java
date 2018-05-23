package by.it.romankov.jd02_02;

public class Util {
    static void sleep(int msTimeout) {
        try {
            Thread.sleep(msTimeout / Dispatcher.speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static int random(int from, int to) {
        return from + (int) (Math.random() * (1 + to - from));
    }

    static int random(int count) {
        return random(0, count);
    }
}
