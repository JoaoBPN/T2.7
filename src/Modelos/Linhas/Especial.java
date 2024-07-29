package Modelos.Linhas;
import java.util.Date;

public class Especial extends LinhaTipo2 {
    private Date dataInicial;
    private Date dataFinal;

    public Especial(Integer sequencial,String nome,String identificadorNoTerminal,Integer idTerminal,Date dataInicial,Date dataFinal){
        super(sequencial,nome,idTerminal,identificadorNoTerminal);
        setDataInicial(dataInicial);
        setDataFinal(dataFinal);
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    @Override
    public String letraDaLinha(){
        return "S";
    }

    @Override
    public String toString(){
        return "Código: "+ getCodigoIdentificador() + "\n" +
                "Nome: "+ getNome() + "\n"+
                "Tarifa: "+ getTarifa() + "\n"+
                "Inicio: " + getDataInicial() +"\n"+
                "Fim: " + getDataFinal() +"\n ";

    }
}
