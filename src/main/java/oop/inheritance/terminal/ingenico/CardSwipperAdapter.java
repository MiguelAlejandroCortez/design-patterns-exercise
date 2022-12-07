package oop.inheritance.terminal.ingenico;

import oop.inheritance.terminal.CardSwipper;
import oop.library.ingenico.services.IngenicoCardSwipper;
import oop.library.ingenico.model.Card;

public class CardSwipperAdapter implements CardSwipper {
    private final IngenicoCardSwipper ingenicoCardSwipper;

    public CardSwipperAdapter() {
        ingenicoCardSwipper = new IngenicoCardSwipper();
    }

    @Override
    public Card readCard() {
        return ingenicoCardSwipper.readCard();
    }
}