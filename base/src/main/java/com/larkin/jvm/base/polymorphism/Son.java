package com.larkin.jvm.base.polymorphism;/**
 * @program: encyclopaedia_java
 * @description: 子类
 * @author: Larkin
 * @create: 2022-06-09 10:14
 **/

/**
 * @description: 子类
 * @version 1.0
 * @author Larkin
 * @date 2022/6/9 10:14 
 */
public class Son extends Parent{
    String a = "我是子类!";

    public String getString()
    {
        return this.a;
    }
}
