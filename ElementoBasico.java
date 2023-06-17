import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public abstract class ElementoBasico extends JButton {
    private Tabuleiro tabuleiro;
    private String id;
    private ImageIcon imagem;
    private int lin;
    private int col;

    public ElementoBasico(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        this.setBorderPainted(false);
        this.setBackground(Color.BLACK);
        this.id = id;
        this.imagem = Tabuleiro.createImageIcon(iconPath);
        this.setIcon(this.imagem);
        this.lin = linInicial;
        this.col = colInicial;
        this.tabuleiro = tabuleiro;
    }

    public ImageIcon getImagem() {
        return this.imagem;
    }

    public void setImage(ImageIcon imagem) {
        this.imagem = imagem;
        this.setIcon(imagem);
    }

    public void mudaIcone(String iconPath) {
        this.imagem = Tabuleiro.createImageIcon(iconPath);
        this.setIcon(this.imagem);
    }

    public String getId() {
        return id;
    }

    public int getLin() {
        return lin;
    }

    public void incLin() {
        if (lin < Tabuleiro.getMaxlin() - 1) {
            lin++;
        }
    }

    public void decLin() {
        if (lin > 0) {
            lin--;
        }
    }

    public void incCol() {
        if (col < Tabuleiro.getMaxcol() - 1) {
            col++;
        }
    }

    public void decCol() {
        if (col > 0) {
            col--;
        }
    }

    public int getCol() {
        return col;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public abstract void acao(ElementoBasico outro);
}
