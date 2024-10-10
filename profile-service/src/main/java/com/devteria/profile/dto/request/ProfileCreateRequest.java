package com.devteria.profile.dto.request;

import lombok.*;

import java.time.LocalDate;
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCreateRequest {
    String firstName;
    LocalDate dob;
    String lastName;
    String city;
}
