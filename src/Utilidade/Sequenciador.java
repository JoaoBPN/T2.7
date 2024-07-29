package Utilidade;

public class Sequenciador {

    private Integer sequencial;

    public Sequenciador(){
        sequencial = 0;
    }

    public Integer getNextSequencial(){
        sequencial++;
        return sequencial;
    }
}
