public class Fil extends Thread {
    private int delay;
    private int comptadorLimit;
    private String paraulaFinal;

    public Fil(String nom, int prioritat, int delay, int comptadorLimit, String paraulaFinal) {
        super(nom);
        this.setPriority(prioritat);
        this.delay = delay;
        this.comptadorLimit = comptadorLimit;
        this.paraulaFinal = paraulaFinal;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(this.getName() + " " + i);

            if (comptadorLimit > 0) {
                for (int j = 0; j < comptadorLimit; j++) {
                }
            }

            if (delay > 0) {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    System.err.println("Fil interromput: " + e.getMessage());
                }
            }
        }
        System.out.println(paraulaFinal + " el fil " + this.getName());
    }
}