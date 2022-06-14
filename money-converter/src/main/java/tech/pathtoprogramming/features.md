Code design:

Money (currency, price)

private final CurrencyClient currencyClient;

input: 100 USD -> EUR = 33 * 0.96 =

Can we make it a pure function?

```java
public convert(String price, String currency); // MoneyConverter
public BigDecimal getConversionRate(Money startingMoney, Currency targetCurrency); // Interface :: CurrencyExchangeBoard
public BigDecimal calculate(BigDecimal basePrice, BigDecimal conversionRate); // MoneyCalculator
```

## test list - EndToEnd

input: 100 USD -> EUR = 100 * 0.96 = 96


## test list - MoneyConverter
## test list - MoneyCalculator



# API Client

```java
HttpRequest httpRequest = HttpRequest.newBuilder()
        .header("apikey", "DSnpC3Zn1zf1VduVixFYJLfFSM7lNWxP")
        .uri(new URI("https://api.apilayer.com/fixer/latest?symbols=EUR&base=USD"))
        .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
```

## Success Response
```json5
{
    "success": true,
    "timestamp": 1655175736,
    "base": "USD",
    "date": "2022-06-14",
    "rates": {
        "EUR": 0.95987
    }
}
```

## Invalid Currency Code Response

```json5
{
    "success": false,
    "error": {
        "code": 202,
        "type": "invalid_currency_codes",
        "info": "You have provided one or more invalid Currency Codes. [Required format: currencies=EUR,USD,GBP,...]"
    }
}
```

## Invalid Base Currency

```json5
{
    "success": false,
    "error": {
        "code": 201,
        "type": "invalid_base_currency"
    }
}
```

## Multiple rates

```json5
{
    "success": true,
    "timestamp": 1655176144,
    "base": "EUR",
    "date": "2022-06-14",
    "rates": {
        "USD": 1.04234,
        "GBP": 0.856855
    }
}
```