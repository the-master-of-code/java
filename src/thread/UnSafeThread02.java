package thread;

public class UnSafeThread02 {
    public static void main(String[] args) {
        Account account = new Account("共有财产",100);
        Drawing drawing1 = new Drawing(account,60,"A");
        Drawing drawing2 = new Drawing(account,70,"B");
        drawing1.start();
        drawing2.start();
    }

}

class Account {
    String account_id;//账户名
    int balance;//余额

    public Account(String account_id, int balance) {
        this.account_id = account_id;
        this.balance = balance;
    }
}

class Drawing extends Thread{
    Account account;
    int drawCount;

    public Drawing(Account account,int drawCount,String name){
        super(name);
        this.account = account;
        this.drawCount = drawCount;

    }


    private void draw(Account account,int drawCount,String user){
        account.balance -= drawCount;
        System.out.println(user+"取现"+drawCount+"w\n"+account.account_id+
                "的余额为"+account.balance+"w\n");
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //不安全的01

        synchronized (account) {//所有有关锁对象的操作包括判断都要放在锁块中
            if (account.balance - drawCount < 0) {
                System.out.println("钱不够，取不了");
                return;
            }
            draw(account, drawCount, this.getName());
        }



        //不安全的02
//        if (account.balance-drawCount<0){
//            System.out.println("钱不够，取不了");
//            return;
//        }
//
//
//        //取现的值
//        System.out.println(this.getName()+"取现"+drawCount);
//        //余额
//        account.balance =account.balance - drawCount;
//        System.out.println(account.account_id+"卡内余额"+account.balance);





        //安全的
        //锁的对象默认是this
        //可以通过如下方式指定锁的对象
//        synchronized (account){//对操作对象加锁，就可以保证线程安全，尽量锁的操作块越小越好，锁块太大会影响性能
//            if (account.balance-drawCount<0){
//                System.out.println("钱不够，取不了");
//                return;
//            }
//
//
//            //取现的值
//            System.out.println(this.getName()+"取现"+drawCount);
//            //余额
//            account.balance =account.balance - drawCount;
//            System.out.println(account.account_id+"卡内余额"+account.balance);
//        }

    }
}