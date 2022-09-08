public class Categories {
    private int id;
    private  String name;
    private boolean expensive;

    public Categories(int id, String name, boolean expensive) {
        this.id = id;
        this.name = name;
        this.expensive = expensive;
    }

    public Categories() {
    }

    public boolean isExpensive() {
        return expensive;
    }

    public void setExpensive(boolean expensive) {
        this.expensive = expensive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
