class Student:
    def __init__(self, name, grade, age):
        self.name = name
        self.grade = grade
        self.age = age

    def display(self):
        print("Name:", self.name)
        print("Grade:", self.grade)
        print("Age:", self.age)


class School(Student):
    def school_student_display(self):
        self.display()


# Create an object using Student class
student_obj = Student("John", 8, 13)

# Display the details of the student object
print("Details of student object:")
student_obj.display()

# Create an object using School class
school_obj = School("Bob", 10, 15)

# Display the details of the school object using the school_student_display() method
print("Details of school object:")
school_obj.school_student_display()
