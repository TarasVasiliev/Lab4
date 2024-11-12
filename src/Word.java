import java.util.ArrayList;
import java.util.List;

/**
 * Клас Word представляє слово, яке складається з масиву літер типу Letter.
 * Містить конструктор для створення слова з літер, геттер для отримання цього масиву,
 * а також перевизначений метод toString для зручного виведення слова у вигляді рядка.
 *
 * @author Taras Vasiliev
 */
public class Word {
    private List<Letter> letters;

    /**
     * Конструктор класу Word, який створює слово з літер.
     * Кожен символ слова додається як окремий об'єкт типу Letter в масив.
     *
     * @param word слово, яке буде розділено на окремі літери.
     */
    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    /**
     * Геттер, який повертає список літер, з яких складається слово.
     *
     * @return список літер, що складають слово.
     */
    public List<Letter> getWord() {
        return letters;
    }

    /**
     * Перевизначений метод toString, який форматує слово з літер.
     * Використовується для зручнішого виведення слова у вигляді рядка.
     *
     * @return слово у вигляді рядка.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.getLetter());
        }
        return sb.toString();
    }
}
