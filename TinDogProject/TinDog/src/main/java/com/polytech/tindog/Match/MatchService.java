package com.polytech.tindog.Match;

import com.polytech.tindog.Dog.Dog;
import com.polytech.tindog.Dog.DogService;
import com.polytech.tindog.Owner.Owner;
import com.polytech.tindog.Owner.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private DogService dogService;

    public void createMatch(String judgingId, String judgedId, Boolean liked) throws Exception {
        if(ownerService.ownerExists(UUID.fromString(judgingId)) && ownerService.ownerExists(UUID.fromString(judgedId))){
            if(matchRepository.existsByJudgingIdAndJudgedId(judgingId,judgedId)){
                throw new Exception("This user has already evaluated the other user.");

            }else{
                DogMatch dogMatch = new DogMatch(judgingId, judgedId, liked);
                matchRepository.save(dogMatch);
            }

        }else{
            throw new Exception(("One or more users don't exist."));
        }
    }

    public List<Dog> getMatchesOfOwner(String ownerId) throws Exception {
        List<Dog> matches = new ArrayList<Dog>();
        if(matchRepository.existsByJudgingId(ownerId)) {
            List<DogMatch> likedMatches = matchRepository.findByJudgingIdAndLiked(ownerId, true).get();
            for (DogMatch match : likedMatches) {
                if (matchRepository.existsByJudgingIdAndJudgedIdAndLiked(match.getJudgedId(), ownerId, true)) {
                    try {
                        matches.add(dogService.findDogByOwnerId(match.getJudgedId()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return matches;
    }
}
