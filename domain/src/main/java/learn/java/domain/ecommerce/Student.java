package learn.java.domain.ecommerce;

import org.apache.commons.lang.builder.EqualsBuilder;

public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(this == obj)
            return true;
        if(getClass()!=obj.getClass())
            return false;
        Student stuObj = (Student) obj;
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        return equalsBuilder.append(name, stuObj.getName())
               .append(marks, stuObj.getMarks()).isEquals();//.appendSuper(super.equals(obj))

        //return super.equals(obj);
    }
}
