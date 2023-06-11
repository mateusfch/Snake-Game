import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jogador {
  private String nome;
  private int macasComidas;

  public Jogador(String nome) {
    this.nome = nome;
    this.macasComidas = 0;
  }

  public String getNome() {
    return nome;
  }

  public int getMacasComidas() {
    return macasComidas;
  }

  public void comeuMaca() {
    macasComidas++;
  }

}