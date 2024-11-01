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
        oponente.vida_hp -= fuerza;
        System.out.println(nombre + " atacó con fuerza de " + fuerza);
    }

    public void defender(int daño) {
        int dañoReducido = daño / 2;
        vida_hp -= dañoReducido;
        System.out.println(nombre + " se defendió del ataque y redujo el daño a " + dañoReducido);
    }

    public void mostrarEstadisticas() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Fuerza: " + fuerza);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("Vida HP: " + vida_hp);
    }

    public void recuperarse() {
        if (vida_hp > 0) {
            vida_hp += 50; // Recupera 50 puntos de vida
            System.out.println(nombre + " se recuperó 50 de HP");
        }
    }

    public void aumentarPoder() {
        if (vida_hp > 0) {
            fuerza += 10; // Incrementa la fuerza
            velocidad += 5; // Incrementa la velocidad
            System.out.println(nombre + " ha aumentado sus poderes! Fuerza: " + fuerza + " y Velocidad: " + velocidad);
        }
    }
}

// Clase para Superhéroes
class SuperHeroe extends Personaje {
    public SuperHeroe(String nombre, int fuerza, int velocidad, int vida_hp) {
        super(nombre, fuerza, velocidad, vida_hp);
    }
}

// Clase para Villanos
class Villano extends Personaje {
    public Villano(String nombre, int fuerza, int velocidad, int vida_hp) {
        super(nombre, fuerza, velocidad, vida_hp);
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
            if (villano.vida_hp > 0) { // Villano solo ataca si está vivo
                villano.defender(heroe.fuerza); // Villano se defiende del ataque
                villano.atacar(heroe);
                heroe.defender(villano.fuerza); // SuperHeroe se defiende del ataque
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

    
    
           
        

        
        
            

        
