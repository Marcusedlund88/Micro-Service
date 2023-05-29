package com.example.gatewaymicro.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouteValidator {


    public static final List<String> openEndpoints = List.of(
            "/authenticate",
            "/register"
    );

    public Predicate<ServerHttpRequest>  isSecure = request -> openEndpoints.stream().noneMatch(uri ->
            request.getURI().getPath().contains(uri));

}
