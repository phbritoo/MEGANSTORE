  
package negocio.basica;


public class Cliente {

    private Integer clienteCpf;
    private String clienteTel;
    private String clienteNome;

    public Integer getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(Integer cpf) {
        this.clienteCpf = cpf;
    }

    public String getClienteTel() {
        return clienteTel;
    }

    public void setClienteTel(String tel) {
        this.clienteTel = tel;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String nome) {
        this.clienteNome = nome;
    }

}    

