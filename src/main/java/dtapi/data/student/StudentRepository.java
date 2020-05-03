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
                .setGradeBookId("КЦ-21-12")
                .setStudentLogin("romank")
                .setStudentEmail("vasaswtrhr@papacarlos.com")
                .setStudentPassword("qwerty123")
                .setStudentConfirmPassword("qwerty123")
                .build();
    }
    public IStudent getSecondStudent() {
        return Student.getStudent()
                .setSurname("Шевченко")
                .setFirstName("Петро")
                .setFatherName("Романович")
                .setGradeBookId("КД-1-12")
                .setStudentLogin("petrik")
                .setStudentEmail("gegehtrhrthrhr@gmail.com")
                .setStudentPassword("qwerty123")
                .setStudentConfirmPassword("qwerty123")
                .build();
    }

    public IStudent getStudentWithEmptyFields() {
        return Student.getStudent()
                .setSurname("")
                .setFirstName("")
                .setFatherName("")
                .setGradeBookId("")
                .setStudentLogin("")
                .setStudentEmail("")
                .setStudentPassword("")
                .setStudentConfirmPassword("")
                .build();
    }
    public IStudent getStudentInvalidLogin() {
        return Student.getStudent()
                .setSurname("Шевченко")
                .setFirstName("Петро")
                .setFatherName("Романович")
                .setGradeBookId("КД-1-12")
                .setStudentLogin("romik")
                .setStudentEmail("jrtjrjstjr@gmail.com")
                .setStudentPassword("qwerty123")
                .setStudentConfirmPassword("qwerty123")
                .build();
    }
    public IStudent getStudentInvalidGradeBookId() {
        return Student.getStudent()
                .setSurname("Шевченко")
                .setFirstName("Петро")
                .setFatherName("Романович")
                .setGradeBookId("ЮК-21-12")
                .setStudentLogin("ololo")
                .setStudentEmail("jrtjrjstjr@gmail.com")
                .setStudentPassword("qwerty123")
                .setStudentConfirmPassword("qwerty123")
                .build();
    }
    public IStudent getStudentInvalidConfirmPassword() {
        return Student.getStudent()
                .setSurname("Шевченко")
                .setFirstName("Петро")
                .setFatherName("Романович")
                .setGradeBookId("ЮК-21-134")
                .setStudentLogin("ololo")
                .setStudentEmail("jrtjrjstjr@gmail.com")
                .setStudentPassword("qwerty123")
                .setStudentConfirmPassword("qwerty")
                .build();
    }

}

