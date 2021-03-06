package thread;

public class ThreadJoin01 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我是vip，我先运行");
        }
    }

    public static void main(String[] args) {
        ThreadJoin01 threadJoin01 = new ThreadJoin01();
        Thread thread = new Thread(threadJoin01);
        thread.start();
        for (int i = 0; i < 10; i++) {
            if (i==3) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("主线程执行");
        }
    }
}
