package smart.common.collection;


public class Data {

    private int id;

    private String data;

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public Data(final int id, final String data) {
        this.id = id;
        this.data = data;
    }

    @Override
    public String toString() {
        return "{ id = [" + id + "], data = [" + data + "] }";
    }
}
