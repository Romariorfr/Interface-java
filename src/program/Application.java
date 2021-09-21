package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entitie.Contract;
import entitie.Installment;
import service.ContractService;
import service.PaypalService;

public class Application {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter contract data");
		System.out.print("number: ");
		Integer number = sc.nextInt();
		
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.next());
		
		System.out.print("Contract value: ");
		Double totalvalue = sc.nextDouble();
		
		System.out.print("Enter number of installments:");
		int N = sc.nextInt();
		
		
		Contract contract = new Contract (number,date,totalvalue);
		
		ContractService cs = new ContractService(new PaypalService());
		cs.processContract(contract, N);
		
		System.out.println("Installments:");
		for(Installment it : contract.getInstallments()) {
			System.out.println(it);
		}

	}

}
