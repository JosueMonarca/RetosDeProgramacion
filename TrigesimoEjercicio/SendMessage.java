public class SendMessage {
    private final Notification NOTIFICATION;

    public SendMessage(Notification notification){
        this.NOTIFICATION = notification;
    }

    public void print(String message){
        NOTIFICATION.send(message);
    }

    public String getType (){
        return NOTIFICATION.getType();
    }
}
