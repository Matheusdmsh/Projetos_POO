/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import projeto.Pessoa;

/**
 *
 * @author Matheus
 */
public class pessoaDAO {

    private static pessoaDAO dao;
    private Pessoa[] pessoas = new Pessoa[5];
    Scanner scanner = new Scanner(System.in);

  
    
  
    /* //Menu Sem Dao Criado para Testar os Metodos.
    public pessoaDAO() {
        int opcaoUsuario = 10;

        while (opcaoUsuario != 9) {
            opcaoUsuario = this.recebeOpcaoUsuario();
            switch (opcaoUsuario) {
                case 0:
                    int posicaoLivre = this.proximaPosicaoLivre();
                    if (posicaoLivre != -1) {
                        Pessoa p = this.criaPessoa();
                        pessoas[posicaoLivre] = p;
                        System.out.println("Pessoa inserida com sucesso!");
                    } else {
                        System.out.println("Nao pode add mais pessoas.");
                    }
                    break;
                case 1:
                    mostrarPessoas();
                    break;
                case 2:
                    mostrarPessoas();

                    long idSerExcluido = menuExclusaoPessoa();

                    if (this.excluir(idSerExcluido)) {
                        System.out.println("Excluido com sucesso! ");

                    } else {
                        System.out.println("Não doi excluido! ");
                    }

                    break;
                case 3:
                    mostrarPessoas();
                    long idASerAlterado = menuAlterarPessoa();
                    System.out.println("Qual é o novo nome...: ");
                    String novoNome = scanner.nextLine();

                    System.out.println("Qual é o novo sexo...: ");
                    String novoSexo = scanner.nextLine();

                    System.out.println("Qual é o novo Tipo de Usuario..: ");
                    String novoTipoUsuario = scanner.nextLine();

                    System.out.println("Qual é o novo Login...: ");
                    String novoLogin = scanner.nextLine();

                    System.out.println("Qual é a nova Senha....: ");
                    String novaSenha = scanner.nextLine();

                    if (this.altera(idASerAlterado, novoNome, novoSexo, novoLogin, novaSenha, novoTipoUsuario)) {
                        System.out.println("Pessoa Alterada com sucesso! ");
                    } else {
                        System.out.println("Não foi possível alterar!");
                    }

                    break;
                case 9:
                    System.out.println("Sair");
                    break;
                default:
                    break;

            }
        }
        System.out.println("Obrigado por ter usado o Programa! ");
    }

    private int recebeOpcaoUsuario() {
        StringBuilder builder = new StringBuilder("");
        builder.append("SEJA BEM VINDO AO MEU PROGRAMA\n\n");
        builder.append("\n0 - Para inserir pessoa");
        builder.append("\n1 - Listar pessoas");
        builder.append("\n2 - Excluir um pessoa");
        builder.append("\n3 - Alterar um pessoa");
        builder.append("\n4 - Buscar salários > 5000");
        builder.append("\n9 - Para sair do programa\n");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    private long menuExclusaoPessoa() {
        System.out.println("Qual pessoa deseja excluir...: ");
        long idSerExcluido = Long.parseLong(scanner.nextLine());

        return idSerExcluido;

    }

    private long menuAlterarPessoa() {
        System.out.println("Qual pessoa deseja alterar...: ");
        long idSerAlterado = Long.parseLong(scanner.nextLine());
        return idSerAlterado;
    }*/
 

    Pessoa buscaPessoaLogin(String login, String senha) {
        for (Pessoa p : pessoas) {
            if (p != null && p.getLogin().equals(login) && p.getSenha().equals(senha)) {
                return p;
            }
        }
        return null;
    }

    public Pessoa criaPessoa() {
        Pessoa p = new Pessoa();

        System.out.println("nome...: ");
        p.setNome(scanner.nextLine());

        System.out.println("Sexo...:");
        p.setSexo(scanner.nextLine());

        System.out.println("Tipo de Usuario...:");
        p.setTipoUsuario(scanner.nextLine());

        System.out.println("Login...:");
        p.setLogin(scanner.nextLine());

        System.out.println("Senha...:");
        p.setSenha(scanner.nextLine());

        System.out.println("Entre com a data do seu nascimento...: ");
        String data_nasc = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate nascimento = LocalDate.parse(data_nasc, formatter);

        return p;

    }

    public boolean adicionar(Pessoa p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            pessoas[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }
    }

    public boolean vazio() {
        for (Pessoa pessoa : pessoas) {
            if (pessoa != null) {
                return false;
            }
        }
        return true;
    }

    public void mostrarPessoas() {
        boolean temPessoa = false;
        for (Pessoa p : pessoas) {
            if (p != null) {
                System.out.println(p);
                temPessoa = true;
            }
        }
        if (!temPessoa) {
            System.out.println("Não existe nenhuma pessoa cadastrada! ");
        }
    }

    private boolean altera(long idASerAlterado, String novoNome, String novoSexo, String novoLogin, String novaSenha, String novoTipoUsuario) {
        for (int i = 0; i < pessoas.length; i++) {

            if (pessoas[i].getId() == idASerAlterado) {
                pessoas[i].setNome(novoNome);
                pessoas[i].setSexo(novoSexo);
                pessoas[i].setLogin(novoLogin);
                pessoas[i].setSenha(novaSenha);
                pessoas[i].setTipoUsuario(novoTipoUsuario);
                return true;
            }
        }
        return false;

    }

    Pessoa buscarPorNome(String nome) {
        for (Pessoa p : pessoas) {
            if (p != null && p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

    Pessoa buscarPorId(long id) {
        for (Pessoa p : pessoas) {
            if (p != null && p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    private boolean excluir(long idSerExcluido) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i].getId() == idSerExcluido) {
                pessoas[i] = null;

                return true;

            }
        }
        return false;
    }

    public boolean remover(String nome) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equals(nome)) {
                pessoas[i] = null;
                return true;
            }
        }
        return false;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                return i;
            }
        }
        return -1;
    }

}
