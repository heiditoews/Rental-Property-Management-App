/**SummaryController.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 */

package Controller;
import GUI.*;
import Model.*;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SummaryController{
    private SummaryView view;
    private Summary model;

    /**
     * Constructor, also displays the periodical summary for a manager. 
     * @param sView A SummaryView object 
     * @param sModel A Summary model object 
     */
    public SummaryController(SummaryView sView, Summary sModel){
        this.view = sView;
        this.model = sModel;

        this.view.requestSummary();
        this.view.addSubmitListener(new SubmitSummaryListener());
        
    }

    /**
     * On click, shows a periodic summary
     */
    class SubmitSummaryListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int range = view.getRange();
            if(range != -1){
                DbConnector dbCon = new DbConnector();
                dbCon.initializeConnection();
                ArrayList<Summary> summaryList = dbCon.getRentedHousesInPeriod(range);
                JTable table = model.summaryTable(summaryList);
                String numRented = String.valueOf(dbCon.getNumRentedInPeriod(range));
                String numActive = String.valueOf(dbCon.getNumActive());
                String numListed = String.valueOf(dbCon.getNumberListedInPeriod(range));
                view.showSummary(table, numListed, numRented, numActive);
            }
        }
        
    }
}