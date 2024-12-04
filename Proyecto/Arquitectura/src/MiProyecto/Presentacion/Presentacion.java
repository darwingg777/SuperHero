import java.util.Scanner;

public class Presentacion {
    private Scanner scanner;

    public Presentacion() {
        scanner = new Scanner(System.in);
    }

    public String leerNombre(String tipo) {
        System.out.print("Introduce el nombre del " + tipo + ": ");
        return scanner.nextLine();
    }

    public int leerAtributo(String atributo) {
        System.out.print("Introduce " + atributo + ": ");
        return scanner.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
