public class PUSH extends Notification {
    @Override
    public void send(String message){
        System.out.println("Message sent "+ message + " atte. PUSH Service");
    }

    @Override
    public String getType(){
        return "PUSH";
    }
}
