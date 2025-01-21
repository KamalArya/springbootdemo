package com.example.demo.prep;

public class ThreadSafetyExample {
    public static void main(String[] args) throws InterruptedException {
        // Using StringBuffer (Thread-Safe)
        StringBuffer stringBuffer = new StringBuffer("Hello");
        Runnable bufferTask = () -> {
            for (int i = 0; i < 1000; i++) {
                stringBuffer.append(" World");
            }
        };

        // Using StringBuilder (Not Thread-Safe)
        StringBuilder stringBuilder = new StringBuilder("Hello");
        Runnable builderTask = () -> {
            for (int i = 0; i < 1000; i++) {
                stringBuilder.append(" World");
            }
        };

        // Starting multiple threads for StringBuffer
        Thread bufferThread1 = new Thread(bufferTask);
        Thread bufferThread2 = new Thread(bufferTask);
        bufferThread1.start();
        bufferThread2.start();

        // Starting multiple threads for StringBuilder
        Thread builderThread1 = new Thread(builderTask);
        Thread builderThread2 = new Thread(builderTask);
        builderThread1.start();
        builderThread2.start();

        // Wait for both threads to complete for StringBuffer
        bufferThread1.join();
        bufferThread2.join();

        // Wait for both threads to complete for StringBuilder
        builderThread1.join();
        builderThread2.join();

        // Output results
        System.out.println("Final StringBuffer Value: " + stringBuffer);
        System.out.println("Final StringBuilder Value: " + stringBuilder);
    }
}
