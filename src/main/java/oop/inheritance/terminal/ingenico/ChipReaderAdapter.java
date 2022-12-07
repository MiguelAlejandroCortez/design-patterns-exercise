package oop.inheritance.terminal.ingenico;

import oop.inheritance.terminal.ChipReader;
import oop.library.ingenico.services.IngenicoChipReader;
import oop.library.ingenico.model.Card;

public class ChipReaderAdapter implements ChipReader {

    private final IngenicoChipReader ingenicoChipReader;

    public ChipReaderAdapter() {
        ingenicoChipReader = new IngenicoChipReader();
    }

    @Override
    public Card readCard() {
        return ingenicoChipReader.readCard();
    }
}