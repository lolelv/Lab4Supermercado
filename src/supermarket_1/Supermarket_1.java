/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket_1;

import java.util.Scanner;

/**
 *
 * @author Toshiba
 */
public class Supermarket_1 {

    static Scanner sc = new Scanner(System.in);
    static int[] idenventas = new int[50];
    static long[] codprod = new long[50];
    static double[] precioxunidad = new double[50];
    static String[] descrip = new String[50];
    static int maxprod = 50;
    static String[][] fechaventas = new String[200][4];
    static int numdeventas;
    static long[] comprastotalesxventa = new long[50];
    //static double[] tcosd = new double[50];
    //static double[] descuento = new double[50];
    //static String[][] nyadelvendedor = new String[50][50];

    static String[][] nyavendedores = new String[50][2];
    //static String [] apellidovend = new String [50];
    static long[] idvendedor = new long[50];
    static long[][] codprodvendidos = new long[50][50];
    static int[][] cantvendidaxprod = new int[50][50];
    static long[] formadepago = new long[50];
    static double[] coddescuento = new double[50];
    static double[] valordescuento = new double[50];
    static double[] totalventaespecifica = new double[50];
    static double[] ventasregistradasxvend = new double[50];
    static double[] aux_idvend = new double[50];
    static int cvar;

    public static void InicializarMatrizVrxv() {

        for (int g = 0; g < ventasregistradasxvend.length; g++) {
            ventasregistradasxvend[g] = 0;
        }

    }

    public static void IngresarDatProd() {

        int prodreg;
        System.out.println("El máximo de productos que puede ingresar es " + maxprod);
        System.out.println("¿Cuántos productos va a registrar? : ");
        prodreg = sc.nextInt();

        for (int i = 0; i < prodreg; i++) {
            System.out.println("Ingrese código del producto " + (i + 1) + ": ");
            codprod[i] = sc.nextLong();
            System.out.println("Ingrese una breve descripción del producto " + (i + 1) + ": ");
            descrip[i] = sc.next();
            System.out.println("Ingrese precio del producto " + (i + 1) + " por unidad  $ ");
            precioxunidad[i] = sc.nextDouble();

        }

    }

    public static void IngresarDatosVentas(double totalventaespecifica[]) {

        //long cvar; //cvar: cantidad de ventas a registrar;
        System.out.println("¿Cuantás ventas registrará? : ");
        cvar = sc.nextInt();

        int aux;
        int p;
        for (aux = 0; aux < cvar; aux++) {

            System.out.println("\t Ingrese los siguientes datos correspondientes a la venta # " + (aux + 1));
            idenventas[aux] = aux + 1;

            System.out.println("¿Cuantos productos de diferente código se registrarán en este venta?");
            int cantprodareg = sc.nextInt();

            System.out.println("Ingrese el día de la venta # : " + (aux + 1));
            fechaventas[aux][0] = sc.next();
            System.out.println("Ingrese mes de la venta # " + (aux + 1));
            fechaventas[aux][1] = sc.next();
            System.out.println("Ingrese año de la venta # " + (aux + 1));
            fechaventas[aux][2] = sc.next();
            System.out.println("Ingrese hora de la venta # " + (aux + 1) + " (Por favor ingrésela de la siguiente manera: 3.45 .");
            System.out.println("En donde 3 representa la hora y 45 los minutos");
            fechaventas[aux][3] = sc.next();
            System.out.println("Ingrese ID del vendedor :");
            idvendedor[aux] = sc.nextLong();

            /*int band = 0;
            int aux_idv = 0;
            for (int z = 0; z < idvendedor.length; z++) {
                do {
                    if (idvendedor[aux] == aux_idvend[z]) {
                        band++;
                        ventasregistradasxvend[z] = ventasregistradasxvend[z]++;
                    } else {
                        ventasregistradasxvend[z] = ventasregistradasxvend[z]++;
                    }
                } while (band == 0);
            }*/

            System.out.println("Ingrese nombre del vendedor (sin apellidos ni espacios ) :");
            nyavendedores[aux][0] = sc.next();
            System.out.println("Ingrese apellido del vendedor (sin espacios): ");
            nyavendedores[aux][1] = sc.next();

            for (int m = 0; m < cantprodareg; m++) {
                System.out.println("Ingrese código del producto " + (m + 1) + " vendido:");
                codprodvendidos[aux][m] = sc.nextLong();
                System.out.println("Ingrese la cantidad vendida del producto." + (m + 1));
                cantvendidaxprod[aux][m] = sc.nextInt();
                totalventaespecifica[aux] = 0;
                int bandera = 0;
                do {
                    for (int d = 0; d < codprodvendidos.length; d++) {
                        if (codprod[d] == codprodvendidos[aux][m]) {
                            totalventaespecifica[aux] = totalventaespecifica[aux] + (precioxunidad[d] * cantvendidaxprod[aux][m]);
                            bandera++;
                        }
                    }

                } while (bandera == 0);

            }
            System.out.println("Ingrese 0 si la factura fue pagada en Efectivo");
            System.out.println("Ingrese 1 si la factura fue pagada con Tarjeta Débito");
            System.out.println("Ingrese 2 si la factura fue pagada con Tarjeta Crédito");
            formadepago[aux] = sc.nextInt();
            System.out.println("¿Se aplicará algún descuento a la factura total?");

            System.out.println("Ingrese 0 para NO , y 1 para SÍ");
            p = sc.nextInt();
            if (p == 1) {
                System.out.println("Recuerde que solo se validará UN (1) Bono de Descuento por factura.");
                System.out.println("Ingrese Código de Descuento Aplicable (solo numeros, no letras): ");
                coddescuento[aux] = sc.nextDouble();
                System.out.println("Ingrese el valor del descuento que se aplicará");
                System.out.println("al valor total final de la factura. $ ");
                valordescuento[aux] = sc.nextDouble();
                totalventaespecifica[aux] = totalventaespecifica[aux] - valordescuento[aux];
            }
            System.out.println("Factura # " + (aux + 1) + " registrada exitosamente.");

        }
        int band = 0;
        int aux_idv = 0;
        for (int z = 0; z < idvendedor.length; z++) {
            do {
                if (idvendedor[aux] == aux_idvend[z]) {
                    band++;
                    ventasregistradasxvend[z] = ventasregistradasxvend[z]++;
                } else {
                    ventasregistradasxvend[z] = ventasregistradasxvend[z]++;
                }
            } while (band == 0);
        }

    }

    public static void ImprimirFactura(long codprod[], int idv[], String nyavendedores[][], double totalventaespecifica[]) {

        int numfact;

        do {
            System.out.println("Ingrese el número de la factura que desea imprimir: ");
            numfact = sc.nextInt();
        } while (numfact < 0 || numfact > idv.length);
        System.out.println("\t Venta #" + numfact);
        System.out.println("\t Vendedor :" + (idvendedor[numfact - 1]));
        System.out.println("\t Nombre y apellido del vendedor : " + (nyavendedores[numfact - 1][0]) + "  " + (nyavendedores[numfact - 1][1]));
        System.out.println("\t Fecha de la venta: " + fechaventas[numfact - 1][0] + " / " + fechaventas[numfact - 1][1] + " / " + fechaventas[numfact - 1][2]);
        System.out.println("\t Hora de la venta : " + fechaventas[numfact - 1][3]);
        System.out.println("\t Código y descripción del producto vendido            Cantidad vendida");
        for (int f = 0; f < cantvendidaxprod.length; f++) {
            if (cantvendidaxprod[numfact - 1][f] == 0) {
                break;
            } else {
                System.out.print("\t   " + codprodvendidos[numfact - 1][f]);
                long codaux = codprodvendidos[numfact - 1][f];
                int bandera = 0;
                do {
                    for (int d = 0; d < codprodvendidos.length; d++) {
                        if (codprod[d] == codaux) {
                            System.out.print("  " + descrip[d]);
                            bandera++;
                        }
                    }
                } while (bandera == 0);
            }
            System.out.print("                         " + cantvendidaxprod[numfact - 1][f] + "\n");

        }
        double totalventaespec = totalventaespecifica[numfact - 1];
        System.out.println(" Total venta con descuento : $ " + totalventaespec);
    }

    public static void Vmcv() {
        double mayor = 0;
        int aux = -1;
        for (int s = 0; s < ventasregistradasxvend.length; s++) {
            if (ventasregistradasxvend[s] > mayor) {
                mayor = ventasregistradasxvend[s];
                aux = s;
            }
        }
        System.out.println("El vendedor que realizó la mayor cantidad de ventas es : " + (nyavendedores[aux][0]) + "  " + (nyavendedores[aux][1]));
        System.out.println("Identificación del vendedor: " + idvendedor[aux]);
        System.out.println("Número de ventas realizadas: " + ventasregistradasxvend[aux]);

    }

    public static void Lvtd() {

        int w;
        System.out.println("\t Ventas realizadas con Tarjeta Débito");
        System.out.println("Número de factura o venta  |  Valor total pagado");
        for (w = 0; w < formadepago.length; w++) {
            if (formadepago[w] == 1) {
                System.out.println("Factura # " + idenventas[w] + "            $  " + totalventaespecifica[w]);
            }
        }
    }

    public static void Avvpe() {
        System.out.println("Disculpe. Esta opción no se encuentra disponible");
        System.out.println("en este momento. Ingrese otra opción. ");
    }

    public static void Mtv() {

        /*double tvr=0;
        for(int r=0; r<ventasregistradasxvend.length; r++){
            tvr=tvr+ventasregistradasxvend[r];
        }*/
        System.out.println("El monto de total de ventas realizadas es:  " + cvar);

    }

    public static void Mvtc() {
        double totalmayorvent = 0;
        int identif;
        int h = -1;
        for (h = 0; h < formadepago.length; h++) {
            if (formadepago[h] == 2 && totalventaespecifica[h] > totalmayorvent) {
                totalmayorvent = totalventaespecifica[h];
                identif = h;

            }

        }
        if (h == -1) {
            System.out.println("No hubo ninguna compra pagada con Tarjeta Crédito.");

        } else {
            System.out.println("La venta de mayor importe abonada con tarjeta crédito es la Venta # " + (h + 1));
            System.out.println("Por un valor total de $ " + totalmayorvent);
        }
    }

    public static void main(String[] args) {

        int opc;

        do {

            System.out.println("Seleccione algunas de las siguientes opciones del menú \n");
            System.out.println(" 1. Ingresar datos de los productos.");
            System.out.println(" 2. Ingresar datos de ventas registradas.");
            System.out.println(" 3. Imprimir factura de una venta.");
            System.out.println(" 4. Averiguar cual fue el vendedor que realizó mayor cantidad de ventas.");
            System.out.println(" 5. Generar listado de todas las ventas realizadas con Tarjeta Débito");
            System.out.println(" 6. Averiguar si un vendedor específico realizó alguna venta de un producto específico.");
            System.out.println(" 7. Consultar el monto TOTAL de ventas.");
            System.out.println(" 8. Consultar datos de la mayor venta realizada con Tarjeta Crédito");
            System.out.println(" 9. Salir");

            opc = sc.nextInt();
            switch (opc) {

                case 1:
                    IngresarDatProd();
                    break;

                case 2:
                    IngresarDatosVentas(totalventaespecifica);
                    break;

                case 3:
                    ImprimirFactura(codprod, idenventas, nyavendedores, totalventaespecifica);
                    break;

                case 4:
                    Vmcv(); //Vmcv: Vendedor mayor cantidad de ventas
                    break;

                case 5:
                    Lvtd(); //Lvtd: Listado ventas tarjetas debito
                    break;

                case 6:
                    Avvpe(); //Avvp: Averiguar si vendedor vendió producto específico
                    break;

                case 7:
                    Mtv(); //Mtv: Monto total de ventas
                    break;

                case 8:
                    Mvtc(); //Mvtc: Mayor venta realizada con tarjeta crédito
                    break;

                case 9:
                    System.out.println("¡Gracias por usar nuestro servicio! ");
                    break;

                default:
                    System.out.println("La opción que ha ingresado es incorecta, intente de nuevo: ");
                    System.out.println(" ");
                    break;
            }
        } while (opc != 9);
    }
}
