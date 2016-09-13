package seedu.addressbook.data.tag;
import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.UniqueTagList.DuplicateTagException;

public class Tagging {
   private int status;
   private Person person;
   private UniqueTagList alltags;
   
   public Tagging(){
	   
   }
   
	public Tagging(int status, ReadOnlyPerson targetPerson, Tag tag) throws DuplicateTagException{
		this.status=status;
		if(targetPerson instanceof Person){
			person=(Person)targetPerson;
		}
		
		alltags.add(tag);
	}
	
	public int getStatus(){
		return status;
	}
	
	public String toString(){
		String action = (status==1) ? "+" : "-";
		String result = action + " " + person.getName().toString() + " ";
		for(Tag tag: alltags){
			result += tag.toString();
		}
		return result;
	}	
	
}
