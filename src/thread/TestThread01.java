package thread;

public class TestThread01 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName()+"抢到了票");
        }
    }

    public static void main(String[] args) {
        TestThread01 thread =new TestThread01();
        thread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"抢到了票");
        }
    }
}
