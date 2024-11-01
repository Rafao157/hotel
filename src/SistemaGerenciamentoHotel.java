import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Quarto {
    int numero;
    String tipo;
    double precoDiario;
    boolean disponivel;

    Quarto(int numero, String tipo, double precoDiario) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponivel = true;
    }
}

class Reserva {
    String nomeHospede;
    String dataCheckIn;
    String dataCheckOut;
    int numeroQuartosReservados;
    String tipoQuartoReservado;

    Reserva(String nomeHospede, String dataCheckIn, String dataCheckOut, int numeroQuartosReservados, String tipoQuartoReservado) {
        this.nomeHospede = nomeHospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroQuartosReservados = numeroQuartosReservados;
        this.tipoQuartoReservado = tipoQuartoReservado;
    }
}

class Hotel {
    List<Quarto> quartos;
    List<Reserva> reservas;

    Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    void cadastrarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    void checkIn(int numeroQuarto, String nomeHospede, String dataCheckIn, String dataCheckOut) {
        for (Quarto quarto : quartos) {
            if (quarto.numero == numeroQuarto && quarto.disponivel) {
                quarto.disponivel = false;
                Reserva reserva = new Reserva(nomeHospede, dataCheckIn, dataCheckOut, 1, quarto.tipo);
                cadastrarReserva(reserva);
                System.out.println("Check-in realizado com sucesso!");
                return;
            }
        }
        System.out.println("Quarto não disponível para check-in.");
    }

    void checkOut(int numeroQuarto) {
        for (Quarto quarto : quartos) {
            if (quarto.numero == numeroQuarto && !quarto.disponivel) {
                quarto.disponivel = true;
                System.out.println("Check-out realizado com sucesso!");
                return;
            }
        }
        System.out.println("Quarto não encontrado ou já disponível.");
    }

    void relatorioOcupacao() {
        int quartosOcupados = 0;
        System.out.println("Relatório de Ocupação:");
        for (Quarto quarto : quartos) {
            if (!quarto.disponivel) {
                quartosOcupados++;
                System.out.println("Quarto " + quarto.numero + " - Tipo: " + quarto.tipo);
            }
        }
        System.out.println("Total de quartos ocupados: " + quartosOcupados);
    }

    void relatorioHistoricoReservas() {
        System.out.println("Histórico de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println("Hóspede: " + reserva.nomeHospede + ", Data de Check-in: " + reserva.dataCheckIn + ", Data de Check-out: " + reserva.dataCheckOut + ", Tipo de Quarto: " + reserva.tipoQuartoReservado);
        }
    }
}

public class SistemaGerenciamentoHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        hotel.cadastrarQuarto(new Quarto(101, "Solteiro", 100.0));
        hotel.cadastrarQuarto(new Quarto(102, "Casal", 150.0));
        hotel.cadastrarQuarto(new Quarto(103, "Suíte", 250.0));}

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Check-in");
            System.out.println("2. Check-out");
            System.out.println("3. Relatório de Ocupação");
            System.out.println("4. Relatório de Histórico de Reservas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            Scanner scanner;
			int opcao = scanner.nextInt();
            scanner.nextLine();}

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número do quarto: ");
                    int numeroQuarto = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o nome do hóspede: ");
                    String nomeHospede = scanner.nextLine();
                    System.out.print("Digite a data de check-in: ");
                    String dataCheckIn = scanner.nextLine();
                    System.out.print("Digite a data de check-out: ");
                    String dataCheckOut = scanner.nextLine();
                    hotel.checkIn(numeroQuarto, nomeHospede, dataCheckIn, dataCheck);

