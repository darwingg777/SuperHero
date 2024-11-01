# Simulación de Batalla: Superhéroe vs Villano
// darwin garcia 192287, jordi hernadez 192283
Este programa simula una batalla entre un superhéroe y un villano, permitiendo a los usuarios ingresar sus atributos y luego observar cómo se desarrolla la pelea hasta que uno de los personajes gane.

## Clases y Funcionalidades

### Clase `Personaje`
La clase `Personaje` es la clase base para los personajes del juego (superhéroes y villanos). Contiene atributos y métodos comunes como:
- **Atributos:**
  - `nombre`: Nombre del personaje.
  - `fuerza`: Poder de ataque del personaje.
  - `velocidad`: Velocidad del personaje.
  - `vida_hp`: Vida (puntos de salud) del personaje.

- **Métodos:**
  - `atacar(Personaje oponente)`: Reduce la vida del oponente basado en la fuerza del personaje.
  - `defender(int daño)`: Reduce el daño recibido dividiéndolo por 2.
  - `mostrarEstadisticas()`: Muestra los atributos del personaje.
  - `recuperarse()`: Recupera 50 puntos de vida si la vida es mayor
