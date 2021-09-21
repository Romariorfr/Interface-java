package service;

import entitie.Contract;

public interface OnlinePaymentService {
	
	//taxa de pagamento
	public Double paymentFee(Double amount);
	
	//juros
	public Double interest(Double amount,Integer months);
	
	
}
