package collectionPro.generic;


/**
 * @author Ayder Khayredinov (emage.haf@gmail.com).
 * @version 1.
 * @since 16.06.2019.
 */
public class User extends Base {
    protected User(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("User{ %s }", getId());
    }
}
