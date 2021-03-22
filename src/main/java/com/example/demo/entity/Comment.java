package com.example.demo.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
public class Comment {

	@EmbeddedId
    private CommentKey id;

    @ManyToOne
    @MapsId("FACId")
    @JoinColumn(name = "FAC_Id")
    private FACMember facMember;

    @ManyToOne
    @MapsId("rid")
    @JoinColumn(name = "rid")
    private Request request;
    
    private boolean isForwarded;
    private boolean isRecommended;
    private Date enteredDate = new Date();
    private String discription1;
    
	public Comment(FACMember facMember, Request request, boolean isForwarded, boolean isRecommended,
			Date enteredDate, String discription1) {
		super();
		this.id = new CommentKey(facMember.getUserId(), request.getRid());
		this.facMember = facMember;
		this.request = request;
		this.isForwarded = isForwarded;
		this.isRecommended = isRecommended;
		this.enteredDate = enteredDate;
		this.discription1 = discription1;
	}

	public Comment() {
		super();
	}

	public CommentKey getId() {
		return id;
	}

	public void setId(CommentKey id) {
		this.id = id;
	}

	public boolean getIsForwarded() {
		return isForwarded;
	}

	public void setIsForwarded(boolean isForwarded) {
		this.isForwarded = isForwarded;
	}

	public boolean getIsRecommended() {
		return isRecommended;
	}

	public void setIsRecommended(boolean isRecommended) {
		this.isRecommended = isRecommended;
	}

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	public String getDiscription1() {
		return discription1;
	}

	public void setDiscription1(String discription1) {
		this.discription1 = discription1;
	}
    
}
