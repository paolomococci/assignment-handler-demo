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

package local.example.demo.assembler

import local.example.demo.controller.TaskRestController
import local.example.demo.model.Task
import org.springframework.hateoas.Resource
import org.springframework.hateoas.ResourceAssembler
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.stereotype.Component

@Component
class TaskResourceAssembler : ResourceAssembler<Task, Resource<Task>> {
    override fun toResource(task: Task): Resource<Task> {
        return Resource(task,
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(TaskRestController::class.java)
                        .read(task.id)).withSelfRel(),
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(TaskRestController::class.java)
                        .readAll()).withRel("tasks"))
    }
}
