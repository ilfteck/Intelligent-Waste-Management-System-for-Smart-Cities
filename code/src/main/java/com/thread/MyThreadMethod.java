package com.thread;

/**
* Thread execution method (do some operations that have been performed since the project started, such as automatically changing the order status according to the time, such as the order signing 30 days automatic receiving function, such as changing the status according to the time) */
public class MyThreadMethod extends Thread  {
    public void run() {
        while (!this.isInterrupted()) {// The thread does not interrupt the execution loop
            try {
                Thread.sleep(5000); //This command is executed every 2000ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//			 ------------------ Start execution ---------------------------
//            System.out.println("Thread execution:" + System.currentTimeMillis());
        }
    }
}
