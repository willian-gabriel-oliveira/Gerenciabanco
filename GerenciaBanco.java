
package gerenciabanco;


import java.util.Scanner;

public class GerenciaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();

        System.out.println("Bem-vindo à aplicação de gerenciamento bancário!");

        do {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    conta.informarDadosPessoais(scanner);
                    break;
                case 2:
                    conta.consultarSaldo();
                    break;
                case 3:
                    conta.realizarDeposito(scanner);
                    break;
                case 4:
                    conta.realizarSaque(scanner);
                    break;
                case 5:
                    System.out.println("Encerrando a aplicação.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (true);
    }

    public static void exibirMenu() {
        System.out.println("\nOpções:");
        System.out.println("1. Informar dados pessoais");
        System.out.println("2. Consultar saldo");
        System.out.println("3. Realizar depósito");
        System.out.println("4. Realizar saque");
        System.out.println("5. Encerrar a aplicação");
        System.out.print("Escolha uma opção: ");
    }
}

class ContaBancaria {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public void informarDadosPessoais(Scanner scanner) {
        System.out.print("Informe seu nome: ");
        nome = scanner.next();

        System.out.print("Informe seu sobrenome: ");
        sobrenome = scanner.next();

        System.out.print("Informe seu CPF: ");
        cpf = scanner.next();
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: " + saldo);
    }

    public void realizarDeposito(Scanner scanner) {
        System.out.print("Informe o valor a depositar: ");
        double valorDeposito = scanner.nextDouble();
        saldo += valorDeposito;
        System.out.println("Depósito realizado com sucesso.");
    }

    public void realizarSaque(Scanner scanner) {
        System.out.print("Informe o valor a sacar: ");
        double valorSaque = scanner.nextDouble();
        if (saldo >= valorSaque) {
            saldo -= valorSaque;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}

