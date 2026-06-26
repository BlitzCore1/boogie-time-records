package org.yearup.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.yearup.models.Profile;
import org.yearup.models.User;
import org.yearup.models.dto.ProfileDto;
import org.yearup.service.ProfileService;
import org.yearup.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/profile")
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class ProfileController
{
    private ProfileService profileService;
    private final UserService userService;

    public ProfileController(ProfileService profileService, UserService userService)
    {
        this.profileService = profileService;
        this.userService = userService;
    }

    @GetMapping("")
    public Profile getProfile(Principal principal)
    {
        String username = principal.getName();

        User user = userService.getByUserName(username);
        int userId = user.getId();


        return profileService.getByUserId(userId);
    }

    @PutMapping("")
    public ResponseEntity<Void> updateProfile(@RequestBody ProfileDto profileDto, Principal principal)
    {
        String username = principal.getName();
        User user = userService.getByUserName(username);
        int userId = user.getId();

        boolean updatedProfile = profileService.update(userId, profileDto);
        if (!updatedProfile)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
