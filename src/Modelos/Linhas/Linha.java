package Modelos.Linhas;

public abstract class Linha {
    private Integer sequencial;
    private String codigoIdentificador;
    private String nome;
    private Double tarifa;

    public Linha(Integer sequencial,String nome){
        setSequencial(sequencial);
        setNome(nome);
        setTarifa(4.5);
    }

    public void setSequencial(Integer sequencial){
        this.sequencial = sequencial;
    }

    public void setCodigoIdentificador(String codigoIdentificador){
        this.codigoIdentificador = codigoIdentificador;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setTarifa(Double tarifa){
        this.tarifa = tarifa;
    }

    public Integer getSequencial(){
        return sequencial;
    }

    public String getCodigoIdentificador(){
        return codigoIdentificador;
    }

    public String getNome(){
        return nome;
    }

    public Double getTarifa(){
        return tarifa;
    }

    public String letraDaLinha(){
        return "";
    }

    public String constroiCodigoIdentificador(){
        return "";
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof Linha)) return false;

        Linha l = (Linha) o;

        if(getNome().equals(l.getNome()) && getCodigoIdentificador().equals(l.getCodigoIdentificador())){
            return true;
        }

        return false;
    }

    @Override
    public String toString(){
        return getCodigoIdentificador()+" - "+getNome();
    }
}
