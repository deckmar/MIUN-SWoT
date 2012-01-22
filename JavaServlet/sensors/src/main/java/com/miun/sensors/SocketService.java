package com.miun.sensors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("socketService")
@Transactional
public class SocketService {
	
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	/*
	 * read a tag
	 */
	public Socket get(long id) {

		Session session = sessionFactory.getCurrentSession();
		Socket sock = (Socket) session.get(Socket.class, id);
		return sock;
	}
	
	/*
	 * update a tag
	 */
	public void update(Socket sock) {
		Session session = sessionFactory.getCurrentSession();
		Socket dbSoc = (Socket) session.get(Socket.class, sock.getId());
		if(dbSoc == null){
			session.save(sock);
		} else {
			dbSoc.setAddress(sock.getAddress());
			dbSoc.setTemperature(sock.getTemperature());
			dbSoc.setHumidity(sock.getHumidity());
			
			dbSoc.setLight(sock.isLight());
			dbSoc.setSocket(sock.isSocket());
			session.save(dbSoc);
		}
	}
	

}

