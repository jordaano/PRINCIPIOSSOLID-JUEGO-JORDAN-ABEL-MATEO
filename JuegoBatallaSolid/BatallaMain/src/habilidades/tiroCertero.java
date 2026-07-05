package habilidades;

public class tiroCertero extends habilidad {

    public tiroCertero() {
        // Nombre, Costo de Energía, Cooldown Máximo (2 turnos), Cooldown Inicial (0 = Disponible)
        super("Tiro Certero", 15, 2, 0);
    }

    @Override
    protected int getMultiplicadorDanio() {
        return 2;
    }

    @Override
    protected String getMensajeUso() {
        return "apunta y dispara su habilidad especial";
    }
}
