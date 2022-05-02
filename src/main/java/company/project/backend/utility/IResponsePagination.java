package company.project.backend.utility;

import company.project.backend.Employee.Domain.Employee;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IResponsePagination {
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static List<Object> requestStatus(String message,
                                     HttpStatus status,
                                     List<Employee> responseObj,
                                     Integer PageNo, Integer PageSize, String SortBy) {
        Timestamp s = new Timestamp(System.currentTimeMillis());
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

            map.put("message", message);
            map.put("statusResponse", String.valueOf(status.value()));
            map.put("data", responseObj);
            map.put("timestamp", sdf3.format(s));
            map.put("pageNo", PageNo);
            map.put("pageSize", PageSize);
            map.put("sortBy", SortBy);
            list.add(map);
        Map[] maps = list.toArray(new HashMap[list.size()]);
        return List.of(maps);
    }

}
