public class DummyLogger implements Observer {
    private Subject subject;

    public DummyLogger(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        if (subject instanceof DummyRequest) {
            System.out.println(((DummyRequest) subject).getRequest());
        }
        if (subject instanceof DummyResponse) {
            System.out.println("Reponse change");
        }
    }

}
