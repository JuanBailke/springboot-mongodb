package com.juanbailke.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juanbailke.workshopmongo.domain.Post;
import com.juanbailke.workshopmongo.resources.util.URL;
import com.juanbailke.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	//Busca informações de um post específico
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> FindById(@PathVariable String id){
		Post obj = postService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> FindByTitle(@RequestParam(value = "text", defaultValue = "") String text){
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
}