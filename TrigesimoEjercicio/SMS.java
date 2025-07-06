public class SMS extends Notification {
    @Override
    public void send(String message){
        System.out.println("Message sent "+ message + " atte. SMS Service");
    }

    @Override
    public String getType(){
        return "SMS";
    }
}
