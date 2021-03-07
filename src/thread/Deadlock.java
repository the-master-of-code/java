package thread;

public class Deadlock {
    public static void main(String[] args) {
        Makeup makeup1 = new Makeup("A",0);
        Makeup makeup2 = new Makeup("B",9);
        makeup1.start();
        makeup2.start();

    }
}

class Mirror{//镜子

}
class Lipstick{//口红

}

class Makeup extends Thread{//化妆，多线程化妆，两个人可以一起化妆
    //为了保证资源只有一份，使用static修饰符
    static Mirror  mirror = new Mirror();
    static Lipstick lipstick = new Lipstick();

    String girlName;//化妆需要一个人来化
    int choice;//为了区分资源获得情况的标识，0代表获得镜子的锁，其他代表获得口红的锁

    Makeup(String girlName,int choice){
        this.girlName = girlName;
        this.choice = choice;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {//化妆的方法

        //死锁
        if (choice == 0) {//如果选择先拿镜子
            synchronized (mirror) {//获得镜子的锁
                System.out.println("获得镜子的锁,我就要拿着镜子不放手");
                Thread.sleep(5000);
                synchronized (lipstick) {//获得口红的锁,一秒钟后想要口红
                    System.out.println("我还想要口红");
                }
            }
        }
        {//其他情况都是先拿口红
            synchronized (lipstick) {
                //获得口红的锁
                System.out.println("获得口红的锁，我就不把口红给你");
                Thread.sleep(5000);
                synchronized (mirror) {
                    //获得镜子的锁，两秒后想要镜子
                    System.out.println("并且我还想要镜子");
                }
            }

        }


        //避免死锁，不要嵌套锁，锁的对象不构成循环
//        if (choice == 0) {//如果选择先拿镜子
//            synchronized (mirror) {//获得镜子的锁
//                System.out.println("获得镜子的锁,我就要拿着镜子不放手");
//                Thread.sleep(1000);
//
//            }
//            synchronized (lipstick) {//获得口红的锁,一秒钟后想要口红
//                System.out.println("我还想要口红");
//            }
//        }
//        {//其他情况都是先拿口红
//            synchronized (lipstick) {
//                //获得口红的锁
//                System.out.println("获得口红的锁，我就不把口红给你");
//                Thread.sleep(1000);
//
//            }
//            synchronized (mirror) {
//                //获得镜子的锁，两秒后想要镜子
//                System.out.println("并且我还想要镜子");
//            }
//
//        }












    }
}