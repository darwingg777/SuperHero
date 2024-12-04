# Simulación de Batalla: Superhéroe vs Villano

Este programa simula una batalla entre un superhéroe y un villano, permitiendo a los usuarios ingresar sus atributos y luego observar cómo se desarrolla la pelea hasta que uno de los personajes gane.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Clases y Funcionalidades](#clases-y-funcionalidades)
- [Uso](#uso)
- [Requisitos](#requisitos)
- [Cómo Ejecutar](#cómo-ejecutar)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Descripción

Este programa permite a los usuarios crear un superhéroe y un villano, especificando sus atributos como fuerza, velocidad y vida. Luego, se simula una batalla en la que ambos personajes se atacan hasta que uno de ellos es derrotado. 

## Características

- Creación de personajes personalizados (superhéroe y villano).
- Simulación de una batalla por turnos.
- Carga y guardado de personajes para futuras batallas.
- Mensajes informativos durante la batalla.

## Clases y Funcionalidades

### Clase `Personaje` (Interfaz)
Define los métodos comunes para los personajes en la batalla.

### Clase `Villano`
Implementa la interfaz `Personaje` y define los atributos y métodos específicos para los villanos.

### Clase `SuperHeroe`
Implementa la interfaz `Personaje` y define los atributos y métodos específicos para los superhéroes.

### Clase `Presentacion`
Maneja la interacción con el usuario, facilitando la entrada de datos y la visualización de mensajes.

### Clase `LogicaBatalla`
Controla la lógica de la batalla entre el héroe y el villano, gestionando los turnos de ataque.

### Clase `Principal`
Clase principal que ejecuta el programa, cargando personajes y coordinando la batalla.

## Uso

1. Ejecuta el programa.
2. Ingresa los atributos del superhéroe y del villano cuando se te solicite.
3. Observa cómo se desarrolla la batalla en la consola.
4. Al finalizar, los personajes se guardarán automáticamente para su uso futuro.

## Requisitos

- Java JDK 8 o superior.
- Un IDE o editor de texto para ejecutar el código (opcional, pero recomendado).

## Cómo Ejecutar

1. Clona este repositorio o descarga los archivos.
2. Abre una terminal y navega hasta el directorio del proyecto.
3. Compila el programa con el siguiente comando:
   ```bash
   javac src/MiProyecto/Principal/Principal.java