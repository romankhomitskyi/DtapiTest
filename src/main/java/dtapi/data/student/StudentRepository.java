package dtapi.data.student;

public final class StudentRepository {
    private static volatile StudentRepository instance = null;

    private StudentRepository() {
    }

    public static StudentRepository get() {
        if (instance == null) {
            synchronized (StudentRepository.class) {
                if (instance == null) {
                    instance = new StudentRepository();
                }
            }
        }
        return instance;
    }

    public IStudent getDefault() {
        return getFirstStudent();
    }

    public IStudent getFirstStudent() {
        return Student.getStudent()
                .setSurname("Хоміцький")
                .setFirstName("Роман")
                .setFatherName("Ігорович")
                .setGradeBookId("ЮК-21-12")
                .setStudentLogin(System.getenv().get("NEW_USER_LOGIN"))
                .setStudentEmail("vasasw@papacarlos.com")
                .setStudentPassword(System.getenv().get("NEW_USER_PASSWORD"))
                .setStudentConfirmPassword(System.getenv().get("NEW_USER_PASSWORD"))
                .build();
    }
    public IStudent getSecondStudent() {
        return Student.getStudent()
                .setSurname("Шевченко")
                .setFirstName("Петро")
                .setFatherName("Романович")
                .setGradeBookId("КД-1-12")
                .setStudentLogin(System.getenv().get("SECOND_USER_LOGIN"))
                .setStudentEmail("gegehtr@gmail.com")
                .setStudentPassword(System.getenv().get("NEW_USER_PASSWORD"))
                .setStudentConfirmPassword(System.getenv().get("NEW_USER_PASSWORD"))
                .build();
    }

}

