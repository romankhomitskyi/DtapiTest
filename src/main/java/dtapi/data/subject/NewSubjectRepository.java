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

    public static NewSubject garden() {
        return new NewSubject(
                "Садівництво",
                "Вивчаємо садівництво"
        );
    }

}
