package icc;

/**
 * Programa para hacer manejo de fechas para determinar
 * la fecha final de una inversión de dinero.
 * 
 * @author Diego Alejandro Peña Suárez
 * @version 1.0
 */
public class Fecha {
    
    private int dia;
    private int mes;
    private int anio;

    /**
     * Construye una fecha con el día, mes y año especificados.
     *
     * @param d el día de la fecha
     * @param m el mes de la fecha
     * @param a el año de la fecha
     */
    public Fecha(int d, int m, int a) {
        if (esFechaValida(d, m, a)) {
            this.dia = d;
            this.mes = m;
            this.anio = a;
        } else {
            System.out.println("Datos ingresados no corresponden a una fecha real. Se asignará 1/Enero/1900 por defecto.");
            this.dia = 1;
            this.mes = 1;
            this.anio = 1900;
        }
    }

    /**
     * Construye una fecha con el valor por defecto.
     * La fecha inicial será 1/Enero/1900.
     */
    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.anio = 1900;
    }
    
    /**
     * Construye una fecha a partir del nombre del mes, el día y el año.
     *
     * @param nombreMes nombre del mes en texto
     * @param d el día de la fecha
     * @param a el año de la fecha
     */
    public Fecha(String nombreMes, int d, int a) {
        int m = obtenerNumeroMes(nombreMes);
        if (esFechaValida(d, m, a)) {
            this.dia = d;
            this.mes = m;
            this.anio = a;
        } else {
            System.out.println("Datos ingresados no corresponden a una fecha real. Se asignará 1/Enero/1900 por defecto.");
            this.dia = 1;
            this.mes = 1;
            this.anio = 1900;
        }
    }

    /*
     * Método auxiliar privado para validar si una fecha existe realmente en el calendario.
     */
    private boolean esFechaValida(int d, int m, int a) {
        if (m < 1 || m > 12 || a < 1 || d < 1) {
            return false;
        }
        int diasMaximos = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            diasMaximos = 30;
        } else if (m == 2) {
            if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0)) {
                diasMaximos = 29;
            } else {
                diasMaximos = 28;
            }
        }
        return d <= diasMaximos;
    }

    /**
     * Obtiene el día de la fecha.
     *
     * @return el día actual de la fecha
     */
    public int obtenerDia() {
        return dia;
    }

    /**
     * Asigna un nuevo valor al día de la fecha.
     *
     * @param d nuevo valor para el día
     */
    public void asignarDia(int d) {
        if (esFechaValida(d, this.mes, this.anio)) {
            this.dia = d;
        } else {
            System.out.println("El día proporcionado no es válido para este mes y año.");
        }
    }

    /**
     * Obtiene el mes de la fecha.
     *
     * @return el mes actual de la fecha 
     */
    public int obtenerMes() {
        return mes;
    }

    /**
     * Asigna un nuevo valor al mes de la fecha.
     *
     * @param m nuevo valor para el mes
     */
    public void asignarMes(int m) {
        if (esFechaValida(this.dia, m, this.anio)) {
            this.mes = m;
        } else {
            System.out.println("El mes proporcionado no es válido con el día actual.");
        }
    }

    /**
     * Obtiene el año de la fecha.
     *
     * @return el año actual de la fecha
     */
    public int obtenerAnio() {
        return anio;
    }

    /**
     * Asigna un nuevo valor al año de la fecha.
     *
     * @param a nuevo valor para el año
     */ 
    public void asignarAnio(int a) {
        if (esFechaValida(this.dia, this.mes, a)) {
            this.anio = a;
        } else {
            System.out.println("El año proporcionado no es válido con el día y mes actuales.");
        }
    }

    /**
     * Devuelve el número correspondiente a un mes a partir de su nombre.
     *
     * @param nombreMes nombre del mes a convertir
     * @return el número del mes, o 0 si el nombre no es válido
     */
    public int obtenerNumeroMes(String nombreMes) {
        nombreMes = nombreMes.toLowerCase();

        if (nombreMes.equals("enero")) {
            return 1;
        } else if (nombreMes.equals("febrero")) {
            return 2;
        } else if (nombreMes.equals("marzo")) {
            return 3;
        } else if (nombreMes.equals("abril")) {
            return 4;
        } else if (nombreMes.equals("mayo")) {
            return 5;
        } else if (nombreMes.equals("junio")) {
            return 6;
        } else if (nombreMes.equals("julio")) {
            return 7;
        } else if (nombreMes.equals("agosto")) {
            return 8;
        } else if (nombreMes.equals("septiembre")) {
            return 9;
        } else if (nombreMes.equals("octubre")) {
            return 10;
        } else if (nombreMes.equals("noviembre")) {
            return 11;
        } else if (nombreMes.equals("diciembre")) {
            return 12;
        } else {
            return 0;
        }
    }

    /**
     * Devuelve la cadena correspondiente a un mes a partir de que reciba un numero.
     *
     * @param numeroMes el número del mes (del 1 al 12)
     * @return el nombre del mes, o "Inválido" si no corresponde
     */
    public String obtenerNombreMes(int numeroMes) {
        if (numeroMes == 1) {
            return "Enero";
        } else if (numeroMes == 2) {
            return "Febrero";
        } else if (numeroMes == 3) {
            return "Marzo";
        } else if (numeroMes == 4) {
            return "Abril";
        } else if (numeroMes == 5) {
            return "Mayo";
        } else if (numeroMes == 6) {
            return "Junio";
        } else if (numeroMes == 7) {
            return "Julio";
        } else if (numeroMes == 8) {
            return "Agosto";
        } else if (numeroMes == 9) {
            return "Septiembre";
        } else if (numeroMes == 10) {
            return "Octubre";
        } else if (numeroMes == 11) {
            return "Noviembre";
        } else if (numeroMes == 12) {
            return "Diciembre";
        } else {
            return "Inválido";
        }
    }

    /**
     * Obtiene el numero de días del mes.
     *
     * @param numeroMes el número del mes (del 1 al 12)
     * @return el número de días del mes, o 0 si el número proveído no es válido.
     */
    public int obtenerDiasDelMes(int numeroMes) {
        if (numeroMes == 1 || numeroMes == 3 || numeroMes == 5 || numeroMes == 7 || numeroMes == 8 || numeroMes == 10 || numeroMes == 12) {
            return 31;
        } else if (numeroMes == 4 || numeroMes == 6 || numeroMes == 9 || numeroMes == 11) {
            return 30;
        } else if (numeroMes == 2) {
            if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
                return 29;
            } else { 
                return 28;
            }
        } else {
            return 0;
        }
    }

    /**
     * Regresa los días transcurridos en el año. 
     *
     * @return el número de días transcurridos en el año hasta la fecha actual.
     */
    public int diasTranscurridos() {
        int acumulador = 0;
        int i = 1;
        while (i < mes) {
            acumulador += obtenerDiasDelMes(i);
            i++;
        }
        acumulador += dia;
        return acumulador;
    }

    /* 
     * Método auxiliar privado para calcular los días totales desde el año 1.
     */
    private int diasAbsolutos() {
        int aniosCompletos = anio - 1;
        int bisiestos = (aniosCompletos / 4) - (aniosCompletos / 100) + (aniosCompletos / 400);
        return (aniosCompletos * 365) + bisiestos + diasTranscurridos();
    }

    /** 
     * Calcula la diferencia, en días, entre dos fechas.
     *
     * @param otraFecha la fecha con la que se quiere comparar.
     * @return la diferencia exacta y precisa, en días, entre la fecha actual y otraFecha.
     */
    public int diferencia(Fecha otraFecha) {
        return Math.abs(this.diasAbsolutos() - otraFecha.diasAbsolutos());
    }

    /**
     * A partir de la fecha actual y una cantidad de días a sumar o restar, 
     * calcula y devuelve un nuevo objeto Fecha.
     * 
     * @param cantidadDias los días a sumar (positivo) o restar (negativo)
     * @return el nuevo objeto Fecha resultante
     */
    public Fecha agregarDias(int cantidadDias) {
        Fecha resultado = new Fecha(this.dia, this.mes, this.anio);
        
        if (cantidadDias > 0) {
            int i = 0;
            while (i < cantidadDias) {
                resultado.dia++;
                if (resultado.dia > resultado.obtenerDiasDelMes(resultado.mes)) {
                    resultado.dia = 1;
                    resultado.mes++;
                    if (resultado.mes > 12) {
                        resultado.mes = 1;
                        resultado.anio++;
                    }
                }
                i++;
            }
        } else if (cantidadDias < 0) {
            int iteraciones = cantidadDias * -1;
            int i = 0;
            while (i < iteraciones) {
                resultado.dia--;
                if (resultado.dia == 0) {
                    resultado.mes--;
                    if (resultado.mes == 0) {
                        resultado.mes = 12;
                        resultado.anio--;
                    }
                    resultado.dia = resultado.obtenerDiasDelMes(resultado.mes);
                }
                i++;
            }
        }
        return resultado;
    }

    /**
     * Determina si dos fechas son iguales.
     * 
     * @param otra la fecha a comparar
     * @return true si el día, mes y año son iguales, false en otro caso
     */
    public boolean equals(Fecha otra) {
        return (this.dia == otra.obtenerDia() && this.mes == otra.obtenerMes() && this.anio == otra.obtenerAnio());
    }

    /** 
     * Representar la fecha en formato dd/mes/aaaa.
     *
     * @return la fecha en formato dd/mes/aaaa.
     */
    public String toString() {
        return (dia + "/" + obtenerNombreMes(mes) + "/" + anio);
    }
}