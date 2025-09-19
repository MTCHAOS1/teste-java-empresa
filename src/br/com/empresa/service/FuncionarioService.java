package br.com.empresa.service;

import br.com.empresa.model.Empresa;
import br.com.empresa.model.Funcionario;
import br.com.empresa.io.FuncionarioInputReader;

import java.util.Comparator;
import java.util.List;

/**
 * Classe responsável por gerenciar operações relacionadas aos funcionários de uma empresa.
 * Centraliza a lógica de negócios: adicionar, remover, buscar, listar e calcular média salarial.
 */
public class FuncionarioService {

    private final Empresa empresa;                       // Instância da empresa
    private final FuncionarioInputReader inputReader = new FuncionarioInputReader(); // Lê dados do usuário

    /**
     * Construtor da classe, recebe a empresa que será gerenciada.
     *
     * @param empresa Empresa cujos funcionários serão gerenciados
     */
    public FuncionarioService(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * Adiciona um novo funcionário à empresa.
     * Valida se o ID informado já existe antes de adicionar.
     */
    public void adicionarFuncionario() {
        Funcionario f = inputReader.lerFuncionario(); // Lê os dados do funcionário

        // Verifica se já existe funcionário com o mesmo ID
        if (empresa.buscarFuncionarioPorId(f.getId()) != null) {
            System.out.println("⚠ Já existe um funcionário com o ID " + f.getId() + "!");
            return;
        }

        // Adiciona funcionário
        empresa.adicionarFuncionario(f);
        System.out.println("✅ Funcionário adicionado com sucesso!");
    }

    /**
     * Lista todos os funcionários da empresa, ordenando primeiro por salário (decrescente)
     * e, em caso de empate, pelo nome (alfabético).
     */
    public void listarFuncionarios() {
        List<Funcionario> lista = empresa.getFuncionarios();

        if (lista.isEmpty()) {
            System.out.println("⚠ Nenhum funcionário cadastrado.");
            return;
        }

        // Ordenação: salário decrescente, depois nome crescente
        lista.sort(
                Comparator.comparingDouble(Funcionario::getSalario).reversed()
                        .thenComparing(Funcionario::getNome)
        );

        System.out.println("📋 Funcionários ordenados por salário e nome:");
        lista.forEach(System.out::println);
    }

    /**
     * Remove um funcionário da empresa pelo ID informado pelo usuário.
     */
    public void removerFuncionario() {
        int id = inputReader.lerId(); // Lê ID do funcionário

        if (empresa.removerFuncionarioPorId(id)) {
            System.out.println("✅ Funcionário removido com sucesso!");
        } else {
            System.out.println("⚠ Funcionário não encontrado!");
        }
    }

    /**
     * Busca e exibe um funcionário pelo ID informado pelo usuário.
     */
    public void buscarFuncionarioPorId() {
        int id = inputReader.lerId(); // Lê ID do funcionário

        Funcionario funcionario = empresa.buscarFuncionarioPorId(id);

        if (funcionario != null) {
            System.out.println("🔍 Funcionário encontrado:");
            System.out.println(funcionario);
        } else {
            System.out.println("⚠ Funcionário não encontrado!");
        }
    }

    /**
     * Calcula e exibe a média salarial dos funcionários da empresa.
     */
    public void imprimirMediaSalarial() {
        List<Funcionario> lista = empresa.getFuncionarios();

        if (lista.isEmpty()) {
            System.out.println("⚠ Nenhum funcionário cadastrado para calcular a média salarial.");
            return;
        }

        // Soma os salários
        double soma = lista.stream().mapToDouble(Funcionario::getSalario).sum();
        double media = soma / lista.size();

        System.out.printf("💰 Média salarial dos %d funcionários: R$ %.2f%n", lista.size(), media);
    }

}
