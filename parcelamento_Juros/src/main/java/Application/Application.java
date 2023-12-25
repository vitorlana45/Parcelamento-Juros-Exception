package Application;

import entities.Contract;
import entities.Installment;
import model.service.ContractService;

import model.service.PaypalService;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                System.out.println("Entre os dados do contrato:");
                System.out.print("Numero: ");
                Integer numero = sc.nextInt();
                System.out.print("Data (dd/MM/yyyy):");
                LocalDate date = LocalDate.parse(sc.next(), fmt);
                System.out.print("Valor do contrato: ");
                Double valorContrato = sc.nextDouble();
                Contract contract = new Contract(numero, date, valorContrato);

                System.out.print("Entre com o numero de parcelas: ");
                Integer parcelas = sc.nextInt();

                ContractService contractService = new ContractService(new PaypalService());

                contractService.processContact(contract, parcelas);

                System.out.println("Parcelas: ");
                for (Installment installment : contract.getContractsInstallments()) {
                    System.out.println(installment);
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Veriique os dados e tente novamente! ");
            }catch (DateTimeParseException e){
                System.out.println("Error: Verique os dados e tente novamente!");
                System.out.println("Data inserida incorretamente tente novamente! = " );
            }
    }
    }
