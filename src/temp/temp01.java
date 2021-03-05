package temp;

public class temp01 {
    public static void main(String[] args) {
        //java静态常量区默认放了-128到127 只在制动装箱时有用,不创建新的对象  范围可以自定义
        Integer i5 = 128;
        Integer i6 = 127;
        Integer i7 = 127;

        System.out.println(i5==i6);
        System.out.println(i6==i7);

        int i = (int)Math.random();
        int i2 = (int)(Math.random()*100)+1;
        int i3 = new Integer("123");
        int i4 = (int)(Math.random()+20);

        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);

        float f = (float) Math.random()*100;

        double d = Math.random();
        System.out.println(f);
        System.out.println(d);
    }
}
