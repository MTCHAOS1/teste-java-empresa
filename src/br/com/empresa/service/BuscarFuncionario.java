package br.com.empresa.service;

import br.com.empresa.model.Funcionario;
import java.util.Scanner;

public record BuscarFuncionario(Empresa empresa, Scanner sc) {

    public void executar() {
        System.out.print("Digite o ID do funcionário para busca (máx. 6 dígitos): ");
        String idInput = sc.nextLine();
        if (!idInput.matches("\\d{1,6}")) {
            System.out.println("⚠ ID inválido!");
            return;
        }
        int id = Integer.parseInt(idInput);

        Funcionario f = empresa.buscarFuncionario(String.valueOf(id));
        if (f != null) {
            System.out.println("✅ Funcionário encontrado: " + f);
        } else {
            System.out.println("⚠ Funcionário não encontrado!");
        }
    }
}
