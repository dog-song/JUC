package com.domi.disruptor.reflect;

import java.lang.reflect.Method;

/**
 * Created by dogsong on 2020/11/05.
 */
public class TestClass {

    private String name = "dogsong";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //非静态代码块
    { System.out.println("非静态代码块---执行"); }

    //静态代码块
    static { System.out.println("静态代码块---执行"); }

    //默认构造方法
    public TestClass(){
        System.out.println("默认构造方法---执行");
    }


    /**
     * 测试
     * @Param [args]
     * @return void
     **/
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*TestClass test = new TestClass();

        System.out.println("******test.getClass()******");
        System.out.println(test.getClass());

        System.out.println("******Class.forName()******");
        System.out.println(Class.forName("com.domi.disruptor.reflect.TestClass"));

        System.out.println("******TestClass.class******");
        System.out.println(TestClass.class);*/

        //第一个
        //Class c = Class.forName("com.domi.disruptor.reflect.TestClass",false,TestClass.class.getClassLoader());
        //第二个
        //Class c = Class.forName("com.domi.disruptor.reflect.TestClass");
        //实例化对象
        /*TestClass testClass = (TestClass) Class.forName("com.domi.disruptor.reflect.TestClass").newInstance();
        System.out.println(testClass.getName());*/

        //TestClass testClass = new TestClass();
        //TestClass testClass1 = new TestClass();
        //TestClass testClass2 = (TestClass) Class.forName("com.domi.disruptor.reflect.TestClass").newInstance();

        /*Class c = Class.forName("com.domi.disruptor.reflect.TestClass",true,TestClass.class.getClassLoader());
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }*/

        TestClass test = new TestClass();
    }
}
