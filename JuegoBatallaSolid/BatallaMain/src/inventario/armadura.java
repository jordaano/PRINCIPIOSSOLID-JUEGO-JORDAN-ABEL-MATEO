package inventario;

/**
 * Clase que representa a las armaduras en el inventario.
 * Hereda de Objeto y sobrescribe getModificadorDefensa() para proveer reducción de daño.
 */
public class armadura extends Objeto {
    private String tipoDefensa; // Ej: "Física", "Mágica", "Ligera"

    public armadura(String nombre, int modificador, String tipoDefensa) {
        super(nombre, modificador);
        this.tipoDefensa = tipoDefensa;
    }

    public String getTipoDefensa() {
        return tipoDefensa;
    }

    @Override
    public int getModificadorDefensa() {
        return modificador;
    }

    @Override
    public void descripcion() {
        System.out.println("  - [Armadura] " + nombre + " (Defensa +" + modificador + ", Tipo: " + tipoDefensa + ")");
    }
}
