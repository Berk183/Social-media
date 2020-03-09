import java.util.*;
public class UserPanel {

    public static void main(String[] args){
        ArrayList<User> users = new ArrayList<User>();
        User userHandler;
        Message messageHandler;
        Post postHandler;
        Administrator adminHandler;
        String name;
        String email;
        String place;
        String birthDay;
        String birthDayYear;
        Scanner s1= new Scanner(System.in);
        Scanner s2=new Scanner(System.in);
        System.out.println("Please enter your choice\nPress -1 to create new user or press -2 to exit or press -3 to choose a user that already exists\n:");
        int x=s1.nextInt();
        
           while(x!=-2){
               if(x==-1||x==-3){
               while(x==-1){
                   
                   System.out.println("Enter your full name:");
                   name=s2.nextLine();
                   System.out.println("Enter your email:");
                   email=s2.nextLine();
                   System.out.println("Enter your birthday(just day and month f.e:11-4):");
                   birthDay=s2.nextLine();
                   System.out.println("Enter your birthday(just year f.e:1999)");
                   birthDayYear=s2.nextLine();
                   System.out.println("Enter your place of residence:");
                   place=s2.nextLine();
                   
                   userHandler= new User(name,email,birthDay,birthDayYear,place);
                   users.add(userHandler);
                   System.out.println("Your account is created succesfully!\n");
                   System.out.println("Please enter your choice\nPress -1 to create new user or press -2 to exit\npress -3 to choose a user that already exists\n:");
                   x=s1.nextInt();
               }
               
               while(x==-3){
               if(users.size()>0){
                   System.out.println("\n------Main Menu------\n");
                   System.out.println("Choose a user");
                   for(int i=0;i<users.size();i++){
                       System.out.println(i+"."+users.get(i).getName());
                   }
                   int index=s1.nextInt();
                   if(index>users.size()-1||index<0){
                       System.out.println("!!!You have entered invalid number please enter again!!!");
                       break;
                   }
                   System.out.println("Choose a operation which you want\n1.Show Inbox\n2.Show Outbox\n3.Send Message\n4.Share Post\n5.Show Timeline\n6.Show Contact List\n7.Show Notifications\n8.Follow People\n9.Back");
                   adminHandler= new Administrator(users.get(index));
                   adminHandler.celebrate();
                   for(int i=0;i<users.size();i++){
                        for(int index1=0;index1<users.get(index).followedSize();index1++){
                            for(int index2=0;index2<users.get(i).followedSize();index2++){
                            if(users.get(index).listFollowedUser(index1).equals(users.get(i).getName())&&users.get(i).listFollowedUser(index2).equals(users.get(index).getName()))
                            {   if(adminHandler.getDate().equals(users.get(index).getDateOfBirth())){
                                users.get(i).addNotification("Today is "+users.get(index).getName()+"'s birthday let's celebrate it");
                            }
                            }
                            }
                        }
                        }
                   int choice=s1.nextInt();
                   System.out.println("Your choice:"+choice);
                   if(choice==1){
                       users.get(index).listInMessageBox();
                   }
                   if(choice==2){
                       users.get(index).listOutMessageBox();
                   }
                   if(choice==3){
                       System.out.println("Select the receiver or press -1 to back");
                       for(int i=0;i<users.size();i++){
                       System.out.println(i+"."+users.get(i).getName());
                   }
                       int receiver=s1.nextInt();
                        if(receiver>users.size()&&receiver<-1){
                            System.out.println("!!!You have entered invalid number please enter again!!!");
                            break;
                        }
                       if(receiver==-1){
                           break;
                       }
                       System.out.println("Enter your message:");
                       String message=s2.nextLine();
                       messageHandler= new Message(users.get(index),users.get(receiver),message);
                       messageHandler.sendMessage();
                               
                   }
                   if(choice==4){
                       System.out.println("Enter whose post you want to share or -1 to back");
                        for(int i=0;i<users.size();i++){
                       System.out.println(i+"."+users.get(i).getName());
                   }
                        int postOwner=s1.nextInt();
                        if(postOwner>users.size()||postOwner<-1){
                            System.out.println("!!!You have entered invalid number please enter again!!!");
                            break;
                        }
                        if(postOwner==-1){
                            break;
                        }
                       if(users.get(postOwner)==users.get(index)){
                       System.out.println("Enter post content");
                       String postContent=s2.nextLine();
                       postHandler=new Post(users.get(index),postContent);
                       users.get(index).addPost(postHandler);
                        }
                       else{
                           System.out.println("Enter the post number or -1 to back:");
                           for(int i=0;i<users.get(postOwner).postSize();i++){
                                System.out.println(i+".");
                                users.get(postOwner).listPosts(i).showPost();
                               }
                           
                           int postNumber=s1.nextInt();
                           if(postNumber>users.size()||postNumber<-1){
                            System.out.println("!!!You have entered invalid number please enter again!!!");
                            break;
                        }
                           if(postNumber==-1){
                               break;
                           }
                           users.get(index).sharePost(users.get(postOwner),postNumber);
                           users.get(postOwner).addNotification(users.get(index).getName()+" has shared a post of yours");
                          
                       }  
                   }
                   if(choice==5){
                       System.out.println("Enter whose timeline you want to see or -1 to back");   
                        for(int i=0;i<users.size();i++){
                       System.out.println(i+"."+users.get(i).getName());
                   }
                        int timeLine=s1.nextInt();
                        if(timeLine>users.size()||timeLine<-1){
                            System.out.println("!!!You have entered invalid number please enter again!!!");
                            break; 
                        }
                        if(timeLine==-1){
                            break;
                        }
                        users.get(timeLine).showTimeline();
                        if(users.get(timeLine).postSize()>0){
                        System.out.println("Enter 1 to see details or press any other number to continue");
                        int detail=s1.nextInt();
                        if(detail==1){
                        System.out.println("Enter a post number to see details");
                        int post=s1.nextInt();
                                
                        users.get(timeLine).listPosts(post).showPost();
                        System.out.println("Press 1 to like it or press 2 to go back");
                        int like=s1.nextInt();
                        if(like!=2){
                            if(like==1){
                                users.get(timeLine).listPosts(post).addLike(users.get(index).getName());                 
                            }
                            else{
                                System.out.println("!!!Please enter 1 or 2!!!");
                            }
                        }
                        }
                        }
                        if(users.get(timeLine).postSize()==0){
                            System.out.println("No posts");
                        }
                        
                   }
                   if(choice==6){
                       System.out.println("Contact List : ");
                       for(int i=0;i<users.size();i++){
                        for(int index1=0;index1<users.get(index).followedSize();index1++){
                            for(int index2=0;index2<users.get(i).followedSize();index2++){
                            if(users.get(index).listFollowedUser(index1).equals(users.get(i).getName())&&users.get(i).listFollowedUser(index2).equals(users.get(index).getName()))
                            {
                                System.out.println(users.get(i).getName());
                            }
                            }
                        }
                        }
                       }
                   if(choice==7){
                        System.out.println("Nofications: ");
                        if(users.get(index).getNotificationBoxSize()>0){
                        for(int i=0;i<users.get(index).getNotificationBoxSize();i++){
                            users.get(index).getNotification(i);
                        }
                        }
                        else{
                            System.out.println("No notifications");
                        }
                   }
                   if(choice==8){
                       System.out.println("Enter a number to follow or -1 to back");
                        for(int i=0;i<users.size();i++){
                       System.out.println(i+"."+users.get(i).getName());
                   }
                        int follow=s1.nextInt();
                        if(follow>users.size()||follow<-1){
                            System.out.println("!!!You have entered invalid number please enter again!!!");
                            break;
                        }
                        if(follow==-1){
                            break;
                        }
                        if(follow==index){
                            System.out.println("!!!You can not follow yourself!!!");
                            break;
                        }
                        users.get(index).follow(users.get(follow));
                        users.get(follow).addNotification(users.get(index).getName()+" has followed you");
                   }
                   if(choice==9){
                       System.out.println("Please enter your choice\nPress -1 to create new user or press -2 to exit or press -3 to choose a user that already exists or \nany other number to back to main menu\n: ");
                       int y=s1.nextInt();
                       if(y==-1 || y==-2 || y==-3 ){
                           x=y;
                       }
                       break;
                   }
                   
                               
                   
                           }
               
               else{
                   System.out.println("There is no user");
                   System.out.println("Please enter your choice\nPress -1 to create new user or press -2 to exit or press -3 to choose a user that already exists\n:");
                   x=s1.nextInt();
                    break;
               }
                
             }
               }
               else{
                   System.out.println("You have entered invalid number");
                   x=s1.nextInt();
                   }
           }
          
    }
    
}
