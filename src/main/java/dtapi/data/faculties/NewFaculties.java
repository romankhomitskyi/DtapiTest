package dtapi.data.faculties;

public class NewFaculties {
    private String facultiesName;
    private String facultiesDesc;

    public NewFaculties(String facultiesName, String facultiesDesc) {
        this.facultiesName = facultiesName;
        this.facultiesDesc = facultiesDesc;
    }

    public String getFacultiesName() {
        return facultiesName;
    }

    public void setFacultiesName(String facultiesName) {
        this.facultiesName = facultiesName;
    }

    public String getFacultiesDesc() {
        return facultiesDesc;
    }

    public void setFacultiesDesc(String facultiesDesc) {
        this.facultiesDesc = facultiesDesc;
    }
}
