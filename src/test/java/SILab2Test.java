import mk.ukim.finki.SILab2;
import mk.ukim.finki.User;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SILab2Test {

    public final User user1 = new User("kiko",null,null);
    public final User user2 = new User(null,"hahahaha","kk@gmail");
    public final User user3 = new User("random","!!!special%poiseod8","kk@protonmail.com");
    public final User user4 = new User("random","1","kkgmail.com");
    public final User user5 = new User("random","1 1","nisto@gmail.com");

    public List<User> users = new ArrayList<>();
    @Test
    public void testBranch(){
        users.add(user1);
        //testing user1
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //testing user 2
        users.add(user2);
        assertFalse(SILab2.function(user2, users));

        //testing user3
        users.add(user3);
        assertFalse(SILab2.function(user3, users));

        //testing user4
        users.add(user4);
        assertFalse(SILab2.function(user4, users));

        //testing user5
        users.add(user5);
        assertFalse(SILab2.function(user5, users));
    }
    @Test
    public void multipleCondition(){
        //test TXX
        User user1 =  new User(null, null, null);
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //test FTX
        User user2 = new User("random", null, null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //test FFT
        User user3 = new User("random", "pass", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user3, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //test FFF
        User user4 = new User("random", "pass", "mail.com");
        assertFalse(SILab2.function(user4, users));
    }

}
