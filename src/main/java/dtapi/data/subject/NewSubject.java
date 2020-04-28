package dtapi.data.subject;

public class NewSubject {
    private String subjectName;
    private String subjectDesc;


    public NewSubject(String subjectName, String subjectDesc) {
        this.subjectName = subjectName;
        this.subjectDesc = subjectDesc;

    }


    //setters
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSubjectDesc(String subjectDesc) {
        this.subjectDesc = subjectDesc;
    }


    //getters

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectDesc() {
        return subjectDesc;
    }

}

