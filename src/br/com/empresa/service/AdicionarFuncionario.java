package br.com.empresa.service;

import br.com.empresa.model.Funcionario;
import java.util.InputMismatchException;
import java.util.Scanner;

public record AdicionarFuncionario(Empresa empresa, Scanner sc) {

    public void executar() {
        int id;
        while (true) {
            System.out.print("ID (máx. 6 dígitos): ");
            String idInput = sc.nextLine();
            if (idInput.matches("\\d{1,6}")) {
                id = Integer.parseInt(idInput);
                break;
            } else {
                System.out.println("⚠ ID inválido! Digite até 6 dígitos numéricos.");
            }
        }

        String nome;
        while (true) {
            System.out.print("Nome (máx. 30 caracteres): ");
            nome = sc.nextLine();
            if (nome.matches("[a-zA-ZÀ-ÿ\\s]+") && nome.length() <= 30) {
                break;
            }
            System.out.println("⚠ Nome inválido! Apenas letras e até 30 caracteres.");
        }

        String cargo;
        while (true) {
            System.out.print("Cargo (máx. 30 caracteres): ");
            cargo = sc.nextLine();
            if (cargo.matches("[a-zA-ZÀ-ÿ\\s]+") && cargo.length() <= 30) {
                break;
            }
            System.out.println("⚠ Cargo inválido! Apenas letras e até 30 caracteres.");
        }

        double salario;
        while (true) {
            try {
                System.out.print("Salário: ");
                salario = sc.nextDouble();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("⚠ Salário inválido! Digite um número válido.");
                sc.nextLine();
            }
        }

        Funcionario f = new Funcionario(id, nome, cargo, salario);
        empresa.adicionarFuncionario(f);
        System.out.println("✅ Funcionário adicionado com sucesso!");
    }
}
