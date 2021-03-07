package thread;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    public static void main(String[] args) {
        RobTicket robTicket = new RobTicket();
        new Thread(robTicket).start();
        new Thread(robTicket).start();
        new Thread(robTicket).start();
    }
}

class RobTicket implements Runnable{
    int ticket = 10;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            lock.lock();//显示加锁
            while(ticket>0){
                System.out.println(Thread.currentThread().getName()+"抢到了票"+ticket--);
            }
        }finally {
            lock.unlock();//释放锁
        }


        //等价于
//        synchronized (this){
//            while(ticket>0){
//                System.out.println(Thread.currentThread().getName()+"抢到了票"+ticket--);
//            }
//        }

    }
}