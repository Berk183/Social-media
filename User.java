import java.util.*;

public class User {
   private String name;
   private String email;
   private String dateOfbirth;
   private ArrayList<String> notificationBox;
   private ArrayList<Post> postList;
   private ArrayList<String> listOfFavouritePost;
   private ArrayList<String> followedUserList;
   private String placeOfResidence;
   private ArrayList<String> incomingMessageBox;
   private ArrayList<String> outgoingMessageBox;
   private String dateOfBirthYear;
   
   public User(String name,String email,String dateOfbirth,String dateOfBirthYear,String placeOfResidence){
       notificationBox=new ArrayList<String>();
       postList=new ArrayList<Post>();
       listOfFavouritePost=new ArrayList<String>();
       followedUserList=new ArrayList<String>();
       incomingMessageBox=new ArrayList<String>();
       outgoingMessageBox=new ArrayList<String>();
       this.name=name;
       this.email=email;
       this.dateOfbirth=dateOfbirth;
       this.placeOfResidence=placeOfResidence;
       this.dateOfBirthYear=dateOfBirthYear;
       
       
        
   }
   public String getName(){
   return name;
   }
    public String getMail(){
   return email;
   }
    public String getDateOfBirth(){
        return dateOfbirth;
    }
     public String getPlace(){
   return placeOfResidence;
   }
   public void addNotification(String notification){
       notificationBox.add(notification);
   }
   
  
   public void getNotification(int index){
       System.out.println("-"+notificationBox.get(index));
       
   }
   public int getNotificationBoxSize(){
       return notificationBox.size();
   }
   public void addPost(Post whichPost){
       postList.add(whichPost);
       
   }
   public void sharePost(User user,int number){
       postList.add(user.listPosts(number));
   }
   public Post listPosts(int counter){
       return postList.get(counter);
   }
   public int postSize(){
       return postList.size();
   }
           
   public void addFavourite(String post){
       listOfFavouritePost.add(post);
   }
   public String listFavouritePost(int counter){
       return listOfFavouritePost.get(counter);
   }
   public void follow(User user){
       followedUserList.add(user.getName());
   }
   public String listFollowedUser(int counter){
       return followedUserList.get(counter);
   }  
   public int followedSize(){
       return followedUserList.size();
   }
   public void addInMessageBox(String message){
       incomingMessageBox.add(message);
   }
   public void listInMessageBox(){
       if(incomingMessageBox.size()>0){
       for(int counter=0;counter<incomingMessageBox.size();counter++){
           System.out.println(incomingMessageBox.get(counter));
       }
       }
       else{
           System.out.println("No message");
       }
   }
   public void addOutMessageBox(String message){
       outgoingMessageBox.add(message);
   }
   public void listOutMessageBox(){
       if(outgoingMessageBox.size()>0){
       for(int counter=0;counter<outgoingMessageBox.size();counter++){
           System.out.println(outgoingMessageBox.get(counter));
       }
       }
       else{
           System.out.println("No message");
       }
   }
   public void likePost(Post whichPost){
   whichPost.addLike(getName());
   addFavourite(whichPost.getPost());
   }
   public void showTimeline(){
        System.out.println("Name:"+name+" Email:"+email+" Birthday:"+dateOfbirth+"-"+dateOfBirthYear+" Place of Residence:"+placeOfResidence);               
       if(postList.size()>0){
           System.out.println("Posts \n");
        for(int i=0;i<postList.size();i++){
          System.out.println(i+"."+listPosts(i).getPost());
          System.out.println(listPosts(i).getLikeSize()+" People liked this post");
       }
       }
       else{
           System.out.println("User does not have any post");
       }
       if(followedUserList.size()>0){
       for(int i=0;i< followedUserList.size();i++){
            System.out.println("Following: \n"+listFollowedUser(i));
       }
       }
       else{
           System.out.println("User is not following anyone");
       }
       
   }
   

} 
