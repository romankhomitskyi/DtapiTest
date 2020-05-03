package dtapi.data.speciality;

public class NewSpeciality {
    private String codeSpeciality;
    private String nameSpeciality;

    public NewSpeciality(String codeSpeciality, String nameSpeciality) {
        this.codeSpeciality = codeSpeciality;
        this.nameSpeciality = nameSpeciality;
    }

    public String getCodeSpeciality() {
        return codeSpeciality;
    }

    public void setCodeSpeciality(String codeSpeciality) {
        this.codeSpeciality = codeSpeciality;
    }

    public String getNameSpeciality() {
        return nameSpeciality;
    }

    public void setNameSpeciality(String nameSpeciality) {
        this.nameSpeciality = nameSpeciality;
    }
}
