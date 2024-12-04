import java.util.Scanner;

public class LogicaBatalla {
    private SuperHeroe heroe;
    private Villano villano;
    private Scanner scanner;

    public LogicaBatalla(SuperHeroe heroe, Villano villano) {
        this.heroe = heroe;
        this.villano = villano;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarBatalla() {
        while (heroe.estaVivo() && villano.estaVivo()) {
            // Turno del héroe
            if (realizarAccion(heroe, villano)) {
                if (!villano.estaVivo()) {
                    System.out.println(villano.getNombre() + " ha sido derrotado. ¡" + heroe.getNombre() + " gana!");
                    return;
                }
            }

            // Turno del villano
            if (realizarAccion(villano, heroe)) {
                if (!heroe.estaVivo()) {
                    System.out.println(heroe.getNombre() + " ha sido derrotado. ¡" + villano.getNombre() + " gana!");
                    return;
                }
            }
        }
    }

    private boolean realizarAccion(Personaje atacante, Personaje defensor) {
        System.out.println(atacante.getNombre() + ", elige una acción:");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");

        // Mostrar opciones especiales según el tipo de personaje
        if (atacante instanceof SuperHeroe) {
            System.out.println("3. Usar Poder Especial");
        } else if (atacante instanceof Villano) {
            System.out.println("3. Usar Poder Especial");
        }

        int opcion = scanner.nextInt();

        if (opcion == 1) {
            int danio = atacante.getFuerza(); // Daño igual a la fuerza del atacante
            System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + " causando " + danio + " de daño.");
            defensor.recibirDanio(danio);
            System.out.println(defensor.getNombre() + " tiene " + defensor.getVida() + " de vida restante.");
            return true; // Acción de ataque realizada
        } else if (opcion == 2) {
            System.out.println(atacante.getNombre() + " se defiende.");
            atacante.defender(); // El personaje se pone en modo defensa
            return false; // Acción de defensa realizada, no se hace daño
        } else if (opcion == 3) {
            if (atacante instanceof SuperHeroe) {
                SuperHeroe heroeAtacante = (SuperHeroe) atacante;
                heroeAtacante.usarPoderEspecial(defensor); // Usar poder especial
            } else if (atacante instanceof Villano) {
                Villano villanoAtacante = (Villano) atacante;
                villanoAtacante.usarPoderEspecial(defensor); // Usar poder especial
            }
            return true; // Acción especial realizada
        } else {
            System.out.println("Opción no válida. Intenta de nuevo.");
            return realizarAccion(atacante, defensor); // Repetir acción
        }
    }
}