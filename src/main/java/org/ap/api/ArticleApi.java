package org.ap.api;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;

import org.ap.entity.Article;
import org.ap.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value="/api/articles")
@CrossOrigin(origins= {"http://localhost:4200"})
public class ArticleApi {
	@Autowired
	private ArticleService articleService;
	
	private static final String uploadedFolder="//Users//Codex//Documents//Spring-Project//ArticleProject//src//main//resources//static//images" ;
	
	@GetMapping("/")
	public Page<Article> listArticles(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size){
		return articleService.listArticles(page,size);
	}
	
	@PostMapping(value="/")
	public Article saveOrUpdate(@RequestBody Article article,@RequestParam("img") MultipartFile img) {
		Path path = Paths.get(uploadedFolder + img.getOriginalFilename());
		try {
			Files.createDirectories(path.getParent());
			Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleService.saveOrUpdate(article);
	}
	
	@GetMapping("/search")
	public Collection<Article> chercherArticle(String motCle) {
		return articleService.chercherArticle(motCle);
	}
	@DeleteMapping("/")
	public void deleteArticle(Long id) {
		articleService.deleteArticle(id);
	}
	
}
