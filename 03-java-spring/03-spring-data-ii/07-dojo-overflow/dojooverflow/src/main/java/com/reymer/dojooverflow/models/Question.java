package com.reymer.dojooverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String question;
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    @OneToMany(mappedBy="question", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Answer> answers;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "questions_tags", 
            joinColumns = @JoinColumn(name = "question_id"), 
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
    
    @Pattern(regexp="^(([a-zA-Z\\s])+$|([a-zA-Z\\s]+,)[a-zA-Z\\s]+){1,2}$",message="Tags must be separated by commas, max 3")
    private String strTag;
    
    @PrePersist
	protected void onCreate(){
        this.createdAt = new Date();
	}
	@PreUpdate
		protected void onUpdate(){
	        this.updatedAt = new Date();
	}
	
	public Question() {
	}
	public Question(String question, List<Tag> tags) {
		this.question = question;
		this.tags = tags;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public String getStrTag() {
		return strTag;
	}
	public void setStrTag(String strTag) {
		this.strTag = strTag;
	}
	public String[] splitTags() {
    	return this.strTag.split("\\s*,\\s*");
    }
}
