/**
 * Клас Punctuation представляє розділовий знак.
 * Містить конструктор для ініціалізації знаку та геттер для його отримання.
 */
class Punctuation {
    private char symbol;

    /**
     * Конструктор класу Punctuation.
     * Ініціалізує об'єкт розділовим знаком.
     *
     * @param symbol розділовий знак, що буде збережений в об'єкті.
     */
    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Геттер, який повертає розділовий знак.
     *
     * @return розділовий знак типу char.
     */
    public char getSymbol() {
        return symbol;
    }
}
