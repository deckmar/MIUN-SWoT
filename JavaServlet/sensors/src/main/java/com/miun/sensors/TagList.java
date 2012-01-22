package com.miun.sensors;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="bottles")
public class TagList implements Serializable{
	private static final long serialVersionUID = 2L;
	
	private List<Tag> tags;
	   
    public TagList(){}
    public TagList(List<Tag> tags){
        this.tags = tags;
    }
   
    @XmlElement(name="bottle")
    public List<Tag> getTags() {
        return tags;
    }
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}



   
    

