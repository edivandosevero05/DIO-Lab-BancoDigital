package NacionalBank.dominio;

import NacionalBank.interfaces.OperacoesFinanceiras;
import NacionalBank.utils.Funcionalidades;

public class Conta implements OperacoesFinanceiras {
    protected int agencia;
    protected int conta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo)
            saldo -= valor;
        else
            System.out.println("Saldo insuficiente para esta operação");
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (valor <= saldo) {
            sacar(valor);
            contaDestino.depositar(valor);
        }
        else
            System.out.println("Saldo insuficiente para esta operação");
    }

    @Override
    public void extrato() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.conta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    @Override
    public void emprestimo(double valor) {
        if(Funcionalidades.gerarBoolRadomico()) {
            this.depositar(valor);
            System.out.println(String.format("Emprestimo aprovado no valor: %d ", valor));
        }
    }
}
