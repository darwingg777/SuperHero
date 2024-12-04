import java.io.Serializable;

public class SuperHeroe implements Personaje, Serializable {
    private String nombre;
    private int vida;
    private int fuerza;
    private int poderEspecial;

    public SuperHeroe(String nombre, int vida, int fuerza, int poderEspecial) {
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.poderEspecial = poderEspecial;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void recibirDanio(int danio) {
        this.vida -= danio;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void defender() {
        // Implementar lógica de defensa si es necesario
    }

    public void usarPoderEspecial(Personaje enemigo) {
        System.out.println(getNombre() + " usa su poder especial.");
        int danioExtra = poderEspecial; // Puedes definir cómo se calcula el daño extra
        enemigo.recibirDanio(danioExtra);
        System.out.println(enemigo.getNombre() + " recibe " + danioExtra + " de daño adicional por el poder especial.");
    }
}
