package socialmedia;

public class ApiResponse<T> {
    private final T data;
    private final boolean sucesso;
    private final String mensagemErro;

    private ApiResponse(T data, boolean sucesso, String mensagemErro) {
        this.data = data;
        this.sucesso = sucesso;
        this.mensagemErro = mensagemErro;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data, true, null);
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(null, false, message);
    }

    public T getData() { return data; }
    public boolean isSucesso() { return sucesso; }
    public String getMensagemErro() { return mensagemErro; }
}