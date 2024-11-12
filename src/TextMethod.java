import java.util.HashSet;

/**
 * Клас TextMethod, який працює з текстом типу {@link Text} та дозволяє шукати слова заданої довжини у питальних реченнях цього тексту.
 * Клас має метод, що виконує пошук таких слів та повертає результат.
 *
 * @author Taras Vasiliev
 */
public class TextMethod {
    private Text text;
    private int wordLength;

    /**
     * Конструктор класу TextMethod.
     * Ініціалізує об'єкт з текстом та задає довжину слів, які будуть шукатись.
     *
     * @param text текст, з яким буде виконуватись подальша робота
     * @param wordLength довжина слів, які потрібно знайти у питальних реченнях
     */
    public TextMethod(Text text, int wordLength) {
        this.text = text;
        this.wordLength = wordLength;
    }

    /**
     * Метод для пошуку та виведення слів заданої довжини у питальних реченнях тексту.
     * Спочатку перевіряється, чи не порожній текст, потім чи є в ньому речення.
     * Якщо умови виконуються, проводиться пошук слів заданої довжини у питальних реченнях.
     * Знайдені слова додаються до {@link HashSet} для уникнення повторів.
     * Якщо таких слів немає, виводиться відповідне повідомлення.
     *
     * @return Результат пошуку слів: повідомлення про порожній текст, відсутність речень, або список знайдених слів
     */
    public String getWordsGivenLengthInQuestions() {
        // Перевірка на пустий текст
        if (text.isNull()) {
            return "Текст не заданий";
        }

        // Перевірка на наявність речень у тексті
        if (!text.hasSentences()) {
            return "У тексті відсутні розділові знаки для визначення речень.";
        }

        // Набір для зберігання слів заданої довжини
        HashSet<String> matchingWords = new HashSet<>();
        for (Sentence sentence : text.getSentences()) {
            // Перевірка, чи є речення питальним
            if (sentence.isQuestion()) {
                // Перевірка кожного елементу в реченні (слово або розділовий знак)
                for (Object e : sentence.getWordsAndPunctuations()) {
                    if (e instanceof Word) {
                        Word word = (Word) e;
                        // Додавання слова заданої довжини до набору
                        if (word.toString().length() == wordLength) {
                            matchingWords.add(word.toString());
                        }
                    }
                }
            }
        }

        // Повернення результату пошуку
        if (matchingWords.isEmpty()) {
            return "Слів із заданою довжиною [" + wordLength + "] у питальних реченнях не знайдено.";
        } else {
            return "Знайдені у питальних реченнях слова із заданою довжиною [" + wordLength + "]: " + matchingWords;
        }
    }
}
