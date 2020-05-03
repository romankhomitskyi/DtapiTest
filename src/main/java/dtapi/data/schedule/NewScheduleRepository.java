package dtapi.data.schedule;

public class NewScheduleRepository {

    public static NewSchedule schedule() {
        return new NewSchedule(
                "СІ-12-2",
                "2020-05-1",
                "2020-05-1",
                "08:00",
                "10:00"

        );
    }
    public static NewSchedule invalidDate() {
        return new NewSchedule(
                "НР-12",
                "2020-08-15",
                "2020-08-1",
                "08:00",
                "10:00"

        );
    }
    public static NewSchedule invalidTime() {
        return new NewSchedule(
                "СІ-12-2",
                "2020-08-1",
                "2020-08-15",
                "09:00",
                "08:00"

        );
    }
}


