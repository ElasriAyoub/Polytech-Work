package com.polytech.tindog.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public boolean ownerExists(UUID id){
        if(ownerRepository.findById(id).isPresent())
            return true;
        return false;
    }

    public Owner createOwner(UUID id, String name, String lastname, String profession, String bio,
                             Date birthday, String gender, MultipartFile multipartImage) throws Exception {
        if(ownerExists(id))
            throw new Exception(("An owner with this id already exists."));
        Owner owner = new Owner(id, name, lastname, profession, bio, birthday, gender);
        owner.setPicture(multipartImage.getBytes());
        return ownerRepository.save(owner);
    }

    public Resource getImage(UUID id) throws Exception {
        if(!ownerExists(id))
            throw new Exception(("An owner with this id doesn't exist."));
        Owner owner = ownerRepository.findById(id).get();
        return new ByteArrayResource(owner.getPicture());
    }

    public Owner getOwnerById(UUID id) throws Exception {
        if(!ownerExists(id))
            throw new Exception(("An owner with this id doesn't exist."));
        return ownerRepository.findById(id).get();
    }

}
