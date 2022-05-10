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

   // additional likely methods not defined since they are not needed for testing

   @Override
   public boolean equals(Object o){
      if(o == null){
         return false;
      }
      if(o instanceof CourseSection){
         CourseSection cs = (CourseSection)o;
         return ((cs.prefix == null && this.prefix == null) || cs.prefix.equals(this.prefix))
                 && ((cs.number == null && this.number == null) || cs.number.equals(this.number))
                 && cs.enrollment == this.enrollment
                 && ((cs.startTime == null && this.startTime == null) || cs.startTime.equals(this.startTime))
                 && ((cs.endTime == null && this.endTime == null) || cs.endTime.equals(this.endTime));
      }
      return false;
   }

   @Override
   public int hashCode(){
      int hash = startTime.getHour()*31+startTime.getMinute()*17+startTime.getSecond()*13+startTime.getNano()*11;
      hash *= 31;
      hash += endTime.getHour()*31+endTime.getMinute()*17+endTime.getSecond()*13+endTime.getNano()*11;
      hash *= 31;
      hash += enrollment;
      String str = prefix+number;
      for(int n = 0; n < str.length(); n++){
         hash *= 7;
         hash += str.charAt(n);
      }
      return hash;
   }
}
