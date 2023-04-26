package ru.mai.articlestore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mai.articlestore.dto.request.stub.StubRequest;
import ru.mai.articlestore.dto.response.StubResponse;
import ru.mai.articlestore.service.stub.StubService;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class StubController {
    private final StubService stubService;
    @GetMapping("/get")
    public StubResponse helloGet(@RequestParam String name) {
        return stubService.hello(name);
    }

    @GetMapping("/get/{name}")
    public StubResponse helloGetWithPathVariable(@PathVariable String name) {
        return stubService.hello(name);
    }

    @PostMapping("/post")
    public StubResponse helloPost(@RequestBody StubRequest stubRequest) {
        return stubService.helloForPost(stubRequest);
    }
}
