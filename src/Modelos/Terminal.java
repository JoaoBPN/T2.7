package Modelos;
import Modelos.Linhas.Linha;
import java.util.HashMap;
import java.util.Map;

public class Terminal {
    private Integer sequencial;
    private String nome;
    private String bairro;
    private final Map<String,Linha> linhasDoTerminal = new HashMap<>();

    public Terminal(Integer sequencial,String nome,String bairro){
        setSequencial(sequencial);
        setNome(nome);
        setBairro(bairro);
    }

    public void setSequencial(Integer sequencial){
        this.sequencial = sequencial;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public Integer getSequencial(){
        return sequencial;
    }

    public String getNome(){
        return nome;
    }

    public String getBairro(){
        return bairro;
    }

    public void adicionaLinha(Linha linha){
        String codigoIdentificador = linha.getCodigoIdentificador();
        linhasDoTerminal.put(codigoIdentificador,linha);
    }

    public void removeLinha(String codigoIdentificador){
        linhasDoTerminal.remove(codigoIdentificador);
    }

    public void exibeLinhasDoTerminal(){
        for(Map.Entry<String,Linha> l:linhasDoTerminal.entrySet()){
            System.out.println(l.getValue());
        }
        System.out.println("Total de linhas: "+quantidadeDeLinhas());
    }

    public Integer quantidadeDeLinhas(){
        return linhasDoTerminal.size();
    }

    public Integer buscarPorProximaVariante(String tipo,Integer idTerminalDestino){
        String str = tipo + getSequencial() + idTerminalDestino;

        for (int i = 0; i < 10; i++) {
            String teste = str + i;
            if(!linhasDoTerminal.containsKey(str)){
                return i;
            }
        }

        return -1;
    }

    public String buscaPorProximoIdentificador(String tipo,Integer idTerminal){
        String str = tipo + idTerminal;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String codigo = str + i + j;
                if(!linhasDoTerminal.containsKey(codigo)){
                    if(i == 0){
                        return "0" + j;
                    }

                    return String.valueOf(10*i + j);
                }
            }
        }

        return "";
    }

    @Override
    public String toString(){
        return  getSequencial() + " - " + getNome();

    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Terminal))return false;

        Terminal t = (Terminal) o;

        if(getNome().equals(t.getNome()) && getBairro().equals(t.getBairro()) && getSequencial().equals(t.getSequencial())){
            return true;
        }

        return false;
    }

}
