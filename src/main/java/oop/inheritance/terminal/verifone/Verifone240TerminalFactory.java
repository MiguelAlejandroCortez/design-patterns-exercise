package oop.inheritance.terminal.verifone;

import oop.inheritance.terminal.*;
import oop.inheritance.terminal.ingenico.EthernetAdapter;
import oop.inheritance.terminal.ingenico.GPSAdapter;
import oop.inheritance.terminal.ingenico.ModemAdapter;

public class Verifone240TerminalFactory extends TerminalFactory {
    @Override
    public Display getDisplay() {
        return new DisplayAdapter();
    }

    @Override
    public Keyboard getKeyboard() {
        return new KeyboardAdapter();
    }

    @Override
    public Printer getPrinter() {
        return new PrinterAdapter();
    }

    @Override
    public CardSwipper getCardSwiper() {
        return new CardSwipperAdapter();
    }

    @Override
    public ChipReader getChipReader() {
        return new ChipReaderAdapter();
    }

    @Override
    public Ethernet getEthernet() {
        return new EthernetAdapter();
    }

    @Override
    public Modem getModem() {
        return new ModemAdapter();
    }

    @Override
    public GPS getGPS() {
        return new GPSAdapter();
    }
}