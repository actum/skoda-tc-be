package com.actumdigital.skoda_demo.payment;

import com.adyen.model.checkout.Amount;
import com.adyen.model.checkout.CardDetails;

public class PaymentRequestData {
    private Amount amount;
    private CardDetails cardDetails;

    // Getters and setters

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public CardDetails getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(CardDetails cardDetails) {
        this.cardDetails = cardDetails;
    }
}
