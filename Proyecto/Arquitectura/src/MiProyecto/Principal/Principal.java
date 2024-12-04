import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Principal {
    public static void main(String[] args) {
        Presentacion presentacion = new Presentacion();
        SuperHeroe heroe = null;
        Villano villano = null;

        // Cargar personajes si existen
        try {
            FileInputStream fileIn = new FileInputStream("personajes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            heroe = (SuperHeroe) in.readObject();
            villano = (Villano) in.readObject();
            in.close();
            fileIn.close();
            presentacion.mostrarMensaje("Personajes cargados exitosamente.");
        } catch (IOException | ClassNotFoundException e) {
            presentacion.mostrarMensaje("No se encontraron personajes guardados. Creando nuevos personajes.");
        }

        // Si no se cargaron personajes, pedir datos al usuario
        if (heroe == null) {
            presentacion.mostrarMensaje("Introduce los datos del superhéroe:");
            String nombreHeroe = presentacion.leerNombre("superhéroe");
            int fuerzaHeroe = presentacion.leerAtributo("Fuerza");
            int velocidadHeroe = presentacion.leerAtributo("Velocidad");
            int vidaHeroe = presentacion.leerAtributo("Vida HP");
            int poderEspecial = presentacion.leerAtributo("Poder Especial"); // Cambiado para incluir poder especial
            heroe = new SuperHeroe(nombreHeroe, vidaHeroe, fuerzaHeroe, poderEspecial);
        }

        if (villano == null) {
            presentacion.mostrarMensaje("Introduce los datos del villano:");
            String nombreVillano = presentacion.leerNombre("villano");
            int fuerzaVillano = presentacion.leerAtributo("Fuerza");
            int velocidadVillano = presentacion.leerAtributo("Velocidad");
            int vidaVillano = presentacion.leerAtributo("Vida HP");
            int debilidad = presentacion.leerAtributo("Debilidad");
            villano = new Villano(nombreVillano, vidaVillano, fuerzaVillano, debilidad);
        }

        LogicaBatalla logicaBatalla = new LogicaBatalla(heroe, villano);
        presentacion.mostrarMensaje("-------¡COMIENZA LA BATALLA!-------");
        logicaBatalla.iniciarBatalla();

        // Guardar personajes al final de la batalla
        try {
            FileOutputStream fileOut = new FileOutputStream("personajes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(heroe);
            out.writeObject(villano);
            out.close();
            fileOut.close();
            presentacion.mostrarMensaje("Personajes guardados exitosamente.");
        } catch (IOException e) {
            presentacion.mostrarMensaje("Error al guardar personajes.");
        }

        presentacion.cerrarScanner();
    }
}