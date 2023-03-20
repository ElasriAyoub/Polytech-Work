package com.polytech.tindog.Match;

import com.polytech.tindog.Dog.Dog;
import com.polytech.tindog.Owner.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public class MatchController {

    @Autowired
    MatchService matchService;

    @PostMapping("/create-match")
    public void createOwner(@RequestParam String judgingId, @RequestParam String judgedId, @RequestParam Boolean liked) throws Exception {
        matchService.createMatch(judgingId,judgedId,liked);
    }

    @GetMapping("/get-matches-of-owner")
    public List<Dog> getMatchesOfOwnerById(@RequestParam String ownerId) throws Exception{
        return matchService.getMatchesOfOwner(ownerId);
    }
}
