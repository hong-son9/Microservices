package com.devteria.profile.controller;

import com.devteria.profile.dto.request.ApiResponse;
import com.devteria.profile.dto.request.ProfileCreateRequest;
import com.devteria.profile.dto.request.response.UserProfileResponse;
import com.devteria.profile.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternalUserProfileController {
    UserProfileService userProfileService;
    @PostMapping
    ApiResponse<UserProfileResponse> createProfile(@RequestBody ProfileCreateRequest request){
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.createProfile(request))
                .build();

    }
    @GetMapping("/{profileId}")
    ApiResponse<UserProfileResponse> getProfile(@PathVariable String profileId) {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.getProfile(profileId))
                .build();
    }
    @GetMapping
    ApiResponse<List<UserProfileResponse>> getAllProfile(){
        return ApiResponse.<List<UserProfileResponse>>builder()
                .result(userProfileService.getAllProfile())
                .build();
    }
    @DeleteMapping("/{profileId}")
    ApiResponse<String> deleteProfile(@PathVariable String profileId){
        userProfileService.deleteProfile(profileId);
        return ApiResponse.<String>builder()
                .result("Delete profile success")
                .build();
    }
    @PutMapping("/{profileId}")
    ApiResponse<UserProfileResponse> updateProfile(@PathVariable String profileId, @RequestBody ProfileCreateRequest request){
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.updateProfile(profileId, request))
                .build();
    }
}
