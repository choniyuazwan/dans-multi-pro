package id.choniyuazwan.onion.infrastructure.rest.dto;

public class CommonResponse<T> {
    private String code;
    private String message;
    private T data;

    public CommonResponse(){
        this.code = "00";
        this.message = "Success";
    }

    public String getCode() {
        return code;
    }

    public CommonResponse<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CommonResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public CommonResponse<T> setData(T data) {
        this.data = data;
        return this;
    }
}
