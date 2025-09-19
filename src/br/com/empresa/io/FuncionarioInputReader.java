package br.com.empresa.io;

import br.com.empresa.model.Funcionario;
import br.com.empresa.factory.FuncionarioFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe responsável por ler dados do usuário para criar um Funcionário.
 * Todas as regras de validação de negócio estão centralizadas na {@link FuncionarioFactory}.
 */
public class FuncionarioInputReader {

    private final Scanner sc = new Scanner(System.in);

    /**
     * Lê os dados do usuário via console e cria um objeto Funcionario usando a Factory.
     *
     * @return Funcionario criado com os dados fornecidos pelo usuário
     */
    public Funcionario lerFuncionario() {
        int id = lerId();
        String nome = lerTexto("Nome", 30);
        String cargo = lerTexto("Cargo", 30);
        double salario = lerSalario();

        // Cria o funcionário usando a Factory (regras de validação centralizadas)
        return FuncionarioFactory.criarFuncionario(id, nome, cargo, salario);
    }

    /**
     * Lê o ID do usuário via console, garantindo que seja um número de até 6 dígitos.
     *
     * @return int ID válido informado pelo usuário
     */
    public int lerId() {
        while (true) {
            System.out.print("ID (máx. 6 dígitos): ");
            String input = sc.nextLine();
            if (input.matches("\\d{1,6}")) {
                return Integer.parseInt(input);
            }
            System.out.println("⚠ ID inválido! Digite até 6 dígitos numéricos.");
        }
    }

    /**
     * Lê um texto do usuário via console, garantindo que contenha apenas letras e tenha tamanho máximo permitido.
     *
     * @param campo     Nome do campo que está sendo lido (ex: "Nome" ou "Cargo")
     * @param maxLength Tamanho máximo permitido para o texto
     * @return String texto válido informado pelo usuário
     */
    private String lerTexto(String campo, int maxLength) {
        while (true) {
            System.out.printf("%s (máx. %d caracteres): ", campo, maxLength);
            String input = sc.nextLine();
            if (input.matches("[a-zA-ZÀ-ÿ\\s]+") && input.length() <= maxLength) {
                return input;
            }
            System.out.printf("⚠ %s inválido! Apenas letras e até %d caracteres.\n", campo, maxLength);
        }
    }

    /**
     * Lê o salário do usuário via console, garantindo que seja um número válido.
     *
     * @return double salário válido informado pelo usuário
     */
    private double lerSalario() {
        while (true) {
            try {
                System.out.print("Salário: ");
                double salario = sc.nextDouble();
                sc.nextLine(); // limpa buffer
                return salario;
            } catch (InputMismatchException e) {
                System.out.println("⚠ Salário inválido! Digite um número válido.");
                sc.nextLine(); // limpa buffer
            }
        }
    }
}
