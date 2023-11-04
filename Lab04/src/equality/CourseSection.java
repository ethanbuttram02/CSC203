package equality;

import java.time.LocalTime;

class CourseSection
{
   private final String prefix;
   private final String number;
   private final int enrollment;
   private final LocalTime startTime;
   private final LocalTime endTime;

   public CourseSection(final String prefix, final String number,
      final int enrollment, final LocalTime startTime, final LocalTime endTime)
   {
      this.prefix = prefix;
      this.number = number;
      this.enrollment = enrollment;
      this.startTime = startTime;
      this.endTime = endTime;
   }

   public boolean equals(Object other) {
      CourseSection o = (CourseSection)other;

      return this.prefix.equals(o.prefix) && this.number.equals(o.number) && this.enrollment == o.enrollment && this.startTime.equals(o.startTime) && this.endTime.equals(o.startTime);
   }

   public int hashCode() {
      int result = 17; // Start with a non-zero constant

      // Combine the hash code of each field
      result = 31 * result + prefix.hashCode();
      result = 31 * result + number.hashCode();
      result = 31 * result + enrollment;
      result = 31 * result + startTime.hashCode();
      result = 31 * result + endTime.hashCode();

      return result;
   }
   // additional likely methods not defined since they are not needed for testing
}
