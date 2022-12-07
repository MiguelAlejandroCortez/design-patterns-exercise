package oop.inheritance;

import java.time.LocalDateTime;

import oop.inheritance.data.CommunicationType;
import oop.inheritance.terminal.*;
import oop.library.ingenico.model.Card;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;

public class Application {

    private CommunicationType communicationType = CommunicationType.ETHERNET;
    private TerminalFactory terminalFactory;

    public Application(TerminalFactory terminalFactory) {
        this.terminalFactory = terminalFactory;
    }

    public void showMenu() {
        Display display = terminalFactory.getDisplay();

        display.showMessage(5, 5, "MENU");
        display.showMessage(5, 10, "1. VENTA");
        display.showMessage(5, 13, "2. DEVOLUCION");
        display.showMessage(5, 16, "3. REPORTE");
        display.showMessage(5, 23, "4. CONFIGURACION");
    }

    public String readKey() {
        Keyboard keyboard = terminalFactory.getKeyboard();

        return keyboard.getChar();
    }

    public void doSale() {
        Display display = terminalFactory.getDisplay();
        Keyboard keyboard = terminalFactory.getKeyboard();
        CardSwipper cardSwipper = terminalFactory.getCardSwiper();
        ChipReader chipReader = terminalFactory.getChipReader();


        Card card;

        do {
            card = cardSwipper.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }
        } while (card == null);

        display.clear();
        display.showMessage(5, 20, "Capture monto:");

        String amount = keyboard.readLine(); //Amount with decimal point as string

        Transaction transaction = new Transaction();

        transaction.setLocalDateTime(LocalDateTime.now());
        transaction.setCard(card);
        transaction.setAmountInCents(Integer.parseInt(amount.replace(".", "")));

        TransactionResponse response = sendSale(transaction);

        if (response.isApproved()) {
            display.showMessage(5, 25, "APROBADA");
            printReceipt(transaction, response.getHostReference());
        } else {
            display.showMessage(5, 25, "DENEGADA");
        }
    }

    private void printReceipt(Transaction transaction, String hostReference) {
        Printer printer = terminalFactory.getPrinter();

        Card card = transaction.getCard();

        printer.print(5, "APROBADA");
        printer.lineFeed();
        printer.print(5, card.getAccount());
        printer.lineFeed();
        printer.print(5, "" + transaction.getAmountInCents());
        printer.lineFeed();
        printer.print(5, "________________");

    }

    private byte[] sendSale(Transaction transaction) {

        Ethernet ethernet = terminalFactory.getEthernet();
        Modem modem = terminalFactory.getModem();
        GPS gps = terminalFactory.getGPS();

        byte[] transactionResponse = null;

        switch (communicationType) {
            case ETHERNET:
                ethernet.open();
                ethernet.send(transaction);
                transactionResponse = ethernet.receive();
                ethernet.close();
                break;
            case GPS:
                gps.open();
                gps.send(transaction);
                transactionResponse = gps.receive();
                gps.close();
                break;
            case MODEM:
                modem.open();
                modem.send(transaction);
                transactionResponse = modem.receive();
                modem.close();
                break;
        }

        return transactionResponse;
    }

    public void doRefund() {
    }

    public void printReport() {
    }

    public void showConfiguration() {
    }

    public void clearScreen() {
        Display display =  terminalFactory.getDisplay();

        display.clear();
    }
}