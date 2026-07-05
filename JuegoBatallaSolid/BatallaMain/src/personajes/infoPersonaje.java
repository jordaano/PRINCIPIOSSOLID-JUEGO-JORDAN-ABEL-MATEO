package personajes;

public class infoPersonaje {
    public void mostrarDatosBase(personaje p, String titulo) {
        System.out.println(titulo);
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("ID: " + p.getId());
        System.out.println("Vida: " + p.getVida());
        System.out.println("Experiencia: " + p.getExperiencia());
    }
}
