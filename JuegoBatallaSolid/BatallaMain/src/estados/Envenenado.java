package Estados;

import personajes.personaje;

public class Envenenado implements IEstadoAlterado {

    private int turnos;

    public Envenenado(int turnos) {
        this.turnos = turnos;
    }

    @Override
    public String getNombre() {
        return "Envenenado";
    }

    @Override
    public boolean aplicar(personaje p) {
        p.setVida(p.getVida() - 8);
        System.out.println("[EFECTO] " + p.getNombre() + " pierde 8 de vida por Veneno. (Vida: " + p.getVida() + ")");
        return true;
    }

    @Override
    public void disminuirTurno() {
        turnos--;
    }

    @Override
    public boolean terminado() {
        return turnos <= 0;
    }
}
