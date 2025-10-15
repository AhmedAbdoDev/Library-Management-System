public abstract class User {
    int id;
    String  name;
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public abstract void displayInfo();
    public int getId() { return id; }
    public String getName() { return name; }
}
