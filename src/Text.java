import java.util.ArrayList;
import java.util.List;

/**
 * Клас Text, який представляє текст, що складається з масиву речень типу {@link Sentence}.
 * Клас містить методи для перевірки на порожній текст, перевірки, чи є в тексті повноцінні речення,
 * а також для отримання всіх речень у тексті.
 *
 * @author Taras Vasiliev
 */
public class Text {
    private List<Sentence> sentences;
    private boolean isNull;
    private boolean hasSentences;

    /**
     * Конструктор класу Text.
     * Розбиває текст на окремі речення та перевіряє, чи є текст порожнім або чи складається він з правильних речень.
     *
     * @param text текст, який буде розділений на масив речень.
     */
    public Text(String text) {
        sentences = new ArrayList<>();
        // Перевірка, чи є текст порожнім
        if (text == null || text.trim().isEmpty()) {
            isNull = true;
            hasSentences = false;
            return;
        }

        text = text.replaceAll("[\\t\\s]+", " ");  // Замінюємо табуляції та зайві пробіли на один пробіл
        String[] sentencesStrings = text.split("(?<=[.!?])\\s*");  // Розбиття на речення

        // Перевірка, чи є хоча б одне правильне речення в тексті
        if (!Sentence.isSentence(sentencesStrings[0])) {
            hasSentences = false;
            return;
        }

        for (String sentenceString : sentencesStrings) {
            sentences.add(new Sentence(sentenceString));
        }
        hasSentences = true;
    }

    /**
     * Геттер, який повертає список усіх речень у тексті.
     *
     * @return список об'єктів {@link Sentence}, що складають текст
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Метод, який повертає, чи є текст порожнім (null або порожній рядок).
     *
     * @return true, якщо текст порожній, false — якщо текст не порожній
     */
    public boolean isNull() {
        return isNull;
    }

    /**
     * Метод, який перевіряє, чи є хоча б одне правильне речення у тексті.
     * Речення вважається правильним, якщо воно завершується крапкою, знаком питання чи оклику.
     *
     * @return true, якщо текст містить хоча б одне правильне речення, false — якщо ні
     */
    public boolean hasSentences() {
        return hasSentences;
    }

    /**
     * Перевизначений метод toString(), який дозволяє зручно вивести всі речення тексту у вигляді рядка.
     * Кожне речення виводиться в порядку їх розташування в тексті.
     *
     * @return текст, що складається з усіх речень, у вигляді одного рядка
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.toString()).append(" ");
        }
        return sb.toString();
    }
}
