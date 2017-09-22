package day2.webscraper;

public class Tester {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());

        TagCounter tc1 = new TagCounter("http://www.fck.dk");

        TagCounter tc2 = new TagCounter("http://www.google.com");

        TagCounter tc3 = new TagCounter("http://politiken.dk/");

        long start = System.nanoTime();

        tc1.run();
        tc2.run();
        tc3.run();

        System.out.println("Title: " + tc1.getTitle());
        System.out.println("Div's: " + tc1.getDivCount());
        System.out.println("Body's: " + tc1.getBodyCount());

        System.out.println("Title: " + tc2.getTitle());
        System.out.println("Div's: " + tc2.getDivCount());
        System.out.println("Body's: " + tc2.getBodyCount());

        System.out.println("Title: " + tc3.getTitle());
        System.out.println("Div's: " + tc3.getDivCount());
        System.out.println("Body's: " + tc3.getBodyCount());

        long end = System.nanoTime();
        long first = end - start;
        System.out.println("Time Sequential: " + first);

        start = System.nanoTime();

        tc1.start();
        tc2.start();
        tc3.start();

        tc1.join();
        tc2.join();
        tc3.join();

        System.out.println("Title: " + tc1.getTitle());
        System.out.println("Div's: " + tc1.getDivCount());
        System.out.println("Body's: " + tc1.getBodyCount());

        System.out.println("Title: " + tc2.getTitle());
        System.out.println("Div's: " + tc2.getDivCount());
        System.out.println("Body's: " + tc2.getBodyCount());

        System.out.println("Title: " + tc3.getTitle());
        System.out.println("Div's: " + tc3.getDivCount());
        System.out.println("Body's: " + tc3.getBodyCount());

        end = System.nanoTime();
        long second = end - start;
        System.out.println("Time Sequential: " + (end - start));
        System.out.println("We gained: " + (first-second));
    }
}
