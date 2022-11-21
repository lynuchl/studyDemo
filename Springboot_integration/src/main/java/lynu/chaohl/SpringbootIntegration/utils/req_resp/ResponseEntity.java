package lynu.chaohl.SpringbootIntegration.utils.req_resp;

import lombok.Data;

/**
 * 后端响应接口请求的数据结构
 * @param <T>
 */
@Data
public  class  ResponseEntity<T> {

    private int respCode;

    private String respMsg;

    private T data;

    public static ResponseEntity getResponse(int respCode,String respMsg){
        return new ResponseEntity(respCode,respMsg,null);
    }

    public static <T> ResponseEntity getResponse(int respCode,String respMsg,T data){
        return new ResponseEntity(respCode,respMsg,data);
    }

    public ResponseEntity(int respCode,String respMsg,T data){
        this.respCode=respCode;
        this.respMsg=respMsg;
        this.data=data;
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "respCode=" + respCode +
                ", respMsg='" + respMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
