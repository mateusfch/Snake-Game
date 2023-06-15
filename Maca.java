import javax.swing.JOptionPane;
import java.util.*;

public class Maca extends ElementoBasico {
    private boolean macaCapturada;
    private int nroMaca;
    private Jogador jogador;
    private Placar placar;

    public Maca(String id, int nroMaca, int linInicial, int colInicial, Tabuleiro tabuleiro, Jogador jogador,
            Placar placar) {
        super(id, "apple.png", linInicial, colInicial, tabuleiro);
        this.macaCapturada = true;
        this.nroMaca = nroMaca;
        this.jogador = jogador;
        this.placar = placar;
    }

    public int getnroMaca() {
        return nroMaca;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (macaCapturada) {
            Tabuleiro t = this.getTabuleiro();
            this.jogador.comeuMaca();
            this.placar.macasComidasAtualizadas(jogador.getMacasComidas());
            macaCapturada = false;

            int linAleatoria = (int) (Math.random() * 4);
            int colAleatoria = (int) (Math.random() * 5);

            // Para impedir que a nova maçã ocupe um quadrante <atualmente> ocupado
            // É quase impossível a cobra ocupar todos os quadrantes, né? Acho q por
            // isso não
            // precisa se preocupar de não sair do loop
            ElementoBasico refQuadranteSorteado = t.getElementoNaPosicao(linAleatoria, colAleatoria);
            while (refQuadranteSorteado instanceof Maca || refQuadranteSorteado instanceof Personagem) {
                linAleatoria = (int) (Math.random() * 4);
                colAleatoria = (int) (Math.random() * 5);
                refQuadranteSorteado = t.getElementoNaPosicao(linAleatoria, colAleatoria);
            }

            // Maçã capturada desaparece do tabuleiro e este é reposto por uma peça padrão
            // do tabuleiro
            t.desapareceMaca(this.getLin(), this.getCol());

            // Nova maçã é adicionada no tabuleiro
            Maca m = new Maca("Maca", 15, linAleatoria, colAleatoria, t, jogador, placar);
            t.insereElemento(m);
            System.out.println(jogador.getMacasComidas());
        } else {
            macaCapturada = true;
            setImage(Tabuleiro.createImageIcon("apple.png"));
        }
    }
}
