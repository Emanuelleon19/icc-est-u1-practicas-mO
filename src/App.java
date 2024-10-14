import java.util.Scanner;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetodosOrdenamiento metodos = new MetodosOrdenamiento();
        int[] arreglo = new int[0]; 

        while (true) {
            //menú principal
            System.out.println("Menu Principal");
            System.out.println("1. Ingrese un arreglo");
            System.out.println("2. Ordenar Arreglo");
            System.out.println("0. Salir");

            int opcion = leerEnteroValido(scanner, "Seleccione una opción:", false);

            if (opcion == 0) {
                System.out.println("Programa finalizado");
                break;
            }

            switch (opcion) {
                case 1:
                    int n;
                    do {
                        n = leerEnteroValido(scanner, "Ingrese el tamaño de su arreglo : ", false);
                        if (n <= 0) {
                            System.out.println("El tamaño del arreglo debe ser mayor que 0. Intente nuevamente.");
                        }
                    } while (n <= 0);
                    
                    arreglo = new int[n];

                    for (int i = 0; i < n; i++) {
                        arreglo[i] = leerEnteroValido(scanner, "Ingrese el valor para " + (i + 1) + ": ", true);
                    }
                    System.out.println(Arrays.toString(arreglo));                    
                    break;
                case 2:
                    if (arreglo.length == 0) {
                        System.out.println("Primero debe ingresar un arreglo.");
                        break;
                    }
                    while (true) {
                        //menu de metodos para ordenar
                        System.out.println("Escoja un metodo de ordenamiento: ");
                        System.out.println("1. Metodo Burbuja");
                        System.out.println("2. Metodo Seleccion");
                        System.out.println("3. Metodo Insercion");
                        System.out.println("4. Metodo Burbuja Mejorado");
                        System.out.println("0. Regresar al menu principal");

                        int metodo = leerEnteroValido(scanner, "Seleccione un método de ordenamiento:", false);

                        if (metodo == 0) {
                            break;  
                        }

                        if (metodo < 1 || metodo > 4) {
                            System.out.println("Opción incorrecta. vuelva a seleccionar un metodo");
                            continue;  
                        }

                        int[] copiaArreglo = Arrays.copyOf(arreglo, arreglo.length);

                        int orden;
                        do {
                            orden = leerEnteroValido(scanner, "Escoja ascendente (1) o descendente (2): ", false);
                            if (orden != 1 && orden != 2) {
                                System.out.println("Debe ingresar 1 para ascendente o 2 para descendente. Intente nuevamente.");
                            }
                        } while (orden != 1 && orden != 2);
                        boolean ascendente = (orden == 1);
                        
                        int mostrar;
                        do {
                            mostrar = leerEnteroValido(scanner, "Quiere ver cada paso? (1. Si, 2. No): ", false);
                            if (mostrar != 1 && mostrar != 2) {
                                System.out.println("Debe ingresar 1 para 'Sí' o 2 para 'No'. Intente nuevamente.");
                            }
                        } while (mostrar != 1 && mostrar != 2);
                        boolean mostrarPasos = (mostrar == 1);
                        

                        switch (metodo) {
                            case 1:
                                metodos.burbuja(copiaArreglo, ascendente,mostrarPasos);
                                break;
                            case 2:
                                metodos.seleccion(copiaArreglo, ascendente, mostrarPasos);
                                break;
                            case 3:
                                metodos.insercion(copiaArreglo, ascendente, mostrarPasos);
                                break;
                            case 4:
                                metodos.sortBubbleAva(copiaArreglo, ascendente, mostrarPasos);
                                break;
                        }

                        System.out.println("Arreglo ordenado: ");
                        for (int num : copiaArreglo) {
                            System.out.print(num + " ");
                        }
                        System.out.println();  
                    }
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }

        scanner.close();
    }

    public static int leerEnteroValido(Scanner scanner,String mensaje,boolean permitirNegativos){
        int numero = 0;

        do{
            System.out.println(mensaje);
            while(!scanner.hasNextInt()){
                System.out.println("Te pedi un entero");
                System.out.println(mensaje);
                scanner.next();
            }
            numero = scanner.nextInt();
            if(!permitirNegativos && numero < 0){
                System.out.println("El tamaño debe ser mayor a 0");
            }
        }while(!permitirNegativos && numero < 0);
        return numero;
    }
}



