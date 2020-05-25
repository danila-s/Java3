package chat.network;

public class Main {
    static volatile String a = "A";
    static Object mon = new Object();

    static class WaitNotifyClass implements Runnable {
        private String currentLetter;
        private String nextLetter;

        public WaitNotifyClass(String currentLetter, String nextLetter) {
            this.currentLetter= currentLetter;
            this.nextLetter = nextLetter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                synchronized (mon) {
                    try {
                        while (a != currentLetter)
                            mon.wait();
                        System.out.print(currentLetter);
                        a = nextLetter;
                        mon.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Task1");
        new Thread(new WaitNotifyClass("A", "B")).start();
        new Thread(new WaitNotifyClass("B", "C")).start();
        new Thread(new WaitNotifyClass("C", "A")).start();
    }
}


