package com.ateam.survivalprep.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateam.survivalprep.Entity.ThreadEntity;
import com.ateam.survivalprep.Repository.ThreadRepository;

@Service
public class ThreadService {
	
	@Autowired
	ThreadRepository trepo;
	
	//create new thread (CREATE)
	public ThreadEntity insertThread(ThreadEntity thread) {
		return trepo.save(thread);
	}
	
	//view all threads that are not deleted (READ)
	public List<ThreadEntity> getAllThreads(){
		return trepo.findByIsdeleted(false);	
		}

	public ThreadEntity getThreadById(int id){
		return trepo.findByThreadid(id);	
		}
	
	//view all threads that belong to a certain forum (READ)
	public List<ThreadEntity> getAllThreadsByForum(int id){
		return trepo.findAllByForumForumidAndIsdeleted(id, false);	
		}
	
	//change Thread Title (UPDATE)
	public ThreadEntity putThreadTitle(int id, ThreadEntity newThreadDetails) throws Exception{
		ThreadEntity thread = new ThreadEntity();
		
		try {
			thread = trepo.findById(id).get();
			thread.setThreadtitle(newThreadDetails.getThreadtitle());
			return trepo.save(thread);
			
		}catch(NoSuchElementException e){
			throw new Exception("ID number " + id + " does not exist!");
		}
	}
	
    //"delete" thread (DELETE)
	public String deleteThread(int id) {
		String msg;
		if(trepo.findById(id) != null) {
			ThreadEntity thread = trepo.findById(id).get();
			thread.setDeleted(true);
			trepo.save(thread);
			msg = " Thread ID number " + id + " deleted succesfully! ";
		}else {
			msg = " Thread ID number " + id + " is NOT found! ";
		}
		return msg;
		}
	}
	