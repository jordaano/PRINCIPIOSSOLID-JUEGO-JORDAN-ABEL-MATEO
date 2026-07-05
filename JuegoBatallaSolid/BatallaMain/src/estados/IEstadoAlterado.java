package Estados;

import personajes.personaje;

public interface IEstadoAlterado {

    String getNombre();

    boolean aplicar(personaje personaje);

    void disminuirTurno();

    boolean terminado();
}
