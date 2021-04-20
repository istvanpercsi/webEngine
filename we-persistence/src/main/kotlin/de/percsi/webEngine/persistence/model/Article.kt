package de.percsi.webEngine.persistence.model


import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "article")
class Article (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    var id: Long? = null,

    @Column(name = "article_id", unique = true)
    var articleId: String? = null,

    @Column(name = "title")
    var title: String? = null,

    @Column(name = "head_line")
    var headLine: String? = null,

    @Column(name = "content")
    var content: String? = null,

    @Column(name = "create_date")
    var createDate: LocalDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "created_by")
    var createdBy: User? = null,

    @Column(name = "format")
    var format: String? = null,

    @ManyToOne
    @JoinColumn(name = "locked_for")
    var lockedFor: User? = null,

    @Column(name = "locked_until")
    var lockedUntil: LocalDateTime? = null,

)