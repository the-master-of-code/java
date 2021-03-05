package lambda;

public class TestLambda2 {

    //静态内部类
    static class Love2 implements ILove{
        @Override
        public void lambda(int a) {
            System.out.println("学习lambda"+a);
        }
    }



    public static void main(String[] args) {

        //局部内部类
        class Love3 implements ILove{
            @Override
            public void lambda(int a) {
                System.out.println("学习lambda"+a);
            }
        }

        //通过new实现类创建接口对象
        ILove love = new Love();
        love.lambda(1);

        love = new Love2();
        love.lambda(2);

        love = new Love3();
        love.lambda(3);


        //匿名内部类
        love = new Love() {
            @Override
            public void lambda(int a) {
                System.out.println("学习lambda"+a);
            }
        };
        love.lambda(4);


        //lambda表达式
        love = (int a)->{
            System.out.println("学习lambda"+a);
        };
        love.lambda(5);

        //lambda表达式的参数类型可以省略，多个参数也可以，参数类型要同时省略
        love = (a)->{
            System.out.println("学习lambda"+a);
        };
        love.lambda(6);


        //lambda表达式只有一行方法体时可以省略花括号
        love = (a)->System.out.println("学习lambda"+a);
        love.lambda(7);

    }


}

//定义函数式接口
interface ILove{
    void lambda(int a);
}

//实现类
class Love implements ILove{
    @Override
    public void lambda(int a) {
        System.out.println("学习lambda"+a);
    }
}