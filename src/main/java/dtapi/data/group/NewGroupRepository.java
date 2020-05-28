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
                "КЕП-10",
                "Геофізика",
                "Програмна інженерія"

        );
    }

    public static NewGroup mathAndProg() {
        return new NewGroup(
                "ПІ16-2",
                "Математика",
                "Програмна інженерія"
        );
    }
    public static NewGroup emptyGroupField() {
        return new NewGroup(
                "",
                "",
                ""

        );
    }
    public static NewGroup existGroup() {
        return new NewGroup(
                "НР-12",
                "Комп'ютерна інженерія",
                "Автоматизація та компютерні наукии"

        );
    }
}
