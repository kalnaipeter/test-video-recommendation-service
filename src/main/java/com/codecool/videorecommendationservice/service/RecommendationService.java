package com.codecool.videorecommendationservice.service;

import com.codecool.videorecommendationservice.entity.Recommendation;
import com.codecool.videorecommendationservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    private RecommendationRepository repository;

    public List<Recommendation> getRecommendationsByVideoId(Long id){
        return repository.findAllByVideoId(id);
    }

    public void addNewRecommendationFOrVideo(Long id, String rating, String comment) {
        Recommendation recommendation = Recommendation.builder()
                .rating(Integer.parseInt(rating))
                .comment(comment)
                .videoId(id)
                .build();

        repository.save(recommendation);
    }
}
