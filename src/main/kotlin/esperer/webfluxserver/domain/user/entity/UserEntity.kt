package esperer.webfluxserver.domain.user.entity

import esperer.webfluxserver.global.entity.BaseUUIDEntity
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("tbl_user")
class UserEntity(
    @get:JvmName("getIdentifier")
    override var id: UUID = UUID(0, 0),
    val email: String,
    val password: String,
    val name: String,
) : BaseUUIDEntity(id)