package thread;


//解决该模式的方法是让生产者和消费者专注生产和消费的行为，
//
// 将产品取出和消费的场景拿到一个中间类中，在对这个类加锁，线程的协同操作也放在这个类中

public class ProducerCustomersPiped {//生产者消费者模式  管道解决法

    public static void main(String[] args) {
        Container container = new Container();
        Producer producer = new Producer(container);
        Custmoer custmoer = new Custmoer(container);
        producer.start();
        custmoer.start();
    }
}
//产品
class Production {//产品
    int product_id;

    public Production(int product_id) {
        this.product_id = product_id;
    }
}
//生产者
class Producer extends Thread{
    Container container;
    Producer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {//一共要生产100个产品
            Production production = new Production(i);
            container.push(production);
            System.out.println("生产产品的编号为"+i);
        }
    }
}
//消费者
class Custmoer extends Thread{
    Container container;
    Custmoer(Container container){
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Production production = container.pop();
            System.out.println("消费者消费的产品编号为---------->"+production.product_id);
        }
    }
}

//缓冲区
class Container {
    //容器的大小为10
    Production[] productions = new Production[10];
    //容器计数器，当前容器内产品数量
    int count = 0;

    //生产者向容器放入产品
    public synchronized  void push(Production production){
        while(count == productions.length) {//容器内的产品数量达到容器能存放的上限了
            //生产者等待，通知消费者消费
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            productions[count] = production;//向容器内放入产品
            count++;
            this.notifyAll();
    }
    //消费者从容器中取走产品
    public synchronized Production pop(){
        while (count <= 0) {
            //消费者等待，通知生产者生产产品
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Production production = productions[count];//这里虽然消耗了产品，但是并没有将产品取出
//            productions[count] = null;//取出产品？

        this.notifyAll();
        return production;
    }


}