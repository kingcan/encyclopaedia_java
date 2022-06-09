package com.larkin.jvm.base.polymorphism;/**
 * @program: encyclopaedia_java
 * @description: 父类
 * @author: Larkin
 * @create: 2022-06-09 10:12
 **/

/**
 * @description: 父类
 * @version 1.0
 * @author Larkin
 * @date 2022/6/9 10:12 
 */
public class Parent {
    String a = "我是父类!";

    public String getString()
    {
        return this.a;
    }

    public static void main(String[] args) {
        Integer i =40;
        Integer i2 =40;
        Integer i3 = new Integer(40);
        System.out.println(i==i2);
        System.out.println(i2==i3);
    }


}
