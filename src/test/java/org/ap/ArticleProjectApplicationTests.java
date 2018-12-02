package org.ap;

import org.ap.api.ArticleApi;
import org.ap.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= {ArticleProjectApplication.class})
public class ArticleProjectApplicationTests {
	
	@Autowired
	private ArticleApi articleApi;
	
	@Test
	public void should_add_one_article() {
		//Given
		Article article = ArticleFactory.createArticle();
		//When
		article=articleApi.saveOrUpdate(article);
		//Then
	 Assert.assertTrue("article Id must not be null", article.getId()>0);
	}

}
