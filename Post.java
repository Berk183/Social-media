import java.text.SimpleDateFormat;
import java.util.*;
public class Post {
    private ArrayList<String> whoLiked;
    private String postContent;
    private User postOwner;
    private SimpleDateFormat dateFormat;
   private Date dateAndHour;
    
    public Post(User postOwner,String postContent){
        this.postOwner=postOwner;
        this.postContent=postContent;
        dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
       dateAndHour = new Date();
       whoLiked=new ArrayList<String>();
}
         public String getPost(){
         return (postContent+"("+"at "+dateFormat.format(dateAndHour)+")"+"by "+postOwner.getName());
         }
         public void addLike(String user){
         whoLiked.add(user);
         postOwner.addNotification(user+" has liked a post of yours");
         }
         public int getLikeSize(){
             return whoLiked.size();
             
                         
             
         }
         public void showPost(){
             System.out.println(getPost());
             if(whoLiked.size()>0){
                 System.out.println("\nLikes:");
             for(int index=0;index<whoLiked.size();index++){
                 System.out.println("\n"+whoLiked.get(index));
             }
             }
         }
         
}
