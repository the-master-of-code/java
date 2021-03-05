package lambda;

public class TestLambda1 {

    //静态内部类
    static class Like2 implements ILile{
        @Override
        public void lambda() {
            System.out.println("学习lambda2");
        }
    }



    public static void main(String[] args) {

        //局部内部类
        class Like3 implements ILile{
            @Override
            public void lambda() {
                System.out.println("学习lambda3");
            }
        }

        //通过new实现类创建接口对象
        ILile like = new Like();
        like.lambda();

        like = new Like2();
        like.lambda();

        like = new Like3();
        like.lambda();


        //匿名内部类
        like = new ILile() {
            @Override
            public void lambda() {
                System.out.println("学习lambda4");
            }
        };
        like.lambda();


        //lambda表达式
        like = ()->{
            System.out.println("学习lambda5");
        };
        like.lambda();


        //lambda表达式只有一行方法体时可以省略花括号
        like = ()->System.out.println("学习lambda6");
        like.lambda();

    }


}

//定义函数式接口
interface ILile{
    void lambda();
}
//实现类
class Like implements ILile{
    @Override
    public void lambda() {
        System.out.println("学习lambda1");
    }
}