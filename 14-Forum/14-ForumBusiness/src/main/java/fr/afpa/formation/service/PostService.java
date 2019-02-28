package fr.afpa.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.entity.Post;
import fr.afpa.formation.exception.post.PostAlreadyExistsException;
import fr.afpa.formation.exception.post.PostNotAvailableException;
import fr.afpa.formation.exception.post.PostNotFoundException;
import fr.afpa.formation.exception.post.PostNotValidException;
import fr.afpa.formation.repository.PostRepository;

@Service
public class PostService implements IService<Post, Exception>{

	@Autowired
	PostRepository postRepository;

	@Override
	public Post create(Post post) throws PostNotValidException, PostAlreadyExistsException {
		if(post == null || post.getAuthorName() == null || post.getPostName() == null || post.getCategory() == null) {
			throw new PostNotValidException("Post Not Valid Exception");
		}
		if(post.getId() != null && postRepository.existsById(post.getId())) {
			throw new PostAlreadyExistsException("Post Already Exists Exception");
		}
		postRepository.save(post);
		return post;
	}

	@Override
	public Post findById(Long id) throws PostNotFoundException {
		Optional<Post> post = postRepository.findById(id);
		if(!post.isPresent()) {
			throw new PostNotFoundException("Post Not Found Exception");
		}
		return post.get();
	}

	@Override
	public List<Post> findAll() throws PostNotAvailableException {
		List<Post> listPost = (List<Post>) postRepository.findAll();
		if(listPost == null) {
			throw new PostNotAvailableException("Post Not Available Exception");
		}
		return listPost;
	}

	@Override
	public void deleteById(Long id) throws PostNotFoundException {
		if(!postRepository.existsById(id)) {
			throw new PostNotFoundException("Post Not Found Exception");
		}
		postRepository.deleteById(id);
	}

	@Override
	public Post update(Post post) throws PostNotValidException, PostNotFoundException {
		if(post == null || post.getAuthorName() == null || post.getPostName() == null || post.getCategory() == null) {
			throw new PostNotValidException("Post Not Valid Exception");
		}
		if(post.getId() == null || !postRepository.existsById(post.getId())) {
			throw new PostNotFoundException("Post Not Found Exception");
		}
		postRepository.save(post);
		return post;
	}

}
