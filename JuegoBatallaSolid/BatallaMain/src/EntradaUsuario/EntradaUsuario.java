package controlador;

import java.util.Scanner;

public class EntradaUsuario {

    private final Scanner sc;

    public EntradaUsuario(Scanner sc) {
        this.sc = sc;
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        int valor = sc.nextInt();
        return valor;
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public void limpiarLinea() {
        sc.nextLine();
    }
}

