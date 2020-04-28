package dtapi.data.speciality;

public class NewSpecialityRepository {

    public static NewSpeciality pravo() {
        return new NewSpeciality(
                234,
                "Право"
        );
    }

    public static NewSpeciality ciberSecurity() {
        return new NewSpeciality(
                243,
                "Кібербезпека"
        );
    }

    public static NewSpeciality metalurgia() {
        return new NewSpeciality(
                67,
                "Водні ресурси"
        );
    }
}

