import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SimuladorbbbGUI extends JFrame {
    private ArrayList<Jogador> participantes;
    private JTextArea resultadoArea;

    public SimuladorbbbGUI() {
        super("Simulador BBB");
        participantes = new ArrayList<>();
        participantes.add(new Jogador("Alane Dias"));
        participantes.add(new Jogador("Beatriz Reis"));
        participantes.add(new Jogador("Davi Brito"));
        participantes.add(new Jogador("Fernanda Bande"));
        participantes.add(new Jogador("Giovanna Lima"));
        participantes.add(new Jogador("Giovanna Pitel"));
        participantes.add(new Jogador("Isabelle Nogueira"));
        participantes.add(new Jogador("Juninho"));
        participantes.add(new Jogador("Leidy Elin"));
        participantes.add(new Jogador("Lucas Henrique"));
        participantes.add(new Jogador("Lucas Luigi"));
        participantes.add(new Jogador("Lucas Pizane"));
        participantes.add(new Jogador("Marcus Vinicius"));
        participantes.add(new Jogador("Matteus Amaral"));
        participantes.add(new Jogador("Maycon Cosmer"));
        participantes.add(new Jogador("MC Bin Laden"));
        participantes.add(new Jogador("Michel Nogueira"));
        participantes.add(new Jogador("Nizam"));
        participantes.add(new Jogador("Raquele Cardozo"));
        participantes.add(new Jogador("Rodriguinho"));
        participantes.add(new Jogador("Thalyta Alves"));
        participantes.add(new Jogador("Juninho"));
        participantes.add(new Jogador("Vanessa Lopes"));
        participantes.add(new Jogador("Vinicius Rodrigues"));
        participantes.add(new Jogador("Wanessa Camargo"));
        participantes.add(new Jogador("Yasmin Brunet"));


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        confingComps();
        setResizable(true);
        setVisible(true);
    }

    private void confingComps(){
        JPanel painel = new JPanel(new GridLayout(participantes.size(), 1));
        painel.setBackground(new Color(87, 86, 86));
        for (Jogador participante : participantes) {
            JButton botao = new JButton(participante.getNome());
            botao.setPreferredSize(new Dimension(10, 10));
            botao.setToolTipText(participante.getNome());
            botao.addActionListener(e -> {
                participante.incrementaUmVoto();
                atualizarResultado();
            });
            painel.add(botao);
        }
        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        add(painel, BorderLayout.CENTER);
        add(new JScrollPane(resultadoArea), BorderLayout.SOUTH);
        resultadoArea.setPreferredSize(new Dimension(100,100));
        atualizarResultado();
    }

    private void atualizarResultado() {
        resultadoArea.setText("");
        Jogador eliminado = participantes.get(0);
        for (Jogador p : participantes) {
            if (p.getVotos() > eliminado.getVotos()) {
                eliminado = p;
            }
        }
        resultadoArea.append("\nO participante eliminado é: " + eliminado.getNome() + " com um total de " + eliminado.getVotos() + " Votos");
    }

    public static void main(String[] args) {
        new SimuladorbbbGUI();
    }
}