package thread;

//礼让不一定成功
//优先级高的也不一定最先执行

//礼让和设置优先级用处都不大（个人理解），不礼让，不设置优先级，AB依然是乱序执行
public class ThreadYiled01 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始");
//        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"结束");
    }

    public static void main(String[] args) {
        ThreadYiled01 threadYiled01 = new ThreadYiled01();

        new Thread(threadYiled01, "A").start();
        new Thread(threadYiled01, "B").start();


//        Thread A = new Thread(threadYiled01,"A");
//        Thread B = new Thread(threadYiled01,"B");
//        A.setPriority(Thread.MAX_PRIORITY);
//        B.setPriority(Thread.MIN_PRIORITY);
//        A.start();
//        B.start();

    }
}
