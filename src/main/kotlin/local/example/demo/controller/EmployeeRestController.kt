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

import local.example.demo.model.Employee
import local.example.demo.repository.EmployeeRepository
import local.example.demo.repository.WorkOrderRepository
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.EntityModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URISyntaxException

@RepositoryRestController
@RequestMapping("/api/employees")
class EmployeeRestController internal constructor(
        val workOrderRepository: WorkOrderRepository,
        val employeeRepository: EmployeeRepository
) {
    @PostMapping
    @Throws(URISyntaxException::class)
    fun create(@RequestBody employee: Employee): ResponseEntity<EntityModel<Employee>> {
        // TODO
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun read(@PathVariable id: Long?): EntityModel<Employee> {
        TODO("not implemented")
    }

    @GetMapping
    @Throws(URISyntaxException::class)
    fun readAll(): CollectionModel<EntityModel<Employee>> {
        TODO("not implemented")
    }

    @PutMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun update(@RequestBody update: Employee, @PathVariable id: Long?): ResponseEntity<*> {
        TODO("not implemented")
    }

    @PatchMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun partialUpdate(@RequestBody update: Employee, @PathVariable id: Long?):ResponseEntity<*> {
        TODO("not implemented")
    }

    @DeleteMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun delete(@PathVariable id: Long?): ResponseEntity<*> {
        when { id != null -> employeeRepository.deleteById(id)}
        return ResponseEntity.noContent().build<Any>()
    }
}
