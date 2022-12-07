package oop.inheritance.terminal.verifone;

import oop.inheritance.terminal.Ethernet;
import oop.library.ingenico.model.Transaction;
import oop.library.v240m.VerifoneV240mEthernet;

public class EthernetAdapter implements Ethernet {
    private final VerifoneV240mEthernet verifoneV240mEthernet;

    public EthernetAdapter() {
        verifoneV240mEthernet = new VerifoneV240mEthernet();
    }

    @Override
    public void open() {
        verifoneV240mEthernet.open();
    }

    @Override
    public void send(Transaction transaction) {
    }

    @Override
    public byte[] receive() {
        return verifoneV240mEthernet.receive();
    }

    @Override
    public void close() {
        verifoneV240mEthernet.close();
    }
}