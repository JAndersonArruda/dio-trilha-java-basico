package candidatura;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
//        analisarCandidato(1000.0);
//        analisarCandidato(2000.0);
//        analisarCandidato(2001.0);

//        selecaoCandidatos();
//        imprimirSelecionados();

        String [] candidatos = {"FELIPE", "ANDRÉ", "MELISA", "BENTO", "LETÍCIA"};
        for (String candidato : candidatos) entrandoEmContato(candidato);
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando) tentativasRealizadas ++;
            else System.out.println("CONTATO REALIZADO COM SUCESSO.");
        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) System.out.println("CONSEGUIMOS CONTATO COM " + candidato+ " NA " + tentativasRealizadas + "° TENTATIVA.");
        else System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NO NÚMERO MÁXIMO DE " + tentativasRealizadas + " TENTATIVAS REALIZADAS.");
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    static void imprimirSelecionados() {
        String[] selecionados = {"FELIPE", "ANDRÉ", "MELISA", "BENTO", "LETÍCIA"};

        for (int i = 0; i < selecionados.length; i++) {
            System.out.println("O candidato de n° " + (i +1) + " é o " + selecionados[i]);
        }

        for (String selecionado : selecionados) {
            System.out.println("O candidato selecionado foi " + selecionado);
        }
    }

    static void imprimirSelecionados(String[] array) {
        for (String selecionado : array) {
            if (selecionado != null) System.out.println("O candidato selecionado foi " + selecionado);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"FELIPE", "ANDRÉ", "MELISA", "BENTO", "LETÍCIA", "FRANCISCO", "ANA", "JOSÉ"};
        String[] selecionados = new String[5];

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + String.format("%.2f", salarioPretendido));
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                selecionados[candidatosSelecionados] = candidatos[candidatoAtual];
                candidatosSelecionados ++;
            }
            candidatoAtual ++;
        }

        System.out.println(Arrays.toString(selecionados));
        imprimirSelecionados(selecionados);
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO.");
        }
        if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA.");
        }
        if (salarioBase < salarioPretendido) {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.");
        }
    }
}
