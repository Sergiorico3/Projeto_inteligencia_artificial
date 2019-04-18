package agentSearch;

public class Step {
    private int linha, coluna, tamanho, valor;

    public Step(int linha, int coluna, int tamanho, int valor) {
        this.linha = linha;
        this.coluna = coluna;
        this.tamanho = tamanho;
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public int getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    public String toString() {
        return "Posicao: (" + getLinha() +", " +getColuna() + "), Tamanho: " + tamanho;
    }
}
