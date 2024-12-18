package com.UserMicroServices.Registration_Service.Repository;

import com.UserMicroServices.Registration_Service.Entity.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalUserRepository extends JpaRepository<PersonalDetails,Integer> {
}
