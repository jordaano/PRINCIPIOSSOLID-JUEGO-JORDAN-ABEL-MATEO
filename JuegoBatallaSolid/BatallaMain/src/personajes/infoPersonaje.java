/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personajes;

/**
 *
 * @author Jordann
 */
public class infoPersonaje {
    public void mostrarDatosBase(personaje p, String titulo) {
        System.out.println(titulo);
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("ID: " + p.getId());
        System.out.println("Vida: " + p.getVida());
        System.out.println("Experiencia: " + p.getExperiencia());
    }
}
