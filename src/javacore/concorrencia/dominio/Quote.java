package javacore.concorrencia.dominio;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

// storeName->price->discountCode
public final class Quote {

    private final String store;
    private final Double price;
    private final Discount.Code discountCode;

    private Quote(String store, Double price, Discount.Code discountCode) {
        this.store = store;
        this.price = price;
        this.discountCode = discountCode;
    }

    /**
     * Creates new Quote object from the value following the pattern storeName:price:discountCode
     *
     * @param value containing storeName:price:discountCode
     * @return new Quote with values from @param value
     * @throws IllegalArgumentException if the input string format is invalid
     * @throws NumberFormatException    if the price cannot be parsed to a Double
     * @throws NullPointerException     if the input string or parts of it are null
     */
    public static Quote newQuote(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Input string for Quote cannot be null or empty.");
        }

        String[] values = value.split(":");

        try {
            String storeName = values[0];

            NumberFormat format = NumberFormat.getInstance(new Locale("pt", "BR"));
            Number parsedNumber = format.parse(values[1]);
            Double priceValue = parsedNumber.doubleValue();
            Discount.Code code = Discount.Code.valueOf(values[2].trim().toUpperCase());

            return new Quote(storeName, priceValue, code);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid price format in Quote string (parsing with locale): " + values[1] + ". Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException("Invalid discount code: " + values[2], e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Quote{" +
                "store='" + store + '\'' +
                ", price=" + price +
                ", discountCode=" + discountCode +
                '}';
    }

    public String getStore() {
        return store;
    }

    public double getPrice() {
        return price;
    }

    public Discount.Code getDiscountCode() {
        return discountCode;
    }
}



