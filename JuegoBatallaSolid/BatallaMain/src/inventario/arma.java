package inventario;

/**
 * Clase que representa a las armas en el inventario.
 * Hereda de Objeto y sobrescribe getModificadorAtaque() para proveer daño adicional.
 */
public class arma extends Objeto {
    private String tipoDano; // Ej: "Cortante", "Mágico", "Perforante"

    public arma(String nombre, int modificador, String tipoDano) {
        super(nombre, modificador);
        this.tipoDano = tipoDano;
    }

    public String getTipoDano() {
        return tipoDano;
    }

    @Override
    public int getModificadorAtaque() {
        return modificador;
    }

    @Override
    public void descripcion() {
        System.out.println("  - [Arma] " + nombre + " (Daño +" + modificador + ", Tipo: " + tipoDano + ")");
    }
}
