package thread;

import java.util.concurrent.*;

public class TestThread03 implements Callable {
    private static int ticketNums = 10;
    @Override
    public Boolean call()  {
        while (true){
            if(ticketNums<0)
                break;
            System.out.println(Thread.currentThread().getName()+"抢到了票"+ticketNums--);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestThread03 t1 = new TestThread03();
        TestThread03 t2 = new TestThread03();
        TestThread03 t3 = new TestThread03();
        ExecutorService ser = Executors.newFixedThreadPool(3);
        Future<Boolean> f1 = ser.submit(t1);
        Future<Boolean> f2 = ser.submit(t2);
        Future<Boolean> f3 = ser.submit(t3);
        boolean b1 =f1.get();
        boolean b2 =f2.get();
        boolean b3 =f3.get();
        ser.shutdownNow();
    }
}
