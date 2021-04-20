package de.percsi.webEngine.persistence.repository

import de.percsi.webEngine.persistence.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Component
@Repository
interface UserRepository : CrudRepository<User,Long>