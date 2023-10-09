/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import projeto.Alimento;
import java.util.Locale;

/**
 *
 * @author Matheus
 */
public class alimentoDAO {

    private Alimento[] alimentos = new Alimento[100];
    Scanner scanner = new Scanner(System.in);

    public alimentoDAO() {

    }

    public Alimento criaPessoa() {
        Alimento a = new Alimento();

        System.out.println("nome...: ");
        a.setNome(scanner.nextLine());

        System.out.println("Carboidratos...: ");
        a.setCarboidratos(scanner.nextDouble());

        System.out.println("Proteina...: ");
        a.setProteina(scanner.nextDouble());

        System.out.println("Gorduras...: ");
        a.setGordura(scanner.nextDouble());

        System.out.println("Tipo de Usuario...:");
        a.setTipoUsuario(scanner.nextLine());

        LocalDateTime dataCriacao = LocalDateTime.now();
        
        LocalDateTime dataModificacao = LocalDateTime.now();

        return a;

    }

    public boolean adicionar(Alimento a) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            alimentos[proximaPosicaoLivre] = a;
            return true;
        } else {
            return false;
        }
    }

    public boolean vazio() {
        for (Alimento alimento : alimentos) {
            if (alimento != null) {
                return false;
            }
        }
        return true;
    }

    public void mostrarAlimento() {
        boolean temAlimento = false;
        for (Alimento a : alimentos) {
            if (a != null) {
                System.out.println(a);
                temAlimento = true;
            }
        }
        if (!temAlimento) {
            System.out.println("Não existe nenhuma Alimento cadastrada! ");
        }
    }

    private boolean altera(long idASerAlterado, String novoNome, double novoCarboidrato, double novaProteina, double novaGordura, String novoTipoUsuario) {
        for (int i = 0; i < alimentos.length; i++) {

            if (alimentos[i].getId() == idASerAlterado) {
                alimentos[i].setNome(novoNome);
                alimentos[i].setCarboidratos(novoCarboidrato);
                alimentos[i].setProteina(novaProteina);
                alimentos[i].setGordura(novaGordura);
                alimentos[i].setTipoUsuario(novoTipoUsuario);
                return true;
            }
        }
        return false;

    }

    Alimento buscarPorNome(String nome) {
        for (Alimento a : alimentos) {
            if (a != null && a.getNome().equals(nome)) {
                return a;
            }
        }
        return null;
    }

    Alimento buscarPorId(long id) {
        for (Alimento a : alimentos) {
            if (a != null && a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    private boolean excluir(long idSerExcluido) {
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i].getId() == idSerExcluido) {
                alimentos[i] = null;

                return true;

            }
        }
        return false;
    }

    public boolean remover(String nome) {
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] != null && alimentos[i].getNome().equals(nome)) {
                alimentos[i] = null;
                return true;
            }
        }
        return false;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private double calcularCalorias(double carboidratos, double proteina, double gordura) {
        return 4 * carboidratos + 4 * proteina + 9 * gordura;
    }

}
