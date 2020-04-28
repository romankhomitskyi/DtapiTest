package dtapi.data.speciality;

public class NewSpeciality {
    private int codeSpeciality;
    private String nameSpeciality;

    public NewSpeciality(int codeSpeciality, String nameSpeciality) {
        this.codeSpeciality = codeSpeciality;
        this.nameSpeciality = nameSpeciality;
    }

    public int getCodeSpeciality() {
        return codeSpeciality;
    }

    public void setCodeSpeciality(int codeSpeciality) {
        this.codeSpeciality = codeSpeciality;
    }

    public String getNameSpeciality() {
        return nameSpeciality;
    }

    public void setNameSpeciality(String nameSpeciality) {
        this.nameSpeciality = nameSpeciality;
    }
}
