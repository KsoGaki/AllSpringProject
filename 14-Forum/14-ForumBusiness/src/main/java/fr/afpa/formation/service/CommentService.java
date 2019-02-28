package fr.afpa.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.entity.Comment;
import fr.afpa.formation.exception.comment.CommentAlreadyExistsException;
import fr.afpa.formation.exception.comment.CommentNotAvailableException;
import fr.afpa.formation.exception.comment.CommentNotFoundException;
import fr.afpa.formation.exception.comment.CommentNotValidException;
import fr.afpa.formation.repository.CommentRepository;

@Service
public class CommentService implements IService<Comment, Exception>{

	@Autowired
	CommentRepository commentRepository;

	@Override
	public Comment create(Comment comment) throws CommentNotValidException, CommentAlreadyExistsException {
		if(comment == null || comment.getMessage() == null|| comment.getUserName() == null || comment.getPost() == null ) {
			throw new CommentNotValidException("Comment Not Valid Exception");
		}
		if(comment.getId() != null && commentRepository.existsById(comment.getId())) {
			throw new CommentAlreadyExistsException("Comment Already Exists Exception");
		}
		commentRepository.save(comment);
		return comment;
	}

	@Override
	public Comment findById(Long id) throws CommentNotFoundException {
		Optional<Comment> comment = commentRepository.findById(id);
		if(!comment.isPresent()) {
			throw new CommentNotFoundException("Comment Not Found Exception");
		}
		return comment.get();
	}

	@Override
	public List<Comment> findAll() throws CommentNotAvailableException {
		List<Comment> listComment = (List<Comment>) commentRepository.findAll();
		if(listComment == null) {
			throw new CommentNotAvailableException("Comment Not Available Exception");
		}
		return listComment;
	}

	@Override
	public void deleteById(Long id) throws CommentNotFoundException {
		if(!commentRepository.existsById(id)) {
			throw new CommentNotFoundException("Comment Not Found Exception");
		}
		commentRepository.deleteById(id);
	}

	@Override
	public Comment update(Comment comment) throws CommentNotValidException, CommentNotFoundException {
		if(comment == null || comment.getMessage() == null|| comment.getUserName() == null || comment.getPost() == null ) {
			throw new CommentNotValidException("Comment Not Valid Exception");
		}
		if(comment.getId() == null || !commentRepository.existsById(comment.getId())) {
			throw new CommentNotFoundException("Comment Not Found Exception");
		}
		commentRepository.save(comment);
		return comment;
	}

}
