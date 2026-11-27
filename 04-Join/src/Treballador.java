import java.util.Random;

public class Treballador extends  Thread {
    private int edat_actual;
    private float cobrat;
    private Random rnd;
    private float sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
        public Treballador(String nom, float sou_anual_brut, int edat_inici_treball, int edat_fi_treball) {
            super(nom);
            this.sou_anual_brut = sou_anual_brut;
            this.edat_inici_treball = edat_inici_treball;
            this.edat_fi_treball = edat_fi_treball;
            this.edat_actual = 0;
            this.cobrat = 0.0f;
            this.rnd = new Random();
        }

    public void cobra() {
        this.cobrat += this.sou_anual_brut / 12.0f;
    }

    public void pagaImpostos() {
        float souMensual = this.sou_anual_brut / 12.0f;
        this.cobrat -= souMensual * 0.24f;
    }

    @Override
    public void run() {
        while (this.edat_actual < this.edat_fi_treball) {
            if (this.edat_actual >= this.edat_inici_treball) {
                for (int mes = 0; mes < 12; mes++) {
                    cobra();
                    pagaImpostos();
                    try {
                        Thread.sleep(rnd.nextInt(10)); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.edat_actual++;
        }
    }


    public float getCobrat() {
        return this.cobrat;
    }

    public int getEdat() {
        return this.edat_actual;
    }

}
