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
        tempProduct = new Product(1430, null, null, 89, 89, null);
        ProductDB dpProduct = new ProductDB();
        //Act
        try {
			Product test = dpProduct.create(tempProduct);
		} catch (DatabaseLayerException e) {
    }

}