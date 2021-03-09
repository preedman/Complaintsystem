/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reedmanit.compliantsystem.ui;

import com.reedmanit.casedomain.cases.Complaint;
import com.reedmanit.complaintsystem.integration.ServiceInterface;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author paul
 */
public class ComplaintData extends AbstractTableModel {
    
    private ServiceInterface serviceInterface;
    
    private Object data [] [];
    
    String columnNames[] = new String[] {    "Received On", "Source", "Reference", "Details", "Priority", "Status", "Closed On"  };
    
    Class types[] = new Class[] {     LocalDate.class, String.class, String.class, String.class,     String.class, String.class, LocalDate.class  };
    
    public ComplaintData() {
        try {
            updateData();
        } catch (Exception ex) {
            Logger.getLogger(ComplaintData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    
    @Override
    public String getColumnName(int col) {
      return columnNames[col];
    }
    
    public void updateData() throws Exception {
        
        serviceInterface = new ServiceInterface();
        
        List listOfCases = serviceInterface.getListOfCases();
        
        data = new Object[listOfCases.size()] [columnNames.length];
        
        int x = 0;
        
        for (int i=0; i < listOfCases.size(); i++) {
            
            Complaint c = (Complaint) listOfCases.get(i);
            
            data[x][0] = c.getReceivedOn();
            data[x][1] = c.getTheSource();
            data[x][2] = c.getReference();
            data[x][3] = c.getDetails();
            data[x][4] = c.getThePriority();
            data[x][5] = c.getTheStatus();
            data[x][6] = c.getClosedOn();
            
            x++;
            
        }
        fireTableDataChanged( );
        
    }
    
    public Object[][] getData() {
        return data;
    }
    
    
    
    
}
