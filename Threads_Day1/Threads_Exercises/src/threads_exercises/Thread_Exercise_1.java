package threads_exercises;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maksymilian
 */
public class Thread_Exercise_1 {
    volatile static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            long sum = 0;
            for (long i = 0; i < 1e9; i++) {
                sum = sum + i;
            }
            System.out.println("t1 Sum is: " + sum);
        });

        Thread t2 = new Thread(() -> {
            try {

                for (int i = 1; i < 6; i++) {                    
                    System.out.println("t2 nr; " + i);
                    Thread.sleep(2222);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Thread_Exercise_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Thread t3 = new Thread(() -> {
            int i = 10;            
            try{
                while (run) {
                    System.out.println("t3 sum: " + i);
                    i++;
                    Thread.sleep(3333);
                }                
            }
            catch(InterruptedException ex){
                Logger.getLogger(Thread_Exercise_1.class.getName()).log(Level.SEVERE, null, ex);
            }            
        });
        
        

        t1.start();
        t2.start(); 
        t3.start();
        Thread.sleep(13000);
        run = false;
    }
}

/*
a) Do you observe a need for synchronization techniques on any of the threads in practise,
or does your program work by accident?
-->
    There's a need for synchronizatino for thread 3. As as I need a shared primitive to coordinate when the loop should stop. 
 
 
b) Regardless of whether you observe the problem on your machine, we need to handle it
What is the problem I’m hinting at, and how can we solve it? (Since I’m such a nice guy, here’s a hint: think about the VolatileExample class from the demo today).
 As I mentioned earlier, using the volatile keyword ensures a happens-before relationship between a thread which reads from the field and the thread that wrote to it.
-->

c) argue that your solution is correct (argue, don’t prove)
 -->

*/