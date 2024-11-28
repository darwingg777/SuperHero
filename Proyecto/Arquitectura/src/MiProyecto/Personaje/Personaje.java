import java.io.Serializable;

public interface Personaje extends Serializable {
    String getNombre();
    int getFuerza();
    int getVida();
    void recibirDanio(int danio);
    boolean estaVivo();
    void ganarExperiencia(int xp);
}

