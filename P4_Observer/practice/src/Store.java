public class Store {
    private final NotificationService notificationService;

    public Store(){
        notificationService = new NotificationService();
    }

    public void newItemPromotion(){
        notificationService.notifyy("New item available!");
    }

    public NotificationService getService(){
        return notificationService;
    }
    
}
