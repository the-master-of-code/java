package thread;

public class ThreadStop01 implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        int i = 1;
        while(flag){
                System.out.println(Thread.currentThread().getName()+"正在执行，次数"+i++);
        }

    }

    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStop01 thread = new ThreadStop01();
        new Thread(thread).start();

        for (int i = 0; i < 100; i++) {
            if(i==70){
                thread.stop();
                System.out.println("从线程停止了");
            }
            System.out.println("主线程在执行"+i);
        }


    }
}
