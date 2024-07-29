package Modelos.Linhas;

public class Truncal extends LinhaTipo1 {

    public Truncal(Integer sequencial,String nome,Integer idTerminal,Integer variante){
        super(sequencial,nome,1,idTerminal,variante);
    }

    @Override
    public String letraDaLinha(){
        return "T";
    }

}
