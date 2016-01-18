package bjs.task31;

/**
 * Created by U-1 on 17.01.2016.
 */
public class ComputerType {
    private int id;

    private String title;
    private String typeName;
    private int amount;

    ComputerType (int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String result = String.format("\t%-16s%-16s%-16d\n", getTitle(), getType(), getAmount());
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return typeName;
    }

    public void setType(String type) {
        this.typeName = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
