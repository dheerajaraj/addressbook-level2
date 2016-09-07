package seedu.addressbook.data.person;

public class Contact {
    public String value;
    protected boolean isPrivate;
    
    public Contact(String contact, boolean isPrivate){
    	this.isPrivate=isPrivate;
    	contact=contact.trim();
    	this.value=contact;
    }
    
    public Contact (String contact){
    	contact=contact.trim();
    	this.value=contact;
    }
    
    public String toString() {
        return value;
    }
    
    public int hashCode() {
        return value.hashCode();
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }
    
}
