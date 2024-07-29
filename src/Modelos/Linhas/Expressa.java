package Modelos.Linhas;

public class Expressa extends LinhaTipo1 {

    public Expressa(Integer sequencial,String nome,Integer idTerminal,Integer variante){
        super(sequencial,nome,1,idTerminal,variante);
    }

    @Override
    public String letraDaLinha(){
        return "E";
    }

}
