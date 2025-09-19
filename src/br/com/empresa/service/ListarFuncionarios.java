package br.com.empresa.service;

import br.com.empresa.model.Funcionario;
import java.util.List;

public record ListarFuncionarios(Empresa empresa) {

    public void executar() {
        List<Funcionario> lista = empresa.ListarFuncionarios();
        if (lista.isEmpty()) {
            System.out.println("⚠ Nenhum funcionário cadastrado.");
        } else {
            System.out.println("📋 Funcionários ordenados por nome:");
            for (Funcionario f : lista) {
                System.out.println(f);
            }
        }
    }
}
