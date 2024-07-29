package Modelos.Linhas;

public class InterBairro extends LinhaTipo1 {

    public InterBairro(Integer sequencial,String nome,Integer idOrigem,Integer idDestino,Integer variante){
        super(sequencial,nome,idOrigem,idDestino,variante);
    }
    @Override
    public String letraDaLinha(){
        return "I";
    }

}
