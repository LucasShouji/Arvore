public class ArvoreBinaria {

    //Nomeei o nó vai ser chamado de raiz para ficar menos confuso
    private No raiz;

    /*
    * Função que vai ser chamado pelo main para inserir um número
    * Precisa de um número (int)
    * Raiz é o local que o número é alocado na árvore
    */
    public void inserir(int valor) {
        raiz = inserirPosicao(raiz, valor);
    }

    /*
    * Função que vai fazer a lógica de onde o valor vai ser inserido na árvore
    * atual - é o último valor que foi inserido na árvore
    * valor - valor que vai ser inserido
    */
    private No inserirPosicao(No atual, int valor) {
        if (atual == null) return new No(valor);

        //Vai para a esquerda
        if (valor < atual.valor) atual.esquerdo = inserirPosicao(atual.esquerdo, valor);

        //Vai para a direita
        else if (valor > atual.valor) atual.direito = inserirPosicao(atual.direito, valor);
        return atual;
    }

    //Função que vai ser chamado e remove um valor da árvore
    public void remover(int valorScanner) {
        raiz = removerNumero(raiz, valorScanner);
    }

    /*
    * Lógica de toda a remoção da árvore binária
    * Retorna um nó para a função pública
     */
    private No removerNumero(No no, int valorScanner) {
        if (no == null) return null;

        // Busca o valor no filho da esquerda
        if (valorScanner < no.valor) {
            no.esquerdo = removerNumero(no.esquerdo, valorScanner);
        }

        // Busca o valor no filho da direita
        else if (valorScanner > no.valor) {
            no.direito = removerNumero(no.direito, valorScanner);
        }

        else {
            // Nó com apenas um filho na direita
            if (no.esquerdo == null) {
                return no.direito;
            }

            // Nó com apenas um filho na esquerda
            else if (no.direito == null) {
                return no.esquerdo;
            }

            // Caso nó com dois filhos, substitui pelo menor valor que vem do filho direito
            No minNo = encontrarMenorValor(no.direito);
            no.valor = minNo.valor;
            no.direito = removerNumero(no.direito, minNo.valor);
        }

        return no;
    }

    // Percorre até o final do filho da esquerda e retorna o menor valor
    private No encontrarMenorValor(No no) {
        while (no.esquerdo != null) no = no.esquerdo;
        return no;
    }

    public void emOrdem() {
        emOrdemLogica(raiz);
        System.out.println();
    }

    private void emOrdemLogica(No no) {
        if (no != null) {
            emOrdemLogica(no.esquerdo);
            System.out.print(no.valor + " ");
            emOrdemLogica(no.direito);
        }
    }

    public void preOrdem() {
        preOrdemLogica(raiz);
        System.out.println();
    }

    private void preOrdemLogica(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdemLogica(no.esquerdo);
            preOrdemLogica(no.direito);
        }
    }

    public void posOrdem() {
        posOrdemLogica(raiz);
        System.out.println();
    }

    private void posOrdemLogica(No no) {
        if (no != null) {
            posOrdemLogica(no.esquerdo);
            posOrdemLogica(no.direito);
            System.out.print(no.valor + " ");
        }
    }
}

