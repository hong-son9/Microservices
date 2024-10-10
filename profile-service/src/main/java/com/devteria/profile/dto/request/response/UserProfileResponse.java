package com.devteria.profile.dto.request.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponse {
    String id;
    String firstName;
    LocalDate dob;
    String lastName;
    String city;
}
