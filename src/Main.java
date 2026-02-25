import Service.ServiceMoeda;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        ServiceMoeda service = new ServiceMoeda();

        System.out.println("""
        Seja bem-vindo/a ao conversor de Moedas!
        ***********************************************
            1) Dólar (USD) para Peso Argentino (ARG)
            2) Peso Argentino (ARG) para Dólar (USD)
            3) Dólar (USD) para Real Brasileiro (BRL)
            4) Real Brasileiro (BRL) para Peso Colombiano (COP)
            5) Dólar (USD) para Peso Colombiano (COP)
            6) Peso Colombiano (COP) para Dólar (USD)
            7) Sair
        ***********************************************""");
        menu(scan, service);
    }
    public static void menu(Scanner scan, ServiceMoeda service) {
        String[][] conversoes = {
                {"USD", "ARS"},
                {"ARS", "USD"},
                {"USD", "BRL"},
                {"BRL", "COP"},
                {"USD", "COP"},
                {"COP", "USD"}
        };
        int opcao = 0;

        do {
            try {
                System.out.print("Escolha uma opção: ");
                opcao = scan.nextInt();

                if (opcao >= 1 && opcao <= 6) {
                    System.out.print("Digite o valor que deseja converter: ");
                    double valor = scan.nextDouble();

                    String moedaBase = conversoes[opcao - 1][0];
                    String moedaConvertida = conversoes[opcao - 1][1];

                    service.converteMoeda(moedaBase, moedaConvertida, valor);

                } else if (opcao != 7) {
                    System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Use apenas números.");
                scan.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (RuntimeException e) {
                System.out.println("Erro inesperado ao converter moeda.");
            }
        } while (opcao != 7);
        System.out.println("Programa encerrado.");
    }
}
