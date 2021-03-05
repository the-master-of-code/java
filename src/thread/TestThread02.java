package thread;

public class TestThread02 implements Runnable{
    private int ticketNums = 1;
    @Override
    public void run() {
        while (ticketNums <= 50){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到了第"+(ticketNums++)+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread02 testThread02 = new TestThread02();
        new Thread(testThread02,"A").start();
        new Thread(testThread02,"B").start();
        new Thread(testThread02,"C").start();
        new Thread(testThread02,"D").start();
    }
}
