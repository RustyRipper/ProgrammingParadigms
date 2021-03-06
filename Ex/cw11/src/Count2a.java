//Maciej Makara
//zadanie 2a

class IntCell2a {
    private int n = 0;
    private boolean flag = true;

    public synchronized int getN() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = false;
        notify();
        return n;
    }

    public synchronized void setN(int n) {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        flag = true;
        notify();
    }
}

class Count2a extends Thread {
    private static IntCell2a n = new IntCell2a();

    @Override
    public void run() {
        int temp;
        for (int i = 0; i < 200000; i++) {
            temp = n.getN();
            n.setN(temp + 1);
        }
    }

    public static void main(String[] args) {
        Count2a p = new Count2a();
        Count2a q = new Count2a();

        p.start();
        q.start();

        try {
            p.join();
            q.join();
        } catch (InterruptedException e) {
        }
        System.out.println("The value of n is " + n.getN());
    }
}