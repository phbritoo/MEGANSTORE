  
package negocio.basica;


public class Cliente {

    private Integer cli_cpf;
    private String cli_tel;
    private String cli_nome;

    public Integer getCli_cpf() {
        return cli_cpf;
    }

    public void setCli_cpf(Integer cpf) {
        this.cli_cpf = cpf;
    }

    public String getCli_tel() {
        return cli_tel;
    }

    public void setCli_tel(String tel) {
        this.cli_tel = tel;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String nome) {
        this.cli_nome = nome;
    }

}    

