import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        Integer numero;
        String agencia;
        String nome;
        double saldo;

        System.out.println("Por favor, informe seu nome: ");
        nome = scan.nextLine();

        System.out.println("Por favor, informe o número da sua agencia: ");
        agencia = scan.nextLine();

        System.out.println("Por favor, informe o número da sua conta: ");
        numero = scan.nextInt();
        scan.nextLine();

        System.out.println("Por favor, informe o valor inicial da sua conta: ");
        saldo = scan.nextDouble();
        scan.nextLine();

        System.out.println("\nOlá " + nome +
                ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia +
                ", conta " + numero +
                " e seu saldo " + String.format("%.2f", saldo) +
                " já está disponível para saque.");
    }
}
