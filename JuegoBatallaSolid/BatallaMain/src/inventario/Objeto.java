package inventario;

/**
 * Clase abstracta que representa a cualquier objeto del inventario en el juego.
 * Sigue el principio SOLID OCP al permitir la extensión para nuevos tipos de objetos
 * y LSP al proveer métodos polimórficos de modificación de estadísticas.
 */
public abstract class Objeto {
    protected String nombre;
    protected int modificador;

    public Objeto(String nombre, int modificador) {
        this.nombre = nombre;
        this.modificador = modificador;
    }

    public String getNombre() {
        return nombre;
    }

    public int getModificador() {
        return modificador;
    }

    /**
     * Devuelve el modificador de ataque otorgado por este objeto.
     * Por defecto es 0, a menos que la subclase (como arma) lo sobrescriba.
     */
    public int getModificadorAtaque() {
        return 0;
    }

    /**
     * Devuelve el modificador de defensa/reducción otorgado por este objeto.
     * Por defecto es 0, a menos que la subclase (como armadura) lo sobrescriba.
     */
    public int getModificadorDefensa() {
        return 0;
    }

    /**
     * Muestra la descripción detallada del objeto por consola.
     */
    public abstract void descripcion();
}
