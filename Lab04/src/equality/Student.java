package equality;

import java.util.List;

class Student
{
   private final String surname;
   private final String givenName;
   private final int age;
   private final List<CourseSection> currentCourses;

   public Student(final String surname, final String givenName, final int age,
      final List<CourseSection> currentCourses)
   {
      this.surname = surname;
      this.givenName = givenName;
      this.age = age;
      this.currentCourses = currentCourses;
   }

   public boolean equals(Object other) {
      Student o = (Student)other;

      return this.surname.equals(o.surname) && this.givenName.equals(o.givenName) && this.age == o.age && this.currentCourses.equals(o.currentCourses);
   }

   public int hashCode() {
      int result = 17; // Start with a non-zero constant

      // Combine the hash code of each field
      result = 31 * result + surname.hashCode();
      result = 31 * result + givenName.hashCode();
      result = 31 * result + age;
      result = 31 * result + currentCourses.hashCode();

      return result;
   }
}
