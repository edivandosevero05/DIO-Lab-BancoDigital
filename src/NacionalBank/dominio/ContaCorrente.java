package NacionalBank.dominio;

public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void extrato() {
        System.out.println("Conta Corrente");
        super.extrato();
    }
}
