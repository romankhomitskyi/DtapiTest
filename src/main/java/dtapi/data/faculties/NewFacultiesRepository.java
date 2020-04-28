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
}
