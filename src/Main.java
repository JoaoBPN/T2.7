import Modelos.Terminal;
import Utilidade.SuperScanner;

public class Main {
    static Gerencia gerencia = new Gerencia("Gerencia");

    public static void main(String[] args) {
        Terminal t1 = new Terminal(1,"Terminal Central","Centro");
        Terminal t2 = new Terminal(2,"Terminal Umuarama","Umuarama");
        Terminal t3 = new Terminal(3,"Terminal Santa Luzia","Santa Luzia");
        Terminal t4 = new Terminal(4,"Terminal Planalto","Planalto");
        Terminal t5 = new Terminal(5,"Terminal Industrial","Distrito Industrial");
        Terminal t6 = new Terminal(6,"Terminal Novo Mundo","Novo mundo");
        Terminal t7 = new Terminal(7,"Terminal Dona Zulmira","Dona Zulmira");
        Terminal t8 = new Terminal(8,"Terminal Canaã","Canaã");

        gerencia.adicionaTerminalTESTE(t1.getSequencial(),t1);
        gerencia.adicionaTerminalTESTE(t2.getSequencial(),t2);
        gerencia.adicionaTerminalTESTE(t3.getSequencial(),t3);
        gerencia.adicionaTerminalTESTE(t4.getSequencial(),t4);
        gerencia.adicionaTerminalTESTE(t5.getSequencial(),t5);
        gerencia.adicionaTerminalTESTE(t6.getSequencial(),t6);
        gerencia.adicionaTerminalTESTE(t7.getSequencial(),t7);
        gerencia.adicionaTerminalTESTE(t8.getSequencial(),t8);

        mainSwitch();
    }

    private static void mainSwitch(){
        int opcao = -1;

        while(opcao != 3){
            opcao = mainMenu();

            switch (opcao){
                case 1:
                    terminalSwitch();
                    break;
                case 2:
                    linhaSwitch();
                    break;
                case 3:
                    System.out.println("Encerrando o código...");
                    break;
                default:
                    System.out.println("Operação invalida, tente novamente");
                    break;
            }
        }
    }


    private static void terminalSwitch(){
        int opcao = -1;

        while(opcao != 0){
            opcao = terminalMenu();

            switch (opcao){
                case 1:
                    gerencia.exibeTerminais();
                    break;
                case 2:
                    gerencia.adicionaTerminal();
                    break;
                case 3:
                    gerencia.removeTerminal();
                    break;
                case 4:
                    gerencia.alteraNomeTerminal();
                    break;
                case 5:
                    System.out.println("Encerrando operação...");
                    break;
                default:
                    System.out.println("Operação invalida, tente novamente");
                    break;
            }
        }
    }

    private static void linhaSwitch(){
        int opcao = -1;

        while(opcao != 6){
            opcao = linhaMenu();

            switch (opcao){
                case 1:
                    gerencia.exibeLinhaPorCodigo();
                    break;
                case 2:
                    gerencia.exibeLinhaPorTerminal();
                    break;
                case 3:
                    gerencia.exibeLinhaPorTipo();
                    break;
                case 4:
                    gerencia.adicionaLinha();
                    break;
                case 5:
                    gerencia.removeLinha();
                    break;
                case 6:
                    gerencia.alteraTarifa();
                    break;
                case 7:
                    System.out.println("Encerrando operação...");
                    break;
                default:
                    System.out.println("Operação invalida, tente novamente");
                    break;
            }
        }
    }

    private static int mainMenu(){
        System.out.println("""
                Selecione uma operação:
                1 - Operações de terminal
                2 - Operações de linha
                3 - Encerrar o código
                """);

        return SuperScanner.getInteger();
    }

    private static int terminalMenu(){
        System.out.println("""
                Selecione uma operação:
                1 - Exibir terminais
                2 - Adicionar terminal
                3 - Remover terminal
                4 - Alterar nome de terminal
                5 - Encerrar operação
                """);

        return SuperScanner.getInteger();
    }

    private static int linhaMenu(){
        System.out.println("""
                Selecione uma operação:
                1 - Exibir linha por código
                2 - Exibir linha por terminal
                3 - Exibir linha por tipo
                4 - Adicionar linha
                5 - Remover linha
                6 - Alterar tarifa
                7 - Encerrar operação
                """);

        return SuperScanner.getInteger();
    }

}
