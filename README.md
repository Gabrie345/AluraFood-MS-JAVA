import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrganizarLista {
    public static void main(String[] args) {
        List<Objeto> objetos = new ArrayList<>();

        // Adicione os objetos à lista
        objetos.add(new Objeto("vigente", "2023-05-24T19:44:45Z"));
        objetos.add(new Objeto("aguardando_vigência", "2023-03-24T19:44:45Z"));
        objetos.add(new Objeto("expirado", "2023-04-24T19:44:45Z"));

        // Defina o Comparator para a ordenação
        Comparator<Objeto> comparator = Comparator.comparing(Objeto::getStatus,
                Comparator.comparing(status -> {
                    if (status.equals("vigente")) return 0;
                    if (status.equals("aguardando_vigência")) return 1;
                    return 2;
                }))
                .thenComparing(Objeto::getDataCriacao, Comparator.reverseOrder());

        // Ordene os objetos usando o Comparator
        Collections.sort(objetos, comparator);

        // Exiba os objetos ordenados
        for (Objeto objeto : objetos) {
            System.out.println(objeto);
        }
    }
}

class Objeto {
    private String status;
    private LocalDateTime dataCriacao;

    public Objeto(String status, String dataCriacaoString) {
        this.status = status;
        this.dataCriacao = LocalDateTime.parse(dataCriacaoString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "status='" + status + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
