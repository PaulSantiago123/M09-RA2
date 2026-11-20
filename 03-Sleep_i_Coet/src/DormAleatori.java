import java.util.Random;

public class DormAleatori extends Thread {
    private final long instantCreat;

    private final Random random = new Random();
    

    public DormAleatori(String nom) {
        super(nom);
        this.instantCreat = System.currentTimeMillis();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int aleatori = random.nextInt(1000);

            long total = System.currentTimeMillis() - instantCreat;

            System.out.println(getName() + " (" + i + ") a dormir " + aleatori + "ms total " + total + "ms");

            try {
                Thread.sleep(aleatori);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();
        System.out.println("-- Fi de main -----------");
    }
}