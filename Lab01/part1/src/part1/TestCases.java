package part1;

import java.util.*;

import org.junit.jupiter.api.Test;
import part2.Applicant;

import static org.junit.jupiter.api.Assertions.*;

public class TestCases {
   private final static double DELTA = 0.0001;

   ////////////////////////////////////////////////////////////
   //                      SimpleIf Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testAnalyzeApplicant1()    {
      assertTrue(part1.SimpleIf.analyzeApplicant(89, 85));
   }

   @Test
   public void testAnalyzeApplicant2()    {
      assertFalse(part1.SimpleIf.analyzeApplicant(15, 90));
   }

   @Test
   public void testAnalyzeApplicant3() { assertFalse(part1.SimpleIf.analyzeApplicant(90, 90)); }


   @Test
   public void testMaxAverage1() {
      assertEquals(part1.SimpleIf.maxAverage(89.5, 91.2), 91.2, DELTA);
   }

   @Test
   public void testMaxAverage2() {
      assertEquals(part1.SimpleIf.maxAverage(60, 89), 89, DELTA);
   }

   @Test
   public void testMaxAverage3() {
      assertEquals(part1.SimpleIf.maxAverage(420, 69), 420, DELTA);
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleLoop1()    {
      assertEquals(7, part1.SimpleLoop.sum(3, 4));
   }

   @Test
   public void testSimpleLoop2()    {
      assertEquals(7, part1.SimpleLoop.sum(-2, 4));
   }

   @Test
   public void testSimpleLoop3()    {
      assertEquals(0, part1.SimpleLoop.sum(0, 0));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleArray Tests                   //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleArray1()    {
      /* What is that parameter?  They are newly allocated arrays
         with initial values. */
      assertArrayEquals(
         new boolean[] {false, false, true, true, false, false},
              part1.SimpleArray.applicantAcceptable(new int[] {80, 85, 89, 92, 76, 81}, 85)
      );
   }

   @Test
   public void testSimpleArray2()    {
      assertArrayEquals(
         new boolean[] {false, false},
              part1.SimpleArray.applicantAcceptable(new int[] {80, 83}, 92));
   }

   @Test
   public void testSimpleArray3()   {
      assertArrayEquals(
              new boolean[] {false, true, false, true, false},
              part1.SimpleArray.applicantAcceptable(new int[] {80, 84, 79, 85, 2}, 83));
   }

   ////////////////////////////////////////////////////////////
   //                    SimpleList Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testSimpleList1()   {
      List<Integer> input =
         new LinkedList<Integer>(Arrays.asList(new Integer[] {80, 85, 89, 92, 76, 81}));
      List<Boolean> expected =
         new ArrayList<Boolean>(Arrays.asList(new Boolean[] {false, false, true, true, false, false}));

      assertEquals(expected, part1.SimpleList.applicantAcceptable(input, 85));
   }

   @Test
   public void testSimpleList2()   {
      List<Integer> input =
           new LinkedList<Integer>(Arrays.asList(new Integer[] {100, 100, 100, 100, 100, 100}));
      List<Boolean> expected =
           new ArrayList<Boolean>(Arrays.asList(new Boolean[] {false, false, false, false, false, false}));

      assertEquals(expected, part1.SimpleList.applicantAcceptable(input, 101));
   }

   ////////////////////////////////////////////////////////////
   //                    BetterLoop Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testFourOver85_1()   {
      assertFalse(part1.BetterLoop.atLeastFourOver85(new int[] {89, 93, 100, 39, 84, 63}));
   }

   @Test
   public void testFourOver85_2()   {
      assertTrue(part1.BetterLoop.atLeastFourOver85(new int[] {86, 87, 90, 82, 83, 90}));
   }

   @Test
   public void testFourOver85_3()   {
      assertFalse(part1.BetterLoop.atLeastFourOver85(new int[] {45, 22, 95, 90, 99,  22}));
   }

   ////////////////////////////////////////////////////////////
   //                    ExampleMap Tests                    //
   ////////////////////////////////////////////////////////////

   @Test
   public void testExampleMap1()   {
      Map<String, List<part1.CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Mary",
         Arrays.asList(
            new part1.CourseGrade("CPE 123", 89),
            new part1.CourseGrade("CPE 101", 90),
            new part1.CourseGrade("CPE 202", 99),
            new part1.CourseGrade("CPE 203", 100),
            new part1.CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Sam",
         Arrays.asList(
            new part1.CourseGrade("CPE 101", 86),
            new part1.CourseGrade("CPE 202", 80),
            new part1.CourseGrade("CPE 203", 76),
            new part1.CourseGrade("CPE 225", 80)));
      courseListsByStudent.put("Sara",
         Arrays.asList(
            new part1.CourseGrade("CPE 123", 99),
            new part1.CourseGrade("CPE 203", 91),
            new part1.CourseGrade("CPE 471", 86),
            new part1.CourseGrade("CPE 473", 90),
            new part1.CourseGrade("CPE 476", 99),
            new part1.CourseGrade("CPE 572", 100)));

      List<String> expected = Arrays.asList("Mary", "Sara");

      /*
       * Why compare HashSets here?  Just so that the order of the
       * elements in the list is not important for this test.
       */
      assertEquals(new HashSet<>(expected),
         new HashSet<>(part1.ExampleMap.highScoringStudents(
            courseListsByStudent, 85)));
   }

   @Test
   public void testExampleMap2()    {
      Map<String, List<part1.CourseGrade>> courseListsByStudent = new HashMap<>();
      courseListsByStudent.put("Mary",
              Arrays.asList(
                      new part1.CourseGrade("CPE 123", 89),
                      new part1.CourseGrade("CPE 101", 66),
                      new part1.CourseGrade("CPE 202", 99),
                      new part1.CourseGrade("CPE 203", 68),
                      new part1.CourseGrade("CPE 225", 89)));
      courseListsByStudent.put("Sam",
              Arrays.asList(
                      new part1.CourseGrade("CPE 101", 99),
                      new part1.CourseGrade("CPE 202", 89),
                      new part1.CourseGrade("CPE 203", 88),
                      new part1.CourseGrade("CPE 225", 100)));
      courseListsByStudent.put("Sara",
              Arrays.asList(
                      new part1.CourseGrade("CPE 123", 99),
                      new part1.CourseGrade("CPE 203", 91),
                      new part1.CourseGrade("CPE 471", 68),
                      new part1.CourseGrade("CPE 473", 33),
                      new part1.CourseGrade("CPE 476", 69),
                      new part1.CourseGrade("CPE 572", 100)));

      List<String> expected = Arrays.asList("Sam");

      /*
       * Why compare HashSets here?  Just so that the order of the
       * elements in the list is not important for this test.
       */
      assertEquals(new HashSet<>(expected),
              new HashSet<>(part1.ExampleMap.highScoringStudents(
                      courseListsByStudent, 85)));
   }
}
