package ui;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.List;


import db.CustomerDB;
import db.ProductDB;
import db.SaleOrderDB;
import model.Customer;
import model.Product;
import model.SaleOrder;
import model.Supplier;
import controller.CustomerCtrl;
import controller.ProductCtrl;
import controller.SaleOrderCtrl;
import controller.SupplierCtrl;

public class UserInterface {

	    static Scanner lectureClavier = new Scanner(System.in);
	    
	    public static void main(String[] args) {
	        
	        String quit = "no";
	        int userLog;
	        do {
	        GeneralSummary();
	        userLog = lectureClavier.nextInt();
	        switch (userLog) {
	            case 1:
	            	CustomerSummary();
					break;
	            case 2:
	            	ProductSummary();
	                break;
	            case 3:
	            	SupplierSummary();
	                break;
	            case 4:
	            	SaleOrderSummary();
	                break;
	            case 5:
	            	break;
	            case 6:
	            	break;
	            case 7 : 
	            	System.out.println("Do you really want to quit ? (yes/no)");
		            quit = lectureClavier.next();
	            default: 
	                System.out.println("Enter one of the options");
	                break;
	        	}
			}
			while (quit.equals("yes") == false);
	    }
	    
	static void GeneralSummary(){
	        System.out.println("Western style user interface");
	        System.out.println("1. Create, delete or update a customer \n" +
	        "2. Create, delete or update a product\n" +
	        "3. Create, delete or update a supplier \n" +
	        "4. Create or delete a sale order \n"+
	        "5. Show an invoice \n"+
	        "6. Change a price \n" +
	        "7. Quit");
	        System.out.println("Enter the number of the function you wish to access");       
	}
	
	static void CustomerSummary() {
		String Quit2 = "no";
        do {
        System.out.println("Customer interface");
        System.out.println("1. Create a customer \n" +
        "2. Delete a customer\n" +
        "3. Update a customer \n" +
        "4. Go back");
        System.out.println("Enter the number of the function you wish to access");
        int UserLog2 = lectureClavier.nextInt();
    	switch (UserLog2) {
    		case 1:
    			CreateCustomer();
    		break;
    		case 2 :
    			DeleteCustomer();
    		break;
    		case 3 :
    			UpdateCustomer();
        	break;
    		case 4 :
	            Quit2 = "yes";
        	break;
            default: 
            System.out.println("Enter one of the options");
            break;
        	}
    	}
		while(Quit2.equals("yes")==false);
	}
	
	static void ProductSummary() {
		String Quit2 = "no";
		do {
        System.out.println("Product interface");
        System.out.println("1. Create a product \n" +
        "2. Delete a product\n" +
        "3. Update a product \n" +
        "4. Go back");
        System.out.println("Enter the number of the function you wish to access");
        int UserLog2 = lectureClavier.nextInt();
    	switch (UserLog2) {
    		case 1:
    			CreateProduct();
    		break;
    		case 2 :
    			DeleteProduct();
    		break;
    		case 3 :
    			UpdateProduct();
        	break;
    		case 4 :
    			Quit2 = "yes";
        	break;
            default: 
            System.out.println("Enter one of the options");
            break;
    		}
		}
		while(Quit2.equals("yes")==false);
	}

	static void SaleOrderSummary() {
		String Quit2 = "no";
        do {
        System.out.println("Sale order interface");
        System.out.println("1. Create a sale order \n" +
        "2. Delete a sale order\n" +
        "3. Go back");
        System.out.println("Enter the number of the function you wish to access");
        int UserLog2 = lectureClavier.nextInt();
    	switch (UserLog2) {
    		case 1:
    			CreateSaleOrder();
    		break;
    		case 2 :
    			DeleteSaleOrder();
    		break;
    		case 3 :
                Quit2 = "yes";
        	break;
            default: 
            System.out.println("Enter one of the options");
            break;
        	}
    	}
		while(Quit2.equals("yes")==false);
	}
	
	static void SupplierSummary() {
		String Quit2 = "no";
        do {
        System.out.println("Supplier interface");
        System.out.println("1. Create a supplier \n" +
        "2. Delete a supplier\n" +
        "3. Update a supplier \n" +
        "4. Go back");
        System.out.println("Enter the number of the function you wish to access");
        int UserLog2 = lectureClavier.nextInt();
    	switch (UserLog2) {
    		case 1:
    			CreateSupplier();
    		break;
    		case 2 :
    			DeleteSupplier();
    		break;
    		case 3 :
    			UpdateSupplier();
        	break;
    		case 4 :
	            Quit2 = "yes";
        	break;
            default: 
            System.out.println("Enter one of the options");
            break;
        	}
    	}
		while(Quit2.equals("yes")==false);
	}
	
	static void CreateSaleOrder() {
		String stop = "yes";
		ProductCtrl ProControl = new ProductCtrl();
		float totalAmount =0;
		CustomerCtrl CusControl = new CustomerCtrl();
		Product CurrentPro = new Product(0, null, null, 0, 0, null); 
		Customer CurrentCus = new Customer(0, null, null, null, null, null, 0);
		List<Customer> CusList= null;
		List<Product> ProList = null;
        Date date = new Date(0);
        LocalDateTime currentDate =LocalDateTime.now();
		SaleOrderCtrl SOControl = new SaleOrderCtrl();
		
		SOControl.addSaleOrder(0, currentDate, totalAmount, stop, null, 1, 0);	
		do {
			System.out.println("What is the name of the product?");
			String name = lectureClavier.next();
			ProList= ProControl.findByName(name);
			CurrentPro = ProList.get(0);
			int ProId = CurrentPro.getId();
			System.out.println(ProId);
			float price = ProControl.getProductPrice(ProId);
			System.out.println("This is the price of the product : " + price);
			System.out.println("How many do you want?");
			int quantity = lectureClavier.nextInt();
			totalAmount = totalAmount +quantity * price;
			System.out.println("The total amount is : " + totalAmount);
			System.out.println("Do you want to add another product? (yes/no)");
			stop = lectureClavier.next();
		}while (stop.equals("no")==false);
		System.out.println("What is the name of the customer?");
		String name = lectureClavier.next();
		CusList= CusControl.findByName(name);
		CurrentCus = CusList.get(0);
		int CusId = CurrentPro.getId();
		System.out.println(CusId);
		System.out.println("What should be the delivery date?");
		String deliveryDate = lectureClavier.next();
	    Date date1= Date.valueOf(deliveryDate);  
	    int SOId = SOControl.getLastId();
	    System.out.println(currentDate);
	    SaleOrder CurrentSO = new SaleOrder(0, currentDate, totalAmount, "Not sent", date1, CusId, 1);
	    CurrentSO.setAmount(totalAmount);
	    System.out.println(totalAmount);
	    System.out.println(CurrentSO.getAmount());
		SOControl.updateSaleOrder(SOId,CurrentSO);
		
	}
	static void DeleteSaleOrder() {
		
	}
	
	
	
	
	static void CreateCustomer() {
		CustomerCtrl customerCtrl = new CustomerCtrl();
		Customer newCustomer = new Customer(0, null, null, null, null, null, 0);
		System.out.println("What is the first name of the customer ?");
		String fname = lectureClavier.next();
		newCustomer.setFname(fname);
		System.out.println("What is the last name of the customer ?");
		String lname = lectureClavier.next();
		newCustomer.setLname(lname);
		
		System.out.println("What is the email of the customer ?");
		String email = lectureClavier.next();
		newCustomer.setEmail(email);
		System.out.println("What is the address of the customer ?");
		String address = lectureClavier.next();
		newCustomer.setAddress(address);
		System.out.println("What is the phone number of the customer ?");
		String phoneno = lectureClavier.next();
		newCustomer.setPhoneNumber(phoneno);
		System.out.println("What is the city zipcode of the customer ?");
		int zipcode = lectureClavier.nextInt();
		newCustomer.setzipCode(zipcode);
		
		customerCtrl.addCustomer(0, fname, lname, email, address, phoneno, zipcode);
	 	
	}
	
	static void DeleteCustomer() {
		CustomerCtrl customerCtrl = new CustomerCtrl();
		System.out.println("What is the id of the customer you want to delete ?");
		int idDelete = lectureClavier.nextInt();
		
			if(customerCtrl.removeCustomer(idDelete)) {
				System.out.println("The customer with the Id : " + idDelete + " has been succesfully deleted");
			}
			
		
	}
	
	static void UpdateCustomer() {
		CustomerCtrl customerCtrl = new CustomerCtrl();
		Customer newCustomer = new Customer(0, null, null, null, null, null, 0);
		System.out.println("What is the id of the customer you want to update ?");
		int idUpdate = lectureClavier.nextInt();
		newCustomer.setId(idUpdate);
		System.out.println("What is the new first name of the customer ?");
		String fname = lectureClavier.next();
		newCustomer.setFname(fname);
		System.out.println("What is the new last name of the customer ?");
		String lname = lectureClavier.next();
		newCustomer.setLname(lname);
		System.out.println("What is the new email of the customer ?");
		String email = lectureClavier.next();
		newCustomer.setEmail(email);
		System.out.println("What is the new address of the customer ?");
		String address = lectureClavier.next();
		newCustomer.setAddress(address);
		System.out.println("What is the new phone number of the customer ?");
		String phoneno = lectureClavier.next();
		newCustomer.setPhoneNumber(phoneno);
		System.out.println("What is the new city zipcode of the customer ?");
		int zipcode = lectureClavier.nextInt();
		newCustomer.setzipCode(zipcode);
		
		if(customerCtrl.updateCustomer(idUpdate, newCustomer)) {
			System.out.println("The customer with the ID: "+ idUpdate + "has been successfully updated!");
		}
	}
	
	static void CreateProduct() {
		ProductCtrl productCtrl = new ProductCtrl();
		Product newProduct = new Product(0, null, null, 0, 0, null);
		System.out.println("What is the name of the product?");
		String name = lectureClavier.next();
		newProduct.setName(name);
		System.out.println("What is the country of origin of the product?");
		String originCountry = lectureClavier.next();
		newProduct.setCountryOfOrigin(originCountry);
		System.out.println("What is the current stock of the product?");
		int stock = lectureClavier.nextInt();
		newProduct.setStock(stock);
		System.out.println("What is the minimum stock of the product?");
		int minStock = lectureClavier.nextInt();
		newProduct.setMinStock(minStock);
		System.out.println("What is the type of the product?");
		String type = lectureClavier.next();
		newProduct.setProductType(type);

		productCtrl.addProduct(0, name, originCountry, stock, minStock, type);
		
	}
	
	static void DeleteProduct() {
		ProductCtrl productCtrl = new ProductCtrl();
		System.out.println("What is the id of the product you want to delete ?");
		int idDelete = lectureClavier.nextInt();
		
			if(productCtrl.removeProduct(idDelete)) 
				
			
			System.out.println("The customer with the Id : " + idDelete + " has been succesfully deleted");
	}
	
	static void UpdateProduct() {
		ProductDB CurrentProdDB = new ProductDB();
		Product newProduct = new Product(0, null, null, 0, 0, null);
		System.out.println("What is the id of the product you want to update ?");
		int idUpdate = lectureClavier.nextInt();
		newProduct.setId(idUpdate);
		System.out.println("What is the new name of the product?");
		String name = lectureClavier.next();
		newProduct.setName(name);
		System.out.println("What is the new country of origin of the product?");
		String originCountry = lectureClavier.next();
		newProduct.setCountryOfOrigin(originCountry);
		System.out.println("What is the new current stock of the product?");
		int stock = lectureClavier.nextInt();
		newProduct.setStock(stock);
		System.out.println("What is the new minimum stock of the product?");
		int minStock = lectureClavier.nextInt();
		newProduct.setMinStock(minStock);
		System.out.println("What is the new type of the product?");
		String type = lectureClavier.next();
		newProduct.setProductType(type);
		try {
			CurrentProdDB.create(newProduct);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	static void CreateSupplier() {
		SupplierCtrl supplierCtrl = new SupplierCtrl();
		Supplier newSupplier = new Supplier(0, null, null, null, null, null,0);
		System.out.println("What is the name of the Supplier ?");
		String name = lectureClavier.next();
		newSupplier.setName(name);
		System.out.println("What is the address of the Supplier ?");
		String address = lectureClavier.next();
		newSupplier.setAddress(address);
		System.out.println("What is the country of the Supplier ?");
		String country = lectureClavier.next();
		newSupplier.setCountry(country);
		System.out.println("What is the phone number of the Supplier ?");
		String phoneno = lectureClavier.next();
		newSupplier.setPhoneno(phoneno);
		System.out.println("What is the email of the Supplier ?");
		String email = lectureClavier.next();
		System.out.println("What is the city zipcode of the Supplier ?");
		int zipcode = lectureClavier.nextInt();
		newSupplier.setZipCode(zipcode);
		
		supplierCtrl.addSupplier(0, name, address, country, phoneno, email, zipcode);
	}
	static void DeleteSupplier() {
		SupplierCtrl supplierCtrl = new SupplierCtrl();
		System.out.println("What is the id of the supplier you want to delete ?");
		int idDelete = lectureClavier.nextInt();
		
			if(supplierCtrl.removeSupplier(idDelete)) {
				System.out.println("The Supplier with the Id : " + idDelete + " has been succesfully deleted");
			}
	}
	
	static void UpdateSupplier() {
		SupplierCtrl supplierCtrl = new SupplierCtrl();
		Supplier newSupplier = new Supplier(0, null, null, null, null, null,0);
		System.out.println("What is the id of the Supplier you want to update ?");
		int idUpdate = lectureClavier.nextInt();
		newSupplier.setId(idUpdate);
		System.out.println("What is the new name of the Supplier ?");
		String name = lectureClavier.next();
		newSupplier.setName(name);
		System.out.println("What is the new address of the Supplier ?");
		String address = lectureClavier.next();
		newSupplier.setAddress(address);
		System.out.println("What is the new country of the Supplier ?");
		String country = lectureClavier.next();
		newSupplier.setCountry(country);
		System.out.println("What is the new phone number of the Supplier ?");
		String phoneno = lectureClavier.next();
		newSupplier.setPhoneno(phoneno);
		System.out.println("What is the new email of the supplier ?");
		String email = lectureClavier.next();
		newSupplier.setEmail(email);
		
		if(supplierCtrl.updateSupplier(idUpdate, newSupplier)) {
			System.out.println("The Supplier with the ID: "+ idUpdate + "has been successfully updated!");
		}
	}
	
	}

