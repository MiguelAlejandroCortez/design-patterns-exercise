package oop.inheritance.terminal.ingenico;

import oop.inheritance.terminal.GPS;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.ingenico.services.IngenicoGPS;

public class GPSAdapter implements GPS {
    private final IngenicoGPS ingenicoGPS;

    public GPSAdapter() {
        ingenicoGPS = new IngenicoGPS();
    }

    @Override
    public void open() {
        ingenicoGPS.open();
    }

    @Override
    public void send(Transaction transaction) {
        ingenicoGPS.send(transaction);
    }

    @Override
    public TransactionResponse receive() {
        return ingenicoGPS.receive();
    }

    @Override
    public void close() {
        ingenicoGPS.close();
    }
}