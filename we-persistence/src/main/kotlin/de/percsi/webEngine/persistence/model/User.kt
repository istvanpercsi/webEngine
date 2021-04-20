package de.percsi.webEngine.persistence.model

import javax.persistence.*


@Entity
@Table(name = "user")
class User (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "login")
    var login: String? = null,

    @Column(name = "first_name")
    var firstName: String? = null,

    @Column(name = "last_name")
    var lastName: String? = null,
)
