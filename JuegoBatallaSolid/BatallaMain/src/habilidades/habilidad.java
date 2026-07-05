package habilidades;

import personajes.personaje;

public abstract class habilidad {
    protected String nombre;
    protected int costoEnergia;
    protected int cooldown;
    protected int cooldownAct;

    public habilidad(String nombre, int costoEnergia, int cooldown, int cooldownAct) {
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.cooldown = cooldown;
        this.cooldownAct = cooldownAct;
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre;
    }
    public int getCostoEnergia() { 
        return costoEnergia;
    }
    public void setCostoEnergia(int costoEnergia) { 
        this.costoEnergia = costoEnergia;
    }
    public int getCooldown() { 
        return cooldown; 
    }
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
    public int getCooldownAct() { 
        return cooldownAct;
    }
    public void setCooldownAct(int cooldownAct) { 
        this.cooldownAct = cooldownAct;
    }

    public void reducirCooldown() {
        if (cooldownAct > 0) {
            cooldownAct--;
        }
    }

    public boolean verificarAtaqueDisp() {
        return cooldownAct == 0;
    }

    // Método plantilla (Template Method): define el esqueleto del ataque especial.
    // Los pasos variables (multiplicador y mensaje) los definen las subclases.
    public final void ataqueEspecial(personaje usuario, personaje enemigo) {
        int dano = usuario.getPoderEspecial() * getMultiplicadorDanio();
        System.out.println("¡" + usuario.getNombre() + " " + getMensajeUso() + ": " + nombre + "!");
        enemigo.setVida(enemigo.getVida() - dano);
        this.setCooldownAct(this.getCooldown());
    }

    protected abstract int getMultiplicadorDanio();
    protected abstract String getMensajeUso();
}
