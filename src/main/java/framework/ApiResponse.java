package framework;

/**
 * Simple generic response wrapper to simulate HTTP API responses.
 */
public class ApiResponse<T> {
    private final int statusCode; // e.g. 200, 201, 404, 400
    private final T body;
    private final String message;

    public ApiResponse(int statusCode, T body, String message) {
        this.statusCode = statusCode;
        this.body = body;
        this.message = message;
    }

    public int getStatusCode() { return statusCode; }
    public T getBody() { return body; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "statusCode=" + statusCode +
                ", body=" + body +
                ", message='" + message + '\'' +
                '}';
    }
}