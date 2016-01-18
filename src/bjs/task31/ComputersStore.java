package bjs.task31;

import java.util.HashMap;

/**
 * Created by U-1 on 17.01.2016.
 */
public class ComputersStore {
    /**Collection of the catalogs*/
    private HashMap<Integer, ComputersCatalog> computerCatalogs;

    public ComputersStore() {
        this.computerCatalogs = new HashMap<Integer, ComputersCatalog>();
    }

    @Override
    public String toString() {
        String result = "\nCatalogs in the computer store:\n";

        for (HashMap.Entry<Integer, ComputersCatalog> entry : computerCatalogs.entrySet()) {
            result += entry.getValue();
        }

        return result;
    }

    public ComputersCatalog getCatalog(int catalogId) {
        return computerCatalogs.get(catalogId);
    }

    public void setCatalog(ComputersCatalog catalog) {
        this.computerCatalogs.put(catalog.getId(), catalog);
    }
}
