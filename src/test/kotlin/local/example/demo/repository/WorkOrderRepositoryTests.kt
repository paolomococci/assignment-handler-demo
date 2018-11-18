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
class WorkOrderRepositoryTests {

    @Autowired
    val workOrderRepository: WorkOrderRepository? = null

    @Before
    @Throws(Exception::class)
    fun initialize() {
        workOrderRepository?.deleteAll()
    }

    @Test
    @Throws(Exception::class)
    fun `should be able to save work order`() {
        val elsa = Employee("elsa")
        val wo000123 = WorkOrder("000123")
        wo000123.beenAssigned(elsa, "filling")
        workOrderRepository?.save(wo000123)
        val temp = workOrderRepository?.findById(wo000123.id)
        val workOrder = temp?.get()?.index
        assertThat(if (workOrder != null) workOrder == wo000123.index else null)
        assertThat((temp?.get()?.tasks?.first())?.equals(wo000123.tasks.first()))
    }
}
