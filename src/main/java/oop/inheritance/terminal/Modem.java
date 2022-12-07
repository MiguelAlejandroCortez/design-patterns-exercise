package oop.inheritance.terminal;

import oop.library.ingenico.model.Transaction;

public interface Modem {
    void open();

    byte[] receive();

    void send(Transaction transaction);

    void close();
}
