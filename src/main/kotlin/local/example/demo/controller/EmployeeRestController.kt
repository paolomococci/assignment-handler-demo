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
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URISyntaxException

@RestController
@RequestMapping("/api/employees")
class EmployeeRestController internal constructor(
        val employeeRepository: EmployeeRepository,
        val employeeResourceAssembler: EmployeeResourceAssembler
){

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
}
