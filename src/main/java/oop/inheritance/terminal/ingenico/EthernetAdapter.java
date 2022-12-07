package oop.inheritance.terminal.ingenico;

import oop.inheritance.terminal.Ethernet;
import oop.library.ingenico.model.Transaction;
import oop.library.ingenico.services.IngenicoEthernet;

public class EthernetAdapter implements Ethernet {

    private final IngenicoEthernet ingenicoEthernet;

    public EthernetAdapter() {
        ingenicoEthernet = new IngenicoEthernet();
    }

    @Override
    public void open() {
        ingenicoEthernet.open();
    }

    @Override
    public void send(Transaction transaction) {
        ingenicoEthernet.send(transaction);
    }

    @Override
    public byte[] receive() {
        return ingenicoEthernet.receive();
    }

    @Override
    public void close() {
        ingenicoEthernet.close();
    }
}