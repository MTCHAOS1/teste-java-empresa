package br.com.empresa.model;

/**
 * Representa um funcionário de uma empresa.
 * Contém informações básicas: ID, nome, cargo e salário.
 */
public class Funcionario {

    // Atributos do funcionário
    private int id;           // Identificador único do funcionário
    private String nome;      // Nome do funcionário
    private String cargo;     // Cargo/função do funcionário
    private double salario;   // Salário do funcionário

    /**
     * Construtor da classe Funcionario.
     *
     * @param id      Identificador único do funcionário
     * @param nome    Nome do funcionário
     * @param cargo   Cargo/função do funcionário
     * @param salario Salário do funcionário
     */
    public Funcionario(int id, String nome, String cargo, double salario) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    // =======================
    // Getters e Setters
    // =======================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // =======================
    // Sobrescrita do toString
    // =======================

    /**
     * Retorna uma representação textual do funcionário.
     *
     * @return String com informações do funcionário formatadas
     */
    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Cargo: " + cargo +
                " | Salário: R$ " + String.format("%.2f", salario);
    }
}
