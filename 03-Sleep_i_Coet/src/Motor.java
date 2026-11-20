import java.util.Random;

public class Motor extends Thread {
    private final int id;
    private final Random random = new Random();
    private int potenciaObjectiu = 0;
    private int potenciaActual = 0;
    private boolean haRebutPotencia = false;

    public Motor(int id) {
        this.id = id;
    }

    public synchronized void setPotencia(int p) {
        potenciaObjectiu = p;
        haRebutPotencia = true;
        notifyAll();
    }

    private boolean acabat() {
        return haRebutPotencia && potenciaObjectiu == 0 && potenciaActual == 0;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (acabat()) {
                    System.out.println("Motor " + id + ": FerRes Objectiu: 0 Actual: 0");
                    break;
                }
                if (!haRebutPotencia || potenciaActual == potenciaObjectiu) {
                    if (haRebutPotencia) {
                        System.out.println("Motor " + id + ": FerRes Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                    continue;
                }
            }

            try {
                Thread.sleep(1000 + random.nextInt(1000)); // entre 1 i 2 segons
            } catch (InterruptedException e) {
                return;
            }

            synchronized (this) {
                if (potenciaActual < potenciaObjectiu) {
                    potenciaActual++;
                    System.out.println("Motor " + id + ": Incre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                } else if (potenciaActual > potenciaObjectiu) {
                    potenciaActual--;
                    System.out.println("Motor " + id + ": Decre. Objectiu: " + potenciaObjectiu + " Actual: " + potenciaActual);
                }
            }
        }
    }
}