//Javier Morales Subaru
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Rutificador {

    public static void main(String[] args) {
        try (Scanner lector = new Scanner(System.in)) {
            String rutCompleto = "";
            boolean rutValido = false;
            
            while (!rutValido) {
                System.out.println("Ingrese su rut (formato: 12345678-9 o 12.345.678-9) o 0 para salir:");
                rutCompleto = lector.nextLine().trim();
                
                // opción de salir
                if (rutCompleto.equals("0")) {
                    System.out.println("Chau.");
                    break;
                }
                
                rutCompleto = rutCompleto.replace(".", "").replace("-", ""); // limpiar RUT
                
                try {
                    if (rutCompleto.length() < 2) throw new IllegalArgumentException("RUT demasiado corto.");
                    
                    String rutString = rutCompleto.substring(0, rutCompleto.length() - 1);
                    int rut = Integer.parseInt(rutString);
                    char dvIngresado = Character.toUpperCase(rutCompleto.charAt(rutCompleto.length() - 1));
                    
                    // separar digitos de derecha a izquierda
                    List<Integer> rutSeparado = new ArrayList<>();
                    int tempRut = rut;
                    while (tempRut > 0) {
                        rutSeparado.add(tempRut % 10);
                        tempRut /= 10;
                    }
                    
                    // multiplicadores segun cantidad de digitos
                    List<Integer> multiplicadores7 = Arrays.asList(2, 3, 4, 5, 6, 7, 2);
                    List<Integer> multiplicadores8 = Arrays.asList(2, 3, 4, 5, 6, 7, 2, 3);
                    List<Integer> multiplicadores = (rutSeparado.size() <= 7) ? multiplicadores7 : multiplicadores8; //practicar operador ternarioxd
                    
                    // detectar RUT de testeo: todos los digitos iguales
                    boolean esRutTesteo = true;
                    int primerDigito = rutSeparado.get(rutSeparado.size() - 1); // digito más a la izquierda
                    for (int n : rutSeparado) {
                        if (n != primerDigito) {
                            esRutTesteo = false;
                            break;
                        }
                    }
                    // Si es un RUT de testeo, no se acepta
                    if (esRutTesteo) {
                        System.out.println("RUT de testeo detectado. Ingrese otro.");
                        continue; // vuelve a pedir otro RUT
                    }
                    
                    // sumatoria con multiplicadores
                    int sumatoria = 0;
                    for (int i = 0; i < rutSeparado.size(); i++) {
                        sumatoria += rutSeparado.get(i) * multiplicadores.get(i % multiplicadores.size()); // ciclo multiplicadores
                    }
                    
                    int resto = 11 - (sumatoria % 11);
                    char dvCalculado;
                    if (resto == 11) dvCalculado = '0';
                    else if (resto == 10) dvCalculado = 'K';
                    else dvCalculado = (char) (resto + '0');
                    
                    // validar DV
                    if (dvIngresado == dvCalculado) {
                        System.out.println("Su RUT es valido: " + rutString + "-" + dvIngresado);
                        rutValido = true;
                    } else {
                        System.out.println("Su RUT NO es valido (" + rutString + "-" + dvIngresado +
                                "). DV correcto: " + dvCalculado);
                    }  
                } catch (NumberFormatException e) {
                    System.out.println("RUT invalido en la parte numerica. Intente nuevamente.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("Error inesperado. Intente nuevamente.");
                }
            }
        }
    }
}
