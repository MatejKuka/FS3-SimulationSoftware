import BE.Student;
import BE.User;
import BLL.exeptions.UserException;
import BLL.facadeBLL.FacadeBLL;
import DAL.UserDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestBLL {

    @Test
    void testingCreateMethodsUser() throws IOException, UserException {
        UserDAO database = new UserDAO();

        User userTest1 = new Student(34, "Matej", "Kuka", "mt", "kuka", 3);

        Assertions.assertEquals(userTest1, database.createStudent("Matej", "Kuka", "mt", "kuka"));
    }

    @Test
    void testingCompareLoginsCorrect() throws IOException, UserException {
        UserDAO database = new UserDAO();
        User user1 = database.createStudent("Matej", "Kuka", "mt789", "kuka456");
        User user2 = database.compareLogins("mt789", "kuka456");
        Assertions.assertEquals(user1, user2);
    }

    @Test
    void testingCompareLoginsIncorrect() throws IOException, UserException {
        UserDAO database = new UserDAO();
        User user1 = database.createStudent("Matej", "Kuka", "mt789", "kuka456");
        User user2 = database.compareLogins("kuka456", "mt789");
        Assertions.assertNotEquals(user1, user2);
    }
}
