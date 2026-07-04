package habilidades;

public class hechizoEspecial extends habilidad {

    public hechizoEspecial() { 
        // Nombre, Costo de Energía, Cooldown Máximo (3 turnos), Cooldown Inicial (0 = Disponible)
        super("Hechizo Especial", 30, 3, 0);
    }

    @Override
    protected int getMultiplicadorDanio() {
        return 2;
    }

    @Override
    protected String getMensajeUso() {
        return "lanza su habilidad especial";
    }

}