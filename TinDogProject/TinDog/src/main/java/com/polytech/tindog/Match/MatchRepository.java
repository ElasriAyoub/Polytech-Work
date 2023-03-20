package com.polytech.tindog.Match;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MatchRepository extends JpaRepository<DogMatch, UUID> {
    boolean existsByJudgingIdAndJudgedId(String judgingId, String judgedId);
    boolean existsByJudgingIdAndLiked(String judgingId, boolean liked);
    boolean existsByJudgingIdAndJudgedIdAndLiked(String judgingId, String judgedId, boolean liked);
    boolean existsByJudgingId(String judgingId);
    Optional<DogMatch> findByJudgingIdAndAndJudgedId(String judgingId, String judgedId);
    Optional<List<DogMatch>> findByJudgingIdAndLiked(String judgingId, boolean liked);

    Optional<List<DogMatch>> findByJudgingId(String judgingId);

}
