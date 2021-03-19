package test;
import db.*;
import model.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import db.DBConnection;

public class connectionTest{
    DBConnection con = null;
    private Product tempProduct;
   
    @Before
	public void setUp() {
		con = DBConnection.getInstance();
	}
    
	@Test
	public void wasConnected() {
		assertNotNull("Connected - connection cannot be null", con);
		
		DBConnection.closeConnection();
		boolean wasNullified = DBConnection.instanceIsNull();
		assertTrue("Disconnected - instance set to null", wasNullified);
		
		con = DBConnection.getInstance();
		assertNotNull("Connected - connection cannot be null", con);		
	}

    @Test
    public void insertion(){
        // Arrange
        tempProduct = new Product(1430, null, null, 89, 89, "test");
        ProductDB dpProduct = new ProductDB();
        Product test = new Product(0, null, null, 0, 0, null);
        //Act
        try {
			test = dpProduct.create(tempProduct);
		} catch (Exception e) {
		//Assert
		assert(test.getProductType()=="test");
   		}
    }
}
