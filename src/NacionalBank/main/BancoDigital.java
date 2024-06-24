package NacionalBank.main;

import NacionalBank.dominio.Cliente;
import NacionalBank.dominio.Conta;
import NacionalBank.dominio.ContaCorrente;
import NacionalBank.dominio.ContaPoupanca;
import NacionalBank.utils.Funcionalidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoDigital {
    public static void main(String[] args) {
        boolean sair = false;
        String operacao;
        Conta conta;
        String cpfOrigem;
        String cpfDestino;
        double valor;

        List<Conta> contas = new ArrayList<Conta>();
        Scanner entrada = new Scanner(System.in);

        System.out.println("-------------------------------------------------------");
        System.out.println("DIO - Banco Digital");
        System.out.println("-------------------------------------------------------");

        do {
            System.out.println("-------------------------------------------------------");

            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Exibir extrato");
            System.out.println("6 - Solicitar emprestimo");
            System.out.println("0 - Sair");
            System.out.println("-------------------------------------------------------");

            System.out.print("Selecione a operação: ");

            operacao = entrada.nextLine();

            switch (operacao) {
                case "0":
                    sair = true;
                    break;
                case "1":
                    System.out.println("Digite 1 para conta corrente ou 2 para conta poupança");
                    String tipo = entrada.nextLine();
                    System.out.println("Digite o nome completo");
                    String nome = entrada.nextLine();
                    System.out.println("Digite o CPF");
                    cpfOrigem = entrada.nextLine();
                    Cliente cliente = new Cliente(nome, cpfOrigem);
                    if (tipo.equals("1")) {
                        conta = new ContaCorrente(cliente, 0);
                        contas.add(conta);
                    } else if (tipo.equals("2")) {
                        conta = new ContaPoupanca(cliente, 0);
                        contas.add(conta);
                    } else {
                        System.out.println("Opção invalida!");
                    }
                    break;
                case "2":
                    try {
                        System.out.println("Digite o cpf da conta de destino");
                        cpfOrigem = entrada.nextLine();
                        System.out.println("Digite o valor a ser depositado!");
                        valor = entrada.nextDouble();
                        conta = Funcionalidades.listarContas(contas, cpfOrigem);
                        conta.depositar(valor);
                        conta.extrato();
                    } catch (Exception ex) {
                        System.out.println(String.format("Ocorreu um erro na operação: %s", ex.getMessage()));
                    }
                    break;
                case "3":
                    try {
                        System.out.println("Digite o cpf da conta de origem");
                        cpfOrigem = entrada.nextLine();
                        System.out.println("Digite o valor a ser sacado!");
                        valor = entrada.nextDouble();
                        conta = Funcionalidades.listarContas(contas, cpfOrigem);
                        conta.sacar(valor);
                        conta.extrato();
                    } catch (Exception ex) {
                        System.out.println(String.format("Ocorreu um erro na operação: %s", ex.getMessage()));
                    }
                    break;
                case "4":
                    try {
                        System.out.println("Digite o cpf da conta de origem");
                        cpfOrigem = entrada.nextLine();
                        System.out.println("Digite o cpf da conta de destino");
                        cpfDestino = entrada.nextLine();
                        System.out.println("Digite o valor a ser transferido!");
                        valor = entrada.nextDouble();
                        Conta contaOrigem = Funcionalidades.listarContas(contas, cpfOrigem);
                        Conta contaDestino = Funcionalidades.listarContas(contas, cpfOrigem);
                        contaOrigem.sacar(valor);
                        contaDestino.depositar(valor);
                        contaOrigem.extrato();
                    } catch (Exception ex) {
                        System.out.println(String.format("Ocorreu um erro na operação: %s", ex.getMessage()));
                    }
                    break;
                case "5":
                    try {
                        System.out.println("Digite o cpf da conta");
                        cpfOrigem = entrada.nextLine();
                        conta = Funcionalidades.listarContas(contas, cpfOrigem);
                        conta.extrato();
                    } catch (Exception ex) {
                        System.out.println(String.format("Ocorreu um erro na operação: %s", ex.getMessage()));
                    }
                    break;
                case "6":
                    try {
                        System.out.println("Digite o cpf da conta de destino");
                        cpfOrigem = entrada.nextLine();
                        System.out.println("Digite o valor do emprestimo!");
                        valor = entrada.nextDouble();
                        conta = Funcionalidades.listarContas(contas, cpfOrigem);
                        if (Funcionalidades.gerarBoolRadomico()) {
                            conta.depositar(valor);
                            System.out.println("Emprestimo realizado com sucesso!");
                            conta.extrato();
                        } else {
                            System.out.println("Não foi possivel liberar o valor solicitado para emprestimo!");
                        }
                    } catch (Exception ex) {
                        System.out.println(String.format("Ocorreu um erro na operação: %s", ex.getMessage()));
                    }
                    break;

            }

        } while (!sair);


        try {

        } catch (Exception ex) {

        }
    }
}
