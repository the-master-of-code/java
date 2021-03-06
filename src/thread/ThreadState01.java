package thread;

public class ThreadState01 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完了");
    }

    public static void main(String[] args) {
        ThreadState01 threadState01 =new ThreadState01();
        Thread thread = new Thread(threadState01);
        System.out.println(thread.getState());

        thread.start();
        System.out.println(thread.getState());

        while (!(thread.getState()==Thread.State.TERMINATED)){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getState());
        }




    }
}
