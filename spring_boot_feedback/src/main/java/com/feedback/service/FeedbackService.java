package com.feedback.service;

import java.util.List;

import com.feedback.exception.BusinessException;
import com.feedback.model.Feedback;

public interface FeedbackService {
	public Feedback createFeedback(Feedback feedback);
	public Feedback updateFeedback(Feedback feedback);
	public Feedback getFeedbackById(int id) throws BusinessException;
	public List<Feedback> getAllFeedbacks();
	public List<Feedback> getFeedbackByName(String name);
	public List<Feedback> getFeedbackByRating(int rating);
	public void deleteFeedbackById(int id);
	
	

}
