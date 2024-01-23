import java.util.*;
public interface ListDetails{
    String ListDetails();
}

class Customer implements ListDetails{
    private int customer_id;
    private String customer_name;
    private String username;
    private String password;

    public Customer(int customer_id, String customer_name, String username, String password) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.username = username;
        this.password = password;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_Name() {
        return customer_name;
    }

    public void setCustomer_Name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean Login(ArrayList<Customer> customers, String username, String password) {
        for (Customer i : customers) {
            if (i.getUsername().equals(username) && i.getPassword().equals(password)) {
                System.out.println("Login Successful");
                System.out.println("Welcome " + i.customer_name);
                return true;}
        }
        System.out.println("Invalid username and password");
        return false;

    }

    public String ListDetails(){
        return "Customer id: "+customer_id+"\nCustomer Name: "+customer_name;
    }
}

class Product implements ListDetails {
    private int product_id;
    private String product_name;
    private double product_price;
    private int product_quantity;

    public Product(int product_id, String product_name, double product_price,int product_quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity=product_quantity;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }
    public int getProduct_quantity(){
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity){
        this.product_quantity=product_quantity;
    }

    public static void addProduct(ArrayList<Product> products,int product_id,String product_name,double product_price,int product_quantity){
        for (Product i:products){
            if (i.getProduct_id()==product_id){
                i.setProduct_quantity(i.getProduct_quantity()+product_quantity);

            }

        }
        products.add(new Product(product_id,product_name,product_price,product_quantity));

    }


    public static void removeProduct(ArrayList<Product> products,int product_id,int product_quantity){
        Iterator<Product> i=products.iterator();
        while (i.hasNext()) {
            Product p = i.next();
            if (p.getProduct_id() == product_id) {
                if (p.getProduct_quantity() >= product_quantity) {
                    p.setProduct_quantity(p.getProduct_quantity() - product_quantity);
                    if (p.getProduct_quantity() == 0) {
                        i.remove();
                    }
                }
                else{
                    System.out.println("Invalid quantity");
                }
            }
            else{
                System.out.println("Product not found");
            }
        }

    }

    public String ListDetails(){
        return "Product_id: "+product_id+"\nproduct_name: "+product_name+"\nproduct_price: "+product_price+"\nAvailable quantity: "+product_quantity;
    }




}

class Order implements ListDetails {
    private int order_id;
    private Date order_date;
    private Customer customer;
    private Product product;
    private double amount;
    private int quantity;

    public Order(int order_id, Date order_date, Customer customer, Product product, double amount, int quantity) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.quantity = quantity;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String ListDetails(){
        return "order id: "+order_id+"\nordered date: "+order_date+"\ncustomer name: "+customer.getCustomer_Name()+"\nproduct name: "+product.getProduct_name()+"\norder quantity: "+quantity+"\norder amount: "+amount;


    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers=new ArrayList<Customer>();
        Scanner scan=new Scanner(System.in);
        Customer customer1=new Customer(1,"Logeshwaran","logesh@gmail.com","Logesh@123");
        Customer customer2=new Customer(2,"SasiKumar","sasi@gmail.com","Sasi@123");
        customers.add(customer1);
        customers.add(customer2);
        ArrayList<Product> products=new ArrayList<Product>();
        ArrayList<Order> orders=new ArrayList<Order>();
        boolean loggedIn=false;
        while(true){
            System.out.println("1.Login");
            System.out.println("2.Exit");
            System.out.print("Choose the option:");
            int choose=scan.nextInt();
            switch(choose) {
                case 1:
                    System.out.print("Enter the username: ");
                    scan.nextLine();
                    String username = scan.nextLine();
                    System.out.print("Enter the password: ");
                    String password = scan.nextLine();
                    loggedIn = Customer.Login(customers, username, password);
                    while (loggedIn) {
                        System.out.println("1.List the customers");
                        System.out.println("2.List the products");
                        System.out.println("3.Add the product");
                        System.out.println("4.Remove the product");
                        System.out.println("5.Order the product");
                        System.out.println("6.History");
                        System.out.println("7.Logout");
                        System.out.print("Choose the option:");
                        int choice = scan.nextInt();
                        switch (choice) {
                            case 1:
                                for (Customer i : customers) {
                                    System.out.println(i.ListDetails());
                                }
                                break;
                            case 2:
                                for (Product i : products) {
                                    System.out.println(i.ListDetails());
                                }
                                break;
                            case 3:
                                System.out.print("Enter the product name: ");
                                scan.nextLine();
                                String product_name = scan.nextLine();
                                System.out.print("Enter the product price: ");
                                double product_price = scan.nextDouble();
                                System.out.print("Enter the product quantity: ");
                                int product_quantity = scan.nextInt();
                                Product.addProduct(products, products.size() + 1, product_name, product_price, product_quantity);
                                System.out.println("Product added successfully");
                                break;
                            case 4:
                                System.out.print("Enter the product id: ");
                                int product_id = scan.nextInt();
                                System.out.print("Enter the product quantity: ");
                                int productQuantity = scan.nextInt();
                                Product.removeProduct(products, product_id, productQuantity);
                                System.out.println("Product removed successfully");
                                break;
                            case 5:
                                System.out.print("Enter the product_id:");
                                int productId = scan.nextInt();
                                System.out.print("Enter the customer_id:");
                                int customer_id = scan.nextInt();
                                System.out.print("Enter the quantity:");
                                int product_Quantity = scan.nextInt();

                                Customer selectedCustomer = null;
                                for (Customer i : customers) {
                                    if (i.getCustomer_id() == customer_id) {
                                        selectedCustomer = i;
                                        break;
                                    }
                                }

                                Product selectedProduct = null;
                                for (Product i : products) {
                                    if (i.getProduct_id() == productId) {
                                        selectedProduct = i;
                                        break;
                                    }
                                }

                                double TotalAmount = selectedProduct.getProduct_price() * product_Quantity;
                                Order order1 = new Order(orders.size() + 1, new Date(), selectedCustomer, selectedProduct, TotalAmount, product_Quantity);
                                orders.add(order1);
                                System.out.println("Ordered successfull.You paid price amount of Rs " + TotalAmount);
                                System.out.println("Thank you " + selectedCustomer.getCustomer_Name());
                                break;

                            case 6:
                                System.out.println("History");
                                for (Order i : orders) {
                                    System.out.println(i.ListDetails());
                                }
                                break;
                            case 7:
                                System.out.println("Logging out...");
                                loggedIn = false;
                                break;
                            default:
                                System.out.println("Invalid option. Please choose a valid option.");
                                break;

                        }


                    }
                    break;


                case 2:
                    System.out.println("Exiting...............");
                    System.exit(0);
            }


            }
        }

    }

