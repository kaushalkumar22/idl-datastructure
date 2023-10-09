package com.structural;

public class BridgePatternClient {
    public static void main(String[] args) {
        MessageSender emailSender = new EmailSender();
        MessageSender smsSender = new SMSSender();

        Message emailMessage = new TextMessage(emailSender, "Hello via email");
        Message smsMessage = new TextMessage(smsSender, "Hello via SMS");

        emailMessage.send();
        smsMessage.send();
    }
}
// Implementor interface
interface MessageSender {
    void sendMessage(String message);
}

// Concrete Implementor 1
class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email: " + message);
    }
}

// Concrete Implementor 2
class SMSSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// Abstraction
abstract class Message {
    protected MessageSender sender;

    public Message(MessageSender sender) {
        this.sender = sender;
    }

    abstract void send();
}

// Refined Abstraction
class TextMessage extends Message {
    private String text;

    public TextMessage(MessageSender sender, String text) {
        super(sender);
        this.text = text;
    }

    @Override
    void send() {
        System.out.print("Text message: ");
        sender.sendMessage(text);
    }
}
