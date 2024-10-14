package com.devteria.identity.mapper;

import com.devteria.identity.dto.request.ProfileCreationRequest;
import com.devteria.identity.dto.request.UserCreationRequest;
import com.devteria.identity.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);

}
