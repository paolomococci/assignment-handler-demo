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
import local.example.demo.model.WorkOrder
import local.example.demo.repository.WorkOrderRepository
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
@RequestMapping("/api/workOrders")
class WorkOrderRestController internal constructor(
        val workOrderRepository: WorkOrderRepository,
        val workOrderResourceAssembler: WorkOrderResourceAssembler
) {
    @PostMapping
    @Throws(URISyntaxException::class)
    fun create(@RequestBody workOrder: WorkOrder): ResponseEntity<EntityModel<WorkOrder>> {
        val entityModel = workOrderResourceAssembler.toModel(workOrderRepository.save(workOrder))
        return ResponseEntity.ok(entityModel)
    }

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun read(@PathVariable id: Long?): ResponseEntity<Any> {
        return if (workOrderRepository.findById(id!!).isPresent) {
            ResponseEntity.ok(workOrderResourceAssembler.toModel(workOrderRepository.findById(id)))
        } else {
            ResponseEntity.noContent().build<Any>()
        }
    }

    @GetMapping
    @Throws(URISyntaxException::class)
    fun readAll(): ResponseEntity<CollectionModel<EntityModel<WorkOrder>>> {
        val workOrders = workOrderRepository
                .findAll()
                .asSequence()
                .map(workOrderResourceAssembler::toModel)
                .toList()
        val collectionModel = CollectionModel(workOrders,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeRestController::class.java)
                        .readAll()).withSelfRel())
        return ResponseEntity.ok(collectionModel)
    }

    @PutMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun update(@RequestBody update: WorkOrder, @PathVariable id: Long?): ResponseEntity<*> {
        val updated = id?.let {
            workOrderRepository.findById(it).map { temp ->
                temp.tag = update.tag
                workOrderRepository.save(temp)
            }
                    .orElseGet {
                        workOrderRepository.save(update)
                    }
        }
        val entityModel = updated?.let {
            workOrderResourceAssembler.toModel(it)
        }
        return ResponseEntity.created(URI(entityModel?.content?.id.toString())).body(entityModel)
    }

    @PatchMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun partialUpdate(@RequestBody update: WorkOrder, @PathVariable id: Long?): ResponseEntity<*> {
        val updated = id?.let {
            workOrderRepository.findById(it).map { temp ->
                if (!update.tag.isNullOrBlank()) temp.tag = update.tag
                workOrderRepository.save(temp)
            }
                    .orElseGet {
                        workOrderRepository.save(update)
                    }
        }
        val entityModel = updated?.let {
            workOrderResourceAssembler.toModel(it)
        }
        return ResponseEntity.created(URI(entityModel?.content?.id.toString())).body(entityModel)
    }

    @DeleteMapping("/{id}")
    @Throws(URISyntaxException::class)
    fun delete(@PathVariable id: Long?): ResponseEntity<*> {
        when { id != null -> workOrderRepository.deleteById(id)}
        return ResponseEntity.noContent().build<Any>()
    }
}
