package org.ap.service;

import java.util.Collection;

import org.ap.entity.Article;
import org.springframework.data.domain.Page;

public interface ArticleService {
	Article saveOrUpdate(final Article article);
	Page<Article> listArticles( final Integer page, final Integer size);
	void deleteArticle(final Long id);
	Collection<Article> chercherArticle(final String motCle);
}
