import java.util.Arrays;

public class MetodosOrdenamiento {

    // Burbuja normal
    public void burbuja(int[] arreglo, boolean ascendente, boolean mostrarPasos) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (mostrarPasos) {
                    System.out.println("i= " + i + " j= " + j + " [i]=" + arreglo[i] + " [j]= " + arreglo[j]);
                }
    
                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    if (mostrarPasos) {
                        System.out.println("\tIntercambiamos " + arreglo[j] + " con " + arreglo[j + 1]);
                    }
    
                    // Intercambio
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
    
                    if (mostrarPasos) {
                        System.out.println("\t--------" + Arrays.toString(arreglo));
                    }
                }
            }
        }
    }
    

    // Selección

public void seleccion(int[] arreglo, boolean ascendente, boolean mostrarPasos) {
    int n = arreglo.length;
    for (int i = 0; i < n - 1; i++) {
        int indiceMinOmax = i;
        for (int j = i + 1; j < n; j++) {
            if (mostrarPasos) {
                System.out.println("i=" + i + " j=" + j + " [minMax]=" + arreglo[indiceMinOmax] + " [j]=" + arreglo[j]);
            }

            if ((ascendente && arreglo[j] < arreglo[indiceMinOmax]) || (!ascendente && arreglo[j] > arreglo[indiceMinOmax])) {
                indiceMinOmax = j;
            }
        }

        if (mostrarPasos) {
            System.out.println("\tIntercambiamos " + arreglo[i] + " con " + arreglo[indiceMinOmax]);
        }

        // Intercambio
        int temp = arreglo[indiceMinOmax];
        arreglo[indiceMinOmax] = arreglo[i];
        arreglo[i] = temp;

        if (mostrarPasos) {
            System.out.println("\t--------" + Arrays.toString(arreglo));
        }
    }
}


    // Inserción
    public void insercion(int[] arreglo, boolean ascendente, boolean mostrarPasos) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            if (mostrarPasos) {
                System.out.println("Pasada número " + i);
            }

            int aux = arreglo[i];
            int j = i - 1;

            if (mostrarPasos) {
                System.out.println("\ti=" + i + " j=" + j + " [i]=" + arreglo[i] + " [j]=" + arreglo[j]);
            }

            while (j >= 0 && ((ascendente && arreglo[j] > aux) || (!ascendente && arreglo[j] < aux))) {
                if (mostrarPasos) {
                    System.out.println("\t\tComparamos " + aux + " con " + arreglo[j]);
                }

                arreglo[j + 1] = arreglo[j];
                j = j - 1;
                arreglo[j + 1] = aux;

                if (mostrarPasos) {
                    System.out.println("\t\t--------" + Arrays.toString(arreglo));
                }
            }

            if (mostrarPasos) {
                System.out.println("\t--------" + Arrays.toString(arreglo));
            }
        }
    }

    // Burbuja avanzada
    public int[] sortBubbleAva(int[] arreglo, boolean ascendente, boolean mostrarPasos) {
        int n = arreglo.length;
        boolean intercambio = false;

        for (int i = 0; i < n; i++) {
            intercambio = false;
            if (mostrarPasos) {
                System.out.println("Pasada " + i);
            }

            for (int j = 0; j < n - 1 - i; j++) {
                if (mostrarPasos) {
                    System.out.println("j=" + j + " [j]=" + arreglo[j] +
                            " j+1=" + (j + 1) + " [j+1]=" + arreglo[j + 1]);
                }

                // Comparación ascendente o descendente
                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    if (mostrarPasos) {
                        System.out.println("Si hay cambio");
                    }

                    // Intercambio
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    intercambio = true;
                }
            }

            // Si no hubo intercambio, el arreglo ya está ordenado
            if (!intercambio) {
                break;
            }
        }
        return arreglo;
    }

    public void imprimirArreglo(int[] arreglo) {
        for (int num : arreglo) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
