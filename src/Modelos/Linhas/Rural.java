package Modelos.Linhas;

public class Rural extends LinhaTipo2 {

    public Rural(Integer sequencial,String nome,Integer idTerminal,String identificadorNoTerminal){
        super(sequencial,nome,idTerminal,identificadorNoTerminal);
    }

    @Override
    public String letraDaLinha(){
        return "D";
    }

    //Na linha rural eu fiquei com um questionamento, o ponto de referencia, pelo que eu vi, fica incluido no nome, então
    // eu acabei não criando um novo atributo para guardar essa caracteristica
}
