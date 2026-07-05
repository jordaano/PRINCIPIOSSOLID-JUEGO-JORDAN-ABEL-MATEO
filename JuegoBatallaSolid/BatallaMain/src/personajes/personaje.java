package personajes;

import habilidades.habilidad;
import habilidades.SinEnergiaException;

/**
 * Clase base para todos los personajes del juego.
 */
public abstract class personaje {

    private static final int ENERGIA_INICIAL = 100;

    private String nombre;
    private final String id;
    private int vida;
    private int experiencia;
    private int nivel;
    private int energia;
    private habilidad habilidadEspecial;

    public personaje(String nombre, String id, int vida, int experiencia,
            habilidad habilidadEspecial) {

        this.nombre = nombre;
        this.id = id;
        this.vida = vida;
        this.experiencia = experiencia;
        this.nivel = 1;
        this.energia = ENERGIA_INICIAL;
        this.habilidadEspecial = habilidadEspecial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = Math.max(0, vida);
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = Math.max(0, experiencia);
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = Math.max(1, nivel);
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = Math.max(0, energia);
    }

    public habilidad getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public void setHabilidadEspecial(habilidad habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
    }

    public boolean usarHabilidadEspecial(Personaje enemigo)
            throws SinEnergiaException {

        if (energia < habilidadEspecial.getCostoEnergia()) {
            throw new SinEnergiaException(
                    nombre + " no tiene suficiente energía. Requiere "
                    + habilidadEspecial.getCostoEnergia() + " de energía.");
        }

        if (!habilidadEspecial.verificarAtaqueDisp()) {

            System.out.println("La habilidad "
                    + habilidadEspecial.getNombre()
                    + " está en cooldown. Faltan "
                    + habilidadEspecial.getCooldownAct()
                    + " turnos.");

            return false;
        }

        energia -= habilidadEspecial.getCostoEnergia();

        habilidadEspecial.ataqueEspecial(this, enemigo);

        habilidadEspecial.setCooldownAct(habilidadEspecial.getCooldown());

        return true;
    }

    public abstract void atacar(Personaje enemigo);

    public abstract void defender();

    public abstract void subirNivel();

    public abstract void mostrarInfo();

    public abstract int getPoderEspecial();

}