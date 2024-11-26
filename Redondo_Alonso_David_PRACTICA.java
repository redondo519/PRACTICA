/*
Redondo, Alonso, David
*/


import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class Redondo_Alonso_David_PRACTICA {
    public static void main(String[] args) {
        //Creacion de escaner para la lectura de los datos
        Scanner scanner = new Scanner(System.in);
        //Creacion de objeto random para la generacion de datos atleatorios (turno, y decisiones jugador2)
        Random random = new Random();

        //Declaracion de variables
        int canicasJugador1 = 10;       //Jugador1 cuenta con 10 canicas inicialmente
        int canicasJugador2 = 10;       //Jugador2 cuenta con 10 canicas inicialmente


        //se decide el turno: devuelve true = turno jugador 1 / false= turno jugador 2
        boolean turnoJugador1 = random.nextBoolean();

        //Inicio del juego antes de comenzar bucle
        System.out.println("Comienza el juego");

        //bucle se ejecuta mientras los jugadores tengan canicas.
        while (canicasJugador1 > 0 && canicasJugador2 > 0) {
            System.out.println(); //separador en blanco

            //se crea una variable que almacena la apuesta entera del jugador, Esta no podra superar el numero de canicas de ninguno de los jugadores
            int apuestaJugador, apuestaMaxima = Math.min(canicasJugador1, canicasJugador2);     //Math.min : el menor de (canicasJugador1 - canicasJugador2)

            //el bucle comienza con turno jugaador 1 o 2 en funcion de variable boolean.
            if (turnoJugador1) {
                // Turno del jugador 1 (humano)

                System.out.println("************* TURNO JUGADOR 1 *************");

                        System.out.print("Jugador 1, ¿cuántas canicas quieres apostar?: ");
                        apuestaJugador = scanner.nextInt();

                        //bucle dentro turnoJ1 para control de apuesta
                        while (apuestaJugador < 1 || apuestaJugador > apuestaMaxima) {
                            System.out.println("Número inválido. Puedes apostar entre 1 y " + apuestaMaxima + " canicas.");
                            System.out.print("Intenta nuevamente: ");
                            apuestaJugador = scanner.nextInt();
                        }


                //Se pide eleccion par/impar
                System.out.print("Jugador 1, ¿qué crees que tiene el Jugador 2? (par/impar): ");
                String eleccion = scanner.next().toLowerCase(); //cambia la entrada a minusculas

                //Control de entrada para siempre sea par/impar (con o sin mayusculas) Ejemplo: "inlpar" o "2" no es aceptado.
                while (!eleccion.equals("par") && !eleccion.equals("impar")) {
                    System.out.print("Entrada inválida. Escribe 'par' o 'impar': ");
                    eleccion = scanner.next().toLowerCase();
                }

                //Las canicas ocultas del Jugador 2 se generarn atleatoriamente
                int canicasOcultasJugador2 = random.nextInt(apuestaMaxima) + 1;     //Numero entre 1 y apuesta maxima (rango incluyente)

                //Almacenamiento si esPar o no: true/false
                boolean esPar = canicasOcultasJugador2 % 2 == 0;

                System.out.println("\nResultado");  // '\n' para salto de linea

                //Comprobaciones eleccion jugador con realidad esPar
                //Si esPar y Jugador dijo "par" o esPar==false y jugador dijo "impar" Jugador1 GANA
                if ((esPar && eleccion.equals("par")) || (!esPar && eleccion.equals("impar"))) {
                    System.out.println("Jugador 1 GANAS " + apuestaJugador + " canicas ya que el Jugador 2 tenía " + canicasOcultasJugador2 + " canicas.");
                    canicasJugador1 += apuestaJugador;
                    canicasJugador2 -= apuestaJugador;

                    //Condicion para perdida jugador 1
                } else {
                    System.out.println("Jugador 1 PIERDES " + apuestaJugador + " canicas ya que el Jugador 2 tenía " + canicasOcultasJugador2 + " canicas.");
                    canicasJugador1 -= apuestaJugador;
                    canicasJugador2 += apuestaJugador;
                }

                //Si turnojugador1 == false
            } else {
                // Turno del jugador 2 (ordenador)
                System.out.println("************* TURNO JUGADOR 2 *************");
                apuestaJugador = random.nextInt(apuestaMaxima) + 1;              //La apuesta generada atleatoriamente no puede superar apuestamaxima
                String eleccion = random.nextBoolean() ? "par" : "impar";        //La eleccion par/impar se genera atleatoriamente.

                //Se pregunta de igual manera la apuesta del jugador1
                System.out.print("Jugador 1, ¿cuántas canicas quieres apostar?: ");
                int canicasOcultasJugador1 = scanner.nextInt();
                System.out.println("Jugador 2 cree que el Jugador 1 tiene un número " + eleccion + ".");
                while (canicasOcultasJugador1 < 1 || canicasOcultasJugador1 > apuestaMaxima) {
                    System.out.println("Número inválido. Puedes apostar entre 1 y " + apuestaMaxima + " canicas.");
                    System.out.print("Intenta nuevamente: ");
                    canicasOcultasJugador1 = scanner.nextInt();
                }

                //Comprobacion si esPar las canicas ocultas del jugador1
                boolean esPar = canicasOcultasJugador1 % 2 == 0;

                //De igual manera se generan respuestas para cada convinacion como en turnojugador1
                System.out.println("\nResultado");
                if ((esPar && eleccion.equals("par")) || (!esPar && eleccion.equals("impar"))) {
                    System.out.println("Jugador 2 GANA " + apuestaJugador + " canicas ya que el Jugador 1 tenía " + canicasOcultasJugador1 + " canicas.");
                    canicasJugador1 -= apuestaJugador;
                    canicasJugador2 += apuestaJugador;
                } else {
                    System.out.println("Jugador 2 PIERDE " + apuestaJugador + " canicas ya que el Jugador 1 tenía " + canicasOcultasJugador1 + " canicas.");
                    canicasJugador1 += apuestaJugador;
                    canicasJugador2 -= apuestaJugador;
                }
            }
            //Fin de turnos

            //En el bucle, indiferentemente de los turnos: Mostrar canicas J1 y J2
            System.out.println("\nJugador 1 tiene " + canicasJugador1 + " canicas.");
            System.out.println("Jugador 2 tiene " + canicasJugador2 + " canicas.");

            //se realiza el cambio de turno false es true / true es false
            turnoJugador1 = !turnoJugador1;
        }

        //si se cierra el bucle gana quien aun tenga canicas.
        if (canicasJugador1 <= 0) {
            System.out.println("\n¡Jugador 2 (Ordenador) gana el juego!");
        } else {
            System.out.println("\n¡Jugador 1 gana el juego!");
        }
    }
}
