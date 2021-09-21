package service;

import java.util.Calendar;
import java.util.Date;

import entitie.Contract;
import entitie.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;

	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		for(int i = 1; i<=months ; i++) {
			double updadeQuota = basicQuota + onlinePaymentService.interest(basicQuota,i);
			double fullQuota = updadeQuota + onlinePaymentService.paymentFee(updadeQuota);
			Date dueDate = addMonth(contract.getDate(), i);
			contract.getInstallments().add(new Installment(dueDate,fullQuota));
		}
		
	}
	
	private Date addMonth(Date date, int N) {
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(date);
		 calendar.add(Calendar.MONTH,N);
		 return calendar.getTime();
	}
	
	

}
