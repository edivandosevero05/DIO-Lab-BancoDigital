package NacionalBank.dominio;

import NacionalBank.interfaces.OperacoesFinanceiras;

public class Banco {
    private String nome;
    private String cnpj;
    private String numeroAgencia;

    public Banco(String nome, String cnpj, String numeroAgencia) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.numeroAgencia = numeroAgencia;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }
}
