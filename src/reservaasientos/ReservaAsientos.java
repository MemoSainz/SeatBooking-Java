package reservaasientos;

import java.util.Scanner;

public class ReservaAsientos {
    public static void main(String[] args) {

        // Variable declaration
        char asientos[][] = new char[10][10];
        boolean bandera = false;
        Scanner teclado = new Scanner(System.in);
        int fila=0, asiento=0;
        String respuesta;
        String verMapa;


        // matrix of seats
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                asientos[f][c] = 'F';
            }
        }

        // welcome to the system
        System.out.println("\n-------WELCOME TO THE BOOKING SYSTEM-------");

        //booking of seats
        while (bandera != true) {
            // visualization of map
            System.out.println("Do you want to know the available seats? Y: yes | N: every key");
            verMapa = teclado.next();
            // Here we will call the method
            if (verMapa.equalsIgnoreCase("Y")) {
                dibujarMapa(asientos);
            }

            //booking
            boolean estaOk=false;
            while (estaOk!=true) {

                System.out.println("\n Insert please the row and seat to reserve.");
                System.out.print("Row (between 0 & 9): ");
                fila = teclado.nextInt();

                System.out.print("Seat (between 0 & 9): ");
                asiento = teclado.nextInt();
                if (fila <= 9 && fila >= 0) {
                    if (asiento <= 9 && asiento >= 0) {
                        estaOk = true;
                    } else {
                        System.out.println("Invalid number of  seat");
                    }
                } else {
                    System.out.println("Invalid number of seat");
                }
            }
            if (asientos[fila][asiento] == 'F') {
                asientos[fila][asiento] = 'X';
                System.out.println("\nThe seat has been reserved.");

            } else {
                System.out.println("\nThe seat has been taken. Please choose another.");
            }

            System.out.println("Do you want to end the reservation? (Y: yes /N: every key): ");
            respuesta = teclado.next();

            if (respuesta.equalsIgnoreCase("Y")) {
                bandera = true;
            }

        }

    }

    //    Funciones fuera del main
//    con static
//    Si vamos a usar funciones, tenemos
//    que declararlo com oestático y ponerlo
//    fuera del main.
    static void dibujarMapa(char asientos[][]) {
        for (int f = 0; f < 10; f++) {
            System.out.print(f + " ");
            for (int c = 0; c < 10; c++) {
                System.out.print("[" + asientos[f][c] + "]");
            }
            System.out.println("");
        }

    }


}
