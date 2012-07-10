package ddd.bank.domain.exchange;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

/**
 *
 */
public interface ExchangeService {
    Currency REF_CURR = Currency.getInstance("EUR");
    BigDecimal FEE = BigDecimal.ONE;

    List<QuoteDTO> findRate(Currency currency);
    QuoteDTO findCurrentRate(Currency currency);
}