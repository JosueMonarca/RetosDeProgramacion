package com.concurrencia;

public class ThreadRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hilo Runnable No :" + Thread.currentThread().getName());
    }

}
