package com.larkin.jvm.base.polymorphism;

/**
 * @program: encyclopaedia_java
 * @description: 运行时变量和编译时变量 属性无多态，而方法具有多态。
 * @author: Larkin
 * @create: 2022-06-09 10:11
 **/
public class Java20220609 {
    public static void main(String[] args) {
        Parent a1 = new Parent();
        System.out.println(a1.getClass() + "  " + a1.getString() + "  " + a1.a);

        Son b1 = new Son();
        System.out.println(b1.getClass() + "  " + b1.getString() + "  " + b1.a);
        //class com.larkin.jvm.base.polymorphism.Son  我是子类!  我是父类!
        a1 = b1;
        System.out.println(a1.getClass() + "  " + a1.getString() + "  " + a1.a);
        //class com.larkin.jvm.base.polymorphism.Son  我是子类!  我是子类!
        b1 = (Son) a1;
        System.out.println(b1.getClass() + "  " + b1.getString() + "  " + b1.a);
        //class com.larkin.jvm.base.polymorphism.Son  我是子类!  我是父类!
        Parent a2 = new Son();
        System.out.println(a2.getClass() + "  " + a2.getString() + "  " + a2.a);
/*
 所谓多态就是指程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时并不确定，
  而是在程序运行期间才确定，即一个引用变量倒底会指向哪个类的实例对象，该引用变量发出的方法调用到底
  是哪个类中实现的方法，必须在由程序运行期间才能决定。因为在程序运行时才确定具体的类，这样，不用修改源程序代码，
  就可以让引用变量绑定到各种不同的类实现上，从而导致该引用调用的具体方法随之改变，即不修改程序代码就可以
  改变程序运行时所绑定的具体代码，让程序可以选择多个运行状态，这就是多态性。
  ———多态存在的三个必要条件
继承
重写
父类引用指向子类对象：Parent p = new Child();
 */
    }
}
