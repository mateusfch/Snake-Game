import javax.swing.JOptionPane;

public class Eca extends ElementoBasico {
    private int nroPista;
    private static int tentativas = 0;

    public Eca(String id, int nroPista, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "eca.jpg", linInicial, colInicial, tabuleiro);
        this.nroPista = nroPista;
    }

    public int getNroPista() {
        return nroPista;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (tentativas == 3) {
            JOptionPane.showMessageDialog(getRootPane(), "Muitas tentativas, você perdeu!");
            System.exit(0);
        }
        String codigo = JOptionPane.showInputDialog(getRootPane(), "Digite o código");
        if (codigo.equals("2215") || codigo.equals("1522")) {
            setImage(Tabuleiro.createImageIcon("ecaDead" + nroPista + ".jpg"));
            getTabuleiro().atualizaVisualizacao();
            JOptionPane.showMessageDialog(getRootPane(), "Parabens você ganhou");
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "Código inválido! Continue tentando");
        }
        tentativas++;
    }
}
