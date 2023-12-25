package entities;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Setter
@Data
@Getter
public class Installment {
   private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate dueDate;

    private Double amount;

    public  Installment(){

    }
    public Installment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return dueDate.format(fmt) + " - " + String.format("%.2f", amount);
    }


}
