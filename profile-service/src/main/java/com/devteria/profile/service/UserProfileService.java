package com.devteria.profile.service;

import com.devteria.profile.dto.request.ProfileCreateRequest;
import com.devteria.profile.dto.request.response.UserProfileResponse;
import com.devteria.profile.entity.UserProfile;
import com.devteria.profile.mapper.UserProfileMapper;
import com.devteria.profile.repository.UserProfileRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;
    public UserProfileResponse createProfile(ProfileCreateRequest request){
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfile = userProfileRepository.save(userProfile);
        return userProfileMapper.toUserProfileRespone(userProfile);
    }
    public UserProfileResponse getProfile(String id){
        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));
        return userProfileMapper.toUserProfileRespone(userProfile);
    }
    public UserProfileResponse updateProfile(String id, ProfileCreateRequest request){
        UserProfile userProfile = userProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("Profile not found"));
        userProfileMapper.updateUser(userProfile, request);
        return userProfileMapper.toUserProfileRespone(userProfileRepository.save(userProfile));
    }
    public void deleteProfile(String id){
        userProfileRepository.deleteById(id);
    }
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserProfileResponse> getAllProfile(){
        return userProfileRepository.findAll().stream().map(userProfileMapper::toUserProfileRespone).toList();
    }

}
