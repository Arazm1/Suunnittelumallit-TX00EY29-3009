public class Main {
    public static void main(String[] args) {
        
        Store store = new Store();

        store.getService().subscribe(new EmailMsgListener("a@mail.com"));
        store.getService().subscribe(new EmailMsgListener("b@mail.com"));

        store.newItemPromotion();
    }
    
}
