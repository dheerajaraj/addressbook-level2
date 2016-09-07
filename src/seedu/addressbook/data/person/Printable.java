package seedu.addressbook.data.person;

public interface Printable {
   Name getName();
   Phone getPhone();
   Email getEmail();
   Address getAddress();
   
   default String getPrintableString(Name name, Phone phone, Email email, Address address){
	   StringBuilder stringConcatenation = new StringBuilder();
	   stringConcatenation.append(name);
	   
	   if(!phone.isPrivate()){
		   stringConcatenation.append(" Phone Number: ").append(phone);
	   }
	   
	   if(!email.isPrivate()){
		   stringConcatenation.append(" Email Address: ").append(email);
	   }
	   
	   if(!address.isPrivate()){
		   stringConcatenation.append(" Address: ").append(address);
	   }
	   return stringConcatenation.toString();
   }
}
