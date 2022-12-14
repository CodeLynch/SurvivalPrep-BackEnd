package com.ateam.survivalprep.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ateam.survivalprep.Entity.CommunityEntity;
import com.ateam.survivalprep.Service.CommunityService;

@CrossOrigin
@RestController
@RequestMapping("/community")
public class CommunityController{
    @Autowired
	CommunityService cserv;

    @PostMapping("/postCommunity")
	public CommunityEntity postCommunity(@RequestBody CommunityEntity community) {
		return cserv.insertCommunity(community);
    }
    
    @GetMapping("/getAllCommunities")
    public List<CommunityEntity> getAllCommunities(){
    	return cserv.getAllUCommunities();
    }
     
    @PutMapping("/putCommunityName")
    public CommunityEntity putCommunityName(@RequestParam int id, @RequestBody CommunityEntity newComDetails) throws Exception{
    	return cserv.putCommunityName(id, newComDetails);
    }

    @DeleteMapping("/deleteCommunity/{id}")
    public String deleteCommunity(@PathVariable int id) {
    	return cserv.deleteCommunity(id);
    }

}
