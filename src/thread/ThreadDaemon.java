package thread;

//java虚拟机不需要等待守护进程结束再结束
//java虚拟机在普通线程（主从线程）结束后就会停止

//gc也是守护线程
public class ThreadDaemon {
    public static void main(String[] args) {
        You you =new You();
        Faith faith = new Faith();

        Thread f = new Thread(faith);
        f.setDaemon(true);//设置信念为守护线程
        f.start();

        new Thread(you).start();
    }

}
class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36000; i++) {//人生不过三万天
            System.out.println("你快乐的生活每一天");
        }
    }
}

class Faith implements  Runnable{
    @Override
    public void run() {
        while (true)
        System.out.println("信念支撑每一天");
    }
}