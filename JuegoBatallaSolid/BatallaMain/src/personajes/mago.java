package personajes;

import java.util.ArrayList;

public class mago extends personaje {

    private int magia;
    private ArrayList<Objeto> inventario;
    private Objeto objetoEquipado;

    public mago(String nombre, String id, int vida, int experiencia, habilidad habilidadEspecial) {
        super(nombre, id, vida, experiencia, habilidadEspecial);
        this.magia = 20;
        this.inventario = new ArrayList<>();
        this.objetoEquipado = null;
    }

    // NUEVO: agrega un objeto al inventario
    public void agregarObjeto(Objeto o) {
        inventario.add(o);
        System.out.println(nombre + " recibió en su inventario: " + o.getNombre());
    }

    // NUEVO: equipa un objeto del inventario
    public void equipar(Objeto o) {
        if (inventario.contains(o)) {
            this.objetoEquipado = o;
            System.out.println(nombre + " equipó: " + o.getNombre());
        } else {
            System.out.println("El objeto no está en el inventario de " + nombre);
        }
    }

    @Override
    public void atacar(personaje enemigo) {
        int danioTotal = magia;

        if (objetoEquipado instanceof arma) {
            danioTotal += objetoEquipado.getModificador();
            System.out.println(nombre + " lanza un hechizo potenciado con " + objetoEquipado.getNombre());
        } else {
            System.out.println(nombre + " lanza un hechizo.");
        }

        enemigo.vida -= danioTotal;
        System.out.println("  Daño causado: " + danioTotal);
    }

    @Override
    public void defender() {
        if (objetoEquipado instanceof armadura) {
            System.out.println(nombre + " crea un escudo mágico reforzado con "
                    + objetoEquipado.getNombre()
                    + " (reduce " + objetoEquipado.getModificador() + " de daño)");
        } else {
            System.out.println(nombre + " crea un escudo mágico.");
        }
    }

    @Override
    public void mostrarInfo() {
        System.out.println("MAGO");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Vida: " + vida);
        System.out.println("Experiencia: " + experiencia);

        System.out.println("Inventario (" + inventario.size() + " objeto/s):");
        if (inventario.isEmpty()) {
            System.out.println("  (vacío)");
        } else {
            for (Objeto o : inventario) {
                o.descripcion();
            }
        }

        System.out.println("Equipado: "
                + (objetoEquipado != null ? objetoEquipado.getNombre() : "Ninguno"));
    }

    @Override
    public void subNivel() {
        nivel += 1;
        experiencia += 10;
        vida += 15;
        magia += 10;
        System.out.println(nombre + " subió de nivel. NIVEL " + nivel);
    }

    @Override
    public int getPoderEspecial() {
        return magia;
    }
}