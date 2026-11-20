import java.util.Scanner;

public class Coet {
    private final Motor[] motors = new Motor[4];

    public Coet() {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void passAAPotencia(int p) {
        if (p < 0 || p > 10) {
            throw new IllegalArgumentException("Valor de potència incorrecte: " + p + " (ha d'estar entre 0 i 10)");
        }
        for (Motor m : motors) {
            m.setPotencia(p);
        }
    }

    public void arranca() {
        for (Motor m : motors) {
            m.start();
        }
    }

    public void esperaMotors() throws InterruptedException {
        for (Motor m : motors) {
            m.join();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Coet coet = new Coet();
        coet.arranca();

        Scanner sc = new Scanner(System.in);
        while (true) {
            int p = sc.nextInt();
            try {
                System.out.println("Passant a potència " + p);
                coet.passAAPotencia(p);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            if (p == 0) {
                break;
            }
        }

        coet.esperaMotors();
        sc.close();
    }
}