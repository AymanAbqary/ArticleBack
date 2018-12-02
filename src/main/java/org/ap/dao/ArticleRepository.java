package org.ap.dao;

import java.util.Collection;

import org.ap.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long>{
	@Query("select a from Article a where a.nom like :x")
	public Collection<Article> chercher(@Param("x") String motcle);
}
