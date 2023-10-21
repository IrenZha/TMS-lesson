package com.example.lesson46_2.config;

import com.example.lesson46_2.exc.UserNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
public class UserErrorDecoder implements ErrorDecoder {

    private final ObjectMapper mapper;
    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            InputStream stream = response.body().asInputStream();
            return mapper.readValue(stream, UserNotFoundException.class);

        } catch (IOException e) {
            return new UserNotFoundException(666_000, "unknown error");
        }

    }
}
