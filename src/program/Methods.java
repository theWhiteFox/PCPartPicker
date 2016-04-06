/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gints Gavars
 */
public class Methods {
//----------------------------------------------------------------------------------------------------------
    //returns a set of data from the sql Server
    public ResultSet displayAllProducts(){
       SQLdao dao = new SQLdao();

        return dao.displayAllProducts();
       
   }
//----------------------------------------------------------------------------------------------------------
//returns checkbox to be added to panel
    static int y = 50;
    static int x = 50;
    public JCheckBox returnCheckBox(){
        JCheckBox checkBox = new JCheckBox("Testing");
        checkBox.setSelected(true);
        checkBox.setBounds(x, y, 130, 35);
        y += 50;
        return checkBox;
    }
//----------------------------------------------------------------------------------------------------------
    //returns spinner to be added to panel
    public JSpinner returnSpinner(){
        //setting spinner values---> starting value / min value / max value / increment value
        SpinnerModel sm = new SpinnerNumberModel(1, 1, 99, 1);
        JSpinner spinner = new JSpinner(sm);
        spinner.setEditor(new JSpinner.DefaultEditor(spinner));
        //value = (int)spinner.getValue();
        spinner.setBounds(x + 220, y - 49, 50, 30);
        return spinner;
    }  
//----------------------------------------------------------------------------------------------------------    

    
    public String search(String strSearch) {
        
        SQLdao dao = new SQLdao();
        dao.search(strSearch);
        
            return strSearch;
    }
//----------------------------------------------------------------------------------------------------------
    //Adds new
    public ArrayList order(ArrayList<String> orderList) {
        orderList.add("Lots of stuff!");
        return orderList;
    }
//----------------------------------------------------------------------------------------------------------    
    //Converts the result set into a suitable type for the JTable
    public DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
    Vector<String> columnNames = new Vector<>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

        // data of the table
    Vector<Vector<Object>> data = new Vector<>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }
//----------------------------------------------------------------------------------------------------------
    return new DefaultTableModel(data, columnNames);

}
     
}
