public class DummyResponse extends Subject {
    private String response;

    public DummyResponse() {
        notifyObserver();
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
        notifyObserver();
    }
}
