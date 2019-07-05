package com.example.restjpaproject

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Employee constructor( var name: String, var role: String) {

    @Id
    @GeneratedValue
    var id: Long? = null

    override fun toString(): String = "Employee(id=$id, name=$name, role=$role)"
}