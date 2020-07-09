package com.feedback.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.dao.FeedbackDAO;
import com.feedback.exception.BusinessException;
import com.feedback.model.Feedback;
import com.feedback.service.FeedbackService;

@Service
public class FeedbackServiceImpl  implements FeedbackService{
    @Autowired
	private FeedbackDAO dao;
	
	@Override
	public Feedback createFeedback(Feedback feedback) {
		
		return dao.save(feedback);
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) {
		return dao.save(feedback);

	}
	
	@Override
	public Feedback getFeedbackById(int id) throws BusinessException {
		if(id<=0) {
			throw new BusinessException("Id "+id +" is invalid");
		}
		Feedback feedback=null;
		try {
		feedback=dao.findById(id).get();
		}catch(NoSuchElementException e) {
			throw new BusinessException("No feedback found for id "+id);
		}
		return feedback;
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		
		return dao.findAll();
	}

	@Override
	public List<Feedback> getFeedbackByName(String name) {
		
		return dao.findAll();
	}

	@Override
	public List<Feedback> getFeedbackByRating(int rating) {
		
		return dao.findByRating(rating);
	}

	@Override
	public void deleteFeedbackById(int id) {
		dao.deleteById(id);
		
	}
	

}
