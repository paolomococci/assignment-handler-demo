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
import local.example.demo.model.WorkOrder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

import org.assertj.core.api.Assertions.*

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [AssignmentHandlerDemoApplication::class])
@Transactional
class EmployeeRepositoryTests {

    @Autowired
    val employeeRepository: EmployeeRepository? = null

    @Before
    @Throws(Exception::class)
    fun initialize() {
        employeeRepository?.deleteAll()
    }

    @Test
    @Throws(Exception::class)
    fun `should be able to save employee`() {
        val wo000123 = WorkOrder("000123")
        val elsa = Employee("elsa")
        elsa.assignedTo(wo000123, "filling")
        employeeRepository?.save(elsa)
        val temp = employeeRepository?.findById(elsa.id)
        val employee = temp?.get()?.employee
        assertThat(if (employee != null) employee == elsa.employee else null)
        val tasks = temp?.get()?.tasks
        assertThat((if (tasks != null) tasks.first() else null)?.equals(elsa.tasks.first()))
    }
}
