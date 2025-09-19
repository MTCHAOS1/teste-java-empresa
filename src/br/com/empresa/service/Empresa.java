package br.com.empresa.service;

import br.com.empresa.model.Funcionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Empresa {
    private final List<Funcionario> funcionarios = new ArrayList<>();

    // Adicionar funcionário (com validação de ID único)
    public boolean adicionarFuncionario(Funcionario f) {
        for (Funcionario existente : funcionarios) {
            if (existente.getId() == f.getId()) {
                return false;
            }
        }
        funcionarios.add(f);
        return false;
    }

    // Remover funcionário pelo ID
    public boolean removerFuncionario(int id) {
        return funcionarios.removeIf(f -> f.getId() == id);
    }

    // Buscar funcionário pelo nome
    public Funcionario buscarFuncionario(String nome) {
        for (Funcionario f : funcionarios) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                return f;
            }
        }
        return null;
    }

    // Calcular média salarial
    public double calcularMediaSalarial() {
        if (funcionarios.isEmpty()) return 0.0;
        double soma = 0;
        for (Funcionario f : funcionarios) {
            soma += f.getSalario();
        }
        return soma / funcionarios.size();
    }

    // Listar ordenados por salário (usando Collections.sort)
    public List<Funcionario> listarOrdenadosPorSalarioSort() {
        List<Funcionario> copia = new ArrayList<>(funcionarios);
        Collections.sort(copia, Comparator.comparingDouble(Funcionario::getSalario).reversed());
        return copia;
    }

    // Listar ordenados por salário (usando Stream.sorted)
    public List<Funcionario> listarOrdenadosPorSalarioStream() {
        return funcionarios.stream()
                .sorted(Comparator.comparingDouble(Funcionario::getSalario).reversed())
                .toList();
    }

    // Getter da lista original
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

}
