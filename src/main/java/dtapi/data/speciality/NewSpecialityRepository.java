package dtapi.data.speciality;

public class NewSpecialityRepository {

    public static NewSpeciality pravo() {
        return new NewSpeciality(
                "234",
                "Право"
        );
    }

    public static NewSpeciality ciberSecurity() {
        return new NewSpeciality(
                "243",
                "Кібербезпека"
        );
    }

    public static NewSpeciality metalurgia() {
        return new NewSpeciality(
                "67",
                "Водні ресурси"
        );
    }public static NewSpeciality emptyField() {
        return new NewSpeciality(
                "",
                ""
        );
    }
    public static NewSpeciality englishSymbols() {
        return new NewSpeciality(
                "ertry",
                "rtyhuj"
        );
    }
    public static NewSpeciality numbers() {
        return new NewSpeciality(
                "23Nfd",
                "543erehe"
        );
    }

    public static NewSpeciality existSpeciality() {
        return new NewSpeciality(
                "151",
                "Автоматизація та комп'ютерно-інтегровані технології"
        );
    }
}

