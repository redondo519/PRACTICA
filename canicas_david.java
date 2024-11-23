/*
Redondo, Alonso, David
*/

import java.util.Random;
import java.util.Scanner;


public class canicas_david {
    public static void main(String[] args) {
        Random random = new Random(); //Creacion objeto random para utilizarlo al generar orden de juego y respuestas atleatorias.
        Scanner sc = new Scanner(System.in); //creacion del escaner para leer entradas


        //Operador ternario para hacer apuesta inferiror

        //Hacer control de excepciones


        /*
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese "par" o "impar"
        System.out.print("Ingrese 'par' o 'impar': ");
        String entrada = scanner.nextLine().trim().toLowerCase(); // Leer la entrada y normalizarla

        // Variable booleana para almacenar el estado
        boolean esPar = false; // Inicialmente, podemos asumir que es impar

        // Verificar la entrada del usuario
        if (entrada == "par") {
            esPar = true; // Si la entrada es "par", se establece a true
            System.out.println("El resultado es: par");
        } else if (entrada == "impar") {
            esPar = false; // Si la entrada es "impar", se establece a false
            System.out.println("El resultado es: impar");
        } else {
            System.out.println("Entrada no válida. Por favor, ingrese 'par' o 'impar'.");
        }

        // Imprimir el valor de la variable booleana
        System.out.println("¿Es par? " + esPar);
         */

        /*
        // Crear un objeto Random
        Random random = new Random();

        // Generar un booleano aleatorio
        boolean esPar = random.nextBoolean();

        // Determinar si es "par" o "impar"
        String resultado = esPar ? "par" : "impar";

        // Imprimir el resultado
        System.out.println("El número es: " + resultado);
         */

        //INICIO
        //Declaracion de variables
        int numCanicasJ1=10;    //se almacena las canicas del Jugador 1,  inicializada a 10.
        int numCanicasJ2=10;    //se almacena las canicas del Jugador 2,  inicializada a 10.
        int apuestaJ1=0;        //se almacena la apuesta del jugador 1.
        int apuestaJ2=0;        //se almacena la apuesta del jugador 2.
        String parImparJ1;      //se almacena la entrada del jugador 1 a la pregunta par/impar.
        String parImparJ2;      //se almacena la entrada del jugador 2 a la pregunta par/impar.
        boolean esPar=false;    //almacena true para par || false para impar.
        int turno; //almacena el turno (generado atleatoriamente) 0 para jugador 1, 1 para jugador 2
        int maxCanicas;


        //Decision orden turno de inicio.
        // Generar un número aleatorio (0 o 1)
        turno = random.nextInt(2);

        //condicion, inicio del juego en funcion de 0 o 1:  0-Inicia J1 \ 1-inicia J2
        if (turno == 0) {

            System.out.println("************* TURNO JUGADOR 1 *************");

            // Determinar el máximo de canicas permitido
            maxCanicas = Math.min(numCanicasJ1, numCanicasJ2);

            //Pedimos apuesta jugador 1
            while((apuestaJ1<0) || (apuestaJ1>(maxCanicas+1))){
                System.out.println("¿Cuantas canicas quieres apostar: ?");
                apuestaJ1 = sc.nextInt();//LANZAR EXCEPCION
            }

            //Pedimos jugada par/impar Jugador 1
            System.out.println("¿Que crees que tiene el Jugador 2 (par/impar)?");
            parImparJ1 = sc.next(); //LANZAR EXCEPCION


            //generamos apuesta Jugador 2
            apuestaJ2 = random.nextInt(maxCanicas + 1); // +1 para incluir el ultimo digito

            //Mostramos:
            System.out.println("Canicas J1: "+numCanicasJ1);
            System.out.println("Canicas J2: "+numCanicasJ2);
            System.out.println("Canicas J1: "+apuestaJ1);
            System.out.println("Apuesta J2: "+apuestaJ2);
            System.out.println("par/impar J1: "+parImparJ1);






        } else {
            System.out.println("************* TURNO JUGADOR 2 *************");
        }














    }
}
