package com.behavioral;

public class StrategyPatternClient {
    public static void main(String[] args) {
        int[] numbers = { 5, 1, 3, 6, 2, 4 };
        SortContext context = new SortContext();
        context.setStrategy(new BubbleSort());
        context.performSort(numbers); // Output: Sorting using Bubble Sort
        context.setStrategy(new QuickSort());
        context.performSort(numbers); // Output: Sorting using Quick Sort
    }
}
// Strategy interface
interface SortingStrategy {
    void sort(int[] arr);
}

// Concrete Strategies
class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] arr) {
        // Implementation of bubble sort
        System.out.println("Sorting using Bubble Sort");
    }
}

class QuickSort implements SortingStrategy {
    @Override
    public void sort(int[] arr) {
        // Implementation of quick sort
        System.out.println("Sorting using Quick Sort");
    }
}

// Context
class SortContext {
    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void performSort(int[] arr) {
        strategy.sort(arr);
    }
}


// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// Concrete Strategy 1
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using credit card " + cardNumber);
    }
}

// Concrete Strategy 2
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using PayPal account " + email);
    }
}

// Context
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int totalAmount) {
        paymentStrategy.pay(totalAmount);
    }
}

 class StrategyPatternExample {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456");
        PaymentStrategy paypalPayment = new PayPalPayment("example@example.com");

        cart.setPaymentStrategy(creditCardPayment);
        cart.checkout(100);

        cart.setPaymentStrategy(paypalPayment);
        cart.checkout(50);
    }
}