package dtapi.data.admin;

import java.util.ArrayList;
import java.util.List;


    interface IAdminLogin {
        IAdminEmail setAdminLogin(String adminLogin);

        IAdmin build();
    }

    interface IAdminEmail {
        IAdminPassword setAdminEmail(String adminEmail);

    }

    interface IAdminPassword {
        IAdminConfirmPassword setAdminPassword(String adminPassword);

    }

    interface IAdminConfirmPassword {
        IAdminLogin setAdminConfirmPassword(String setAdminConfirmPassword);

    }



    interface IBuildAdmin {
        IAdmin build();
    }

    public final class Admin implements IAdmin, IAdminConfirmPassword,IAdminEmail,IAdminLogin,IAdminPassword,IBuildAdmin {

        public static enum AdminColumns {
            ADMINLOGIN(0),
            ADMINEMAIL(1),
            ADMINPASSWORD(2),
            ADMINCONFIRMPASSWORD(3);


            private int index;

            private AdminColumns(int index) {
                this.index = index;
            }

            public int getIndex() {
                return index;
            }
        }

        public final static String EMPTY_STRING = new String();
        private String adminLog;
        private String adminEmail;
        private String adminPassword;
        private String adminConfirmPassword;


        public static IAdminLogin getAdmin() {
            return new Admin();
        }


        //getters
        public String getAdminLogin() {
            return adminLog;
        }

        public String getAdminEmail() {
            return adminEmail;
        }

        public String getAdminPassword() {
            return adminPassword;
        }

        public String getAdminConfirmPassword() {
            return adminConfirmPassword;
        }



        //setters
        public IAdminEmail setAdminLogin(String adminLog) {
            this.adminLog = adminLog;
            return this;
        }

        public IAdminPassword setAdminEmail(String adminEmail) {
            this.adminEmail = adminEmail;
            return this;
        }

        public IAdminConfirmPassword setAdminPassword(String adminPassword) {
            this.adminPassword = adminPassword;
            return this;
        }

        public IAdminLogin setAdminConfirmPassword(String adminConfirmPassword) {
            this.adminConfirmPassword = adminConfirmPassword;
            return this;
        }




        public IAdmin build() {
            return this;
        }

        @Override
        public String toString() {
            return "Admin [adminLogin=" + adminLog
                    + ", adminEmail=" + adminEmail
                    + ", adminPassword=" + adminPassword
                    + ", adminConfirmPassword=" + adminConfirmPassword
                    + "]";
        }

        public static IAdmin getByList(List<String> row) {
            List<String> userData = new ArrayList<>(row);
            for (int i = userData.size(); i < Admin.AdminColumns.values().length; i++) {
                userData.add(EMPTY_STRING);
            }
            return Admin.getAdmin()
                    .setAdminLogin(userData.get(AdminColumns.ADMINLOGIN.getIndex()))
                    .setAdminEmail(userData.get(AdminColumns.ADMINEMAIL.getIndex()))
                    .setAdminPassword(userData.get(AdminColumns.ADMINPASSWORD.getIndex()))
                    .setAdminConfirmPassword(userData.get(AdminColumns.ADMINCONFIRMPASSWORD.getIndex()))
                    .build();
        }
}
