package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task1 extends Thread{

    public void run(){
        System.out.println("\nTask1 Strted ");
        for(int i=101;i<=199;i++){
            System.out.print(i+ " ");
        }
        System.out.println("\nTask1 Done");
    }
}

class Task2 implements Runnable{
@Override
    public void run(){
        System.out.println("\nTask2 Strted ");
        for(float i=0;i<=100;i++){
            System.out.print(i+ " ");
        }
        System.out.println("\nTask2 Done");
    }
}

public class ExecutorServiceRunner {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Thread task2 = new Thread(new Task2());
        // task1.setPriority(1);
        // task2.setPriority(4);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(task1);
        executorService.execute(task2);
        // task1.start();
        // task2.start();
        // System.out.println("main Strted ");
        // for(int i=200;i<=300;i++){
        //     System.out.print((char)i+ " ");
        // }
        // System.out.println("main Done");

        // executorService.shutdown();
    }
    
}
