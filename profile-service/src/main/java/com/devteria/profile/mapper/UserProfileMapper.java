package com.devteria.profile.mapper;

import com.devteria.profile.dto.request.ProfileCreateRequest;
import com.devteria.profile.dto.request.response.UserProfileResponse;
import com.devteria.profile.entity.UserProfile;
import com.devteria.profile.repository.UserProfileRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreateRequest request);
    UserProfileResponse toUserProfileRespone(UserProfile entity);
    void updateUser(@MappingTarget UserProfile userProfile, ProfileCreateRequest request);
}
