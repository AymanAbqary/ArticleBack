package org.ap.service;

import java.util.Collection;

import org.ap.dao.ArticleRepository;
import org.ap.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public Article saveOrUpdate(Article article) {
		return articleRepository.save(article);
	}

	@Override
	public Page<Article> listArticles(Integer page, Integer size) {
		Pageable pages=PageRequest.of(page, size);
		return articleRepository.findAll(pages);
	}

	@Override
	public void deleteArticle(Long id) {
		articleRepository.deleteById(id);
	}

	@Override
	public Collection<Article> chercherArticle(String motCle) {
		return articleRepository.chercher(motCle);
	}}
