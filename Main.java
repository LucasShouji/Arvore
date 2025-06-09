import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Cria uma nova árvore binária chamando ArvoreBinária.java
        ArvoreBinaria arvore = new ArvoreBinaria();
        Scanner scanner = new Scanner(System.in);

        //Valores para montar a árvore
        arvore.inserir(14);
        arvore.inserir(85);
        arvore.inserir(1);
        arvore.inserir(-96);
        arvore.inserir(55);
        arvore.inserir(57);
        arvore.inserir(44);
        arvore.inserir(7);
        arvore.inserir(69);
        arvore.inserir(100);
        arvore.inserir(-19);
        arvore.inserir(111);
        arvore.inserir(91);

        //chamando o valor que vai chamar o Scanner
        int valor;

        //Mostra as árvores em diferentes ordens
        while (true) {
            System.out.println("\nÁrvore atual:");
            System.out.print("Em ordem: ");
            arvore.emOrdem();

            System.out.print("Pré-ordem: ");
            arvore.preOrdem();

            System.out.print("Pós-ordem: ");
            arvore.posOrdem();

            System.out.print("\nDigite um número para remover: ");
            valor = scanner.nextInt();

            arvore.remover(valor);
            System.out.println("O número " + valor + " foi removido da árvore.");

        }
    }
}
