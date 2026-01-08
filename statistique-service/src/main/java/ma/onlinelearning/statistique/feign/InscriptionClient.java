package ma.onlinelearning.statistique.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INSCRIPTION-SERVICE")
public interface InscriptionClient {

    @GetMapping("/inscriptions/count/{courseId}")
    Long countByCourseId(@PathVariable("courseId") Long courseId);
}
