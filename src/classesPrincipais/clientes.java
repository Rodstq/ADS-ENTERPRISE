package classesPrincipais;

import java.util.Date;

public class clientes {

    private String cpfCliente;
    private String nomeCliente;
    private Date dataNascimentoCliente;
    private String telefoneCliente;
    private String estadoCliente;
    private String cidadeCliente;
    private String bairroCliente;
    private String cepCliente;
    private String ruaCliente;
    private String descricaoRuaCliente;

    public void setCpf(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCpf() {
        return cpfCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setDataNascimentoCliente(Date dataNascimentoCliente) {
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public Date getDataNascimentoCliente() {
        return this.dataNascimentoCliente;
    }

    public void setTelefoneCliente(String telefone) {
        this.telefoneCliente = telefone;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getEstadoCliente() {
        return this.estadoCliente;
    }

    public void setCidadeCliente(String cidadeCliente) {
        this.cidadeCliente = cidadeCliente;
    }

    public String getCidadeCliente() {
        return this.cidadeCliente;
    }

    public void setBairroCliente(String bairroCliente) {
        this.bairroCliente = bairroCliente;
    }

    public String getBairroCliente() {
        return this.bairroCliente;
    }

    public void setCepCliente(String cepCliente) {
        this.cepCliente = cepCliente;
    }

    public String getCepCliente() {
        return cepCliente;
    }

    public void setRuaCliente(String ruaCliente) {
        this.ruaCliente = ruaCliente;
    }

    public String getRuaCliente() {
        return this.ruaCliente;
    }

    public void setDescricaoRuaCliente(String descricaoRuaCliente) {
        this.descricaoRuaCliente = descricaoRuaCliente;
    }

    public String getDescricaoRuaCliente() {
        return this.descricaoRuaCliente;
    }

    public clientes(String nomeCliente, String cpfCliente, Date dataNascimentoCliente, String telefoneCliente,
            String estadoCliente, String cidadeCliente, String bairroCliente, String cepCliente, String ruaCliente,
            String descricaoRuaCliente) {

        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.dataNascimentoCliente = dataNascimentoCliente;
        this.telefoneCliente = telefoneCliente;
        this.estadoCliente = estadoCliente;
        this.cidadeCliente = cidadeCliente;
        this.bairroCliente = bairroCliente;
        this.ruaCliente = ruaCliente;
        this.descricaoRuaCliente = descricaoRuaCliente;
    }

    public clientes() {
    }
}