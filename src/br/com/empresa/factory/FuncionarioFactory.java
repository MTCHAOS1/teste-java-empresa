package br.com.empresa.factory;

import br.com.empresa.model.Funcionario;

/**
 * Factory responsável por criar objetos {@link Funcionario}.
 * Todas as validações de negócio relacionadas a um funcionário estão centralizadas aqui.
 */
public class FuncionarioFactory {

    /**
     * Cria um novo objeto {@link Funcionario} após validar os parâmetros fornecidos.
     *
     * Regras de validação:
     * - ID: deve ser entre 0 e 999999.
     * - Nome: apenas letras e espaços, máximo 30 caracteres.
     * - Cargo: apenas letras e espaços, máximo 30 caracteres.
     * - Salário: deve ser maior ou igual a 0.
     *
     * @param id      ID do funcionário (0 a 999999)
     * @param nome    Nome do funcionário (apenas letras, até 30 caracteres)
     * @param cargo   Cargo do funcionário (apenas letras, até 30 caracteres)
     * @param salario Salário do funcionário (valor >= 0)
     * @return {@link Funcionario} criado com os dados fornecidos
     * @throws IllegalArgumentException se algum dos parâmetros for inválido
     */
    public static Funcionario criarFuncionario(int id, String nome, String cargo, double salario) {
        if (id < 0 || id > 999999)
            throw new IllegalArgumentException("ID inválido!");
        if (!nome.matches("[a-zA-ZÀ-ÿ\\s]+") || nome.length() > 30)
            throw new IllegalArgumentException("Nome inválido!");
        if (!cargo.matches("[a-zA-ZÀ-ÿ\\s]+") || cargo.length() > 30)
            throw new IllegalArgumentException("Cargo inválido!");
        if (salario < 0)
            throw new IllegalArgumentException("Salário inválido!");

        return new Funcionario(id, nome, cargo, salario);
    }
}
