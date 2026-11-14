package icc;

import java.util.Scanner;

/**
 * Representa el tiempo en el que la persona inversionista decide invertir su dinero, 
 * y calcula el rendimiento de la inversión a 12%.
 * 
 * @author Diego Alejandro Peña Suárez
 * @version 1.0
 */
public class TiempoDeInversion { 

    /**
     * Método principal que ejecuta la simulación de inversión interactiva.
     * 
     * @param args argumentos de línea de comandos (no se utilizan)
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String hacerOtra = ""; 

        System.out.println("Bienvenido al simulador de inversiones de Banco Kala");
        
        do {
            System.out.println("Por favor, escoge alguna de las opciones disponibles:");
            System.out.println("1. Simular inversión");
            System.out.println("2. Abandonar tus sueños.");

            String opcion = in.nextLine().trim();

            if (opcion.equals("1")) {
                System.out.println("Perfecto, has escogido la opción 1. Vamos a perseguir ese sueño.");
                
                System.out.println("Por favor, ingresa tu nombre completo para poder iniciar la simulación de inversión.");
                String nombreCompleto = in.nextLine().trim();
        
                System.out.println("Excelente, mucho gusto, " + nombreCompleto + ". ");
                
                System.out.println("Ahora, por favor, ingresa el monto que desearías invertir. Dame una cifra mayor a cero, sin comas ni puntos, sin símbolos de pesos ni centavos, y sin espacios.");
                double monto = in.nextDouble();
                in.nextLine();

                System.out.println("Perfecto, has ingresado el monto de $" + monto + ".");

                System.out.println("Requiero un poco más de información para poder acercarnos un paso más hacia tus sueños. Te solicitaré la fecha exacta para iniciar tu camino hacia el éxito.");
                
                System.out.println("Por favor, ingresa el día de inicio de tu inversión en el formato dd");
                int diaInicio = in.nextInt();
                in.nextLine();

                System.out.println("Por favor, ingresa el mes de inicio en el formato mes (ejemplo; enero, febrero, marzo, etc.)");
                String mesInicio = in.nextLine().trim();

                System.out.println("Por favor ingresa el año del inicio de tu inversión. Estamos casi listos. No olvides escribirlo con cuatro dígitos, en el formato aaaa, por ejemplo: 2026");
                int anioInicio = in.nextInt();
                in.nextLine();

                Fecha fechaInicio = new Fecha(mesInicio, diaInicio, anioInicio);
            
                System.out.println("Perfecto, mi estimado " + nombreCompleto + ". Has ingresado la fecha de inicio de tu inversión como: " + fechaInicio.toString() + ".");

                System.out.println("Ahora, para calcular el rendimiento de tu inversión a 12%, necesito que me proporciones la fecha de fin de tu inversión, empezaremos por el día.");
                int diaFin = in.nextInt();
                in.nextLine();

                System.out.println("Perfecto ahora necesito que ingreses el mes de finalización de tu inversión, de la misma forma en la que la has ingresado en la fecha de inicio, es decir en formato mes, (minúsculas), de la siguiente forma: enero, febrero, marzo... etc.");
                String mesFin = in.nextLine().trim();

                System.out.println("Para finalizar y calcular tu rendimiento a 12%, necesito que ingreses el año de finalización de tu inversión, recuerda escribirlo con cuatro dígitos, por ejemplo: 2026");
                int anioFin = in.nextInt();
                in.nextLine();

                Fecha fechaFin = new Fecha(mesFin, diaFin, anioFin);

                System.out.println("Perfecto, mi estimado " + nombreCompleto + ". Has ingresado la fecha de fin de tu inversión como: " + fechaFin.toString() + ".");

                int diasDeInversion = fechaFin.diferencia(fechaInicio);

                System.out.println("Finalmente, puedo calcular el monto final de tu inversión a 12% de rendimiento, así como el número de días que durará tu inversión.");

                double rendimiento = monto * 0.12 * (diasDeInversion / 365.0);
                double montoFinal = monto + rendimiento;

                System.out.println("El monto final de tu inversión a 12% de rendimiento es: $ " + montoFinal);
                System.out.println("La inversión durará " + diasDeInversion + " días.");

                System.out.println("Gracias por utilizar nuestro simulador de inversiones. No podemos afirmar nada, pero sabemos que tu inversión será un éxito y que sus sueños están al alcance con nosotros.");

            } else if (opcion.equals("2")) {
                System.out.println("Perfecto, has escogido la opción 2. Lamento que hayas decidido abandonar tus sueños. Espero que algún día los retomes.");
            } else {
                System.out.println("Lo siento, no he podido reconocer la opción que has escogido. Por favor, inténtalo de nuevo.");
            }

            System.out.println("\n¿Deseas hacer otra simulación? (escribe 'si' para repetir o cualquier otra cosa para salir)");
            hacerOtra = in.nextLine().trim().toLowerCase();

        } while (hacerOtra.equals("si"));

    }
}