
public class Message {
    private User sender;
    private User receiver;
    private String messageContent;
    
    public Message(User sender,User receiver, String messageContent){
        this.sender=sender;
        this.receiver=receiver;
        this.messageContent=messageContent;
    }
    public void sendMessage(){
        boolean condition=false;
        for(int index1=0;index1<sender.followedSize();index1++){
            for(int index2=0;index2<receiver.followedSize();index2++)
                if(sender.listFollowedUser(index1).equals(receiver.getName())&&receiver.listFollowedUser(index2).equals(sender.getName())){
                    receiver.addInMessageBox(messageContent+" from "+sender.getName());
                    sender.addOutMessageBox(messageContent+" to "+receiver.getName());
                    condition=true;
                    receiver.addNotification(sender.getName()+" has send you a message");
                    break;
                    
                }
                }
        if(condition==false){
                System.out.println("!!!Users are not following each other!!!");
        }         
        }
    
    public String showMessage(){
        return messageContent;
    }
}   
