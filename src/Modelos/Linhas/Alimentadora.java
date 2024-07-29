package Modelos.Linhas;

public class Alimentadora extends LinhaTipo2 {

    public Alimentadora(Integer sequencial,String nome,Integer idTerminal,String identificadorNoTerminal){
        super(sequencial, nome,idTerminal,identificadorNoTerminal);
    }

    @Override
    public String letraDaLinha(){
        return "A";
    }

}
