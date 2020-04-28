package dtapi.data.question;

public final class NewQuestionRepository {
    private NewQuestionRepository() {
    }





    public static NewQuestion getQuestion1() {
        return new NewQuestion(
                "Скільки планет")
                .addAnswer("Дві", true)
                .addAnswer("Три", false)
                .addAnswer("Чотири", false)
                .addAnswer("Одна", false);


    }
    public static NewQuestion getQuestion2() {
        return new NewQuestion(
                "Скільки днів в тижні")
                .addAnswer("Дві", true)
                .addAnswer("Три", false)
                .addAnswer("Чотири", false)
                .addAnswer("Одна", false);


    }
    public static NewQuestion getQuestion3() {
        return new NewQuestion(
                "Скільки місяців в році")
                .addAnswer("Дві", true)
                .addAnswer("Три", false)
                .addAnswer("Чотири", false)
                .addAnswer("Одна", false);

    }
    public static NewQuestion getQuestion4() {
        return new NewQuestion(
                "Скільки днів в році")
                .addAnswer("Чотири", true)
                .addAnswer("10", false)
                .addAnswer("365", true)
                .addAnswer("1", false);

    }
    public static NewQuestion getQuestion5() {
        return new NewQuestion(
                "Скільки днів в році")
                .addAnswer("Чотири", true)
                .addAnswer("10", false)
                .addAnswer("365", true)
                .addAnswer("1", false);

    }


}
