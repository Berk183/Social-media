import java.text.SimpleDateFormat;
import java.util.*;
public class Administrator {
   private SimpleDateFormat dateFormat;
   private Date date;
   private User user;
   public Administrator(User user){
       dateFormat = new SimpleDateFormat("dd-M"); 
       date = new Date();
       this.user=user;  
   }
    public String getDate(){
       return dateFormat.format(date);
   }
   public void celebrate(){
       if(getDate().equals(user.getDateOfBirth())){
           user.addNotification("!!!Happy Birthday!!!");
       }
   }
   
}
