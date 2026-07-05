package habilidades;

public class ataqueCritico extends habilidad {

    public ataqueCritico() {
        // Nombre, Costo de Energía, Cooldown Máximo (2 turnos), Cooldown Inicial (0 = Disponible)
        super("Ataque Critico", 20, 2, 0);
    }

    @Override
    protected int getMultiplicadorDanio() {
        return 2;
    }

    @Override
    protected String getMensajeUso() {
        return "usa su habilidad especial";
    }
}
