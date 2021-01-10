package com.test.sampleapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
@CrossOrigin
public class SampleController {

    @GetMapping
    public ResponseEntity<ListItem> list() {
        ListItem listItem = new ListItem(1, "test");
        return new ResponseEntity<>(listItem, HttpStatus.OK);
    }
}
