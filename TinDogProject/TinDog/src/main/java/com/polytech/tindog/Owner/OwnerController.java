package com.polytech.tindog.Owner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.sql.Date;
import java.util.UUID;

@RestController
@CrossOrigin
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @PostMapping("/create-owner")
    public Owner createOwner(@RequestParam UUID id, @RequestParam String name, @RequestParam String lastname,
                             @RequestParam String profession, @RequestParam String bio,
                             @RequestParam Date birthday, @RequestParam String gender,
                             @RequestParam MultipartFile multipartImage) throws Exception {
        return ownerService.createOwner(id,name,lastname,profession,bio,birthday,gender,multipartImage);
    }

    @GetMapping(value = "/owner-image", produces = MediaType.IMAGE_JPEG_VALUE)
    public Resource getImage(@RequestParam UUID id) throws Exception {
        return ownerService.getImage(id);
    }

    @GetMapping("/owner")
    public Owner getOwnerById(@RequestParam("id") UUID id) throws Exception {
        return ownerService.getOwnerById(id);
    }
}
