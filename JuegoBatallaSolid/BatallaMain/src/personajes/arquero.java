package personajes;

import habilidades.ataqueNormal;
import habilidades.defensaNormal;
import habilidades.habilidad;
import inventario.Objeto;
import java.util.ArrayList;

public class arquero extends personaje {
    private int precision;
    private ArrayList<Objeto> inventario;
    private Objeto objetoEquipado;
    private final ataqueNormal accionAtaque = new ataqueNormal();
    private final defensaNormal accionDefensa = new defensaNormal();
    private final infoPersonaje info = new infoPersonaje();

    public arquero(String nombre, String id, int vida, int experiencia, habilidad habilidadEspecial) {
        super(nombre, id, vida, experiencia, habilidadEspecial);
        this.precision = 10;
        this.inventario = new ArrayList<>();
        this.objetoEquipado = null;
    }

    public void agregarObjeto(Objeto o) {
        inventario.add(o);
        System.out.println(nombre + " recibió en su inventario: " + o.getNombre());
    }

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
        int modAtaque = (objetoEquipado != null) ? objetoEquipado.getModificadorAtaque() : 0;
        int danioTotal = precision + modAtaque;
        String mensaje = (modAtaque > 0)
                ? nombre + " dispara una flecha con " + objetoEquipado.getNombre()
                : nombre + " dispara una flecha.";
        accionAtaque.ejecutar(enemigo, danioTotal, mensaje);
    }

    @Override
    public void defender() {
        int modDefensa = (objetoEquipado != null) ? objetoEquipado.getModificadorDefensa() : 0;
        String mensaje = (modDefensa > 0)
                ? nombre + " esquiva el ataque con agilidad gracias a " + objetoEquipado.getNombre() + " (reduce " + modDefensa + " de daño)"
                : nombre + " esquiva el ataque.";
        accionDefensa.ejecutar(mensaje);
    }

    @Override
    public void mostrarInfo() {
        info.mostrarDatosBase(this, "ARQUERO");
        System.out.println("Inventario (" + inventario.size() + " objeto/s):");
        if (inventario.isEmpty()) {
            System.out.println("  (vacío)");
        } else {
            for (Objeto o : inventario) {
                o.descripcion();
            }
        }
        System.out.println("Equipado: " + (objetoEquipado != null ? objetoEquipado.getNombre() : "Ninguno"));
    }

    @Override
    public void subNivel() {
        nivel += 1;
        experiencia += 10;
        vida += 10;
        precision += 5;
        System.out.println(nombre + " subió de nivel. NIVEL " + nivel);
    }

    @Override
    public int getPoderEspecial() {
        return precision;
    }
}
