package com.aaquib.springcloud.couponservice.model

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    @ManyToMany(mappedBy = "roles")
    val users: Set<PcUser>
): GrantedAuthority {
    override fun getAuthority(): String {
        return name
    }
}
