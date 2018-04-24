package IxD406.Payment.Model;

import IxD406.calendar.Model.Appointment;
import IxD406.Inventory.Product;
import java.util.List;

public class Invoice {

    public Appointment appointment;
    public List<Product> productList;

    public double getSum() {
        double sum = 0;

        for (Product item :
                productList) {
            //sum += item.getPrice(); //getPrice() does not exist yet, implement

        }
        return sum;
        
    }
}
