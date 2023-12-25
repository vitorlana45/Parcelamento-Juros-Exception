package model.service;

import java.security.PrivateKey;

public interface OnlinePaymentService {


     Double paymentFee (Double amount);
     Double interest(Double amount, Integer months);


}
