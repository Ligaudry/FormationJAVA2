package com.m2i.formation.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import com.m2i.formation.media.entities.Author;
import com.m2i.formation.media.entities.Media;
import com.m2i.formation.media.repositories.*;

public class MainService implements IMainService {
	
	private Media2Repository mediaRepository;
	private Author2Repository authorRepository;
	
	/* (non-Javadoc)
	 * @see com.m2i.formation.services.IMainService#addAuthorToMedia(com.m2i.formation.media.entities.Author, int)
	 */
	@Override
	public void addAuthorToMedia(Author a, int MediaId) throws ServiceException{
		
		EntityManagerFactory emf = EmfSingleton.getInstance();
		EntityManager em = emf.createEntityManager();
		mediaRepository = new Media2Repository();
		mediaRepository.setEntityManager(em);
		
		Media m = mediaRepository.getById(MediaId);
		
		if (m!=null){
			if(!m.getAuthors().contains(a)){
				m.getAuthors().add(a);
				mediaRepository.getTransaction();
				mediaRepository.save(m);
				mediaRepository.commit();
							
			}
			else {
				throw new ServiceException("Author allready mentionned in Media");
			}
		}
		else{
			throw new ServiceException("Media doesn't exist");
		}
		
	}

	public Media2Repository getMediaRepository() {
		return mediaRepository;
	}

	public void setMediaRepository(Media2Repository mediaRepository) {
		this.mediaRepository = mediaRepository;
	}

	public Author2Repository getAuthorRepository() {
		return authorRepository;
	}

	public void setAuthorRepository(Author2Repository authorRepository) {
		this.authorRepository = authorRepository;
	}

}
