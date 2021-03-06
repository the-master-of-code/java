package thread;

public class ThreadSleep01 implements Runnable {
    int  countDown = 10;
    @Override
    public void run() {
        while (countDown >= 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(countDown--);
        }
    }

    public static void main(String[] args) {//实现倒计时
        ThreadSleep01 threadSleep01 = new ThreadSleep01();
        new Thread(threadSleep01).start();
    }
}
