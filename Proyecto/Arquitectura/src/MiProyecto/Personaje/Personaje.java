public interface Personaje {
    String getNombre();
    int getVida();
    int getFuerza();
    void recibirDanio(int danio);
    boolean estaVivo();
    void defender();
}