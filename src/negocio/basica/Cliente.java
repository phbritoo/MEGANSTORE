  
package negocio.basica;


public class Cliente {

    private String clienteCpf;
    private String clienteTel;
    private String clienteNome;

    public String getClienteCpf() {
        return clienteCpf;
    }

    public void setClienteCpf(String cpf) {
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
    
    @Override
    public String toString(){
        return getClienteNome();
    }

}    

