package org.ap;

import org.ap.entity.Article;

public class ArticleFactory {
	public static Article createArticle() {
		Article article = new Article();
		article.setNom("PC");
		article.setText("Ordinateur");
		article.setImg("https://dw9to29mmj727.cloudfront.net/misc/newsletter-naruto3.png");
		return article;
	}

}
