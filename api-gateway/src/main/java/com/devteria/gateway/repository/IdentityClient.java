package com.devteria.gateway.repository;

import com.devteria.gateway.dto.request.IntrospectRequest;
import com.devteria.gateway.dto.request.response.ApiResponse;
import com.devteria.gateway.dto.request.response.IntrospectResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;
@Repository
public interface IdentityClient {
    @PostExchange(url = "/auth/introspect", contentType = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ApiResponse<IntrospectResponse>> introspect(@RequestBody IntrospectRequest request);

}