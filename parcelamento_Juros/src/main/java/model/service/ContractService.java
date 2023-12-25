package model.service;

import entities.Contract;

import entities.Installment;
import lombok.Data;

import java.time.LocalDate;


@Data

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }
    public void processContact(Contract contract, int months) {
        Double basicQuota = contract.getValorDoContrato() / months;
        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);

            double interest = onlinePaymentService.interest(basicQuota, i);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;

            contract.getContractsInstallments().add(new Installment(dueDate, quota));
        }
    }
}