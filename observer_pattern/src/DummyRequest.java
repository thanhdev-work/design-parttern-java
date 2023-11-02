public class DummyRequest extends Subject {
    private String request;

    public DummyRequest() {
        notifyObserver();
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
        notifyObserver();
    }
}
