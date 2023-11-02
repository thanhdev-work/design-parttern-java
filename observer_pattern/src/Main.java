

public class Main {
    public static void main(String[] args) {
        // create the subject
        DummyRequest request = new DummyRequest();
        // create observers and register them
        Observer loggerRequest = new DummyLogger(request);
        request.register(loggerRequest);
        request.setRequest("req");

        DummyResponse response = new DummyResponse();
        Observer loggerResponse = new DummyLogger(response);
        response.register(loggerResponse);
        response.setResponse("res");

        request.setRequest("req");
    }
}