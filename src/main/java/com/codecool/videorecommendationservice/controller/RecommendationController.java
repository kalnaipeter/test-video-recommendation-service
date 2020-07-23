package com.codecool.videorecommendationservice.controller;

import com.codecool.videorecommendationservice.entity.Recommendation;
import com.codecool.videorecommendationservice.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecommendationController {

    @Autowired
    private RecommendationService service;

    @GetMapping("/{id}")
    public List<Recommendation> getRecommendationsByVideoId(@PathVariable("id")Long id){
        return service.getRecommendationsByVideoId(id);
    }

    @PostMapping("/new/{id}")
    public void addNewRecommendationForVideo(@PathVariable("id")Long id, @RequestBody MultiValueMap<String,String> map){
        service.addNewRecommendationFOrVideo(id,map.getFirst("rating"),map.getFirst("comment"));
    }
}
