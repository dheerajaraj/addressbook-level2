package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address{

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses can be in any format";
    public static final String MESSAGE_BLOCK_CONSTRAINT = "Please enter a digit for the block number";
    public static final String MESSAGE_POSTAL_CONSTRAINT = "Please enter a valid digit for the postal address";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";
    public final String value;
    private boolean isPrivate;
    
    private String[] splitAddress= new String[5];
    private Block block;
    private Street street;
    private Unit unit;
    private Postal postal;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = address;
        splitAddress=value.split(", ");
        block = new Block(splitAddress[0].substring(2));
        street = new Street(splitAddress[1]);
        unit = new Unit(splitAddress[2]);
        postal = new Postal(splitAddress[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }
    
    public Block getBlock(){
    	return block;
    }
    
    public Street getStreet(){
    	return street;
    }
    
    public Unit getUnit(){
    	return unit;
    }
    
    public Postal getPostal(){
    	return postal;
    }
    
    public boolean matchingBlock(Block block1){
       return block.getBlockName().equals(block1.getBlockName());
    }
    
    public boolean matchingStreet(Street street1){
        return street.getStreetName().equals(street1.getStreetName());
     }
    
    public boolean matchingUnit(Unit unit1){
        return unit.getUnitName().equals(unit1.getUnitName());
     }
    
    public boolean matchingPostal(Postal postal1){
    	return postal.getPostalDigit().equals(postal1.getPostalDigit());
    }
    
    public String getPrintableString(){
    	return "Address: "+toString();
    }

    @Override
    public boolean equals(Object other) {
        if(other instanceof Address){
        	Address otherAddress = (Address) other;
        	return matchingBlock(otherAddress.getBlock()) && matchingStreet(otherAddress.getStreet()) && matchingUnit(otherAddress.getUnit()) && matchingPostal(otherAddress.getPostal());
        }
        return false;
    }

    @Override
    public String toString() {
        return value;
    }
    
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    
    public class Block{
    	private String _blockName;
    	
    	    public Block(String blockName) throws IllegalValueException{
    	    	if(!isValidBlock(blockName))
    	    		throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINT);
    	    	_blockName=blockName;
    	    }
    	    
    	       private boolean isValidBlock (String blockName){
    	    	   int i;
    	    	   for(i=0;(i<blockName.length()) && Character.isDigit(blockName.charAt(i));i++);
    	    	   
    	    	      return (i==blockName.length());
    	    		   
    	       } 
                    public String getBlockName(){
                	return _blockName;
                    }
                    
    }
    
    public class Street{
    	private String streetName;
    	
    	    public Street(String streetName){
    	    	this.streetName=streetName;
    	    }
                public String getStreetName(){
                	return streetName;
                }
                
                
    }
    
    public class Unit{
    	private String unitName;
    	
    	    public Unit(String unitName){
    	    	this.unitName=unitName;
    	    }
                public String getUnitName(){
                	return unitName;
                }
               
    }
    
    public class Postal{
    	private String _postalDigit;
    	
    	    public Postal(String postalDigit) throws IllegalValueException{
    	    	if(!isValidPostalAddress(postalDigit)){
    	    		throw new IllegalValueException(MESSAGE_POSTAL_CONSTRAINT);
    	    	}
    	    	_postalDigit=postalDigit;
    	    }
    	    
    	    private boolean isValidPostalAddress(String postalDigit){
 	    	   int i;
 	    	   for(i=0;(i<postalDigit.length()) && Character.isDigit(postalDigit.charAt(i));i++);
 	    	      return (i==6);
 	       }
    	    
                public String getPostalDigit(){
                	return _postalDigit;
                }
               
    
    }
}