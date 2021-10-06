package com.company;

public class Demo {
    public static void main(String[] args) {

        /** By extending the thread super class **/
//        lesson1 l = new lesson1();
//        l.start();
//        lesson1 x = new lesson1();
//        x.start();
        /** By runnable interfaces **/
//        Thread t1 = new Thread(new lesson2());
//        Thread t2 = new Thread(new lesson2());
//        t2.start();t1.start();
        /** By direct implementing **/

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i=1; i < 11; i++){
                    System.out.println( Thread.currentThread().getId() + " value = " + i);
                    }
            }
        });
        t1.start();
    }
}


//-----------------------------------------------------------------------------------------------------------------------------

//class lesson2 implements Runnable {
//
//    @Override
//    public void run() {
//        for (int i=1; i < 11; i++){
//            System.out.println( Thread.currentThread().getId() + " value = " + i);
//       }
//    }
//}


//-----------------------------------------------------------------------------------------------------------------------------

//class lesson1 extends Thread {
//    public void run() {
//        for (int i=1; i < 11; i++){
//            System.out.println( Thread.currentThread().getId() + " value = " + i);
//        }
//    }
//}
//-----------------------------------------------------------------------------------------------------------------------------
