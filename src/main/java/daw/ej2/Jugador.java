/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daw.ej2;

import daw.ej1.Utilidades;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Enrique
 */
public class Jugador {

    private String nombre;
    private String apellido;
    private LocalDate fecNacimiento;
    private boolean esPar;
    public static int contador = 0;

    public Jugador() {
        this.nombre = "Jose";
        this.apellido = "García Moreno";
        this.fecNacimiento = LocalDate.of(1997, Month.APRIL, 27);
        this.esPar = true;
        contador++;
    }

    public Jugador(String nombre, String apellido, LocalDate fecNacimiento, boolean esPar) {
        if (fecNacimiento.getYear() < 18 && fecNacimiento == null) {
            this.nombre = "Jose";
            this.apellido = "García Moreno";
            this.fecNacimiento = LocalDate.of(1997, Month.APRIL, 27);
            this.esPar = true;
        } else {
            this.nombre = nombre;
            this.apellido = apellido;
            this.fecNacimiento = fecNacimiento;
            this.esPar = esPar;
        }
        contador++;
    }

    public static Jugador clonar(Jugador persona) {
        Jugador copia = new Jugador(persona.nombre, persona.apellido, persona.fecNacimiento, persona.esPar);
        return copia;
    }

    public Jugador(Jugador persona) {
        this(persona.nombre, persona.apellido, persona.fecNacimiento, persona.esPar);
    }

    @Override
    public String toString() {
        if (esPar == true) {
            return "Nombre: " + nombre + "\tApellidos: " + apellido + "\nFecha: " + fecNacimiento.getDayOfMonth() + "/" + fecNacimiento.getMonthValue() + "/" + fecNacimiento.getYear() + "\tElección:[Pares]";
        } else {
            return "Nombre: " + nombre + "\tApellidos: " + apellido + "\nFecha: " + fecNacimiento.getDayOfMonth() + "/" + fecNacimiento.getMonthValue() + "/" + fecNacimiento.getYear() + "\tElección:[Nones]";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(LocalDate fecNacimiento) {
        if (fecNacimiento.getYear() < 18) {
            this.fecNacimiento = LocalDate.of(1997, Month.APRIL, 27);
        } else {
            this.fecNacimiento = fecNacimiento;
        }

    }

    public boolean isEsPar() {
        return esPar;
    }

    public void setEsPar(boolean esPar) {
        this.esPar = esPar;
    }

    public int getContador() {
        return contador;
    }

    public int getEdad(Jugador persona) {
        int edad = Utilidades.calcularYear(persona.getFecNacimiento());

        return edad;
    }

    public int sacarDedos() {
        int numObtenido = Utilidades.intAleatorio(0, 10);

        return numObtenido;
    }

}
