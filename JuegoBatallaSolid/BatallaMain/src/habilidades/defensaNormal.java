package habilidades;

public class defensaNormal implements IDefensa {

    @Override
    public void ejecutar(String mensajeAccion) {
        System.out.println(mensajeAccion);
    }
}
