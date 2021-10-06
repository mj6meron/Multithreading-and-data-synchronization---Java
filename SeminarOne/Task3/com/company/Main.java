package com.company;

public class Main {
    static int second = 0;
    static int millisecond = 0;
    static int minute = 0;
    static int hour = 0;
    public static void main(String[] args) throws InterruptedException {

        /** The stopwatch Thread **/
        Thread stopWatch = new Thread(new Runnable() {
            public void run() {
                System.out.println("Stopwatch thread. Stopwatch starts now!");
                while(true){
                    try {
                        if (minute >= 1) {
                            System.out.print("Stopwatch thread. Elapsed: ");
                            System.out.println( String.format("%02d", minute) + "." + String.format("%02d", second) + " minutes.");
                            break;
//                            counter();
//                            Thread.sleep(10);
                        }
                        else {
                            System.out.print("Stopwatch thread. Elapsed: ");
                            System.out.println( second + "." + String.format("%02d", millisecond) + " seconds.");
                            counter();
                            Thread.sleep(10);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.out.println("Main thread. Waiting for stopwatch thread ... ");
        stopWatch.start();
        stopWatch.join();
        System.out.println("\nOne minute stopwatch is over.");
    }

    public void reset(){
        hour = 0;
        minute = 0;
        second = 0;
        millisecond = 0;
    }

    /** The counter function **/
    public static void counter() {
        millisecond++;
        if (millisecond >= 100) {
            millisecond = 0;
            second++;
        }
        if (second >= 60) {
            millisecond = 0;
            second = 0;
            minute++;
        }
        if (minute >= 60) {
            millisecond = 0;
            second = 0;
            minute = 0;
            hour++;
        }
    }
}
