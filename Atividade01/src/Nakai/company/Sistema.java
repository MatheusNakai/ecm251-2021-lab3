package Nakai.company;

import java.util.Scanner;

public class Sistema {
    public static int MainMenu=0;
    public static int LogedMenu=0;
    public static Usuario usuarioLogado=null;

    public static void run(){
        Scanner scanner= new Scanner(System.in);
        while(Sistema.MainMenu!=3){
            switch (Sistema.MainMenu){
                case 0:
                    mostrarMainMenu();
                    System.out.println("Escolha uma Opcao:");
                    Sistema.MainMenu= scanner.nextInt();
                    break;
                case 1:
                    System.out.println("Informe os dados a seguir para criar usuario:");
                    System.out.println("Nome de Usuario:");
                    String nomeUsuarioConta=scanner.next();
                    System.out.println("Senha:");
                    String senha = scanner.next();
                    System.out.println("email:");
                    String email = scanner.next();

                    new Usuario(nomeUsuarioConta,email,senha);

                    break;
                case 2:
                    if(Sistema.usuarioLogado==null){
                        login(scanner);
                    }else{

                    }
                    }
            }
        }


    public static void mostrarMainMenu(){
        System.out.println("Por favor, escolha uma opção:");
        System.out.println("1 - Criar Usuario.");
        System.out.println("2 - Login como usuário.");
        System.out.println("3 - Terminar programa.");

    }
    private static void login(Scanner scanner){
        System.out.println("Insira as credenciais.");
        System.out.println("Nome:");
        String nomeDeUsuario=scanner.next();
        if(nomeDeUsuario.equals("")){
            System.out.println("Nome de Usuario invalido");
            Sistema.MainMenu=0;
            return;
        }
        System.out.println("Senha:");
        String senha=scanner.next();
        if(nomeDeUsuario.equals("")){
            System.out.println("senha invalida");
            Sistema.MainMenu=0;
            return;
    }
        if(Usuario.login(nomeDeUsuario,senha)){
            System.out.println("Login efetuado com sucesso.");
        }else{
            System.out.println("Nome de Usuario ou senha incorretos.");
        }

    }
    private static void logout(){
        String nome=Sistema.usuarioLogado.nomeInteiro;
        Sistema.usuarioLogado=null;
        Sistema.MainMenu=0;
        Sistema.LogedMenu=0;
        System.out.println("Usuario deslogado.");
    }
    private static void mostrarMenuDeUsuario(){
        System.out.println("Bem-vindo "+usuarioLogado.nomeInteiro+".");
        System.out.println("Escolha uma das opcoes:");
        System.out.println("1 - Exibir minhas contas");
        System.out.println("2 - Criar pedido de transferencia");
        System.out.println("3 - Realizar tranferência");
        System.out.println("4 - Criar Conta.");
        System.out.println("5 - Logout");
    }
    private static void ExecucaComandoUsuario(Scanner scanner){
        switch (Sistema.LogedMenu){
        case 1:
            System.out.println(Usuario.getContas(Sistema.usuarioLogado));
            break;
        case 2:
            System.out.println("Suas contas disponiveis:");
            System.out.println(Usuario.getContas(Sistema.usuarioLogado));
            int IdRecebedor = scanner.nextInt();

            if(!Sistema.usuarioLogado.verificacaContaId(IdRecebedor)){
                System.out.println("Voce Nao possui Conta com "+IdRecebedor+".");
                break;
            }
            System.out.println("Porfavor informe o valor:");
            double valorTransferido = scanner.nextDouble();


    }
    }
}
