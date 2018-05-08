package com.cai.ggs2.test;

import java.util.Date;
import java.util.Arrays;

public class T1 {

    public static void main(String[] args) {

        f7();
    }

    private static void f7() {

        Date d = new Date();

        System.out.println(d.getClass().getName());

        System.out.println(d.getTime());
        try {
            Class c = Class.forName("java.util.Date");

            try {
                Date d2 = (Date) c.newInstance();

                System.out.println(d2.getTime());

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void f6() {

        Integer in = new Integer(1);

    }

    private static void f5() {

        String[] arr = {"a", "b"};

        System.out.println(arr.toString());
        System.out.println(Arrays.toString(arr));

    }

    private static void f3() {
        int i1=10;
        f4(i1);

        System.out.println(i1);

        User u = new User("zs");

        f5(u);

        System.out.println(u.getName());
    }

    private static void f5(User u) {

        u.setName("ls");
    }

    private static void f4(int i1) {

        i1 = 5;
    }

    private static void f2() {

        for(int i=10; i>0; i--){
            System.out.println(i);
        }
        System.out.println("end");
    }

    private static void f1() {

        Integer num1 = 1000;
        Integer num2 = 1000;
        System.out.println(num1 == num2);
        System.out.println(num1.equals(num2));


        String s1 = "hello";
        s1 += " world";
        System.out.println(s1);
    }
}
