package oop.inheritance.terminal.verifone;

import oop.inheritance.terminal.GPS;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.model.TransactionResponse;
import oop.library.v240m.VerifoneV240mGPS;

public class GPSAdapter implements GPS {
    private final VerifoneV240mGPS verifoneV240mGPS;

    public GPSAdapter() {
        verifoneV240mGPS = new VerifoneV240mGPS();
    }

    @Override
    public void open() {
        verifoneV240mGPS.open();
    }

    @Override
    public void send(Transaction transaction) {
    }

    @Override
    public TransactionResponse receive() {
        return verifoneV240mGPS.receive();
    }

    @Override
    public void close() {
        verifoneV240mGPS.close();
    }
}