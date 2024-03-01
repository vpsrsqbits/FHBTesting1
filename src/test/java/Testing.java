import org.frenbenhealth.SignIn;
import org.frenbenhealth.SignUp;
import org.junit.jupiter.api.Test;


public class Testing {
SignIn signIn = new SignIn();
SignUp signUp = new SignUp();
    @Test
    void test() throws InterruptedException {

//        String userName = signUp.userSignUp();
//        signUp.confirmSignUp();
//        signIn.signIn(userName);

//        Delete Created User.
        signUp.deleteUser("andrew.russel");
    }
}