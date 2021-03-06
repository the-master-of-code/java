package thread;

public class ThreadSleep02 {
    public static void main(String[] args) {//主线程的睡眠，实现倒计时
        try {
            cuntDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static void cuntDown() throws InterruptedException {
        int cuntDown = 10;
        while (cuntDown>=0){
            Thread.sleep(1000);
            System.out.println(cuntDown--);
        }
    }
}
