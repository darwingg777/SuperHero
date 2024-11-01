import java.util.Scanner;

// Clase base para personajes
class Personaje {
    protected String nombre;
    protected int fuerza;
    protected int velocidad;
    protected int vida_hp;

    public Personaje(String nombre, int fuerza, int velocidad, int vida_hp) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.velocidad = velocidad;
        this.vida_hp = vida_hp;
    }

    public void atacar(Personaje oponente) {
        oponente.vida_hp -= this.fuerza;
    }

    public void defender(int daño) {
        this.vida_hp -= daño / 2;
        System.out.println(nombre + " se defendió del ataque y redujo el daño a " + daño / 2);
    }

    public void mostrarEstadisticas() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("Vida HP: " + vida_hp);
    }

    public void recuperarse() {
        this.vida_hp += 50; // Recupera 50 puntos de vida

    }
}

// Clase para Superhéroes
class SuperHeroe extends Personaje {
    public SuperHeroe(String nombre, int fuerza, int velocidad, int vida_hp) {
        super(nombre, fuerza, velocidad, vida_hp);
    }

    public void atacar(Personaje oponente) {
        oponente.vida_hp -= this.fuerza;
        System.out.println(nombre + " atacó con fuerza de " + this.fuerza);
    }

    public void aumentarPoder() {
        if (this.vida_hp > 0) {
            this.fuerza += 10; // Incrementa la fuerza
            this.velocidad += 5; // Incrementa la velocidad
            System.out.println(nombre + " ha aumentado sus poderes malignos! Fuerza: " + this.fuerza + " y Velocidad: "
                    + this.velocidad);
        }
    }

    public void recuperarse() {
        if (this.vida_hp > 0 && Math.random() > 0.5) {
            this.vida_hp += 50;
            System.out.println(this.nombre + " se recuperó 50 de HP");
        }
    }
}

// Clase para Villanos
class Villano extends Personaje {
    public Villano(String nombre, int fuerza, int velocidad, int vida_hp) {
        super(nombre, fuerza, velocidad, vida_hp);
    }

    public void atacar(Personaje oponente) {
        oponente.vida_hp -= this.fuerza;
        System.out.println(nombre + " atacó con fuerza de " + this.fuerza);
    }

    public void recuperarse() {
        if (this.vida_hp > 0 && Math.random() > 0.5) {
            this.vida_hp += 50;
            System.out.println(this.nombre + " se recuperó 50 de HP");
        }
    }

    public void aumentarPoder() {
        if (vida_hp > 0) {
            this.fuerza += 10; // Incrementa la fuerza
            this.velocidad += 5; // Incrementa la velocidad
            System.out.println(nombre + " ha aumentado sus poderes malignos! Fuerza: " + this.fuerza + " y Velocidad: "
                    + this.velocidad);
        }
    }
}

// Clase principal para probar el programa
class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lectura de datos para SuperHeroe
        System.out.println("Introduce los datos del superhéroe:");
        System.out.print("Nombre: ");
        String nombreHeroe = scanner.nextLine();
        System.out.print("Fuerza: ");
        int fuerzaHeroe = scanner.nextInt();
        System.out.print("Velocidad: ");
        int velocidadHeroe = scanner.nextInt();
        System.out.print("Vida HP: ");
        int vidaHeroe = scanner.nextInt();
        SuperHeroe heroe = new SuperHeroe(nombreHeroe, fuerzaHeroe, velocidadHeroe, vidaHeroe);
        scanner.nextLine(); // Limpiar el buffer del scanner

        // Lectura de datos para Villano
        System.out.println("Introduce los datos del villano:");
        System.out.print("Nombre: ");
        String nombreVillano = scanner.nextLine();
        System.out.print("Fuerza: ");
        int fuerzaVillano = scanner.nextInt();
        System.out.print("Velocidad: ");
        int velocidadVillano = scanner.nextInt();
        System.out.print("Vida HP: ");
        int vidaVillano = scanner.nextInt();
        Villano villano = new Villano(nombreVillano, fuerzaVillano, velocidadVillano, vidaVillano);

        System.out.println("-------¡COMIENZA LA BATALLA!-------");
        while (heroe.vida_hp > 0 && villano.vida_hp > 0) {
            heroe.atacar(villano);
            if (villano.vida_hp > 0) {
                villano.defender(heroe.fuerza);
                villano.atacar(heroe);
                heroe.defender(villano.fuerza);
            }
            heroe.mostrarEstadisticas();
            villano.mostrarEstadisticas();

            System.out.println("----------------------------");
            // Opción de recuperación y aumento de poder
            heroe.recuperarse();
            villano.recuperarse();
            heroe.aumentarPoder();
            villano.aumentarPoder();

        }
        if (heroe.vida_hp <= 0) {
            System.out.println(villano.nombre + " ha ganado la batalla!");
        } else {
            System.out.println(heroe.nombre + " ha ganado la batalla!");
        }

        scanner.close();
    }
}
