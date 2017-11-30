/*
 * Classe básica Cliente com seus
 * atributos mais gets e sets
 * PROJETO PROGRAMAÇÃO ORIENTADA A OBJETOS - PROF TITO KENZO 
 * FACULDADE UNIBRATEC - RECIFE - PERNAMBUCO - BRASIL - NOVEMBRO/2017
 */  
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
    
    /**
     * método da super classe String que
     * @return o nome do cliente para ser inserido na jTable
     */
    @Override
    public String toString(){
        return getClienteNome();
    }

}    

