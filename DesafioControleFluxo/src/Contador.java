import java.lang.reflect.Parameter;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numeroUm, numeroDois;

        System.out.println("Por favor, informe dois números inteiros.");
        System.out.println("Primeiro número: ");
        numeroUm = scan.nextInt();
        scan.nextLine();

        System.out.println("Segundo número: ");
        numeroDois = scan.nextInt();
        scan.nextLine();

        try {
            contar(numeroUm, numeroDois);
        } catch (ParametrosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scan.close();
    }

    static void contar(int valorUm, int valorDois) throws ParametrosInvalidosException {
        if (valorUm > valorDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }

        int contagem = valorDois - valorUm;
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}