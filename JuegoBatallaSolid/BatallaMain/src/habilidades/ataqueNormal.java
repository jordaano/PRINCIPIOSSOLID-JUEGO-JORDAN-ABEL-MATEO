package habilidades;

import personajes.personaje;

public class ataqueNormal implements IAtaque {

    @Override
    public void ejecutar(personaje enemigo, int danioTotal, String mensajeAccion) {
        System.out.println(mensajeAccion);
        enemigo.setVida(enemigo.getVida() - danioTotal);
        System.out.println("  Daño causado: " + danioTotal);
    }
}
