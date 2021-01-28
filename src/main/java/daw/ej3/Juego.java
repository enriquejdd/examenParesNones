/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ej3;

import daw.ej1.Utilidades;
import daw.ej2.Jugador;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Enrique
 */
public class Juego {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        final int k = 6; // Número de rondas.
        ArrayList<Character> Victorias = new ArrayList<>();

        // Creamos al jugador con los parámetros obtenidos.
        Jugador J = new Jugador(leerNombre(), leerApe(), LocalDate.of(leerAño(), leerMes(), leerDia()), leerParesNones());
        Jugador M = new Jugador();

//        System.out.println("");
//        System.out.println(J.toString());
//        System.out.println("");
//        System.out.println(M.toString());
//        System.out.println("Cantidad de jugadores creados: " + Jugador.contador);
        System.out.println("");
        System.out.println(J.toString());
        System.out.println("");
        for (int i = 0; i < k; i++) {
            int dedosJugador = J.sacarDedos();
            System.out.println("");
            System.out.println("El jugador sacó: " + dedosJugador);

            int dedosMaquina = Juego.sacarDedosMaquina();
            System.out.println("");
            System.out.println("La máquina sacó: " + dedosMaquina);

            if (J.isEsPar()) {
                if (dedosJugador % 2 == 0) {
                    System.out.println("");
                    System.out.println("El ganador es el jugador");
                    Victorias.add('J');
                } else {
                    System.out.println("");
                    System.out.println("El ganador es la máquina");
                    Victorias.add('M');
                }
            } else {
                if (dedosJugador % 2 == 1) {
                    System.out.println("");
                    System.out.println("El ganador es el jugador");
                    Victorias.add('J');
                } else {
                    System.out.println("");
                    System.out.println("El ganador es la máquina");
                    Victorias.add('M');
                }
            }
        }

        int contadorVictoriasJugador = 0;
        Victorias.forEach(System.out::println);
        for (int i = 0; i < Victorias.size(); i++) {
            if (Victorias.get(i) == 'J') {
                System.out.println("El jugador ganó la ronda: " + (i + 1));
                System.out.println("");
                contadorVictoriasJugador++;
            }
        }

        if (contadorVictoriasJugador > (k - contadorVictoriasJugador)) {
            System.out.println("El ganador es el jugador");
        } else if (contadorVictoriasJugador < (k - contadorVictoriasJugador)) {
            System.out.println("El ganador es la maquina");
        } else {
            System.out.println("El ganador es la maquina");
        }
    }

    private static int leerDia() {
        System.out.println("");
        System.out.println("Día");
        int dia = Utilidades.leerEnteroRango(1, 31);

        return dia;
    }

    private static int leerMes() {
        System.out.println("");
        System.out.println("Mes");
        int mes = Utilidades.leerEnteroRango(1, 12);

        return mes;
    }

    private static int leerAño() {
        System.out.println("");
        System.out.println("Año");
        int anio = Utilidades.leerEnteroRango(1900, LocalDate.now().getYear());

        return anio;
    }

    private static String leerNombre() {
        System.out.println("");
        System.out.println("¿Cómo se llama?");
        String nombre = teclado.nextLine();

        return nombre;
    }

    private static String leerApe() {
        System.out.println("");
        System.out.println("¿Cuál es su apellido?");
        String apellido = teclado.nextLine();

        return apellido;
    }

    private static boolean leerParesNones() {
        boolean esPar = true;
        System.out.println("");
        System.out.println("Pares/Nones - 1/2");
        int paresNones = Utilidades.leerEnteroRango(1, 2);
        if (paresNones == 2) {
            esPar = false;
        }

        return esPar;
    }

    public static int sacarDedosMaquina() {
        int numObtenido = Utilidades.intAleatorio(0, 10);
        return numObtenido;
    }

}
