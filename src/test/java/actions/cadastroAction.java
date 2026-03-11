package actions;

import org.framework.utils.FakerUtils;
import org.framework.utils.MongoUtils;

public class cadastroAction {

    public static String getName() {
        String name = MongoUtils.getField("name");

        if (name == null) {
            name = FakerUtils.generateName();
            MongoUtils.setField("name", name);
        }

        return name;
    }

    public static String getEmail() {
        String email = MongoUtils.getField("email");

        if (email == null) {
            email = FakerUtils.generateEmail();
            MongoUtils.setField("email", email);
        }

        return email;
    }

    public static String getPassword() {
        String pass = MongoUtils.getField("password");

        if (pass == null) {
            pass = FakerUtils.generatePassword();
            MongoUtils.setField("password", pass);
        }

        return pass;
    }

    public static void ensureUserData() {
        getName();
        getEmail();
        getPassword();
    }


}