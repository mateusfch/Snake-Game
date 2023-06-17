import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    private Tabuleiro tabuleiro;
    private Personagem personagem;

    public App() {
        super();

        Jogador jogador1 = new Jogador("Giselle");

        // Define os componentes da tela
        tabuleiro = new Tabuleiro();

        JPanel botoesDirecao1 = new JPanel(new FlowLayout());
        JPanel botoesDirecao2 = new JPanel(new FlowLayout());
        JPanel botoesDirecao3 = new JPanel(new FlowLayout());
        JButton butDir = new JButton("Direita");
        butDir.addActionListener(this);
        JButton butEsq = new JButton("Esquerda");
        butEsq.addActionListener(this);
        JButton butCima = new JButton("Acima");
        butCima.addActionListener(this);
        JButton butBaixo = new JButton("Abaixo");
        butBaixo.addActionListener(this);
        botoesDirecao2.add(butEsq);
        botoesDirecao2.add(butDir);
        botoesDirecao1.add(butCima);
        botoesDirecao3.add(butBaixo);
        JLabel pontuacao = new JLabel("PONTOS: " + jogador1.getMacasComidas());

        JPanel painelGeral = new JPanel();

        painelGeral.setLayout(new BoxLayout(painelGeral, BoxLayout.PAGE_AXIS));
        painelGeral.add(tabuleiro);
        painelGeral.add(pontuacao);
        painelGeral.add(botoesDirecao1);
        painelGeral.add(botoesDirecao2);
        painelGeral.add(botoesDirecao3);

        Placar placar = new Placar(pontuacao);
        // Insere os personagens no tabuleiro
        personagem = new Personagem("Feliz", "icone3.jpg", 0, 0, tabuleiro, null);
        ElementoBasico anterior = tabuleiro.insereElemento(personagem);
        personagem.setAnterior(anterior);

        Maca maca1 = new Maca("Maca1", 0, 2, 4, tabuleiro, jogador1, placar);
        tabuleiro.insereElemento(maca1);

        // Exibe a janela
        this.add(painelGeral);

        this.setSize(1100, 1100);
        this.setTitle("Jogo Demo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        tabuleiro.atualizaVisualizacao();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JButton but = (JButton) arg0.getSource();
        if (but.getText().equals("Direita")) {
            personagem.mudaIcone("icone3.jpg");
            personagem.moveDireita();
        }
        if (but.getText().equals("Esquerda")) {
            personagem.mudaIcone("icone.jpg");
            personagem.moveEsquerda();
        }
        if (but.getText().equals("Acima")) {
            personagem.mudaIcone("icone4.jpg");
            personagem.moveCima();
        }
        if (but.getText().equals("Abaixo")) {
            personagem.mudaIcone("icone2.jpg");
            personagem.moveBaixo();
        }
        tabuleiro.atualizaVisualizacao();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}