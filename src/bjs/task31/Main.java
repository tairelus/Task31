package bjs.task31;

public class Main {

    public static void main(String[] args) {
        ComputersStore computersStore = new ComputersStore();
        ComputersStoreLoader storeLoader = new ComputersStoreLoader(computersStore);
        storeLoader.parse("computerStore.xml");

        System.out.print(computersStore);
    }
}

/*
Catalogs in the computer store:
Catalog id = 1
	Title           Type            Amount
	Computer1       Desktop         10
	Computer2       Laptop          20
	Computer3       Tablet          30
 */
