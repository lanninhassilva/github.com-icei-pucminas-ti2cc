package principal;

import java.util.Scanner;

import dao.PessoaDAO;
import model.Pessoa;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PessoaDAO dao = new PessoaDAO();

        int opcao;

        do {

            System.out.println("\n1 - Listar");
            System.out.println("2 - Inserir");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Sair");

            opcao = sc.nextInt();

            if (opcao == 1) {

                dao.listar();

            }

            if (opcao == 2) {

                Pessoa p = new Pessoa();

                System.out.println("Nome:");
                p.setNome(sc.next());

                System.out.println("Idade:");
                p.setIdade(sc.nextInt());

                dao.inserir(p);

            }

            if (opcao == 3) {

                Pessoa p = new Pessoa();

                System.out.println("ID:");
                p.setId(sc.nextInt());

                System.out.println("Novo nome:");
                p.setNome(sc.next());

                System.out.println("Nova idade:");
                p.setIdade(sc.nextInt());

                dao.atualizar(p);

            }

            if (opcao == 4) {

                System.out.println("ID para excluir:");
                int id = sc.nextInt();

                dao.excluir(id);

            }

        } while (opcao != 5);

        sc.close();
    }
}