package how.to.jacoco;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountController {

    private static int counter = 0;
    @GetMapping
    public int current() {
        return counter;
    }

    @PutMapping("/increase")
    public int increase() {
        return ++counter;
    }

    @PutMapping("/decrease")
    public int decrease() {
        return --counter;
    }
}
