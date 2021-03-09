/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.compliantsystem.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author paul
 */
public class ComplaintDataTest {
    
    public ComplaintDataTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

   

   

    @Test
    public void testGetData() throws Exception {
        System.out.println("getData");
        ComplaintData instance = new ComplaintData();
        
        instance.updateData();
        
        Object[][] data = instance.getData();
        
        for (int i = 0; i < instance.getRowCount(); i++) {
            for ( int z = 0; z < instance.getColumnCount(); z++) {
                System.out.println(instance.getValueAt(i, z));
            }
        }
    }
    
}
