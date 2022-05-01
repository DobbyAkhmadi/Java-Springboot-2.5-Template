package company.project.backend.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", String.valueOf(status.value()));
        map.put("data", responseObj);

        return new ResponseEntity<Object>(map,status);
    }
    public static ResponseEntity<Object> requestStatus(Object requestObj)
    {
        String tes=requestObj.toString();
        if (tes.equals("[]"))
        {
            return ResponseHandler.generateResponse("request failed !", HttpStatus.NOT_FOUND,tes);
        }
        else
        {
            return ResponseHandler.generateResponse("request successfully !", HttpStatus.OK, requestObj);
        }

    }

}