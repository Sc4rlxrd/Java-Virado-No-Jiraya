package javacore.concorrencia.test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable{
    private final int num;
    public Printer(int num){
        this.num = num;
    }
    @Override
    public void run() {
        System.out.printf("%s inicio %d%n", Thread.currentThread().getName(),num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s finalizou%n", Thread.currentThread().getName());
    }
}
public class ExecutorsTest01 {
    public static void main(String[] args) {
        // uma forma mais prática de criar threads

        System.out.println(Runtime.getRuntime().availableProcessors()); // mostra a quantidade de threads do processador da sua máquina
        ExecutorService executorService = Executors.newFixedThreadPool(4);  // esse você fixa um limite de thread para roda simultaneamente
//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());  -> esse vai rodar com todas as threads do seu processador no meu caso 8
//        ExecutorService executorService = Executors.newSingleThreadExecutor();  -> ele executar todas instancias numa thread somente
//        ExecutorService executorService = Executors.newCachedThreadPool(); -> ele criar um size dinâmico para o serviço depois encerrar a thread reutiliza threads criados anteriormente que estão disponíveis no cache, melhorando o desempenho, evitando a sobrecarga de criar novos threads para cada tarefa. Os threads que permanecem ociosos (não utilizados) por 60 segundos são terminados e removidos do cache, conservando os recursos do sistema quando o pool não é usado ativamente.
        executorService.execute(new Printer(1));
        executorService.execute(new Printer(2));
        executorService.execute(new Printer(3));
        executorService.execute(new Printer(4)); // cria uma thread e inicia ela em seguida
        executorService.execute(new Printer(5));
        executorService.execute(new Printer(6));

        executorService.shutdown();  // faz e thread parar
        System.out.println("Programa finalizado");

    }
}
