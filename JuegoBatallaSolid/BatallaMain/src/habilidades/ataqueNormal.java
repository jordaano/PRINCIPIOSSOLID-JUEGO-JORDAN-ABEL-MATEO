/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package habilidades;

import personajes.personaje;

/**
 *
 * @author Jordann
 */
public class ataqueNormal implements IAtaque {
    
    public void ejecutar(personaje enemigo, int danioTotal, String mensajeAccion) {
        System.out.println(mensajeAccion);
        enemigo.setVida(enemigo.getVida() - danioTotal);
        System.out.println("  Daño causado: " + danioTotal);
    }
    
}
