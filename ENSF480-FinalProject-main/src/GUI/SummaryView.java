/**SummaryView.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 *
 */

package GUI;

import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class SummaryView{

    /**
     * Function that opens the sFrame window to display a Summary table for the property rental information
     * @param table JTable object which lists all of the information in a table format
     * @param numListed String parameter which represents the number of properties listed in the current period
     * @param numRented String parameter which represents the number of properties rented in the current period
     * @param numActive String parameter which represents the number of active listings
     */
    public void showSummary(JTable table, String numListed, String numRented, String numActive){
        JFrame sFrame = new JFrame("Summary");
        JPanel sPanel = new JPanel();

        JLabel listedLabel = new JLabel("Number of properties listed in the current period: " + numListed);
        JLabel rentedLabel = new JLabel("Number of properties rented in the current period: " + numRented);
        JLabel activeLabel = new JLabel("Number of active listings: " + numActive);

        JScrollPane sPane = new JScrollPane(table);
        sPane.setPreferredSize(new Dimension(900, 500));
        
        sPanel.add(listedLabel);
        sPanel.add(rentedLabel);
        sPanel.add(activeLabel);
        
        sPanel.add(sPane);

        sFrame.setContentPane(sPanel);
        sFrame.setSize(1000, 800);
        sFrame.setVisible(true);

    }

    JTextField rangeField = new JTextField(30);

    JButton submit = new JButton("Submit Request");

    /**
     * Requests a range for the period of the report
     */
    public void requestSummary(){
        JFrame rFrame = new JFrame("Summary Request");
        JPanel rPanel = new JPanel();

        JLabel rangeLabel = new JLabel("Enter the number of days the report should cover.");

        rPanel.add(rangeLabel);
        rPanel.add(rangeField);
        rPanel.add(submit);

        rFrame.setContentPane(rPanel);
        rFrame.setSize(500, 500);
        rFrame.setVisible(true);
    }

    public void addSubmitListener(ActionListener al){
        submit.addActionListener(al);
    }

    /**
     * Returns the range put in rangeField
     * @return
     */
    public int getRange(){
        try{
            return Integer.parseInt(rangeField.getText());
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Invalid input");
        }
        return -1;
    }

}
