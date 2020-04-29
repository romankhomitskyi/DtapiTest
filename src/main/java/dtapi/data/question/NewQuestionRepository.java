package dtapi.data.question;

import dtapi.data.enums.QuestionLvl;
import dtapi.data.enums.QuestionType;

public final class NewQuestionRepository {
    private NewQuestionRepository() {
    }





    public static NewQuestion getQuestion1() {
        return new NewQuestion(
                "Скільки планет",
                QuestionType.RADIO_BUTTON,
                QuestionLvl.FIRST_LVL)
                .addAnswer("Дві", true)
                .addAnswer("Три", false)
                .addAnswer("Чотири", false)
                .addAnswer("Одна", false);


    }
    public static NewQuestion getQuestion2() {
        return new NewQuestion(
                "Скільки днів в тижні",
                QuestionType.CHECK_BOX,
                QuestionLvl.SECOND_LVL)
                .addAnswer("12", true)
                .addAnswer("14", false)
                .addAnswer("6+1", true)
                .addAnswer("7", true);


    }
    public static NewQuestion getQuestion3() {
        return new NewQuestion(
                "Скільки місяців в році",
                QuestionType.TEXT_FIELD,
                QuestionLvl.THIRD_LVL)
                .addAnswer("7", false)
                .addAnswer("1", false);


    }
    public static NewQuestion getQuestion4() {
        return new NewQuestion(
                "Від 1 до 7",
                QuestionType.RANGE,
                QuestionLvl.FOURTH_LVL)
                .addAnswer("1", false)
                .addAnswer("7", false);


    }



}
