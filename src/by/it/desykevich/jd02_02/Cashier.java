package by.it.desykevich.jd02_02;

public class Cashier implements Runnable {

    private int number;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println(this + " открыл кассу.");
        //пока план не выполнен, покупатель ищется в очереди
        while (!Dispatcher.planComplete()) {
            Buyer buyer = QueueBuyer.extractBuyer();
            //покупатель найден
            if (buyer != null) {
                System.out.println(this + ". Начало обслуживания для объекта: " + buyer);
                Util.sleep(Util.random(2000, 5000));
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
