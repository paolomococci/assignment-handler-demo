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

package local.example.demo.repository

import local.example.demo.AssignmentHandlerDemoApplication
import local.example.demo.model.Employee
import local.example.demo.model.Task
import local.example.demo.model.WorkOrder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [AssignmentHandlerDemoApplication::class])
@Transactional
class TaskRepositoryTests {

    @Autowired
    val taskRepository: TaskRepository? = null

    @Before
    @Throws(Exception::class)
    fun initialize() {
        taskRepository?.deleteAll()
    }

    @Test
    @Throws(Exception::class)
    fun `should be able to save task`() {
        val clara = Employee("clara")
        val wo000147 = WorkOrder("000147")
        val task = Task(
                task = "packaging",
                employee = clara,
                workOrder = wo000147
        )
        taskRepository?.save(task)
    }
}
