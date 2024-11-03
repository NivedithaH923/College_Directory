import React from 'react';
import Navbar from '../Navbar/Navbar';
import './Courses.css'; // Ensure you have this CSS file for styles

const Courses = () => {
  const courses = [
    { id: 1, name: 'Data Structure', faculty: 'Shastri', email: 'shastri@gmail.com' },
    { id: 2, name: 'Operating System', faculty: 'Bhavani', email: 'bhavani@gmail.com' },
    { id: 3, name: 'Electronics', faculty: 'Rajshekar', email: 'raja@gmail.com' },
    { id: 4, name: 'Introduction to AIML', faculty: 'Vishnu', email: 'vishnu@gmail.com' },
    { id: 5, name: 'Cloud Computing', faculty: 'Krishna', email: 'krishna@gmail.com' }
  ];

  return (
    <div>
      <Navbar />
      <div className="student-content">
        <h2 style={{textAlign:"center"}}>Available Courses</h2>
        <table className="courses-table">
          <thead>
            <tr>
              <th>Serial No</th>
              <th>Course Name</th>
              <th>Faculty Name</th>
              <th>Email</th>
            </tr>
          </thead>
          <tbody>
            {courses.map(course => (
              <tr key={course.id}>
                <td>{course.id}</td>
                <td>{course.name}</td>
                <td>{course.faculty}</td>
                <td>{course.email}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default Courses;
