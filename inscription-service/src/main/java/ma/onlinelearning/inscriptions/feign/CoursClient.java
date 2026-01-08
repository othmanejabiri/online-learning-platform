package ma.onlinelearning.inscriptions.feign;

import ma.onlinelearning.inscriptions.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "COURS-SERVICE")
public interface CoursClient {

    @GetMapping("/courses/{id}")
    CourseDTO getCourseById(@PathVariable("id") Long id);
}
