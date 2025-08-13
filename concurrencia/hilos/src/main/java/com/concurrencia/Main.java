package com.concurrencia;

public class Main {
    public static void main(String[] args) {
        hilo hilo1 = new hilo();
        hilo hilo2 = new hilo();
        ThreadRunnable runnable = new ThreadRunnable();
        Thread thread = new Thread(new ThreadRunnable());

        thread.start();
        
        runnable.run();

        hilo1.start();
        hilo2.start();
    }
}