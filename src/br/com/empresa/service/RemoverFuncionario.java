package br.com.empresa.service;

import java.util.Scanner;

public record RemoverFuncionario(Empresa empresa, Scanner sc) {

    public void executar() {
        System.out.print("Digite o ID do funcionário a remover (máx. 6 dígitos): ");
        String idInput = sc.nextLine();
        if (!idInput.matches("\\d{1,6}")) {
            System.out.println("⚠ ID inválido!");
            return;
        }
        int id = Integer.parseInt(idInput);

        if (empresa.removerFuncionario(id)) {
            System.out.println("✅ Funcionário removido com sucesso!");
        } else {
            System.out.println("⚠ Funcionário não encontrado!");
        }
    }
}
