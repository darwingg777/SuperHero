public class Villano implements Personaje {
    private String nombre;
    private int fuerza;
    private int velocidad;
    private int vida_hp;
    private int nivel;
    private int experiencia;
    private boolean habilidadUsada;

    public Villano(String nombre, int fuerza, int velocidad, int vida_hp) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.vida_hp = vida_hp;
        this.nivel = 1;
        this.experiencia = 0;
        this.habilidadUsada = false;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getFuerza() {
        return fuerza;
    }

    @Override
    public int getVida() {
        return vida_hp;
    }

    @Override
    public void recibirDanio(int danio) {
        vida_hp -= danio;
    }

    @Override
    public boolean estaVivo() {
        return vida_hp > 0;
    }

    @Override
    public void ganarExperiencia(int xp) {
        experiencia += xp;
        if (experiencia >= 100) {
            nivel++;
            fuerza += 5;
            velocidad += 5;
            vida_hp += 10;
            experiencia = 0;
        }
    }

    public void usarHabilidadEspecial(Personaje enemigo) {
        if (!habilidadUsada) {
            enemigo.recibirDanio(fuerza * 2);
            habilidadUsada = true;
        }
    }
}