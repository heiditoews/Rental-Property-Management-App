package Model;

public class Listing {
    private int id;
    private String state;
    private int fee;
    private String expiryDate;
    private Property property;
    private String landlordName;

    public Listing(int id, String state, int fee, String expiryDate, Property property, String landlordName){
        this.setID(id);
        this.setState(state);
        this.setFee(fee);
        this.setExpiryDate(expiryDate);
        this.setProperty(property);
        this.setLandlordName(landlordName);
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getState(){
        return this.state;
    }

    public void setState(String state){
        this.state = state;
    }

    public int getFee(){
        return this.fee;
    }

    public void setFee(int fee){
        this.fee = fee;
    }

    public String getExpiryDate(){
        return this.expiryDate;
    }

    public void setExpiryDate(String expiryDate){
        this.expiryDate = expiryDate;
    }

    public Property getProperty(){
        return this.property;
    }

    public void setProperty(Property p){
        this.property = p;
    }

    public String getLandlordName(){
        return this.landlordName;
    }

    public void setLandlordName(String name){
        this.landlordName = name;
    }


}