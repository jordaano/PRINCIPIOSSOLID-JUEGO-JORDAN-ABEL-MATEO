package habilidades;

import personajes.personaje;

/**
 * Interfaz de estrategia para la acción de "ataque normal".
 * Permite aplicar DIP: los personajes dependen de esta abstracción,
 * no de la clase concreta ataqueNormal.
 */
public interface IAtaque {
    void ejecutar(personaje enemigo, int danioTotal, String mensajeAccion);
}
