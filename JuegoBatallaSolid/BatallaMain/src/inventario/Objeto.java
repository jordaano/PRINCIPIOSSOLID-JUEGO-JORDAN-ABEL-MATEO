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

    public int getModificadorAtaque() {
        return 0;
    }

    public int getModificadorDefensa() {
        return 0;
    }

    public abstract void descripcion();
}
