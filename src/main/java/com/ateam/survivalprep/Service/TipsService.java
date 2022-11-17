package com.ateam.survivalprep.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateam.survivalprep.Entity.TipsEntity;
import com.ateam.survivalprep.Repository.TipsRepository;

@Service
public class TipsService {

	@Autowired
	TipsRepository trepo;
	
	public TipsEntity insertTip(TipsEntity tips) {
		return trepo.save(tips);
	}
	
	public List<TipsEntity> getAllTips(){
		return trepo.findAll();
	}
		
	public TipsEntity putTipContent(int id, TipsEntity newTipDetails) throws Exception{
		TipsEntity tips = new TipsEntity();
		
		try {
			tips = trepo.findById(id).get();
			tips.setTipContent(newTipDetails.getTipContent());

			return trepo.save(tips);
		}catch(NoSuchElementException e){
			throw new Exception("ID number " + id + " does not exist!");
		}
	}
	
	public String deleteTip(int id) {
		String msg;
		if(trepo.findById(id) != null) {
            TipsEntity user = trepo.findById(id).get();
            user.setDeleted(true);
			msg = "User ID number " + id + " deleted successfully!";
		}else {
			msg = "User ID number " + id + " is NOT found!";
		}
		return msg;
	}
}