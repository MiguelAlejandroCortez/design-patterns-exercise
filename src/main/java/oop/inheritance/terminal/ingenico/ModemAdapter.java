package oop.inheritance.terminal.ingenico;

import oop.inheritance.terminal.Modem;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.services.IngenicoModem;

public class ModemAdapter implements Modem {
    private final IngenicoModem ingenicoModem;

    public ModemAdapter() {
        ingenicoModem = new IngenicoModem();
    }

    @Override
    public void open() {
        ingenicoModem.open();
    }

    @Override
    public byte[] receive() {
        return ingenicoModem.receive();
    }

    @Override
    public void send(Transaction transaction) {
        ingenicoModem.send(transaction);
    }

    @Override
    public void close() {
        ingenicoModem.close();
    }
}