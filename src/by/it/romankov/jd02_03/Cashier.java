package by.it.romankov.jd02_03;

public class Cashier implements Runnable {

    private int number;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + " открыл кассу.");
         while (!Dispatcher.planComplete()) {
            Buyer buyer = QueueBuyer.extractBuyer();

            if (buyer != null) {
                System.out.println(this + ". Начало обслуживания для объекта: " + buyer);
                Util.sleep(Util.random(2000, 5000));
                buyer.printBascet();
                System.out.println(this + ". Конец обслуживания  для объекта: " + buyer);
                //покупатель запущен из состояния wait
                synchronized (buyer) {
                    buyer.notify();
                }
            } else
                Util.sleep(100);
            }
        System.out.println(this + " закрыл кассу.");
    }

    @Override
    public String toString() {
        return "Кассир №" + number;
    }
}
