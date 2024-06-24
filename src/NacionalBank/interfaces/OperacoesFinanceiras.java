package NacionalBank.interfaces;

import NacionalBank.dominio.Conta;

public interface OperacoesFinanceiras {
    public void depositar(double valor);
    public void sacar(double valor);
    public void transferir(double valor, Conta contaDestino);
    public void extrato();
    public void emprestimo(double valor);
}
