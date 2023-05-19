import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CadastroClientes {
    private List<Cliente> clientes;

    public CadastroClientes() {
        clientes = new ArrayList<>();
    }

    public void cadastrarCliente(String nome, String endereco, String telefone) {
        Cliente cliente = new Cliente(nome, endereco, telefone);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void exibirClientes() {
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("----------------------");
        }
    }

    public static void main(String[] args) {
        CadastroClientes cadastro = new CadastroClientes();
        Scanner scanner = new Scanner(System.in);

        boolean executando = true;
        while (executando) {
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Exibir clientes");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.next();
                    System.out.print("Digite o endereço do cliente: ");
                    String endereco = scanner.next();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = scanner.next();
                    cadastro.cadastrarCliente(nome, endereco, telefone);
                    break;
                case 2:
                    cadastro.exibirClientes();
                    break;
                case 3:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        System.out.println("Encerrando o programa...");
        scanner.close();
    }
}
