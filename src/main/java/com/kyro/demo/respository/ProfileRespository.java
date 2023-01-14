package com.kyro.demo.respository;

import com.kyro.demo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRespository extends JpaRepository<Profile, Long> {
    List<Profile> findByIdContaining(String id);

}
