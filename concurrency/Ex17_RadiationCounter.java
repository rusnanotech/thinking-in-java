package biz.markov.thinking.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/****************** Exercise 17 ************************
 * Create a radiation counter that can have any number of
 * remote sensors.
 ******************************************************/
public class Ex17_RadiationCounter {
    private double totalDose;

    public synchronized void addDose(double dose) {
        totalDose += dose;
    }

    public synchronized double getTotalDose() {
        return totalDose;
    }

    public static class Sensor implements Runnable {
        private static final List<Sensor> sensors = new ArrayList<Sensor>();
        private static final Random random = new Random();
        private static long counter;

        private final long id = ++counter;
        private final Ex17_RadiationCounter radiationCounter;
        private double totalDose;

        public Sensor(Ex17_RadiationCounter radiationCounter) {
            this.radiationCounter = radiationCounter;
            sensors.add(this);
        }

        @Override
        public void run() {
            System.out.format("Sensor %2d started\n", id);
            try {
                while (!Thread.interrupted()) {
                    TimeUnit.MILLISECONDS.sleep( random.nextInt(50));
                    double dose = random.nextDouble();
                    radiationCounter.addDose(dose);
                    this.totalDose += dose;
                }
            } catch (Exception x) {
                System.out.format("Sensor %2d interrupted\n", id);
                return;
            }
            System.out.format("Sensor %2d stopped\n", id);
        }

        public static double calculateTotalDose() {
            double totalDose = 0.0;
            for (Sensor sensor : sensors) {
                totalDose += sensor.totalDose;
            }
            return totalDose;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Ex17_RadiationCounter radiationCounter = new Ex17_RadiationCounter();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new Sensor(radiationCounter));
        }
        TimeUnit.SECONDS.sleep(10);
        executorService.shutdownNow();

        double counterValue = radiationCounter.getTotalDose();
        double sensorsValue = Sensor.calculateTotalDose();
        System.out.println("Total radiation dose from counter: " + counterValue);
        System.out.println("Total radiation dose from sensors: " + sensorsValue);
    }
}
