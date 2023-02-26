package com.rest.api.post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.api.post.dto.Fields;
import com.rest.api.post.dto.IssueType;
import com.rest.api.post.dto.Payload;
import com.rest.api.post.dto.Project;

public class POSTAPIWithSerialization {
	
	public static void main(String[] args) throws JsonProcessingException {
	
	IssueType issue=new IssueType("Task");
	Project project=new Project("REST");
	Payload p=new Payload("Demo", "Demo1Description", issue, project);
	Fields f=new Fields(p);
	
	ObjectMapper obj=new ObjectMapper();
	String myData=obj.writerWithDefaultPrettyPrinter().writeValueAsString(f);
	
	}

}
