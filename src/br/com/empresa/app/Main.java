package br.com.empresa.app;
import br.com.empresa.service.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empresa empresa = new Empresa();

        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("1 - Adicionar Funcionário");
            System.out.println("2 - Remover Funcionário");
            System.out.println("3 - Buscar Funcionário");
            System.out.println("4 - Mostrar Média Salarial");
            System.out.println("5 - Listar Funcionários Ordenados");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1" -> new AdicionarFuncionario(empresa, sc).executar();
                case "2" -> new RemoverFuncionario(empresa, sc).executar();
                case "3" -> new BuscarFuncionario(empresa, sc).executar();
                case "4" -> new MostrarMediaSalarial(empresa).executar();
                case "5" -> new ListarFuncionarios(empresa).executar();
                case "6" -> {
                    System.out.println("Encerrando o sistema...");
                    sc.close();
                    return;
                }
                default -> System.out.println("⚠ Opção inválida! Tente novamente.");
            }
        }
    }
}
