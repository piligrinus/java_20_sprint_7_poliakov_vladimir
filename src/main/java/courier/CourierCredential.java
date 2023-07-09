package courier;

public class CourierCredential {
private String login;
private String password;


    public CourierCredential(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CourierCredential(){

    }
    public static CourierCredential from (Courier courier){
        return new CourierCredential(courier.getLogin(), courier.getPassword());
    }

        public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
