/**
 *
 * Copyright 2018 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.demo.controller

import local.example.demo.assembler.TaskResourceAssembler
import local.example.demo.exception.TaskNotFoundException
import local.example.demo.model.Task
import local.example.demo.repository.TaskRepository
import org.springframework.hateoas.Resource
import org.springframework.hateoas.Resources
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URISyntaxException

@RestController
@RequestMapping("/api/tasks")
class TaskRestController internal constructor(
        val taskRepository: TaskRepository,
        val taskResourceAssembler: TaskResourceAssembler
) {

    @GetMapping("/{id}")
    @Throws(URISyntaxException::class)
    internal fun read(@PathVariable id: Int?): Resource<Task> {
        val task = taskRepository.findById(id!!)
                .orElseThrow { TaskNotFoundException(id) }
        return taskResourceAssembler.toResource(task)
    }

    @GetMapping
    @Throws(URISyntaxException::class)
    internal fun readAll(): Resources<Resource<Task>> {
        val tasks = taskRepository.findAll()
                .asSequence()
                .map(taskResourceAssembler::toResource).toList()
        return Resources(tasks,
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(TaskRestController::class.java)
                        .readAll()).withSelfRel())
    }
}
