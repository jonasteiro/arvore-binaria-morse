class Nodo {
    char caractere;
    Nodo filhoEsquerdo;
    Nodo filhoDireito;

    public Nodo() {
        this.caractere = '\0';
    }
}

class ArvoreBinariaMorse {
    private Nodo raiz;

    public void inicializar() {
        raiz = new Nodo();
    }

    public void inserir(String codigoMorse, char caractere) {
        Nodo noAtual = raiz;

        for (int i = 0; i < codigoMorse.length(); i++) {
            char simbolo = codigoMorse.charAt(i);

            if (simbolo == '.') {
                if (noAtual.filhoEsquerdo == null) {
                    noAtual.filhoEsquerdo = new Nodo();
                }
                noAtual = noAtual.filhoEsquerdo;

            } else if (simbolo == '-') {
                if (noAtual.filhoDireito == null) {
                    noAtual.filhoDireito = new Nodo();
                }
                noAtual = noAtual.filhoDireito;
            }
        }

        noAtual.caractere = caractere;
    }
}