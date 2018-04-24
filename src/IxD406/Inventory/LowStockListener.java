package IxD406.Inventory;

//Observer pattern - this interface is used in the Inventory class
public interface LowStockListener{
    void lowStock (String articleName, int count);
}