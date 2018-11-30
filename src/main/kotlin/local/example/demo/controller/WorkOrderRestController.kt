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

import local.example.demo.assembler.WorkOrderResourceAssembler
import local.example.demo.exception.WorkOrderNotFoundException
import local.example.demo.model.WorkOrder
import local.example.demo.repository.WorkOrderRepository
import org.springframework.hateoas.Resource
import org.springframework.hateoas.Resources
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.net.URISyntaxException

@RestController
@RequestMapping("/api/workOrders")
class WorkOrderRestController internal constructor(
        val workOrderRepository: WorkOrderRepository,
        val workOrderResourceAssembler: WorkOrderResourceAssembler
) {

    @PostMapping
    @Throws(URISyntaxException::class)
    fun create(@RequestBody workOrder: WorkOrder): ResponseEntity<Resource<WorkOrder>> {
        val resource = workOrderResourceAssembler.toResource(workOrderRepository.save(workOrder))
        return ResponseEntity.created(URI(resource.id.expand().href)).body(resource)
    }

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun read(@PathVariable id: Long?): Resource<WorkOrder> {
        return workOrderResourceAssembler.toResource(workOrderRepository.findById(id!!)
                .orElseThrow { WorkOrderNotFoundException(id) })
    }

    @GetMapping
    @Throws(URISyntaxException::class)
    fun readAll(): Resources<Resource<WorkOrder>> {
        val workOrders = workOrderRepository.findAll()
                .asSequence()
                .map(workOrderResourceAssembler::toResource).toList()
        return Resources(workOrders,
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(WorkOrderRestController::class.java)
                        .readAll()).withSelfRel())
    }

    @PutMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun update(@RequestBody update: WorkOrder, @PathVariable id: Long?): ResponseEntity<*> {
        val updated = workOrderRepository.findById(id!!)
                .map { temp ->
                    temp.label = update.label
                    workOrderRepository.save(temp)
                }
                .orElseGet {
                    workOrderRepository.save(update)
                }
        val resource = workOrderResourceAssembler.toResource(updated)
        return ResponseEntity.created(URI(resource.id.expand().href)).body(resource)
    }

    @DeleteMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun delete(@PathVariable id: Long?): ResponseEntity<*> {
        when { id != null -> workOrderRepository.deleteById(id) }
        return ResponseEntity.noContent().build<Any>()
    }
}
