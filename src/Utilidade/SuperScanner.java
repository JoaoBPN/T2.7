package Utilidade;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class SuperScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static Integer getInteger(){

        while (true) {
            try {
                Integer var = scanner.nextInt();
                scanner.nextLine();
                return var;

            } catch (InputMismatchException e) {
                System.out.println("Tipo não atendido");
                scanner.nextLine();
            }
        }
    }

    public static Double getDouble(){
        while (true) {
            try {
                Double var = scanner.nextDouble();
                scanner.nextLine();
                return var;

            } catch (InputMismatchException e) {
                System.out.println("Tipo não atendido");
                scanner.nextLine();
            }
        }
    }

    public static String getString(){
        while (true){
            String str = scanner.nextLine();
            if(!str.isEmpty()){
                return str;
            }
            System.out.println("String vazia, tente novamente");
        }
    }

    public static List<String> getStringList(){
        String str = "";
        List<String> lista = new ArrayList<>();
        while (!str.equals("nulo")){
            System.out.println("Digite o nome: ");
            str = getString();
            if(!str.equals("nulo")){
                lista.add(str);
            }
        }
        return lista;
    }
}


