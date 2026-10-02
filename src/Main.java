public class Nodo {
    char caractere;
    Nodo filhoEsquerdo;
    Nodo filhoDireito;

    public Nodo() {
        this.caractere = '\0'; 
    }
}

public class ArvoreBinariaMorse {
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

    public char buscar(String codigoMorse) {
        Nodo noAtual = raiz;
        for (int i = 0; i < codigoMorse.length(); i++) {
            char simbolo = codigoMorse.charAt(i);

            if (simbolo == '.') {
                noAtual = noAtual.filhoEsquerdo;
            } else if (simbolo == '-') {
                noAtual = noAtual.filhoDireito;
            }

            if (noAtual == null) {
                return '\0'; 
            }
        }
        return noAtual.caractere;
    }

    public String buscarMensagem(String mensagemMorse) {
        String texto = "";
        String[] letras = mensagemMorse.split(" ");

        for (int i = 0; i < letras.length; i++) {
            char resultado = buscar(letras[i]);
            if (resultado != '\0') {
                texto = texto + resultado; 
            }
        }
        return texto;
    }

    public void exibirArvore(Nodo no, int nivel) {
        if (no != null) {
            for (int i = 0; i < nivel * 4; i++) {
                System.out.print(" ");
            }
            
            if (no.caractere == '\0') {
                System.out.println("(*)");
            } else {
                System.out.println(no.caractere);
            }

            exibirArvore(no.filhoEsquerdo, nivel + 1);
            exibirArvore(no.filhoDireito, nivel + 1);
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }
}