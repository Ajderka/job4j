package ru.job4j.condition;

/**
 * Class  4.1. Глупый бот.[#91001]
 * @author Ayder Khayredinov (emage.haf@gmail.com)
 * @since 03.12.2018
 * @version 1
 */
public class DummyBot {

    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
