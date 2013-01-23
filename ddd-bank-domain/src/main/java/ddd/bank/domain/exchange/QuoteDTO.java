package ddd.bank.domain.exchange;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

/**
 *
 */
public class QuoteDTO {

    public QuoteDTO(Date dayOfValidity, BigDecimal rate) {
        this.validfromday = dayOfValidity;
        this.validtoday = new Date(dayOfValidity.getTime()+86400);//add one day
        this.rate = rate;
    }

    public Currency currency;
    public BigDecimal rate; // relative reference currency
    public Date validfromday;
    public Date validtoday;
}

