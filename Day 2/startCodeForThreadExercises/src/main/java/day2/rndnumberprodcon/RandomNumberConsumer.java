package day2.rndnumberprodcon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class RandomNumberConsumer implements Runnable {

    private ArrayBlockingQueue<Integer> numbersProduced;

    public RandomNumberConsumer(ArrayBlockingQueue<Integer> numbersProduced) {
        this.numbersProduced = numbersProduced;
    }
    //Should eventually hold the sum of all random number consumed
    private int sumTotal = 0;
    private List<Integer> below50 = new ArrayList();
    private List<Integer> aboveOr50 = new ArrayList();

    @Override
    public void run() {
        //In this exercise, we start four threads, each producing 100 numbers, so we know how much to consume
        for (int i = 0; i < 400; i++) {
            int element = 0;
            try {
                element = numbersProduced.take();
            } catch (InterruptedException ex) {
            }
            sumTotal += element;
            if (element < 50) {
                below50.add(element);
            } else {
                aboveOr50.add(element);
            }
        }
    }

    public int getSumTotal() {
        return sumTotal;
    }

    public List<Integer> getBelow50() {
        return below50;
    }

    public List<Integer> getAboveOr50() {
        return aboveOr50;
    }

}
