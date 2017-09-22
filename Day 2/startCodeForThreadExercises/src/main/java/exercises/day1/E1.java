package exercises.day1;

import java.util.logging.Level;
import java.util.logging.Logger;


public class E1 {
    public static void main(String[] args) {
        boolean[] list = {true};
        
        Thread t1 = new Thread(() -> {
            long sum = 0;
            for(long i = 0; i < 1000000000l; i++) {
                sum += i;
            }
            System.out.println("The sum is: " + sum);
        });
        
        Thread t2 = new Thread(() -> {
            for(int i = 1; i < 6; i++) {
                System.out.println("Thread 2: " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(E1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Thread t3 = new Thread(() -> {
            for(int i = 10; list[0]; i++) {
                System.out.println("Thread 3: " + i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(E1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        t1.start();
        t2.start();
        t3.start();
        
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(E1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        list[0] = false;
    }
}
