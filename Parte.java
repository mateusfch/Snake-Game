import javax.lang.model.util.ElementScanner14;

public class Parte extends Personagem {

    public Parte(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro, Parte atras) {
        super(id, iconPath, linInicial, colInicial, tabuleiro, atras);
    }

    public void moveTo(int col, int lin) {
        if (col > this.getCol())
            this.moveDireita();
        else if (col < this.getCol())
            this.moveEsquerda();
        else if (lin > this.getLin())
            this.moveBaixo();
        else if (lin < this.getLin())
            this.moveCima();
    }
    
}
