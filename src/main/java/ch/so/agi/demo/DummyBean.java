package ch.so.agi.demo;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("dummy")
public class DummyBean {

    public String getText() {
        return "Hello from Spring: " + LocalDateTime.now();
    }
}
