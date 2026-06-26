package org.yearup.service;

import org.springframework.stereotype.Service;
import org.yearup.models.Profile;
import org.yearup.models.dto.ProfileDto;
import org.yearup.repository.ProfileRepository;

@Service
public class ProfileService
{
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository)
    {
        this.profileRepository = profileRepository;
    }

    public Profile create(Profile profile)
    {
        return profileRepository.save(profile);
    }

    public Profile getByUserId(int userId)
    {
        return profileRepository.findById(userId).orElse(null);
    }

    public boolean update(int userId, ProfileDto profileDto)
    {
        Profile oldProfile = profileRepository.findById(userId).orElse(null);
        if (oldProfile == null){return false;}
        oldProfile.setFirstName(profileDto.firstName);
        oldProfile.setLastName(profileDto.lastName);
        oldProfile.setPhone(profileDto.phone);
        oldProfile.setEmail(profileDto.email);
        oldProfile.setAddress(profileDto.address);
        oldProfile.setCity(profileDto.city);
        oldProfile.setState(profileDto.state);
        oldProfile.setZip(profileDto.zip);

         profileRepository.save(oldProfile);
         return true;
    }
}
