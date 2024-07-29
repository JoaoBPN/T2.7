import Modelos.Linhas.*;
import Modelos.Terminal;
import Utilidade.Sequenciador;
import Utilidade.SuperScanner;

import java.util.*;

public class Gerencia {
    private String nome;
    private final Sequenciador sequenciador = new Sequenciador();
    private final Map<String,Linha> linhas = new HashMap<>();
    private final Map<Integer,Terminal> terminais = new HashMap<>();

    public Gerencia(String nome){
        setNome(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void exibeTerminais(){
        for(Map.Entry<Integer,Terminal> t: terminais.entrySet()){
            System.out.println(t.getValue());
        }
    }

    public void adicionaTerminal(){
        Integer sequenciador = sequenciadorDeTerminalDisponivel();
        if(sequenciador == -1){
            System.out.println("Não é possível criar um novo terminal,o limite de 10 foi atingido");
            return;
        }

        System.out.println("Digite o nome do terminal");
        String nome = SuperScanner.getString();
        System.out.println("Digite o bairro do terminal");
        String bairro = SuperScanner.getString();
        Terminal terminal = new Terminal(sequenciador,nome,bairro);

        if(sequenciador == 1 || nome.equals("Terminal Central")){
            if(!nome.equals("Terminal Central") || sequenciador != 1){
                System.out.println("O código 1 só é valido para o Terminal Central, o contrário também é verdade");
                return;
            }
        }

        if(atributosUnicosDeTerminal(terminal)) {
            terminais.put(sequenciador, terminal);
            return;
        }

        System.out.println("Não foi possível adicionar, outro terminal estava com alguma caracteristica repetida");

    }

    public void adicionaTerminalTESTE(Integer sequenciador,Terminal terminal){
        terminais.put(sequenciador,terminal);
    }

    public boolean atributosUnicosDeTerminal(Terminal terminal){
        for(Map.Entry<Integer,Terminal> t: terminais.entrySet()){
            if(t.getValue().getNome().equals(terminal.getNome())){
                return false;
            }
            if(t.getValue().getBairro().equals(terminal.getBairro())){
                return false;
            }
            if(t.getValue().getSequencial().equals(terminal.getSequencial())){
                return false;
            }
        }

        return true;
    }

    public void removeTerminal(){
        System.out.println("Digite o nome do terminal a ser removido");
        String nome = SuperScanner.getString();
        Integer chave = -1;

        for(Map.Entry<Integer,Terminal> t: terminais.entrySet()){
            if(t.getValue().getNome().equals(nome)){
                chave = t.getKey();
                break;
            }
        }
        if(chave != -1) {
            terminais.remove(chave);
        }
    }

    public void alteraNomeTerminal(){
        System.out.println("Digite o nome do terminal antigo");
        String nome = SuperScanner.getString();

        for(Map.Entry<Integer,Terminal> t: terminais.entrySet()){
            if(t.getValue().getNome().equals(nome)){
                if(t.getValue().getNome().equals("Terminal Central")){
                    System.out.println("Impossível alterar o nome do Terminal Central");
                    return;
                }
                System.out.println("Digite o nome nome");
                String novoNome = SuperScanner.getString();
                t.getValue().setNome(novoNome);
            }
        }
    }

    public Integer sequenciadorDeTerminalDisponivel(){
        for (int i = 1; i < 10; i++) {
            if(!terminais.containsKey(i)){
                return i;
            }
        }
        if(!terminais.containsKey(0)){
            return 0;
        }

        return -1;
    }

    public void exibeLinhaPorCodigo(){
        System.out.println("Digite o código da linha");
        String codigoIdentificador = SuperScanner.getString();

        if(linhas.containsKey(codigoIdentificador)){
            System.out.println(linhas.get(codigoIdentificador));
        }
    }

    public void exibeLinhaPorTerminal(){
        System.out.println("Digite o nome do terminal");
        String nome = SuperScanner.getString();

        for(Map.Entry<Integer,Terminal> t: terminais.entrySet()){
            if(t.getValue().getNome().equals(nome)){
                t.getValue().exibeLinhasDoTerminal();
            }
        }
    }

    public void adicionaLinha(){
        System.out.println("""
                Selecione o tipo da linha:
                A - Alimentadora
                I - Interbairro
                T - Truncal
                E - Expressa
                D - Rural
                S - Especial
                """);

        String tipo = SuperScanner.getString();

        switch(tipo.toLowerCase()){
            case "a":
                cadastraLinhaComUmTerminal("Alimentadora");
                break;
            case "i":
                cadastraLinhaComDoisTerminais("Interbairros");
                break;
            case "t":
                cadastraLinhaComDoisTerminais("Truncal");
                break;
            case "e":
                cadastraLinhaComDoisTerminais("Expressa");
                break;
            case "d":
                cadastraLinhaComUmTerminal("Rural");
                break;
            case "s":
                cadastraLinhaComUmTerminal("Especial");
                break;
            default:
                System.out.println("Opção invalida, cancelando operação");
                break;
        }
    }

    public void exibeLinhaPorTipo(){
        System.out.println("""
                Selecione o tipo da linha:
                A - Alimentadora
                I - Interbairro
                T - Truncal
                E - Expressa
                D - Rural
                S - Especial
                """);

        String tipo = SuperScanner.getString();
        int cont = 0;

        for(Map.Entry<String,Linha> l: linhas.entrySet()){
            if(l.getValue().letraDaLinha().equals(tipo)){
                cont++;
                System.out.println(l);
            }
        }

        System.out.println("Toltal de linhas: "+cont);
    }

    public void cadastraLinhaComUmTerminal(String tipo){
        Integer sequencial = sequenciador.getNextSequencial();
        System.out.println("Digite o nome da linha");
        String nome = SuperScanner.getString();
        System.out.println("Informe o id do terminal da linha");
        Integer idTerminal = SuperScanner.getInteger();
        System.out.println("Digite o identificador de dois digitos da linha");

        String str = String.valueOf(tipo.charAt(0));

        String idNoTerminal = terminais.get(idTerminal).buscaPorProximoIdentificador(str,idTerminal);

        Linha linha = null;
        if(tipo.equals("Alimentadora")){
            linha = new Alimentadora(sequencial,nome,idTerminal,idNoTerminal);
        }
        if(tipo.equals("Rural")){
            linha = new Rural(sequencial,nome,idTerminal,idNoTerminal);
        }
        if(tipo.equals("Especial")){
            System.out.println("Digite o ano de incio");
            int ano = SuperScanner.getInteger();
            System.out.println("Digite o mes de inicio, no formato numérico");
            int mes = SuperScanner.getInteger();
            System.out.println("Digite o dia de inicio");
            int dia = SuperScanner.getInteger();
            Date dataI = new Date(ano,mes,dia);
            System.out.println("Digite o ano de encerramento");
            ano = SuperScanner.getInteger();
            System.out.println("Digite o mes de encerramento, no formato numérico");
            mes = SuperScanner.getInteger();
            System.out.println("Digite o dia de encerramneto");
            dia = SuperScanner.getInteger();
            Date dataF = new Date(ano,mes,dia);
            linha = new Especial(sequencial,nome,idNoTerminal,idTerminal,dataI,dataF);
        }

        for(Map.Entry<Integer,Terminal> t: terminais.entrySet()){
            if(t.getValue().getSequencial().equals(idTerminal)){
                if(linha != null){
                    t.getValue().adicionaLinha(linha);
                    linhas.put(linha.getCodigoIdentificador(),linha);
                    System.out.println("Linha adicionada com sucesso");
                    return;
                }
            }
        }
        System.out.println("Não foi possível adicionar corretamente");
    }

    public void cadastraLinhaComDoisTerminais(String tipo){
        Integer sequencial = sequenciador.getNextSequencial();
        System.out.println("Digite o nome da linha");
        String nome = SuperScanner.getString();

        int cont = 0;
        Integer idOrigem = -1;
        Integer idDestino = -1;
        Integer variante = -1;
        Linha linha = null;

        if(tipo.equals("Truncal")){
            idOrigem = 1;
            System.out.println("Digite o id do terminal de Destino");
            idDestino = SuperScanner.getInteger();
            variante = terminais.get(idOrigem).buscarPorProximaVariante("T",idDestino);
            linha = new Truncal(sequencial,nome,idDestino,variante);

        }
        if(tipo.equals("Expressa")) {
            idOrigem = 1;
            System.out.println("Digite o id do outro terminal");
            idDestino = SuperScanner.getInteger();
            variante = terminais.get(idOrigem).buscarPorProximaVariante("E",idDestino);
            linha = new Expressa(sequencial, nome,idDestino,variante);
        }
        if(tipo.equals("Interbairros")){
            System.out.println("Digite o id do terminal de origem");
            idOrigem = SuperScanner.getInteger();
            System.out.println("Digite o id do terminal de destino");
            idDestino = SuperScanner.getInteger();
            variante = terminais.get(idOrigem).buscarPorProximaVariante("I",idDestino);
            linha = new InterBairro(sequencial,nome,idOrigem,idDestino,variante);
        }

        if(variante == -1){
            System.out.println("Limite de variantes atingido, não é possível concluir o cadastro");
            return;
        }

        for(Map.Entry<Integer,Terminal> t: terminais.entrySet()){
            if(t.getValue().getSequencial().equals(idOrigem) || t.getValue().getSequencial().equals(idDestino)){
                t.getValue().adicionaLinha(linha);
                cont++;
            }
        }

        if(cont == 2){
            linhas.put(linha.getCodigoIdentificador(),linha);
            System.out.println("Linha adicionada aos terminais com sucesso");
            return;
        }

        for(Map.Entry<Integer,Terminal> t: terminais.entrySet()){
            if(t.getValue().getSequencial().equals(idOrigem) || t.getValue().getSequencial().equals(idDestino)){
                if(linha != null){
                    t.getValue().removeLinha(linha.getCodigoIdentificador());
                }
            }
        }
        System.out.println("Não foi possível adicionar corretamente");
    }

    public void removeLinha(){
        System.out.println("Digite o código identificador da linha");
        String codigoIdentificador = SuperScanner.getString();

        String tipo = String.valueOf(codigoIdentificador.charAt(0));

        Integer idTerminal = Integer.parseInt(String.valueOf(codigoIdentificador.charAt(1)));

        if(linhas.containsKey(codigoIdentificador)) {
            if (tipo.equals("A") || tipo.equals("D") || tipo.equals("S")) {
                terminais.get(idTerminal).removeLinha(codigoIdentificador);
                linhas.remove(codigoIdentificador);
                System.out.println("Linha removida com sucesso");
                return;
            }
            if (tipo.equals("I") || tipo.equals("T") || tipo.equals("E")) {
                Integer idTerminal2 = Integer.parseInt(String.valueOf(codigoIdentificador.charAt(2)));
                terminais.get(idTerminal).removeLinha(codigoIdentificador);
                terminais.get(idTerminal2).removeLinha(codigoIdentificador);
                linhas.remove(codigoIdentificador);
                System.out.println("Linha removida com sucesso");
                return;
            }
        }

        System.out.println("Linha não encontrada");

    }

    public void alteraTarifa(){
        System.out.println("Digite o código identificador da linha");
        String codigo = SuperScanner.getString();
        System.out.println("Digite a nova tarifa");
        Double tarifa = SuperScanner.getDouble();

        linhas.get(codigo).setTarifa(tarifa);
    }

    public Integer quantidadeDeLinhas(){
        return linhas.size();
    } //coloquei a quantidade de linhas cadastradas por tipo na impressão de linhas por tipo,
      //a quantidade de linhas em um terminal na exibição de linhas por terminal,
      //contudo não encontrei um bom lugar para exibir essa quantidade, então deixei apenas a função

}
