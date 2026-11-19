public class Main {

    public static void main(String[] args) throws InterruptedException {
        String[] nomsJugadors = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan",
                         "Belli", "Arnau", "Aspas", "Messi", "MBapé"};


        Futbolista[] jugadors = new Futbolista[Futbolista.NUM_JUGADORS];
        for (int i = 0; i < jugadors.length; i++) {
            jugadors[i] = new Futbolista(nomsJugadors[i]);
        }



        System.out.println("Inici dels xuts ---------");

        for (Futbolista f : jugadors) {
            f.start();
        }


        for (Futbolista f : jugadors) {
            f.join();
        }



        System.out.println("Fi dels xuts --------");

        System.out.println("--- Estadístiques ----");
        for (Futbolista f : jugadors) {
            System.out.printf("%-10s -> %2d gols%n", f.getName(), f.getNgols());
        }
    }
}