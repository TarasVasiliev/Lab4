/**
 * Клас PunctuationMark, який представляє розділовий знак.
 * Клас містить конструктор для ініціалізації розділового знаку, геттер для його отримання
 * та перевизначений метод `toString` для зручнішого виведення знаку.
 *
 * @author Dmytro Lutsenko
 */
public class PunctuationMark {
    private char punctuation;

    /**
     * Конструктор класу PunctuationMark, який ініціалізує розділовий знак.
     *
     * @param punctuation розділовий знак, що буде збережений у об'єкті.
     */
    public PunctuationMark(char punctuation) {
        this.punctuation = punctuation;
    }

    /**
     * Геттер, який повертає розділовий знак.
     *
     * @return розділовий знак типу char.
     */
    public char getPunctuation() {
        return punctuation;
    }

    /**
     * Перевизначений метод toString, який повертає розділовий знак як рядок.
     * Використовується для зручнішого виведення розділового знаку.
     *
     * @return розділовий знак у вигляді рядка.
     */
    @Override
    public String toString() {
        return String.valueOf(punctuation);
    }
}
