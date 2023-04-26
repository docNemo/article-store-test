package ru.mai.articlestore.controller.stub;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mai.articlestore.dto.request.stub.StubRequest;
import ru.mai.articlestore.dto.response.stub.StubResponse;
import ru.mai.articlestore.service.stub.StubService;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class StubController {
    private final StubService stubService;

    @GetMapping("/get")
    public StubResponse helloGet(@RequestParam String name) {
        return stubService.helloForGet(name);
    }

    @GetMapping("/get/{name}")
    public StubResponse helloGetWithPathVariable(@PathVariable String name) {
        return stubService.helloForGet(name);
    }

    @PostMapping("/post")
    public StubResponse helloPost(@RequestBody StubRequest stubRequest) {
        return stubService.helloForPost(stubRequest);
    }
}
