import java.util.Random;

public class LogicaBatalla {
    private Personaje heroe;
    private Personaje villano;
    private Random random;

    public LogicaBatalla(Personaje heroe, Personaje villano) {
        this.heroe = heroe;
        this.villano = villano;
        this.random = new Random();
    }

    public void iniciarBatalla() {
        while (heroe.estaVivo() && villano.estaVivo()) {
            // Turno del héroe
            realizarAtaque(heroe, villano);
            if (!villano.estaVivo()) {
                System.out.println(villano.getNombre() + " ha sido derrotado. ¡" + heroe.getNombre() + " gana!");
                return;
            }

            // Turno del villano
            realizarAtaque(villano, heroe);
            if (!heroe.estaVivo()) {
                System.out.println(heroe.getNombre() + " ha sido derrotado. ¡" + villano.getNombre() + " gana!");
                return;
            }
        }
    }

    private void realizarAtaque(Personaje atacante, Personaje defensor) {
        int danio = atacante.getFuerza() + random.nextInt(5); // Añade un poco de aleatoriedad al daño
        defensor.recibirDanio(danio);
        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + " y causa " + danio + " de daño.");
        System.out.println(defensor.getNombre() + " tiene " + defensor.getVida() + " HP restantes.");
    }
}