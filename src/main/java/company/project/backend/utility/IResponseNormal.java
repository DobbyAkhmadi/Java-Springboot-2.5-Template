package company.project.backend.utility;

import company.project.backend.Employee.Domain.Employee;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IResponseNormal {
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static Object requestStatus(String message,
                                      HttpStatus status,
                                      Employee responseObj) {
        Timestamp s = new Timestamp(System.currentTimeMillis());
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        map.put("message", message);
        map.put("statusResponse", String.valueOf(status.value()));
        map.put("data", responseObj);
        map.put("timestamp", sdf3.format(s));
        list.add(map);
        Map[] maps = list.toArray(new HashMap[list.size()]);
        return List.of(maps);
    }

}