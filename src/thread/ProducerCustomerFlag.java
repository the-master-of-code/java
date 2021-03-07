package thread;


//解决生产者消费者模式的问题时，让生产者专注于生产，消费者专注与消费，他们都只提供产品或取出产品
//
//而产品要根据生产者提供的产品发生变化，也要对消费者消费产品的行为发生变化

public class ProducerCustomerFlag {//生产者消费者模式使用标志位解决

    public static void main(String[] args) {//剧本杀
        Script script = new Script("精彩的剧本");
        Author author = new Author(script);
        Player player = new Player(script);
        author.start();
        player.start();
    }
}

class Script{//剧本    记得对产品对象加锁！！！！！！！！！！
    String scriptName;
    boolean flag = false;//写好的剧本(初始为没有)

    Script(String scriptName){
        this.scriptName = scriptName;
    }

    public synchronized void write(Script script,int i){
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.scriptName = scriptName;
        System.out.println("作者完成了剧本："+script.scriptName+i);
        flag = !flag;
        this.notifyAll();
    }

    public synchronized void play(Script script,int i){
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("玩家们完美的破解了剧本---------->"+script.scriptName+i);
        flag = !flag;
        this.notifyAll();
    }
}

class Author extends Thread {//作者
    Script script;
    Author(Script script){
        this.script = script;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            script.write(script,i);
        }
    }
}
class Player extends Thread{//玩家
    Script script;
    Player(Script script){
        this.script = script;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            script.play(script,i);
        }
    }
}