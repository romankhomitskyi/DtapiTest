package dtapi.data.group;

public class NewGroupRepository {
    public static NewGroup entoAndSocio() {
        return new NewGroup(
                "ІФ-88",
                "Ентомологія",
                "Факукльтет соціології"

        );
    }

    public static NewGroup geoAndMed() {
        return new NewGroup(
                "ІФ-111",
                "Геофізика",
                "Програмна інженерія"

        );
    }

    public static NewGroup mathAndProg() {
        return new NewGroup(
                "ПІ16-222",
                "Математика",
                "Програмна інженерія"
        );
    }
}
