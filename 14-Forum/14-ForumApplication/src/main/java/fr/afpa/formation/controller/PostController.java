package fr.afpa.formation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.afpa.formation.entity.Comment;
import fr.afpa.formation.entity.Post;
import fr.afpa.formation.exception.comment.CommentAlreadyExistsException;
import fr.afpa.formation.exception.comment.CommentNotValidException;
import fr.afpa.formation.service.CategoryService;
import fr.afpa.formation.service.CommentService;
import fr.afpa.formation.service.PostService;

@Controller
public class PostController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	PostService postService;

	@Autowired
	CommentService commentService;

	@Autowired
	HttpServletRequest httpServletRequest;

	@RequestMapping("/")
	public String listPost(Model model) {
		List<Post> listPost = postService.findAll();
		model.addAttribute("listPost", listPost);
		model.addAttribute("listPostSize", listPost.size());
		return "home";
	}

	@RequestMapping("/{id}/post")
	public String singlePost(Model model, @PathVariable("id") Long id) {
		Post post = postService.findById(id);
		model.addAttribute("post", post);
		return "post";
	}

	@RequestMapping("/post/addComment")
	public String addComment(Model model,
			@RequestParam(name="userName", required=true) String userName,
			@RequestParam(name="message", required=true) String message,
			@RequestParam(name="idPost", required=true) Long idPost) {
		Post post = postService.findById(idPost);
		Comment comment = new Comment(userName, message, post);
		try {
			commentService.create(comment);
		} catch (CommentNotValidException e) {
			e.printStackTrace();
			return "redirect:/error";
		} catch (CommentAlreadyExistsException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
		return "redirect:/ "+ idPost +"/post";
	}
}
