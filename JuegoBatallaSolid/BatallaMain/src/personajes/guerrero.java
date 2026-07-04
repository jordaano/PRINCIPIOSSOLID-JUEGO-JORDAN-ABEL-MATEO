package personajes;

import habilidades.ataqueNormal;
import habilidades.defensaNormal;
import habilidades.habilidad;
import inventario.Objeto;
import inventario.arma;
import inventario.armadura;
import java.util.ArrayList;


public class guerrero extends personaje {

    private int fuerza;
    private ArrayList<Objeto> inventario;
    private Objeto objetoEquipado;
    
    private final ataqueNormal accionAtaque = new ataqueNormal();
    private final defensaNormal accionDefensa = new defensaNormal();
    private final infoPersonaje info = new infoPersonaje();
    
    public guerrero(String nombre, String id, int vida, int experiencia, habilidad habilidadEspecial) {
        super(nombre, id, vida, experiencia, habilidadEspecial);
        this.fuerza = 15;
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
        int danioTotal = fuerza;
        String mensaje;
 
        if (objetoEquipado instanceof arma) {
            danioTotal += objetoEquipado.getModificador();
            mensaje = nombre + " ataca con espada y " + objetoEquipado.getNombre();
        } else {
            mensaje = nombre + " ataca con espada";
        }
        accionAtaque.ejecutar(enemigo, danioTotal, mensaje);
    }

        @Override
        public void defender() {
            String mensaje;

            if (objetoEquipado instanceof armadura) {
                mensaje = nombre + " bloquea con escudo y "
                        + objetoEquipado.getNombre()
                        + " (reduce " + objetoEquipado.getModificador() + " de daño)";
            } else {
                mensaje = nombre + " bloquea con escudo.";
            }

            accionDefensa.ejecutar(mensaje);
        }
    

    @Override
    public void mostrarInfo() {
        info.mostrarDatosBase(this, "GUERRERO");
 
        // Parte propia del guerrero: inventario y equipamiento
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

        System.out.println("Equipado: "
                + (objetoEquipado != null ? objetoEquipado.getNombre() : "Ninguno"));
    }

    @Override
    public void subNivel() {
        nivel += 1;
        experiencia += 10;
        vida += 20;
        fuerza += 5;
        System.out.println(nombre + " subió de nivel. NIVEL " + nivel);
    }

    @Override
    public int getPoderEspecial() {
        return fuerza;
    }
}
