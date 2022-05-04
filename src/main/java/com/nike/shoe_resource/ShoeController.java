package com.nike.shoe_resource;


import com.nike.v1_0.shoe_resource.ShoeHandler;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@AllArgsConstructor
public class ShoeController {

    private ShoeHandler shoeHandler;


   @GetMapping(value = "/shoe/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoeResponse showcase(
            @RequestHeader(name = "X-Version", defaultValue = "1.0") String version,
            @PathVariable("keyword") String model) {

        return shoeHandler.handle(ShoeRequest.builder().model(StringUtils.defaultString(model, "")).build());
    }
}
