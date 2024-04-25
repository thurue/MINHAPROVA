import java.util.ArrayList;
import java.util.Scanner;
public class SimuladorBBB {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Jogador> participantes = new ArrayList<>();
        int sair = 1;

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

        for (int i = 0; sair == 1;) {
            System.out.println("1. Votar em alguém? ");
            System.out.println("2. Sair para contabilizar");
            int votar = s.nextInt();
            if (votar == 1) {
                System.out.println("Votação #" + (i + 1));
                System.out.println("Escolha o participante a ser votado:");
                for (int j = 0; j < participantes.size(); j++) {
                        System.out.println((j + 1) + ". " + participantes.get(j).getNome());
                    }
                    int voto = s.nextInt();
                    if (voto >= 1 && voto <= participantes.size()) {
                        participantes.get(voto - 1).incrementaUmVoto();
                        System.out.println("Voto computado!");
                    } else {
                        System.out.println("Opção inválida, voto não computation.");
                    }
            } else if (votar == 2) {
                sair = 0;
            }
            else {
                System.out.println("Opção inválida");
            }
        }

        Jogador eliminado = participantes.get(0);
        for (Jogador p : participantes) {
            if (p.getVotos() > eliminado.getVotos()) {
                eliminado = p;
            }
        }
        System.out.printf("Se eu conseguir mover montanhas, se eu conseguir " +
                "surfar um tsunami, se eu conseguir domar o sol, " +
                "se eu conseguir fazer o mar virar sertão, e o sertão " +
                "virar mar, se eu conseguir dizer o que eu nunca vou conseguir dizer, " +
                "aí terá chegado o dia em que eu vou conseguir te eliminar com alegria. " +
                "Com %d votos, é você quem sai: %s",eliminado.getVotos() , eliminado.getNome());
    }
}