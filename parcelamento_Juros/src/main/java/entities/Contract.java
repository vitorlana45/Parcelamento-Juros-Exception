package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    private Installment installment;

    private List<Installment> contractsInstallments = new ArrayList<>();

    public Integer numero;

    public LocalDate date;

    public Double valorDoContrato;


    public Contract(Integer numero, LocalDate date, Double valorDoContrato) {
        this.numero = numero;
        this.date = date;
        this.valorDoContrato = valorDoContrato;
    }

    public void addContractIntallments(Installment installment) {
        contractsInstallments.add(installment);
    }

    public void removeContractIntallments(Installment installment) {
        contractsInstallments.remove(installment);
    }

    public String toString() {
        for (Installment list : contractsInstallments) {
            System.out.println(list.getDueDate() + " " + list.getAmount());
        }
       return toString();
    }


}
