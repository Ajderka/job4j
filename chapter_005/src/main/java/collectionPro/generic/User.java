package collectionPro.generic;

public class User extends Base {
    protected User(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return String.format("User{ %s }", getId());
    }
}
