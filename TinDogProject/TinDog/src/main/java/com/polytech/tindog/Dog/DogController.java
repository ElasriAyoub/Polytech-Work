package com.polytech.tindog.Dog;
import com.polytech.tindog.Owner.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
public class DogController {
    @Autowired
    private DogService dogService;

    @PostMapping("/create-dog")
    public Dog createOwner(@RequestParam String dogname, @RequestParam Date birthday,
                             @RequestParam String bio, @RequestParam String gender,
                           @RequestParam String ownerId, @RequestParam MultipartFile multipartImage) throws Exception {
        return dogService.createDog(dogname,birthday,bio,gender,ownerId,multipartImage);
    }

    @GetMapping("/dogs-of-owner")
    public Dog getDogsByOwner(@RequestParam String ownerId){
        return dogService.findDogByOwnerId(ownerId);
    }

    @GetMapping(value = "/dog-image", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource getImage(@RequestParam UUID id) throws Exception {
        return dogService.getImage(id);
    }

    @GetMapping("/dog")
    public Dog getDogById(@RequestParam UUID id) throws Exception {
        return dogService.getDogById(id);
    }

    @GetMapping("/dogs-to-show")
    public List<Dog> getDogsToShowToOwner(@RequestParam String ownerId){
        return dogService.getListOfDogsToShow(ownerId);
    }

    @GetMapping("/find-owner-id")
    public String findOwnerIdByDogId(@RequestParam UUID id){
        return dogService.findOwnerIdByDogId(id);
    }

    @GetMapping("find-dog-by-owner")
    public Dog findDogByOwnerId(@RequestParam String ownerId){
        return dogService.findDogByOwnerId(ownerId);
    }

}
