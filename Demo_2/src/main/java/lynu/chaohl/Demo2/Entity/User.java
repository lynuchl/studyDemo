package lynu.chaohl.Demo2.Entity;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class User {

    public int id;

    public String username;

    public String password;
}
