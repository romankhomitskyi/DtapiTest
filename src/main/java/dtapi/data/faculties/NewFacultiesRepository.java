package dtapi.data.faculties;

public class NewFacultiesRepository {
    public static NewFaculties filologiya() {
        return new NewFaculties(
                "Філологія",
                "Вивчення китайської"
        );
    }

    public static NewFaculties phisoloh() {
        return new NewFaculties(
                "Філософія",
                "Вивчення філософії"
        );
    }

    public static NewFaculties financy() {
        return new NewFaculties(
                "Фінанси",
                "Вивчення фінансів і бізнесу"
        );
    }
    public static NewFaculties emptyField() {
        return new NewFaculties(
                "",
                ""
        );
    }
    public static NewFaculties englishSymbols() {
        return new NewFaculties(
                "ertry",
                "rtyhuj"
        );
    }
    public static NewFaculties numbers() {
        return new NewFaculties(
                "23Nfd",
                "543erehe"
        );
    }
    public static NewFaculties lowerCase() {
        return new NewFaculties(
                "факультет",
                "опис факультета"
        );
    }
    public static NewFaculties existFaculty() {
        return new NewFaculties(
                "Програмна інженерія",
                "Вивчення основ програмування"
        );
    }


}
