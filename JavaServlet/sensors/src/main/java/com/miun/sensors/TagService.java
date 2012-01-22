package com.miun.sensors;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tagService")
@Transactional
public class TagService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/*
	 * read a tag
	 */
	public Tag get(long id) {

		Session session = sessionFactory.getCurrentSession();
		Tag tag = (Tag) session.get(Tag.class, id);
		return tag;
	}
	
	/*
	 * update a tag
	 */
	public void update(Tag tag) {
		Session session = sessionFactory.getCurrentSession();
		Tag dbTag = (Tag) session.get(Tag.class, tag.getId());
		if(dbTag == null){
			session.save(tag);
		} else {
			dbTag.setTemp(tag.getTemp());
			session.save(dbTag);
		}
		//updatetag.setTemp(tag.getTemp());
		//session.save(updatetag);
	}
	
	/*
	 * get all tags 
	 */
	public TagList getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Tag");
		return  new TagList(query.list());
	}

}
