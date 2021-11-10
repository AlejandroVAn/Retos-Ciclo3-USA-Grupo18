package co.usa.edu.ciclo3.reto3.service;

import co.usa.edu.ciclo3.reto3.model.Score;
import co.usa.edu.ciclo3.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int scoreId) {
        return scoreRepository.getScore(scoreId);
    }

    public Score save(Score score) {
        if (score.getStars() >= 0 && score.getStars() <= 5) {
            if (score.getIdScore() == null) {
                return scoreRepository.save(score);
            } else {
                Optional<Score> e = scoreRepository.getScore(score.getIdScore());
                if (e.isEmpty()) {
                    return scoreRepository.save(score);
                }
            }

        }
        return score;
    }

        public Score update (Score score){
            if (score.getIdScore() != null) {
                Optional<Score> e = scoreRepository.getScore(score.getIdScore());
                if (!e.isEmpty()) {
                    if (score.getMessageText() != null) {
                        e.get().setMessageText(score.getMessageText());
                    }
                    if (score.getStars() != null && score.getStars() >= 0 && score.getStars() <= 5) {
                        e.get().setStars(score.getStars());
                    }
                    scoreRepository.save(e.get());
                    return e.get();
                } else {
                    return score;
                }
            } else {
                return score;
            }
        }

        public boolean deleteScore ( int scoreId){
            Boolean aBoolean = getScore(scoreId).map(score -> {
                scoreRepository.delete(score);
                return true;
            }).orElse(false);
            return aBoolean;
        }
    }

