public class No {
    int valor;
    No esquerdo, direito;

    //Valor é o número, e esquerdo e direito para vir como default para o primeiro valor.
    public No(int valor) {
        this.valor = valor;
        esquerdo = null;
        direito = null;
    }
}
