package designPattern;


//静态代理模式
//真实对象和代理对象都要实现同一个接口
//代理对象代理真实角色，真实角色要作为参数传入代理角色
//可以让真实角色专注做自己的事
//代理角色可以做到真实角色做不到的事

//Runnable就是一个函数式接口，线程的start()就是静态代理模式

public class ProxyPattern {

    public static void main(String[] args) {
        You you = new You();
        WeddingCompany weddingCompany =new WeddingCompany(you);
        weddingCompany.happyMarry();
    }

}

interface Marrry {
    //函数式接口，只有一个方法的接口
    void happyMarry();
}

//真实角色
class You implements Marrry{
    @Override
    public void happyMarry() {
        System.out.println("我要结婚了");
    }
}
//代理角色
class WeddingCompany implements Marrry{
    private Marrry target;

    public WeddingCompany(Marrry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }


    private void before() {
        System.out.println("布置婚礼现场");
    }

    private void after() {
        System.out.println("结算尾款");
    }
}
