package dtapi.data.group;

import dtapi.data.faculties.NewFaculties;

public class NewGroup {
    private String groupId;
    private String groupSpeciality;
    private String groupFaculty;
    private NewFaculties facult;

    public NewGroup(String groupId, String groupSpeciality, String groupFaculty) {
        this.groupId = groupId;
        this.groupSpeciality = groupSpeciality;
        this.groupFaculty = groupFaculty;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupSpeciality() {
        return groupSpeciality;
    }

    public void setGroupSpeciality(String groupSpeciality) {
        this.groupSpeciality = groupSpeciality;
    }

    public String getGroupFaculty() {
        return groupFaculty;
    }

    public void setGroupFaculty(String groupFaculty) {
        this.groupFaculty = groupFaculty;
    }


}
