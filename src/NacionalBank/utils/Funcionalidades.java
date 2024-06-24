package NacionalBank.utils;

import NacionalBank.dominio.Conta;

import java.util.List;

public class Funcionalidades {
    public static boolean gerarBoolRadomico() {
        //Serve para simular a aprovação do emprestimo
        return Math.random() < 0.5;
    }
    public static Conta listarContas(List<Conta> contas, String cpf) {
        if (!contas.isEmpty()) {
            for (Conta conta : contas) {
                if (conta.getCliente().getCpf().equals(cpf))
                    return  conta;
            }
        }
        throw new Error("Conta não encontrada!");
    }
}
