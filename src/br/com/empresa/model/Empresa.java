package br.com.empresa.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Representa uma empresa com uma lista de funcionários.
 * Responsável por gerenciar funcionários: adicionar, remover, buscar e listar.
 */
public class Empresa {

    // Lista de funcionários da empresa
    private final List<Funcionario> funcionarios;

    /**
     * Construtor padrão.
     * Inicializa a lista de funcionários vazia.
     */
    public Empresa() {
        this.funcionarios = new ArrayList<>();
    }

    /**
     * Adiciona um funcionário à empresa.
     *
     * @param funcionario Funcionário a ser adicionado
     * @return Funcionario O funcionário que foi adicionado
     */
    public Funcionario adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        return funcionario;
    }

    /**
     * Remove um funcionário da empresa pelo ID.
     * Utiliza Iterator para evitar problemas de concorrência durante a remoção.
     *
     * @param id ID do funcionário a ser removido
     * @return true se encontrou e removeu, false caso contrário
     */
    public boolean removerFuncionarioPorId(int id) {
        Iterator<Funcionario> it = funcionarios.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                return true; // Funcionário removido com sucesso
            }
        }
        return false; // Funcionário não encontrado
    }

    /**
     * Busca um funcionário pelo ID.
     *
     * @param id ID do funcionário a ser buscado
     * @return Funcionario encontrado ou null se não existir
     */
    public Funcionario buscarFuncionarioPorId(int id) {
        Iterator<Funcionario> it = funcionarios.iterator();
        while (it.hasNext()) {
            Funcionario f = it.next();
            if (f.getId() == id) {
                return f; // Retorna o funcionário encontrado
            }
        }
        return null; // Não encontrado
    }

    /**
     * Retorna a lista de funcionários da empresa.
     * Para segurança, retorna uma lista não modificável externamente.
     *
     * @return List<Funcionario> Lista de funcionários
     */
    public List<Funcionario> getFuncionarios() {
        return Collections.unmodifiableList(funcionarios);
    }

}
