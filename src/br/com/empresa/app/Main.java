package br.com.empresa.app;

import br.com.empresa.model.Empresa;
import br.com.empresa.service.FuncionarioService;

import java.util.Scanner;

/**
 * Classe principal da aplicação.
 * Responsável por exibir o menu e interagir com o usuário.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);             // Scanner para ler input do usuário
        Empresa empresa = new Empresa();                 // Cria a empresa
        FuncionarioService funcionarioService = new FuncionarioService(empresa); // Serviço de funcionários

        while (true) {
            exibirMenu();                                // Exibe opções do menu
            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1" -> funcionarioService.adicionarFuncionario();       // Adiciona funcionário
                case "2" -> funcionarioService.removerFuncionario();         // Remove funcionário
                case "3" -> funcionarioService.buscarFuncionarioPorId();     // Busca funcionário por ID
                case "4" -> funcionarioService.imprimirMediaSalarial();      // Mostra média salarial
                case "5" -> funcionarioService.listarFuncionarios();         // Lista funcionários ordenados
                case "6" -> {                                                  // Sai do sistema
                    System.out.println("Encerrando o sistema...");
                    sc.close();
                    return;
                }
                default -> System.out.println("⚠ Opção inválida! Tente novamente.");
            }
        }
    }

    /**
     * Exibe o menu principal da aplicação.
     */
    private static void exibirMenu() {
        System.out.println("\n------ MENU ------");
        System.out.println("1 - Adicionar Funcionário");
        System.out.println("2 - Remover Funcionário");
        System.out.println("3 - Buscar Funcionário");
        System.out.println("4 - Mostrar Média Salarial");
        System.out.println("5 - Listar Funcionários Ordenados");
        System.out.println("6 - Sair");
    }
}
