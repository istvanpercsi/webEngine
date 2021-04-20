package de.percsi.webEngine.persistence.repository

import io.kotest.core.extensions.Extension
import io.kotest.extensions.spring.SpringExtension
import io.kotest.core.spec.style.FunSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.FilterType
import org.springframework.stereotype.Repository

@DataJpaTest(includeFilters = [ComponentScan.Filter(type = FilterType.ANNOTATION, classes = [Repository::class])])
class ArticleRepositoryTest : FunSpec(){
    override fun extensions(): List<Extension> {
        return listOf(SpringExtension)
    }

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var articleRepository: ArticleRepository

    init {
        test("blabla") {
            var x = articleRepository.findAll()
            x.forEach{it}
        }
    }

}
