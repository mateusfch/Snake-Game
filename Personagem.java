import java.util.List;

public class Personagem extends ElementoBasico {
    private ElementoBasico anterior;
    private List<ElementoBasico> lista;
    private Parte atras;
    private int oldLin;
    private int oldCol;

    public Personagem(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro, Parte atras) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        this.atras = atras;
    }

    public void setAtras(Parte p) {
        this.atras = p;
    }

    public Parte getAtras() {
        return this.atras;
    }

    public void setAnterior(ElementoBasico anterior) {
        this.anterior = anterior;
    }

    public void addFilho(ElementoBasico filho) {
        this.lista.add(filho);
    }

    private void setOldCoords() {
        this.oldLin = this.getLin();
        this.oldCol = this.getCol();
    }

    public void moveDireita() {
        // Remove o Personagem da posicao atual e avança
        getTabuleiro().insereElemento(anterior);
        if (atras != null)
            atras.moveTo(this.getCol(), this.getLin());
        setOldCoords();
        this.incCol();
        // Verifica se tem algum elemento de interesse na nova posicao
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (elemento instanceof Maca) {
            addParte();
            elemento.acao(this);
        }
        else if (elemento instanceof Parte) {
            // fim de jogo
        }
        this.anterior = getTabuleiro().insereElemento(this);
    }

    public void moveEsquerda() {
        // Remove o Personagem da posicao atual e avança
        getTabuleiro().insereElemento(anterior);
        if (atras != null)
            atras.moveTo(this.getCol(), this.getLin());
        setOldCoords();
        this.decCol();
        // Verifica se tem algum elemento de interesse na nova posicao
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (elemento instanceof Maca) {
            addParte();
            elemento.acao(this);
        }
        else if (elemento instanceof Parte) {
            // fim de jogo
        }
        this.anterior = getTabuleiro().insereElemento(this);
    }

    public void moveCima() {
        // Remove o Personagem da posicao atual e avança
        getTabuleiro().insereElemento(anterior);
        if (atras != null)
            atras.moveTo(this.getCol(), this.getLin());
        setOldCoords();
        this.decLin();
        // Verifica se tem algum elemento de interesse na nova posicao
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (elemento instanceof Maca) {
            addParte();
            elemento.acao(this);
        }
        else if (elemento instanceof Parte) {
            // fim de jogo
        }
        this.anterior = getTabuleiro().insereElemento(this);
    }

    public void moveBaixo() {
        // Remove o Personagem da posicao atual e avança
        getTabuleiro().insereElemento(anterior);
        if (atras != null)
            atras.moveTo(this.getCol(), this.getLin());
        setOldCoords();
        this.incLin();
        // Verifica se tem algum elemento de interesse na nova posicao
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (elemento instanceof Maca) {
            addParte();
            elemento.acao(this);
        }
        else if (elemento instanceof Parte) {
            // fim de jogo
        }
        this.anterior = getTabuleiro().insereElemento(this);
    }

    public void addParte() {
        if (atras == null) {
            atras = new Parte("parte","icone.jpg",oldLin,oldCol,getTabuleiro(),null);
            ElementoBasico ant = getTabuleiro().insereElemento(atras);
            atras.setAnterior(ant);
        }
        else {
            atras.addParte();
        }
    }

    @Override
    public void acao(ElementoBasico outro) {
        throw new UnsupportedOperationException("Unimplemented method 'acao'");
    }
}
