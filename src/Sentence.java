import java.util.ArrayList;
import java.util.List;

/**
 * Клас Sentence, який представляє речення, що складається з масиву слів типу {@link Word}
 * та розділових знаків типу {@link PunctuationMark}.
 * Клас містить методи для розбиття речення на слова та знаки, перевірки, чи є це питанням,
 * а також для перевірки, чи є це саме реченням, а не просто набором слів чи символів.
 *
 * @author Taras Vasiliev
 */
public class Sentence {
    private List<Object> wordsAndPunctuations;
    final String allPunctuations = ",:;.?!";

    /**
     * Конструктор класу Sentence.
     * Розбиває текстове речення на слова та розділові знаки, додаючи їх у масив.
     *
     * @param sentence текстове речення, яке буде розділене на слова та розділові знаки
     *                 за допомогою пробілів як роздільників.
     */
    public Sentence(String sentence) {
        wordsAndPunctuations = new ArrayList<>();
        String[] elements = sentence.split("\\s+");  // Розбиття на елементи за пробілами

        for (String element : elements) {
            // Перевірка на наявність розділового знаку після слова
            if (allPunctuations.contains(element.substring(element.length() - 1))) {
                wordsAndPunctuations.add(new Word(element.substring(0, element.length() - 1)));
                wordsAndPunctuations.add(new PunctuationMark(element.toCharArray()[element.length() - 1]));
            } else {
                wordsAndPunctuations.add(new Word(element));
            }
        }
    }

    /**
     * Геттер, який повертає список елементів (слів та розділових знаків), з яких складається речення.
     *
     * @return список елементів, що складають речення
     */
    public List<Object> getWordsAndPunctuations() {
        return wordsAndPunctuations;
    }

    /**
     * Метод для перевірки, чи є це речення питальним.
     * Речення вважається питальним, якщо воно завершується знаком питання (?).
     *
     * @return true, якщо речення питальне, false — якщо ні
     */
    public boolean isQuestion() {
        if (!wordsAndPunctuations.isEmpty() && wordsAndPunctuations.get(wordsAndPunctuations.size() - 1) instanceof PunctuationMark) {
            PunctuationMark lastPunctuation = (PunctuationMark) wordsAndPunctuations.get(wordsAndPunctuations.size() - 1);
            return lastPunctuation.getPunctuation() == '?';
        }
        return false;
    }

    /**
     * Метод для перевірки, чи є це правильним реченням.
     * Речення вважається правильним, якщо воно завершується крапкою, знаком питання або оклику.
     *
     * @param sentence текст, який буде перевірено на наявність ознак речення
     * @return true, якщо це правильне речення, false — якщо ні
     */
    public static boolean isSentence(String sentence) {
        return sentence.endsWith(".") || sentence.endsWith("?") || sentence.endsWith("!");
    }

    /**
     * Перевизначений метод toString(), що дозволяє зручно вивести речення у вигляді рядка.
     * У виводі слова та розділові знаки відображаються у правильному порядку.
     *
     * @return відформатоване речення у вигляді рядка
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object wordOrPunctuation : wordsAndPunctuations) {
            if (wordOrPunctuation instanceof Word) {
                sb.append(wordOrPunctuation.toString()).append(" ");
            } else if (wordOrPunctuation instanceof PunctuationMark) {
                sb.append(wordOrPunctuation.toString());
            }
        }
        return sb.toString();
    }
}
