package Modelos.Linhas;

// o tipo dois de linha é feito para cobrir os Alimentadora, Rural e especial, já que todas tem id de Terminal e um identificador de 2 digitos no Terminal

public abstract class LinhaTipo2 extends Linha{
    private Integer idTerminal;
    private String identificadorNoTerminal;

    public LinhaTipo2(Integer sequencial,String nome,Integer idTerminal,String identificadorNoTerminal){
        super(sequencial,nome);
        setIdentificadorNoTerminal(identificadorNoTerminal);
        setIdTerminal(idTerminal);
        setCodigoIdentificador(constroiCodigoIdentificador());
    }

    public void setIdTerminal(Integer idTerminal){
        this.idTerminal = idTerminal;
    }

    public void setIdentificadorNoTerminal(String identificadorNoTerminal){
        this.identificadorNoTerminal = identificadorNoTerminal;
    }

    public Integer getIdTerminal(){
        return idTerminal;
    }

    public String getIdentificadorNoTerminal(){
        return identificadorNoTerminal;
    }

    @Override
    public String constroiCodigoIdentificador(){
        return letraDaLinha()+getIdTerminal()+getIdentificadorNoTerminal();
    }
}
