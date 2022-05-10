import java.util.List;
import java.util.Objects;

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

   @Override
   public boolean equals(Object o){
      if(o instanceof Student){
         return Objects.equals(this, o);
      }
      return false;
   }

   @Override
   public int hashCode(){
      return Objects.hash(surname, givenName, age, currentCourses);
   }

}
