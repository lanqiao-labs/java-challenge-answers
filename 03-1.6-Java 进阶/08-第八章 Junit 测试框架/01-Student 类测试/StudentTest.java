import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;

/**
 * Student Tester.
 *
 * @author <Authors name>
 * @since <pre>12月 25, 2020</pre>
 * @version 1.0
 */
public class StudentTest {

    Student studentTest;

    @Before
    public void before() throws Exception {
        System.out.println("测试前实例化一个 Student 类");
        studentTest = new Student("Tom", "male", 25);
    }

    @After
    public void after() throws Exception {
        System.out.println("测试后...");
    }

    /**
     *
     * Method: getName()
     *
     */
    @Test
    public void testGetName() throws Exception {
        //TODO: Test goes here...
        assertEquals("Tom", studentTest.getName());
    }

    /**
     *
     * Method: setName(String name)
     *
     */
    @Test
    public void testSetName() throws Exception {
        //TODO: Test goes here...
        studentTest.setName("Jimmy");
        assertEquals("Jimmy", studentTest.getName());
    }

    /**
     *
     * Method: getSex()
     *
     */
    @Test
    public void testGetSex() throws Exception {
        //TODO: Test goes here...
        assertEquals("male", studentTest.getSex());
    }

    /**
     *
     * Method: setSex(String sex)
     *
     */
    @Test
    public void testSetSex() throws Exception {
        //TODO: Test goes here...
        studentTest.setSex("female");
        assertEquals("female", studentTest.getSex());
    }

    /**
     *
     * Method: getAge()
     *
     */
    @Test
    public void testGetAge() throws Exception {
        //TODO: Test goes here...
        assertEquals(25, studentTest.getAge());
    }

    /**
     *
     * Method: setAge(int age)
     *
     */
    @Test
    public void testSetAge() throws Exception {
        //TODO: Test goes here...
        studentTest.setAge(26);
        assertEquals(26,studentTest.getAge());
    }

} 
