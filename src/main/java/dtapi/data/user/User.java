package dtapi.data.user;

import java.util.ArrayList;
import java.util.List;

interface ILogin {
    IPassword setLogin(String login);

    IUser build();
}

interface IPassword {
    ILogin setPassword(String password);

}

interface IBuildUser {
    IUser build();
}


public final class User implements ILogin, IPassword, IUser, IBuildUser {


    public static enum UserColumns {
        LOGIN(0),
        PASSWORD(1);


        private int index;

        private UserColumns(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    public final static String EMPTY_STRING = new String();
    private String login;
    private String password;

    public static ILogin get() {
        return new User();
    }


    //getters
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    //setters
    public IPassword setLogin(String login) {
        this.login = login;
        return this;
    }

    public ILogin setPassword(String password) {
        this.password = password;
        return this;
    }

    public IUser build() {
        return this;
    }

    @Override
    public String toString() {
        return "User [login=" + login
                + ", password=" + password
                + "]";
    }

    public static IUser getByList(List<String> row) {
        List<String> userData = new ArrayList<>(row);
        for (int i = userData.size(); i < UserColumns.values().length; i++) {
            userData.add(EMPTY_STRING);
        }
        return User.get()
                .setLogin(System.getenv().get(userData.get(UserColumns.LOGIN.getIndex())))
                .setPassword(System.getenv().get(userData.get(UserColumns.PASSWORD.getIndex())))
                .build();
    }


}
