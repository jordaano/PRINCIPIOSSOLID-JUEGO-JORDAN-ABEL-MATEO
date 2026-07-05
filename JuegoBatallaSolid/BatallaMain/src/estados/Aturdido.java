package Estados;

import personajes.personaje;

public class Aturdido implements IEstadoAlterado {

    private int turnos;

    public Aturdido(int turnos) {
        this.turnos = turnos;
    }

    @Override
    public String getNombre() {
        return "Aturdido";
    }

    @Override
    public boolean aplicar(personaje p) {
        System.out.println("[EFECTO] " + p.getNombre() + " está aturdido y pierde el turno.");
        return false;
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
