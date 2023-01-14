package com.kyro.demo.controller;

import com.kyro.demo.model.Profile;
import com.kyro.demo.respository.ProfileRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    ProfileRespository profileRespository;

    @PostMapping("/profile")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        try {
            Profile _profile = profileRespository
                    .save(new Profile(profile.getFirstName(), profile.getLastName(), profile.getDisplayName(), profile.getEmail(), profile.getPhoneNumberWork(),
                            profile.getPhoneNumberHome(), profile.getLocation()));
            return new ResponseEntity<>(_profile, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/profile/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") long id) {
        Optional<Profile> tutorialData = profileRespository.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/profile/{id}")
    public ResponseEntity<Profile> updateTutorial(@PathVariable("id") long id, @RequestBody Profile newProfile) {
        Optional<Profile> profileData = profileRespository.findById(id);

        if (profileData.isPresent()) {
            Profile _profile = profileData.get();
            _profile.setFirstName(newProfile.getFirstName());
            _profile.setLastName(newProfile.getLastName());
            _profile.setDisplayName(newProfile.getDisplayName());
            _profile.setEmail(newProfile.getEmail());
            _profile.setPhoneNumberWork(newProfile.getPhoneNumberWork());
            _profile.setPhoneNumberHome(newProfile.getPhoneNumberHome());
            _profile.setLocation(newProfile.getLocation());
            return new ResponseEntity<>(profileRespository.save(_profile), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
