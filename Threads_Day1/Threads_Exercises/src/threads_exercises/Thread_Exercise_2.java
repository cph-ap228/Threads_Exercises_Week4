 package threads_exercises;

/**
 *
 * @author Maksymilian
 */
public class Thread_Exercise_2 {

    public static void main(String[] args) {
        Even e = new Even(); 
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1e8; i++) {
                double a = e.next();
                if (e.isEven(a)) {
                    System.out.println("t1, Even");    
                } else {
                    System.out.println("t1, Odd");
                }
            }
        });
        t1.start();
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1e8; i++) {
                double a = e.next(); 
                if (e.isEven(a)) {
                    System.out.println("t2, Even");
                } else { 
                    System.out.println("t2 Odd");
                }
            }
        });
        t2.start();
    }
}

class Even {
    private int n = 0; 
    
    public int next() {
        n++;
        n++;
        return n;
    
}

public synchronized boolean isEven(double value) { 
    if (value % 2 == 0) {
        return true;
    } else {
        return false;
}
    
}
}

