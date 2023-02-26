package com.rest.api.post.dto;

public class Payload {
	
	String summary;
	String description;
	IssueType issuetype;
	Project project;
	
	public Payload(String summary,String description,IssueType issue,Project project) {
		this.summary=summary;
		this.description=description;
		this.issuetype=issue;
		this.project=project;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public IssueType getIssuetype() {
		return issuetype;
	}
	public void setIssuetype(IssueType issuetype) {
		this.issuetype = issuetype;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	

}
