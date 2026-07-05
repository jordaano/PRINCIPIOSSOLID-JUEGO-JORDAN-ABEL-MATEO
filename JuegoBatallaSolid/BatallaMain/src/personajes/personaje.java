package personajes;

import habilidades.habilidad;
import habilidades.sinEnergiaException;

public abstract class personaje {
    protected String nombre;
    protected String id;
    protected int vida;
    protected int experiencia;
    protected int nivel;
    protected int energia;
    protected habilidad habilidadEspecial;

    public personaje(String nombre, String id, int vida, int experiencia, habilidad habilidadEspecial) {
        this.nombre = nombre;
        this.id = id;
        this.vida = vida;
        this.experiencia = experiencia;
        this.nivel = 1;
        this.energia = 100;
        this.habilidadEspecial = habilidadEspecial;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }
    public int getExperiencia() { return experiencia; }
    public void setExperiencia(int experiencia) { this.experiencia = experiencia; }
    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }
    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = energia; }
    public habilidad getHabilidadEspecial() { return habilidadEspecial; }

    public boolean usarHabilidadEspecial(habilidad hab, personaje enemigo) throws sinEnergiaException {
        if (energia < hab.getCostoEnergia()) {
            throw new sinEnergiaException(nombre + " no tiene suficiente energía. Requiere " + hab.getCostoEnergia() + " de energía.");
        }
        if (!hab.verificarAtaqueDisp()) {
            System.out.println("¡La habilidad [" + hab.getNombre() + "] está en cooldown! Faltan " + hab.getCooldownAct() + " turnos.");
            return false;
        }
        energia -= hab.getCostoEnergia();
        hab.ataqueEspecial(this, enemigo);
        hab.setCooldownAct(hab.getCooldown());
        return true;
    }

    public abstract void atacar(personaje enemigo);
    public abstract void defender();
    public abstract void subNivel();
    public abstract void mostrarInfo();
    public abstract int getPoderEspecial();
}
