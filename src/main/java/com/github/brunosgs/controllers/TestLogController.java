package com.github.brunosgs.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {
    private final Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("test")
    public String testeLog() {
        logger.debug("This is and DEBUG log");
        logger.info("This is and INFO log");
        logger.warn("This is and WARN log");
        logger.error("This is and ERROR log");

        return "Logs generated successfully!";
    }
}
