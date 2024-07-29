package Modelos.Linhas;

// o tipo um de linha é feito para cobrir os tipos, Truncal, Expressa e Interbairro, já que todas tem variante, id de terminal tanto de origem quanto de destino


public abstract class LinhaTipo1 extends Linha{
    private Integer idTerminalOrigem;
    private Integer idTerminalDestino;
    private Integer variante;

    public LinhaTipo1(Integer sequencial,String nome,Integer idTerminalOrigem,Integer idTerminalDestino,Integer variante){
        super(sequencial,nome);
        setIdTerminalOrigem(idTerminalOrigem);
        setIdTerminalDestino(idTerminalDestino);
        setVariante(variante);
        setCodigoIdentificador(constroiCodigoIdentificador());
    }

    public void setIdTerminalOrigem(Integer idTerminalOrigem){
        this.idTerminalOrigem = idTerminalOrigem;
    }

    public void setIdTerminalDestino(Integer idTerminalDestino){
        this.idTerminalDestino = idTerminalDestino;
    }

    public void setVariante(Integer variante){
        this.variante = variante;
    }

    public Integer getIdTerminalOrigem(){
        return idTerminalOrigem;
    }

    public Integer getIdTerminalDestino(){
        return idTerminalDestino;
    }

    public Integer getVariante(){
        return variante;
    }

    @Override
    public String constroiCodigoIdentificador(){
        return letraDaLinha()+getIdTerminalOrigem()+getIdTerminalDestino()+getVariante();
    }

}
