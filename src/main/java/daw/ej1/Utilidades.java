/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ej1;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Enrique
 */
public class Utilidades {

    private static Scanner teclado = new Scanner(System.in);
    private static Random aleatorio = new Random();

    public static int intAleatorio(int min, int max) {
        int num = aleatorio.nextInt(max - min + 1) + min;

        return num;
    }

    public static int leerEnteroRango(int min, int max) {
        System.out.println("¿Cuál es el número?");
        int num;

        do {
            try {
                num = teclado.nextInt();
            } catch (InputMismatchException e) {
                num = min - 1;
                teclado.nextLine();
            }
        } while (num < min || num > max);

        return num;
    }

    public static int calcularYear(LocalDate fecha) {
        LocalDate hoy = LocalDate.now();
        int aniosTranscurridos = 0;

        if (fecha.isAfter(hoy)) {
            aniosTranscurridos = -1;
        } else {
            aniosTranscurridos = hoy.getYear() - fecha.getYear();
        }

        return aniosTranscurridos;
    }
}
