package by.it.fando.jd02_02;

public class Controller {

    private final static int planCount = 100;
    private static int numberBuyer = 0;
    private static int processCount = 0;
    private static int factCount = 0;

    synchronized static boolean planComplete() {
        return factCount >= planCount;
    }

    synchronized static Buyer addNewBuyer() {
        processCount++;
        return new Buyer(++numberBuyer);
    }

    synchronized static void finalBuyer() {
        processCount--;
        factCount++;
    }

    synchronized static boolean allBuyersInShop() {
        return numberBuyer == planCount;
    }
}
