public class Email extends  Notification{
    @Override
    public void send(String message){
        System.out.println("Message sent "+ message + " atte. Email Service");
    }


    @Override
    public String getType(){
        return "Email";
    }
}
