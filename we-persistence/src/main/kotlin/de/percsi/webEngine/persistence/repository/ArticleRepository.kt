package de.percsi.webEngine.persistence.repository

import de.percsi.webEngine.persistence.model.Article
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ArticleRepository : CrudRepository<Article, Long>