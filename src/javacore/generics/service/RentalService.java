package javacore.generics.service;

import java.util.List;

public class RentalService<T> {
    private List<T> veiculosDisponiveis;

    public RentalService(List<T> veiculosDisponiveis) {
        this.veiculosDisponiveis = veiculosDisponiveis;
    }

    public T buscarVeiculoDisponivel(){
        System.out.println("Buscando veículos disponível");
        T t = veiculosDisponiveis.removeFirst();
        System.out.println("Alugando veiculo: " + t);
        System.out.println("Veículos disponível para alugar");
        System.out.println(veiculosDisponiveis);
        return t;
    }

    public void retornarVeiculoAlugado(T t){
        System.out.println("Devolvendo veiculo: "+t);
        veiculosDisponiveis.add(t);
        System.out.println("Veículos disponíveis para alugar: ");
        System.out.println(veiculosDisponiveis);
    }
}
