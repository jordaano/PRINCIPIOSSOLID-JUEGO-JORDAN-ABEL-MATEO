package menuBatalla;

import java.util.Scanner;
import personajes.personaje;
import personajes.arquero;
import personajes.guerrero;
import personajes.mago;
import habilidades.ataqueCritico;
import habilidades.hechizoEspecial;
import habilidades.tiroCertero;
import habilidades.sinEnergiaException;
import inventario.arma;
import inventario.armadura;

public class menuBatalla {

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("JUEGO BATALLA CAMPAL");
        System.out.println("====================");
        System.out.println("Cuantos luchadores desea ingresar");
        int n = sc.nextInt();
        System.out.println("CREACION DE PERSONAJES");
        System.out.println("======================");
        personaje[] listaPersonajes = new personaje[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nPersonaje " + (i + 1));
            System.out.println("1. Guerrero");
            System.out.println("2. Mago");
            System.out.println("3. Arquero");
            int opcion = sc.nextInt();
            sc.nextLine();

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Vida: ");
            int vida = sc.nextInt();
            System.out.print("Experiencia: ");
            int experiencia = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    guerrero g = new guerrero(nombre, id, vida, experiencia, new ataqueCritico());
                    arma espadaLarga = new arma("Espada Larga", 10, "Cortante");
                    armadura cota = new armadura("Cota de Malla", 8, "Física");
                    g.agregarObjeto(espadaLarga);
                    g.agregarObjeto(cota);
                    g.equipar(espadaLarga);
                    listaPersonajes[i] = g;
                    break;
                case 2:
                    mago m = new mago(nombre, id, vida, experiencia, new hechizoEspecial());
                    arma baston = new arma("Bastón Arcano", 12, "Mágico");
                    armadura robesMagicas = new armadura("Robes Mágicas", 5, "Mágica");
                    m.agregarObjeto(baston);
                    m.agregarObjeto(robesMagicas);
                    m.equipar(baston);
                    listaPersonajes[i] = m;
                    break;
                case 3:
                    arquero a = new arquero(nombre, id, vida, experiencia, new tiroCertero());
                    arma arcoElfo = new arma("Arco Élfico", 8, "Perforante");
                    armadura cuero = new armadura("Armadura de Cuero", 4, "Ligera");
                    a.agregarObjeto(arcoElfo);
                    a.agregarObjeto(cuero);
                    a.equipar(arcoElfo);
                    listaPersonajes[i] = a;
                    break;
                default:
                    System.out.println("Opción inválida");
                    i--;
            }
        }

        System.out.println("\n=================================");
        System.out.println("   INFORMACIÓN DE LOS LUCHADORES  ");
        System.out.println("=================================");

        for (int i = 0; i < listaPersonajes.length; i++) {
            System.out.print("[" + i + "] ");
            listaPersonajes[i].mostrarInfo();
            System.out.println("---------------------------------");
        }

        System.out.print("\nSeleccione el número del primer luchador: ");
        int p1 = sc.nextInt();
        System.out.print("Seleccione el número del segundo luchador: ");
        int p2 = sc.nextInt();

        personaje luchador1 = listaPersonajes[p1];
        personaje luchador2 = listaPersonajes[p2];

        System.out.println("\n===== INICIA LA BATALLA =====");

        while (luchador1.getVida() > 0 && luchador2.getVida() > 0) {
            luchador1.getHabilidadEspecial().reducirCooldown();
            ejecutarTurnoMenu(luchador1, luchador2, sc);
            System.out.println("\n-> STATUS: " + luchador2.getNombre() + " se queda con " + luchador2.getVida() + " PS.\n");
            if (luchador2.getVida() <= 0) {
                break;
            }
            luchador2.getHabilidadEspecial().reducirCooldown();
            ejecutarTurnoMenu(luchador2, luchador1, sc);
            System.out.println("\n-> STATUS: " + luchador1.getNombre() + " se queda con " + luchador1.getVida() + " PS.\n");
        }

        System.out.println("\n===== RESULTADO =====");
        if (luchador1.getVida() > 0) {
            System.out.println("Ganador: " + luchador1.getNombre());
            luchador1.subNivel();
        } else {
            System.out.println("Ganador: " + luchador2.getNombre());
            luchador2.subNivel();
        }
    }

    private void ejecutarTurnoMenu(personaje atacante, personaje enemigo, Scanner sc) {
        boolean accionRealizada = false;

        while (!accionRealizada) {
            System.out.println("==================================================");
            System.out.println("TURNO DE: " + atacante.getNombre().toUpperCase());
            System.out.println("Vida: " + atacante.getVida() + " | Energía: " + atacante.getEnergia());
            System.out.println("Habilidad Especial: " + atacante.getHabilidadEspecial().getNombre()
                    + " [CD Actual: " + atacante.getHabilidadEspecial().getCooldownAct() + "]");
            System.out.println("--------------------------------------------------");
            System.out.println("1. Realizar Ataque Normal");
            System.out.println("2. Utilizar Defender");
            System.out.println("3. Usar Habilidad Especial (Gasta Energía)");
            System.out.print("Seleccione su acción (1-3): ");

            int opcionAccion = sc.nextInt();
            System.out.println();

            switch (opcionAccion) {
                case 1:
                    atacante.atacar(enemigo);
                    accionRealizada = true;
                    break;
                case 2:
                    atacante.defender();
                    accionRealizada = true;
                    break;
                case 3:
                    try {
                        boolean exitoHabilidad = atacante.usarHabilidadEspecial(atacante.getHabilidadEspecial(), enemigo);
                        if (exitoHabilidad) {
                            accionRealizada = true;
                        } else {
                            System.out.println("Intenta con otra opción.");
                        }
                    } catch (sinEnergiaException e) {
                        System.out.println("¡ERROR! " + e.getMessage());
                        System.out.println("Elige una acción que no requiera tanta energía.");
                    }
                    break;
                default:
                    System.out.println("¡Opción inválida! Por favor, selecciona 1, 2 o 3.");
                    break;
            }
        }
    }
}
