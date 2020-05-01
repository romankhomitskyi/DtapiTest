package dtapi.data.student;


import java.util.ArrayList;
import java.util.List;


interface ISurname {
    IFirstName setSurname(String surname);

    IStudent build();
}

interface IFirstName {
    IFatherName setFirstName(String firstName);

}

interface IFatherName {
    IGradeBookId setFatherName(String fatherName);

}

interface IGradeBookId {
    IStudentLogin setGradeBookId(String gradeBookId);

}

interface IStudentLogin {
    IStudentEmail setStudentLogin(String studLog);

}

interface IStudentEmail {
    IStudentPassword setStudentEmail(String studEmail);

}

interface IStudentPassword {
    IStudentConfirmPassword setStudentPassword(String studPass);

}

interface IStudentConfirmPassword {
    ISurname setStudentConfirmPassword(String studConfPass);

}

interface IBuildStudent {
    IStudent build();
}

public final class Student implements IStudent, ISurname, IFirstName,
        IFatherName, IGradeBookId, IStudentLogin,
        IStudentEmail, IStudentPassword, IStudentConfirmPassword, IBuildStudent {

    public static enum StudentColumns {
        SURNAME(0),
        FIRSTNAME(1),
        FATHERNAME(2),
        GRADEBOOKID(3),
        STUDENTLOGIN(4),
        STUDENTEMAIL(5),
        STUDENTPASSWORD(6),
        STUDENTCONFIRMPASSWORD(7);


        private int index;

        private StudentColumns(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    public final static String EMPTY_STRING = new String();
    private String surname;
    private String firstName;
    private String fatherName;
    private String gradeBookId;
    private String studLog;
    private String studEmail;
    private String studPass;
    private String studConfPass;

    public static ISurname getStudent() {
        return new Student();
    }


    //getters
    public String getSurname() {
        return surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getGradeBookId() {
        return gradeBookId;
    }

    public String getStudentLogin() {
        return studLog;
    }

    public String getStudentEmail() {
        return studEmail;
    }

    public String getStudentPassword() {
        return studPass;
    }

    public String getStudentConfirmPassword() {
        return studConfPass;
    }

    //setters
    public IFirstName setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public IFatherName setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public IGradeBookId setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public IStudentLogin setGradeBookId(String gradeBookId) {
        this.gradeBookId = gradeBookId;
        return this;
    }

    public IStudentEmail setStudentLogin(String studLog) {
        this.studLog = studLog;
        return this;
    }

    public IStudentPassword setStudentEmail(String studEmail) {
        this.studEmail = studEmail;
        return this;
    }

    public IStudentConfirmPassword setStudentPassword(String studPass) {
        this.studPass = studPass;
        return this;
    }

    public ISurname setStudentConfirmPassword(String studConfPass) {
        this.studConfPass = studConfPass;
        return this;
    }


    public IStudent build() {
        return this;
    }

    @Override
    public String toString() {
        return "Student [surName=" + surname
                + ", firstName=" + firstName
                + ", fatherName=" + fatherName
                + ", gradeBookId=" + gradeBookId
                + ", studentLogin=" + studLog
                + ", studentEmail=" + studEmail
                + ", studentPassword=" + studPass
                + ", studentConfirmPassword=" + studConfPass
                + "]";
    }

    public static IStudent getByList(List<String> row) {
        List<String> userData = new ArrayList<>(row);
        for (int i = userData.size(); i < Student.StudentColumns.values().length; i++) {
            userData.add(EMPTY_STRING);
        }
        return Student.getStudent()
                .setSurname(userData.get(StudentColumns.SURNAME.getIndex()))
                .setFirstName(userData.get(StudentColumns.FIRSTNAME.getIndex()))
                .setFatherName(userData.get(StudentColumns.FATHERNAME.getIndex()))
                .setGradeBookId(userData.get(StudentColumns.GRADEBOOKID.getIndex()))
                .setStudentLogin(userData.get(StudentColumns.STUDENTLOGIN.getIndex()))
                .setStudentEmail(userData.get(StudentColumns.STUDENTEMAIL.getIndex()))
                .setStudentPassword(userData.get(StudentColumns.STUDENTPASSWORD.getIndex()))
                .setStudentConfirmPassword(userData.get(StudentColumns.STUDENTCONFIRMPASSWORD.getIndex()))
                .build();
    }


}
