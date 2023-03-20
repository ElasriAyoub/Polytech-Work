package com.polytech.tindog.Dog;

import com.polytech.tindog.Match.DogMatch;
import com.polytech.tindog.Match.MatchRepository;
import com.polytech.tindog.Owner.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private MatchRepository matchRepository;

    public boolean dogExists(UUID id){
        if(dogRepository.findById(id).isPresent())
            return true;
        return false;
    }

    public Dog createDog(String dogname, Date birthday,String bio, String gender, String ownerId, MultipartFile multipartImage) throws Exception {
        Dog dog = new Dog(dogname,birthday,bio,gender,ownerId);
        dog.setPicture(multipartImage.getBytes());
        return dogRepository.save(dog);
    }

    public Resource getImage(UUID id) throws Exception {
        if(!dogExists(id))
            throw new Exception(("A dog with this id doesn't exist."));
        Dog dog = dogRepository.findById(id).get();
        return new ByteArrayResource(dog.getPicture());
    }

    public Dog findDogByOwnerId(String ownerId){
        return dogRepository.findByOwnerId(ownerId).get();
    }

    public Dog getDogById(UUID id) throws Exception {
        if(!dogExists(id))
            throw new Exception(("A dog with this id doesn't exist."));
        return dogRepository.findById(id).get();
    }

    public List<Dog> getListOfDogsToShow(String ownerId){
        Dog dogOfOwner = findDogByOwnerId(ownerId);
        List<Dog> all= dogRepository.findAll();

        List<DogMatch> listMatch = matchRepository.findByJudgingId(ownerId).get();
        List<Dog> dogsAlreadySeen = new ArrayList<Dog>();
        for(DogMatch match:listMatch){
            dogsAlreadySeen.add(dogRepository.findByOwnerId(match.getJudgedId()).get());
        }

        all.remove(dogOfOwner);
        for(Dog seen:dogsAlreadySeen){
            all.remove(seen);
        }
        return all;
    }

    public String findOwnerIdByDogId(UUID id){
        Dog dog = dogRepository.findById(id).get();
        return dog.getOwnerId();
    }
}
