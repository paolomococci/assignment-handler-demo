/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.demo.controller

import local.example.demo.assembler.EmployeeResourceAssembler
import local.example.demo.model.Employee
import local.example.demo.repository.EmployeeRepository
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.net.URISyntaxException
import java.util.*

@RepositoryRestController
@RequestMapping("/api/employees")
class EmployeeRestController internal constructor(
        val employeeRepository: EmployeeRepository,
        val employeeResourceAssembler: EmployeeResourceAssembler
) {
    @PostMapping
    @Throws(URISyntaxException::class)
    fun create(@RequestBody employee: Employee): ResponseEntity<EntityModel<Employee>> {
        val entityModel = employeeResourceAssembler.toModel(employeeRepository.save(employee))
        return ResponseEntity.ok(entityModel)
    }

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun read(@PathVariable id: Long?): ResponseEntity<EntityModel<Optional<Employee>>> {
        if (employeeRepository.findById(id!!).isPresent) {
            return ResponseEntity.ok(employeeResourceAssembler.toModel(employeeRepository.findById(id!!)))
        } else {
            return ResponseEntity.ok(EntityModel(Optional.empty()))
        }
    }

    @GetMapping
    @Throws(URISyntaxException::class)
    fun readAll(): ResponseEntity<CollectionModel<EntityModel<Employee>>> {
        val employees = employeeRepository
                .findAll()
                .asSequence()
                .map(employeeResourceAssembler::toModel)
                .toList()
        val collectionModel = CollectionModel(employees,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeRestController::class.java)
                        .readAll()).withSelfRel())
        return ResponseEntity.ok(collectionModel)
    }

    @PutMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun update(@RequestBody update: Employee, @PathVariable id: Long?): ResponseEntity<*> {
        val updated = id?.let {
            employeeRepository.findById(it).map { temp ->
                temp.firstName = update.firstName
                temp.lastName = update.lastName
                employeeRepository.save(temp)
            }
                    .orElseGet {
                        employeeRepository.save(update)
                    }
        }
        val entityModel = updated?.let {
            employeeResourceAssembler.toModel(it)
        }
        return ResponseEntity.created(URI(entityModel?.content?.id.toString())).body(entityModel)
    }

    @PatchMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun partialUpdate(@RequestBody update: Employee, @PathVariable id: Long?): ResponseEntity<*> {
        val updated = id?.let {
            employeeRepository.findById(id).map {temp ->
                if (!update.firstName.isNullOrBlank()) temp.firstName = update.firstName
                if (!update.lastName.isNullOrBlank()) temp.lastName = update.lastName
                employeeRepository.save(temp)
            }
                    .orElseGet {
                        employeeRepository.save(update)
                    }
        }
        val entityModel = updated?.let {
            employeeResourceAssembler.toModel(it)
        }
        return ResponseEntity.created(URI(entityModel?.content?.id.toString())).body(entityModel)
    }

    @DeleteMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun delete(@PathVariable id: Long?): ResponseEntity<*> {
        when {
            id != null -> employeeRepository.deleteById(id)
        }
        return ResponseEntity.noContent().build<Any>()
    }
}
