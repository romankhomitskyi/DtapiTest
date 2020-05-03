package dtapi.data.subject;

public class NewSubjectRepository {
    private NewSubjectRepository() {
    }

    public static NewSubject photo() {
        return new NewSubject(
                "Фото",
                "Вивчаємо фото"
        );
    }

    public static NewSubject planet() {
        return new NewSubject(
                "Планети",
                "Вивчаємо планети"
        );
    }

    public static NewSubject blog() {
        return new NewSubject(
                "Блог",
                "Вивчаємо блогерство"
        );
    }
    public static NewSubject highMath() {
        return new NewSubject(
                "Вища математика",
                "Вивчаємо блогерство"
        );
    }

    public static NewSubject garden() {
        return new NewSubject(
                "Садівництво",
                "Вивчаємо садівництво"
        );
    }
    public static NewSubject emptyField() {
        return new NewSubject(
                "",
                ""
        );
    }
    public static NewSubject englishSymbols() {
        return new NewSubject(
                "ertry",
                "rtyhuj"
        );
    }
    public static NewSubject numbers() {
        return new NewSubject(
                "23ркрк",
                "543ркрк"
        );
    }

    public static NewSubject existSubject() {
        return new NewSubject(
                "Вища математика",
                "Один із фундаментальних предмет"
        );
    }

}
