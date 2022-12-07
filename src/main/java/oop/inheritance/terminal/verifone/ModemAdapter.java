package oop.inheritance.terminal.verifone;

import oop.inheritance.terminal.Modem;
import oop.library.ingenico.model.Transaction;
import oop.library.v240m.VerifoneV240mModem;

public class ModemAdapter implements Modem {
    private final VerifoneV240mModem verifoneV240mModem;

    public ModemAdapter() {
        verifoneV240mModem = new VerifoneV240mModem();
    }

    @Override
    public void open() {
        verifoneV240mModem.open();
    }

    @Override
    public byte[] receive() {
        return verifoneV240mModem.receive ();
    }

    @Override
    public void send(Transaction transaction) {
    }

    @Override
    public void close() {
        verifoneV240mModem.close();
    }
}