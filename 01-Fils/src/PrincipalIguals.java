public class PrincipalIguals {
    public static void main(String[] args) {
        Fil juan = new Fil("Juan", Thread.MAX_PRIORITY, 0, 1000, "Acaba");
        Fil pepe = new Fil("Pepe", Thread.MAX_PRIORITY, 0, 1000, "Acaba");

        pepe.start();
        juan.start();

        System.out.println("Acaba thread main");
    }
}