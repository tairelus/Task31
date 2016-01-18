package bjs.task31;

import java.util.HashMap;

/**
 * Created by U-1 on 17.01.2016.
 */
public class ComputersCatalog {
    private int id;

    /**Collection of the computer types*/
    private HashMap<Integer, ComputerType> computerTypes;

    public ComputersCatalog(int id) {
        this.id = id;
        this.computerTypes = new HashMap<Integer, ComputerType>();
    }

    @Override
    public String toString() {
        String result = "Catalog id = " + getId() + "\n";
        result += String.format("\t%-16s%-16s%-16s\n", "Title", "Type", "Amount");

        for (HashMap.Entry<Integer, ComputerType> entry : computerTypes.entrySet()) {
            result += entry.getValue();
        }

        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ComputerType getComputerType(int typeId) {
        return computerTypes.get(typeId);
    }

    public void setComputerType(ComputerType computerType) {
        this.computerTypes.put(computerType.getId(), computerType);
    }
}
