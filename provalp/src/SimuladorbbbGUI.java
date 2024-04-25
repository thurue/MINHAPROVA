import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SimuladorbbbGUI extends JFrame {
    private ArrayList<Jogador> participantes;
    private JTextArea resultadoArea;

    public SimuladorbbbGUI() {
        super("Simulador BBB");
        participantes = new ArrayList<>();
        
        String[] participantesArray = {"Alane Dias", "Beatriz Reis", "Davi Brito", "Fernanda Bande", "Alane Dias",
                "Beatriz Reis", "Davi Brito", "Fernanda Bande", "Giovanna Lima", "Giovanna Pitel",
                "Isabelle Nogueira", "Juninho", "Leidy Elin", "Lucas Henrique", "Lucas Luigi", "Lucas Pizane",
                "Marcus Vinicius", "Matteus Amaral", "Maycon Cosmer", "MC Bin Laden", "Michel Nogueira", "Nizam",
                "Raquele Cardozo", "Rodriguinho", "Thalyta Alves", "Juninho", "Vanessa Lopes", "Vinicius Rodrigues",
                "Wanessa Camargo", "Yasmin Brunet"};
            
   for (String participante : participantesLista) {
            participantes.add(new Jogador(participante));
        }
    for (Jogador jogador : participantes) {
            System.out.println(jogador.getNome());   }     

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
