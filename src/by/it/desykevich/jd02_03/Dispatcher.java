package by.it.desykevich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static int speed = 25; //во сколько раз ускорить приложение
    private final static int planCount = 100; //сколько покупателей нужно всего

    private static final AtomicInteger numberBuyer =
            new AtomicInteger(0); //счетчик покупателей

    private static final AtomicInteger factCount =
            new AtomicInteger(0);  //сколько вышло из магазина

    //синхронизация происходит по объекту Dispatcher.class
    static boolean planComplete() {
        return factCount.get() >= planCount;
    }

    //синхронизация происходит по объекту Dispatcher.class
    static Buyer addNewBuyer() {
        return new Buyer(numberBuyer.addAndGet(1));
    }

    //синхронизация происходит по объекту Dispatcher.class
    static void finalBuyer() {
        factCount.addAndGet(1);
    }

    //синхронизация происходит по объекту Dispatcher.class
    static boolean allBuyersInShop() {
        return numberBuyer.get() >= planCount;
    }


}
