/**Message.java
 * @author Tyler Thain
 * @author Luis Sulbaran
 * @author Heidi Toews
 * @author Neeraj Sunil Kumar
 * 
 */
package Model;

import java.lang.String;

public class Message {
    private String senderEmail;
    private String recieverEmail;
    private String content;
    private int viewed;

    /**
     * Constructor method for class Message with 3 parameters
     * @param senderEmail String parameter representing the senderEmail
     * @param recieverEmail String parameter representing the receiverEmail
     * @param content String parameter representing the content of the message
     */
    public Message(String senderEmail, String recieverEmail, String content) {
        this.senderEmail = senderEmail;
        this.recieverEmail = recieverEmail;
        this.content = content;
        this.viewed = 0;
    }

    /**
    * Constructor method for class Message with 4 parameters
     * @param senderEmail String parameter representing the senderEmail
     * @param recieverEmail String parameter representing the receiverEmail
     * @param content String parameter representing the content of the message
     * @param viewed int parameter representing wether the message has been viewed or not
     */
    public Message(String senderEmail, String recieverEmail, String content, int viewed) {
        this.senderEmail = senderEmail;
        this.recieverEmail = recieverEmail;
        this.content = content;
        this.viewed = viewed;
    }

    /**
     * Getter method for the sender email
     * @return returns a string corresponding to the sender email
     */
    public String getSenderEmail() {
        return senderEmail;
    }

    /**
     * Getter method for the receiver email
     * @return returns a string corresponding to the receiver email
     */
    public String getRecieverEmail() {
        return recieverEmail;
    }   

    /**
     * Getter method for the content of the message
     * @return returns a string corresponding to the message content
     */
    public String getContent() {
        return content;
    }

    /**
     * Getter method for the viewed information
     * @return returns an integer representing wether the message has been viewed or not
     */
    public int getViewed() {
        return viewed;
    }
}
