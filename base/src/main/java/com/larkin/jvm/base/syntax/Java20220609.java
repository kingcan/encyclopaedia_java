package com.larkin.jvm.base.syntax;/**
 * @program: encyclopaedia_java
 * @description: 作用域说明
 * @author: Larkin
 * @create: 2022-06-09 13:51
 **/
public class Java20220609 {
    public static String name = "TEST"; // 类级变量
    public int i; // 对象实例级变量

    // 属性块，在类初始化属性时候运行
    {
        int j = 2;// 块级变量
    }

    public void test1() {
        int j = 3; // 方法级变量
        if(j == 3) {
            int k = 5; // 块级变量
        }
        // 这里不能访问块级变量，块级变量只能在块内部访问
        System.out.println("name=" + name + ", i=" + i + ", j=" + j);
        int i =11;//同一作用域范围的包裹下成员变量名和局部变量名是可以变量名相同的。
        // 在方法中使用变量时，如果不指明使用成员变量还是局部变量，那么默认使用局部变量（就近原则）
        System.out.println("i="+i);
        System.out.println("当前对象的i="+this.i);
    }

    public static void main(String[] args) {
        // 不创建对象，直接通过类名访问类级变量
        System.out.println(Java20220609.name);
        // 创建对象并访问它的方法
        Java20220609 t = new Java20220609();
        t.test1();
    }

}
