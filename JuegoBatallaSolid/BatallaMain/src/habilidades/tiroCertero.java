package habilidades;

public class tiroCertero extends habilidad {

    public tiroCertero() { 
        // Nombre, Costo de Energía, Cooldown Máximo (1 turno), Cooldown Inicial (0 = Disponible)
        super("Tiro Certero", 15, 1, 0);
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