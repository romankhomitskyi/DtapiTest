package dtapi.data.enums;

public enum QuestionType {
    RADIO_BUTTON("Простий вибір"),
    CHECK_BOX("Мультивибір"),
    TEXT_FIELD("Текстове"),
    RANGE("Числовий діапазон");

    public String question;

    QuestionType(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return question;
    }
}
