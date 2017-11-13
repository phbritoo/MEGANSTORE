/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio.basica;

/**
 *
 * @author paulo
 */
public class Pagamento {
    private Integer cardParcelas;
    private Double cardValor;
    private String cardNum;
    private String cardValidade;
    private String cardTitular;

    /**
     * @return the cardParcelas
     */
    public Integer getCardParcelas() {
        return cardParcelas;
    }

    /**
     * @param cardParcelas the cardParcelas to set
     */
    public void setCardParcelas(Integer cardParcelas) {
        this.cardParcelas = cardParcelas;
    }

    /**
     * @return the cardValor
     */
    public Double getCardValor() {
        return cardValor;
    }

    /**
     * @param cardValor the cardValor to set
     */
    public void setCardValor(Double cardValor) {
        this.cardValor = cardValor;
    }

    /**
     * @return the cardNum
     */
    public String getCardNum() {
        return cardNum;
    }

    /**
     * @param cardNum the cardNum to set
     */
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum.trim();
    }

    /**
     * @return the cardValidade
     */
    public String getCardValidade() {
        return cardValidade;
    }

    /**
     * @param cardValidade the cardValidade to set
     */
    public void setCardValidade(String cardValidade) {
        this.cardValidade = cardValidade.trim();
    }

    /**
     * @return the cardTitular
     */
    public String getCardTitular() {
        return cardTitular;
    }

    /**
     * @param cardTitular the cardTitular to set
     */
    public void setCardTitular(String cardTitular) {
        this.cardTitular = cardTitular.trim();
    }
    
}
