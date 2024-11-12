/**
 * Клас Letter, який представляє одну літеру типу {@code char}.
 * Клас має конструктор для ініціалізації літери та геттер для отримання значення літери.
 *
 * @author Taras Vasiliev
 */
public class Letter {
    private char letter;

    /**
     * Конструктор класу Letter.
     * Ініціалізує об'єкт літери, що зберігається у полі {@code letter}.
     *
     * @param letter літера, яку потрібно зберігати в об'єкті
     */
    public Letter(char letter) {
        this.letter = letter;
    }

    /**
     * Геттер, який повертає значення літери.
     *
     * @return літера типу {@code char}
     */
    public char getLetter() {
        return letter;
    }

    /**
     * Перевизначений метод {@code toString()} для зручнішого виведення літери.
     * Повертає літеру у вигляді рядка.
     *
     * @return літера у відформатованому вигляді як рядок
     */
    @Override
    public String toString() {
        return String.valueOf(letter);
    }
}
