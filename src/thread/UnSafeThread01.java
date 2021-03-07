package thread;

public class UnSafeThread01 {
    static int balance = 100;//账户余额100w

    static class Account extends Thread{
        final String ACCOUNT_ID = "公有财产";


        int drawCount;//取现值
        String user;//取现人

        public  Account(int drawCount){
            this.drawCount=drawCount;
            user = super.getName();
        }

        /*drawCount 取现的数值,user 提取操作者的姓名*/
        private  void drawCash(int drawCount,String user){//提取现金的方法
            balance -= drawCount;
            System.out.println(user+"提取了现金"+drawCount+"w\n"+"账户余额"+balance+"w\n");
        }

        @Override
        public  void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

                if(balance>=0)
                    drawCash(drawCount,user);

        }
    }

    public static void main(String[] args) {
        Account account1 = new Account(60);
        account1.start();
        Account account2 = new Account(60);
        account2.start();

    }

}



