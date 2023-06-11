import javax.swing.JLabel;

public class Placar {
  private JLabel pontuacao;

  public Placar(JLabel pontuacao) {
    this.pontuacao = pontuacao;
  }

  public void macasComidasAtualizadas(int macasComidas) {
    pontuacao.setText("PONTOS: " + macasComidas);
  }

}
