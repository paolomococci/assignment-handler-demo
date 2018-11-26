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
import local.example.demo.exception.EmployeeNotFoundException
import local.example.demo.model.Employee
import local.example.demo.repository.EmployeeRepository
import org.springframework.hateoas.Resource
import org.springframework.hateoas.Resources
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.net.URISyntaxException

@RestController
@RequestMapping("/api/employees")
class EmployeeRestController internal constructor(
        val employeeRepository: EmployeeRepository,
        val employeeResourceAssembler: EmployeeResourceAssembler
){

    @PostMapping
    @Throws(URISyntaxException::class)
    fun create(@RequestBody employee: Employee): ResponseEntity<Resource<Employee>> {
        val resource = employeeResourceAssembler.toResource(employeeRepository.save(employee))
        return ResponseEntity.created(URI(resource.id.expand().href)).body(resource)
    }

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun read(@PathVariable id: Long?): Resource<Employee> {
        return employeeResourceAssembler.toResource(employeeRepository.findById(id!!)
                .orElseThrow { EmployeeNotFoundException(id) })
    }

    @GetMapping
    @Throws(URISyntaxException::class)
    internal fun readAll(): Resources<Resource<Employee>> {
        val employees = employeeRepository.findAll()
                .asSequence()
                .map(employeeResourceAssembler::toResource).toList()
        return Resources(employees,
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(EmployeeRestController::class.java)
                        .readAll()).withSelfRel())
    }

    @PutMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun update(@RequestBody update: Employee, @PathVariable id: Long?): ResponseEntity<*> {
        val updated = employeeRepository.findById(id!!)
                .map { temp ->
                    temp.name = update.name
                    temp.surname = update.surname
                    employeeRepository.save(temp)
                }
                .orElseGet {
                    employeeRepository.save(update)
                }
        val resource = employeeResourceAssembler.toResource(updated)
        return ResponseEntity.created(URI(resource.id.expand().href)).body(resource)
    }

    @PatchMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun partialUpdate(@RequestBody update: Employee, @PathVariable id: Long?): ResponseEntity<*> {
        val updated = employeeRepository.findById(id!!)
                .map { temp ->
                    if (!update.name.isNullOrBlank()) temp.name = update.name
                    if (!update.surname.isNullOrBlank()) temp.surname = update.surname
                    employeeRepository.save(temp)
                }
                .orElseGet {
                    employeeRepository.save(update)
                }
        val resource = employeeResourceAssembler.toResource(updated)
        return ResponseEntity.created(URI(resource.id.expand().href)).body(resource)
    }

    @DeleteMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun delete(@PathVariable id: Long?): ResponseEntity<*> {
        when { id != null -> employeeRepository.deleteById(id) }
        return ResponseEntity.noContent().build<Any>()
    }
}
