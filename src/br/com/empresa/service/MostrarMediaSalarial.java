package br.com.empresa.service;

public record MostrarMediaSalarial(Empresa empresa) {

    public void executar() {
        double media = empresa.calcularMediaSalarial();
        if (media > 0) {
            System.out.printf("✅ Média salarial: R$ %.2f%n", media);
        } else {
            System.out.println("⚠ Nenhum funcionário cadastrado.");
        }
    }
}
