package esperer.webfluxserver.domain.post.entity

import esperer.webfluxserver.global.entity.BaseUUIDEntity
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("tbl_post")
class PostEntity(
    @get:JvmName("getIdentifier")
    override var id: UUID = UUID(0, 0),
    val title: String,
    val content: String,
    val userId: UUID
) : BaseUUIDEntity(id)