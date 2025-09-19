package br.com.empresa.service;

import br.com.empresa.model.Funcionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Empresa {
    private final List<Funcionario> funcionarios = new ArrayList<>();

    // Adicionar funcionário
    public void adicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    // Remover funcionário pelo ID
    public boolean removerFuncionario(int id) {
        return funcionarios.removeIf(f -> f.getId() == id);
    }

    // Buscar funcionário pelo nome
    public Funcionario buscarFuncionario(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId()==(id)) {
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

    // Listar ordenados por salário (Stream.sorted)
    public List<Funcionario> ListarFuncionarios() {
        return funcionarios.stream()
                .sorted(Comparator.comparingDouble(Funcionario::getSalario).reversed())
                .toList();
    }
}
