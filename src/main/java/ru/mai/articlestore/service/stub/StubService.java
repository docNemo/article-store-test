package ru.mai.articlestore.service.stub;

import ru.mai.articlestore.dto.request.stub.StubRequest;
import ru.mai.articlestore.dto.response.StubResponse;

public class StubService {
    public StubResponse hello(final String name) {
        return new StubResponse("Hello, %s".formatted(name));
    }

    public StubResponse helloForPost(final StubRequest stubRequest) {
        return new StubResponse("Hello, %s".formatted(stubRequest.getName()));
    }
}
