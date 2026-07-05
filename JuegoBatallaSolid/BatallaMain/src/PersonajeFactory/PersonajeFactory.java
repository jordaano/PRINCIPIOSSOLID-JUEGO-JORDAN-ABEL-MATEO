package modelo;

public class PersonajeFactory {

    public static final int GUERRERO = 1;
    public static final int MAGO = 2;
    public static final int ARQUERO = 3;
    public static personaje crear(int tipo, String nombre, String id, int vida, int experiencia) {
        switch (tipo) {
            case GUERRERO:
                return new guerrero(nombre, id, vida, experiencia);
            case MAGO:
                return new mago(nombre, id, vida, experiencia);
            case ARQUERO:
                return new arquero(nombre, id, vida, experiencia);
            default:
                return null; 
        }
    }
}


