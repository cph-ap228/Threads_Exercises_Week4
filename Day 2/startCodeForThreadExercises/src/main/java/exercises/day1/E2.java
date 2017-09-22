package exercises.day1;

import static exercises.day1.E2.function;

public class E2 {

    static int[] array = {0};
    
    public static void main(String[] args) {
        final int times = 1000;
        
        
        Even even = new Even();
        
        Thread t1 = new Thread(() -> {
            System.out.println("T1");
            function(even, times);
        });
        Thread t2 = new Thread(() -> {
            System.out.println("T2");
            function(even, times);
        });
        
        t1.start();
        t2.start();
    }
    
    public static void function(Even even, int times) {
        for (int i = 0; i < times; i++) {
            if(even.next()%2 != 0) {
                System.out.println("Not even");
                array[0]++;
            } 
        }
        System.out.println(array[0]);
    }
    
    public static class Even {

        private int n = 0;

        public int next() {
            n++;
            n++;
            return n;
        }
    }

}
