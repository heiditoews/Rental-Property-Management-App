/**Observer.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 * 
 */

package Model;

public interface Observer {
    /**
     * Update Function
     * @param newProperty Property parameter that will be updated 
     */
    public void update(Property newProperty);
}
